package ca.dal.csci3130.quickcash.jobmanagement;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

import ca.dal.csci3130.quickcash.R;
import ca.dal.csci3130.quickcash.usermanagement.SessionManager;

public class JobAdActivity extends AppCompatActivity {

    String jobID;
    private TextView jobTitle;
    private TextView jobDesc;
    private TextView jobType;
    private TextView jobDuration;
    private TextView jobPayRate;
    private Button apply;
    private List<String>employees;

    public JobAdActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_ad);

        jobTitle = findViewById(R.id.jobAdTitle);
        jobDesc = findViewById(R.id.jobAdDescription);
        jobType = findViewById(R.id.jobAdType);
        jobDuration = findViewById(R.id.jobAdDuration);
        jobPayRate = findViewById(R.id.jobAdPayRate);

        // Grab job id
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            jobID = extras.getString("JobID");
        }

        apply = (Button) findViewById(R.id.apply);

        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Job");
                ref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                            Job newJob = snapshot1.getValue(Job.class);
                            if (newJob.getJobID().matches(jobID)){
                                if(!employees.contains(grabEmail()))
                                    employees.add(grabEmail());

                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });



        // query the database and find the job by its ID
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Job");
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                    Job newJob = snapshot1.getValue(Job.class);
                    if(newJob.getJobID().matches(jobID)) {
                        jobTitle.setText("" + newJob.getJobTitle());
                        jobDesc.setText("" + newJob.getDescription());
                        jobType.setText("" + newJob.getJobType());
                        jobDuration.setText("" + newJob.getDuration());
                        jobPayRate.setText("" + newJob.getPayRate());
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }

    /**
     * Returns the email of the user signed in
     * @return
     */
    private String grabEmail(){
        SessionManager session = new SessionManager(JobAdActivity.this);

        boolean isLoggedIn = session.isLoggedIn();

        if(isLoggedIn)
            return session.getKeyEmail();

       return null;
    }
}