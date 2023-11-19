package com.thapelo.mxocars;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class Welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_welcome );
        AppCompatButton goToVehicles = findViewById( R.id.vehicle_categories_button );
        goToVehicles.setOnClickListener( v -> {
            Intent intentCategories = new Intent( Welcome.this, VehicleCategoryActivity.class );
            // Start the wanted Activity
            startActivity( intentCategories );

        } );

    }
}