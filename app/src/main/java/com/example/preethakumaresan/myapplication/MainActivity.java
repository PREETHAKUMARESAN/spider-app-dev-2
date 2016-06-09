package com.example.preethakumaresan.myapplication;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;



public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

private String name,roll,dept;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Spinner element
        Spinner spinner = (Spinner) findViewById(R.id.departMent);

        // Spinner click listener
        assert spinner != null;
        spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories;
        categories = new ArrayList<String>();
        categories.add("CSE");
        categories.add("ECE ");
        categories.add("EEE");
        categories.add("ICE");
        categories.add("PROD");
        categories.add("MECH");
        categories.add("META");
        categories.add("CIVIL");
        categories.add("ARCHI");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
        spinner.setOnItemSelectedListener(this);

        assert ((Button) findViewById(R.id.submitbtn)) != null;
        assert ((Button) findViewById(R.id.submitbtn)) != null;
        ((Button) findViewById(R.id.submitbtn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = ((EditText) findViewById(R.id.nameedit)).getText().toString();
                roll = ((EditText) findViewById(R.id.roll)).getText().toString();

                boolean appdev, webdev, algo, tronix;

                webdev = ((CheckBox) findViewById(R.id.webdev)).isChecked();
                appdev = ((CheckBox) findViewById(R.id.appdev)).isChecked();
                algo = ((CheckBox) findViewById(R.id.algos)).isChecked();
                tronix = ((CheckBox) findViewById(R.id.tronix)).isChecked();


                if (name.equals("")) {
                    Toast.makeText(MainActivity.this, "Please enter your Name.It is blank!", Toast.LENGTH_SHORT).show();
                } else {
                    if (roll.equals("")) {
                        Toast.makeText(MainActivity.this, "Please enter your Roll Number.It is blank!", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        if (!appdev && !webdev && !algo && !tronix) {
                            Toast.makeText(MainActivity.this, "You have not chosen a profile!.Please choose atleast one profile. ", Toast.LENGTH_SHORT).show();
                        }




                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                    alertDialogBuilder.setMessage("Are you sure you want to proceed?");
                    alertDialogBuilder.setCancelable(false).setPositiveButton("YES", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(MainActivity.this, "You clicked yes button", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                            intent.putExtra("name", name);
                            startActivity(intent);
                        }
                    });

                    alertDialogBuilder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();
                }

            }}


        });
    }


    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

}
