package com.madderate.skyloft.ViewModels;

import androidx.lifecycle.ViewModel;

import com.madderate.skyloft.Activities.Fragments.EmailLoginFragment;
import com.madderate.skyloft.Activities.Fragments.PhoneLoginFragment;

public class LoginViewModel extends ViewModel {

    private String phoneNumber;
    private String password;
    private String email;

    private PhoneLoginFragment phoneLoginFragment;
    private EmailLoginFragment emailLoginFragment;

    public PhoneLoginFragment getPhoneLoginFragment() {
        return phoneLoginFragment;
    }

    public void setPhoneLoginFragment(PhoneLoginFragment phoneLoginFragment) {
        this.phoneLoginFragment = phoneLoginFragment;
    }

    public EmailLoginFragment getEmailLoginFragment() {
        return emailLoginFragment;
    }

    public void setEmailLoginFragment(EmailLoginFragment emailLoginFragment) {
        this.emailLoginFragment = emailLoginFragment;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
