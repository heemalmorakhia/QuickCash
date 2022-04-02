package ca.dal.csci3130.quickcash.usermanagement;

import java.util.ArrayList;

public interface UserInterface {

    String getFirstName();

    void setFirstName(String firstName);

    String getLastName();

    void setLastName(String lastName);

    String getEmail();

    void setEmail(String email);

    String getPhone();

    void setPhone(String phone);

    String getPassword();

    void setPassword(String password);

    boolean getIsEmployee();

    void setIsEmployee(boolean isEmployee);

    ArrayList<String> getAppliedJobs();

    double getRating();

    void setRating(double rating);

    int getNumberOfRatings();

    void setNumberOfRatings(int numberOfRating);
}

