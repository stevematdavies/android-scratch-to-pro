package com.example.steve.contacts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class StudentListActivity extends AppCompatActivity {

    Button newStudentButton;
    ListView studentsList;
    ArrayAdapter<String> adapter;
    List<Student> students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);

        // TODO load Students from Database
        //students = new String[] {"Guilherme","Paulo","Ana","Maria Lucia","Carlos","Daniela"};
        studentsList = (ListView)findViewById(R.id.student_list_list);
        //adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,students);
        //studentsList.setAdapter(adapter);
        newStudentButton = (Button) findViewById(R.id.student_list_new_student_button);
        newStudentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentListActivity.this, StudentFormActivity.class);
                startActivity(intent);
            }
        });
    }
}
