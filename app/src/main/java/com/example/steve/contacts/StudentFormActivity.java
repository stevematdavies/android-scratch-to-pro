package com.example.steve.contacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class StudentFormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_form);

        if(isEditing()){
           new StudentFormViewHelper(this)
                   .populateForm(getOriginalStudentToUpdate());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_student_form, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.menu_student_form_confirm_button) {
            Student student = new StudentFormViewHelper(this).createStudent();

            StudentDAO dao = new StudentDAO(this);

            if(isEditing()){
                dao.update(student, getOriginalStudentToUpdate().getId() );
            } else {
                dao.insert(student);
            }

            dao.close();
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private boolean isEditing() {
        return getIntent().hasExtra("student");
    }

    private Student getOriginalStudentToUpdate() {
        return (Student) getIntent().getSerializableExtra("student");
    }
}
