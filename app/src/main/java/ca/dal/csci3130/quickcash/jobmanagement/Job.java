package ca.dal.csci3130.quickcash.jobmanagement;

import com.google.android.gms.maps.model.LatLng;

import java.util.List;
import java.util.Map;

public class Job implements JobInterface{

    private String jobTitle;
    private String jobType;
    private String jobDescription;
    private int jobDuration;
    private double payRate;
    private String jobID;
    private double latitude;
    private double longitude;
    private List<String> applicants;
    private String selectedApplicant;

    public Job(Map<String, String> jobData,
               int jobDuration,
               double payRate,
               LatLng jobLocation,
               List<String> applicants) {
        this.jobTitle = jobData.get("jobTitle");
        this.jobType = jobData.get("jobType");
        this.jobDescription = jobData.get("jobDescription");
        this.jobID = jobData.get("jobID");
        this.selectedApplicant = jobData.get("selectedApplicant");
        this.jobDuration = jobDuration;
        this.payRate = payRate;
        this.latitude = jobLocation.latitude;
        this.longitude = jobLocation.longitude;
        this.applicants = applicants;
    }

    public Job(){
    }

    @Override
    public String getJobTitle() {
        return jobTitle;
    }

    @Override
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Override
    public String getJobType() {
        return jobType;
    }

    @Override
    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    @Override
    public String getDescription() {
        return jobDescription;
    }

    @Override
    public void setDescription(String description) {
        this.jobDescription = description;
    }

    @Override
    public int getDuration() {
        return jobDuration;
    }

    @Override
    public void setDuration(int duration) {
        this.jobDuration = duration;
    }

    @Override
    public double getPayRate() {
        return payRate;
    }

    @Override
    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }

    @Override
    public String getJobID() {
        return jobID;
    }

    @Override
    public void setJobID(String jobID) {
        this.jobID = jobID;
    }

    @Override
    public double getLatitude(){
        return this.latitude;
    }

    @Override
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @Override
    public double getLongitude() {
        return this.longitude;
    }

    @Override
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public List<String> getApplicants() {
        return applicants;
    }

    @Override
    public void setApplicants(List<String> applicants) {
        this.applicants = applicants;
    }

    @Override
    public String getSelectedApplicant() {
        return selectedApplicant;
    }

    @Override
    public void setSelectedApplicant(String selectedApplicant) {
        this.selectedApplicant = selectedApplicant;
    }
}
