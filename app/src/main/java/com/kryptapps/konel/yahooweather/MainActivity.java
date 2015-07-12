package com.kryptapps.konel.yahooweather;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import data.Channel;
import data.Item;
import service.WeatherServiceCallback;
import service.YahooWeatherService;


public class MainActivity extends Activity implements WeatherServiceCallback{

    private ImageView weatherImageView;
    private TextView tvTemperature, tvCondition, tvLocation, tvSunrise, tvSunset;

    private YahooWeatherService service;
    private ProgressDialog dialog;

    private Intent intent;
    private String city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intent = getIntent();
        city = intent.getStringExtra(LauncherActivity.EXTRA_CITY);

        weatherImageView = (ImageView) findViewById(R.id.weatherImageView);
        tvTemperature = (TextView) findViewById(R.id.tvTemperature);
        tvCondition = (TextView) findViewById(R.id.tvCondition);
        tvLocation = (TextView) findViewById(R.id.tvLocation);
        tvSunrise = (TextView) findViewById(R.id.tvSunriseVal);
        tvSunset = (TextView) findViewById(R.id.tvSunsetVal);

        service = new YahooWeatherService(this);
        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading...");
        dialog.show();

        service.refreshWeather(city + ", India");
    }

    @Override
    public void ServiceSuccess(Channel channel) {
        dialog.hide();

        Item item = channel.getItem();
        int resourceId = getResources().getIdentifier("drawable/icon_" + item.getCondition().getCode(), null, getPackageName());
        weatherImageView.setImageResource(resourceId);

        tvTemperature.setText(item.getCondition().getTemperature() + "\u00B0" + channel.getUnits().getTemperature());
        tvCondition.setText(item.getCondition().getDescription());
        tvLocation.setText(channel.getLocation().getCity() + ", "+ channel.getLocation().getRegion() + ", "+ channel.getLocation().getCountry());

        tvSunrise.setText(channel.getAstronomy().getSunrise());
        tvSunset.setText(channel.getAstronomy().getSunset());

    }

    @Override
    public void ServiceFailure(Exception exception) {
        dialog.hide();
        Toast.makeText(this, exception.getMessage(), Toast.LENGTH_LONG).show();

    }
}
