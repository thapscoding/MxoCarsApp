package com.thapelo.mxocars;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class SpecificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.list_vehicle_specification_appearance );
        final MediaPlayer mediaPlayer3 = MediaPlayer.create( this, R.raw.be_ready );
        Intent intentSpecifications = getIntent();
        // Find your Image View by ID
        ImageView imageViewArtist = findViewById( R.id.mimic_image_view2 );
        // Call Bundle object
        Bundle bundle = getIntent().getExtras();
        // Load image
        if (bundle != null) {
            int resId = bundle.getInt( "getImage" );
            imageViewArtist.setImageResource( resId );
        }
        // Find your Text View by ID
        TextView brandTextView = findViewById( R.id.mimic_brand_name_text_view2 );
        // Retrieve the key name case sensitive
        String brand = intentSpecifications.getStringExtra( "getVehicleManufacturer" );
        brandTextView.setText( "Brand : " + brand );
        // Find your Text View by ID
        TextView modelTextView = findViewById( R.id.mimic_model_text_view2 );
        // Retrieve the key name case sensitive
        String model = intentSpecifications.getStringExtra( "getVehicleModel" );
        modelTextView.setText( "Model : " + model );
        // Find your Text View by ID
        TextView yearTextView = findViewById( R.id.mimic_year_text_view2 );
        // Retrieve the key name case sensitive
        String year = intentSpecifications.getStringExtra( "getYear" );
        yearTextView.setText( "Year Model : " + year );
        // Find your Text View by ID
        TextView mileageTextView = findViewById( R.id.mimic_mileage_text_view2 );
        // Retrieve the key name case sensitive
        String mileage = intentSpecifications.getStringExtra( "getMileage" );
        mileageTextView.setText( "Mileage : " + mileage );
        // Find your Text View by ID
        TextView transmissionTextView = findViewById( R.id.mimic_transmission_text_view2 );
        // Retrieve the key name case sensitive
        String transmission = intentSpecifications.getStringExtra( "getTransmission" );
        transmissionTextView.setText( "Transmission : " + transmission );
        // Find your Text View by ID
        TextView priceTextView = findViewById( R.id.mimic_price_text_view2 );
        // Retrieve the key name case sensitive
        String price = intentSpecifications.getStringExtra( "getVehiclePrice" );
        priceTextView.setText( "Price : " + price );
        TextView fuelTextView = findViewById( R.id.mimic_fuel_text_view2 );
        // Retrieve the key name case sensitive
        String fuel = intentSpecifications.getStringExtra( "getFuel" );
        fuelTextView.setText( "Fuel Type : " + fuel );
        AppCompatButton appCompatEnquiries = findViewById( R.id.enquiry_button );
        appCompatEnquiries.setOnClickListener( v -> {
            Intent cellPhoneIntent = new Intent( Intent.ACTION_DIAL );
            cellPhoneIntent.setData( Uri.parse( "tel:083-225-2708" ) );
            startActivity( cellPhoneIntent );
            mediaPlayer3.start();
        } );
    }
}