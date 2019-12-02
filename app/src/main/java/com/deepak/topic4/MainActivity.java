package com.deepak.topic4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    //Add value in array
    public static final String countries[] = {
            "Nepal","Kathmandu",
            "India","Delhi",
            "China","Beijing",
            "UK","London",
            "US","Washington D.C.",
            "Canada","Ottawa"
    };

    //Mapping the array data data
    private Map<String,String> dictionary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ListView lstcountries = findViewById(R.id.lstcountries);


        //Hashmapping
        dictionary = new HashMap<>();

        for(int i=0;i<countries.length;i+=2){
            dictionary.put(countries[i],countries[i+1]);
        }


        //Arrayadapter to display the array countries value
        ArrayAdapter countryAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                new ArrayList<String>(dictionary.keySet())
        );
        lstcountries.setAdapter(countryAdapter);


        //Pass the capital of country to Capital Activity
        lstcountries.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //To represent which country the user has been click
                String country = parent.getItemAtPosition(position).toString();

                //Get hashmap data from dictionary variable from above
                String capital = dictionary.get(country);

              //Toast.makeText(getApplicationContext(),capital.toString(),Toast.LENGTH_LONG).show();

                Intent intent = new Intent(MainActivity.this, CapitalActivity.class);

                //Send the value of capital and country through the name: "mszCapital" & "mszCountry"
                intent.putExtra("mszCapital", capital);
                intent.putExtra("mszCountry", country);
                startActivity(intent);


            }
        });

    }
}

