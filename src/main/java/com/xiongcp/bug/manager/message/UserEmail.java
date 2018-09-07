package com.xiongcp.bug.manager.message;

/**
 * ${ClassName}
 * Created by xiongcp on 2018/9/7.
 */

public class UserEmail {
    private String email;
    private String sendEmail;
    private String checkNumber;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSendEmail() {
        return sendEmail;
    }

    public void setSendEmail(String sendEmail) {
        this.sendEmail = sendEmail;
    }

    public String getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(String checkNumber) {
        this.checkNumber = checkNumber;
    }

    public UserEmail(String email, String sendEmail, String checkNumber) {
        this.email = email;
        this.sendEmail = sendEmail;
        this.checkNumber = checkNumber;

    }

    @Override
    public String toString() {
        return "UserEmail{" +
                "email='" + email + '\'' +
                ", sendEmail='" + sendEmail + '\'' +
                ", checkNumber='" + checkNumber + '\'' +
                '}';
    }
}
