package com.example.steve.contacts;

import android.app.Activity;
import android.widget.EditText;
import android.widget.RatingBar;


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
                getWebsite(),
                getRating()

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

    private Float getRating() {
        RatingBar ratingBar = (RatingBar)activity.findViewById(R.id.student_form_rating);
        return ratingBar.getRating();
    }

    public void populateForm(Student student) {
        fill(R.id.student_form_name, student.getName());
        fill(R.id.student_form_address, student.getAddress());
        fill(R.id.student_form_email, student.getEmail());
        fill(R.id.student_form_phone, student.getPhoneNumber());
        fill(R.id.student_form_website, student.getWebsite());

        RatingBar rating = (RatingBar) activity.findViewById(R.id.student_form_rating);
        rating.setRating(student.getRating());
    }

    private void fill(int id, String value) {
        ((EditText) activity.findViewById(id)).setText(value);
    }
}
