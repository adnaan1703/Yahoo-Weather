package com.kryptapps.konel.yahooweather;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class LauncherActivity extends Activity {

    EditText etCity;
    Button bSubmit;
    public static final String EXTRA_CITY = "com.kryptapps.konel.yahooweather.CITY";
    private String city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        etCity = (EditText) findViewById(R.id.etCity);
        bSubmit = (Button) findViewById(R.id.bSubmit);

        bSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                city = etCity.getText().toString().trim();
                if(!city.isEmpty()) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.putExtra(EXTRA_CITY, city);
                    startActivity(intent);
                }
            }
        });
    }

}
