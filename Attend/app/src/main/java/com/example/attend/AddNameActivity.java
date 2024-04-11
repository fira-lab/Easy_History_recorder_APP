package com.example.attend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddNameActivity extends AppCompatActivity {
    private EditText editTextName;
    private Button buttonSave, buttonHistory;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_name);

        editTextName = findViewById(R.id.edit_text_name);
        buttonSave = findViewById(R.id.button_save);
        buttonHistory = findViewById(R.id.button_history);
        databaseHelper = new DatabaseHelper(this);

        buttonHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddNameActivity.this, DisplayNamesActivity.class);
                startActivity(intent);
            }
        });





        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString().trim();

                if (!TextUtils.isEmpty(name)) {
                    long id = databaseHelper.insertName(name);

                    if (id != -1) {
                        Toast.makeText(AddNameActivity.this, "Name saved successfully", Toast.LENGTH_SHORT).show();
                        editTextName.setText("");
                    } else {
                        Toast.makeText(AddNameActivity.this, "Error saving name", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(AddNameActivity.this, "Please enter a name", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }}

