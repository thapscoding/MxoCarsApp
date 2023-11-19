package com.thapelo.mxocars;


import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;

public class VehicleCategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_vehicle_catergory );
        //Find View by ID
        FrameLayout suv = findViewById( R.id.suv_frame );
        FrameLayout miniBus = findViewById( R.id.mini_frame );
        FrameLayout sedan = findViewById( R.id.sedan_frame );
        FrameLayout pickupTruck = findViewById( R.id.van_frame );
        FrameLayout electrical = findViewById( R.id.ev_frame );
        FrameLayout hatch = findViewById( R.id.hatch_frame );

        // SetOnClickListener on the View
        suv.setOnClickListener( v -> {
            Intent intentSuv = new Intent( VehicleCategoryActivity.this, SuvActivity.class );
            // Start the wanted Activity
            startActivity( intentSuv );

        } );
        miniBus.setOnClickListener( v -> {
            Intent intentMinibus = new Intent( VehicleCategoryActivity.this, MinibusActivity.class );
            // Start the wanted Activity
            startActivity( intentMinibus );

        } );
        sedan.setOnClickListener( v -> {
            Intent intentSedan = new Intent( VehicleCategoryActivity.this, SedanActivity.class );
            // Start the wanted Activity
            startActivity( intentSedan );

        } );
        // setOnClickListener on the View
        pickupTruck.setOnClickListener( v -> {
            Intent intentPickUpTruck = new Intent( VehicleCategoryActivity.this, PickupActivity.class );
            // Start the wanted Activity
            startActivity( intentPickUpTruck );


        } );
        // setOnClickListener on the View
        electrical.setOnClickListener( v -> {
            Intent intentElectrical = new Intent( VehicleCategoryActivity.this, EvActivity.class );
            // Start the wanted Activity
            startActivity( intentElectrical );

        } );

        // setOnClickListener on the View
        hatch.setOnClickListener( v -> {
            // Call the Intent source Activity to destination Activity
            Intent intentHatch = new Intent( VehicleCategoryActivity.this, HatchActivity.class );
            // Start the wanted Activity
            startActivity( intentHatch );
        } );
    }
}



