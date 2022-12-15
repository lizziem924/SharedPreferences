package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //reading the data
        //our variables
        EditText name = (EditText) findViewById(R.id.nameTextBox);
        EditText age = (EditText) findViewById(R.id.ageTextBox);
        CheckBox enrolled = (CheckBox) findViewById(R.id.enrolledCheckBox);

        //Retrieving the value using its keys the file name
        // must be same in both saving and retrieving the data
        SharedPreferences sp = getSharedPreferences("MySharedPref", MODE_PRIVATE);

        // The value will be default as empty string because for
        // the very first time when the app is opened, there is nothing to show
        String n = sp.getString("name", "");
        int a = sp.getInt("age", 0);
        boolean e = sp.getBoolean("enrolled", false);

        // We can then use the data
        name.setText(n);
        age.setText(String.valueOf(a));
        enrolled.setChecked(e);
    }


    public void onSave(View v) {
        //Storing data into SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);

        //our variables
        EditText name = (EditText) findViewById(R.id.nameTextBox);
        EditText age = (EditText) findViewById(R.id.ageTextBox);
        CheckBox enrolled = (CheckBox) findViewById(R.id.enrolledCheckBox);

        // Creating an Editor object to edit(write to the file)
        SharedPreferences.Editor myEdit = sharedPreferences.edit();

        // Storing the key and its value as the data fetched from edittext
        myEdit.putString("name", name.getText().toString());
        myEdit.putInt("age", Integer.parseInt(age.getText().toString()));
        myEdit.putBoolean("enrolled", enrolled.isChecked());

    // Once the changes have been made,
    // we need to commit to apply those changes made,
    // otherwise, it will throw an error
        myEdit.commit();
    }

}