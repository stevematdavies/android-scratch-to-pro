package com.example.steve.contacts;

import android.app.Activity;
import android.widget.EditText;


public class StudentFormViewHelper {

    private final Activity activity;

    StudentFormViewHelper(Activity activity){
        this.activity = activity;
    }

    private String getTextFieldValue(int id){
        EditText  field= (EditText)this.activity.findViewById(id);
        return field.getText().toString();
    }

    public Student createStudent(){
        return new Student(
                getName(),
                getEmail(),
                getAddress(),
                getPhoneNumber(),
                getWebsite()
        );
    }

    private String getName() {
        return getTextFieldValue(R.id.student_form_name);
    }

    private String getAddress() {
        return getTextFieldValue(R.id.student_form_address);
    }

    private String getEmail() {
        return getTextFieldValue(R.id.student_form_email);
    }

    private String getPhoneNumber() {
        return getTextFieldValue(R.id.student_form_phone);
    }

    private String getWebsite() {
        return getTextFieldValue(R.id.student_form_website);
    }
}
