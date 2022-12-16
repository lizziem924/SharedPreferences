package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

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

        //create gson object
        Gson gson = new Gson();

        //create new employee object
        List<FamilyMember> family = new ArrayList<FamilyMember>();
        family.add(new FamilyMember("cat", 8));
        Employee liz = new Employee("Liz", 17, "liz@gmail.com", new Address("US", "Dallas"), family);

        //create json version of object as a string
        String lizString = gson.toJson(liz);
        //back to employee class
        Employee employee2 = gson.fromJson(lizString, Employee.class);

        //creating json of family list
        String json2 = gson.toJson(family);

        Type familyType = new TypeToken<ArrayList<FamilyMember>>(){}.getType();
        ArrayList<FamilyMember> family2 = gson.fromJson(json2, familyType);
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