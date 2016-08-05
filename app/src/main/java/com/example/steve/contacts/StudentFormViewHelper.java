package com.example.steve.contacts;

import android.app.Activity;
import android.widget.EditText;


public class StudentFormViewHelper {


    private final Activity activity;

    StudentFormViewHelper(Activity activity){
        this.activity = activity;
    }

    public String getStudentName() {
        EditText studentNameField = (EditText)this.activity.findViewById(R.id.student_form_name);
        return studentNameField.getText().toString();
    }

    public String getStudentAddress() {
        EditText studentAddressField = (EditText)this.activity.findViewById(R.id.student_form_address);
        return studentAddressField.getText().toString();
    }

    public String getStudentEmail() {
        EditText studentEmailField = (EditText)this.activity.findViewById(R.id.student_form_email);
        return studentEmailField.getText().toString();
    }

    public String getStudentPhone() {
        EditText studentPhoneField = (EditText)this.activity.findViewById(R.id.student_form_phone);
        return studentPhoneField.getText().toString();
    }

    public String getStudentWebsite() {
        EditText studentWebsiteField = (EditText)this.activity.findViewById(R.id.student_form_website);
        return studentWebsiteField.getText().toString();
    }
}
