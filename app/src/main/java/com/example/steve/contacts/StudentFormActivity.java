package com.example.steve.contacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class StudentFormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_form);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_student_form, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.menu_student_form_confirm_button) {
            StudentFormViewHelper helper = new StudentFormViewHelper(this);
            Student student = helper.createStudent();
            String message = "\""+ student.getName() + "\" was created with rating: "+student.getRating();
            Toast.makeText(StudentFormActivity.this, message,Toast.LENGTH_SHORT).show();
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
