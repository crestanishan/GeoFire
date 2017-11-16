package com.example.nishan.registrationandlogin.Model;

/**
 * Created by nishan on 11/13/17.
 */

public class User {

    String userId;
    String userName;
    String userEmail;
    String userAddress;
    String userContacts;
    String userBloodGroup;

    public User(){

    }

    public User (String userId, String userName, String userEmail, String userAddress, String userContacts, String userBloodGroup){
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userAddress = userAddress;
        this.userContacts = userContacts;
        this.userBloodGroup = userBloodGroup;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public String getUserContacts() {
        return userContacts;
    }

    public String getUserBloodGroup() {
        return userBloodGroup;
    }
}
