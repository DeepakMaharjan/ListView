package com.deepak.topic4;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;
import android.widget.Toast;

public class CapitalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capital);

        TextView tvCapital = findViewById(R.id.tvCapital);

//        tvCapital.setTypeface(Typeface.SANS_SERIF,Typeface.BOLD_ITALIC);

        Bundle bundle = getIntent().getExtras();

        if (bundle!=null){
            String capital = bundle.getString("mszCapital");
            String country = bundle.getString("mszCountry");
            //String result = "The capital city of "+ country + " is "+ capital;
            tvCapital.setText(Html.fromHtml("The capital city of <b><i>"+ country + "</i></b> is <b> <i>"+ capital + "</i></b>."));
        }
        else {
            Toast.makeText(this, "No Message", Toast.LENGTH_SHORT).show();
        }

    }
}
