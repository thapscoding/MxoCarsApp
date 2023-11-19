package com.thapelo.mxocars;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class AboutUsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.about_us );
        // Call the MediaPlayer
        final MediaPlayer mediaPlayer2 = MediaPlayer.create( this, R.raw.mxo_assist_you );
        // Assign values to variables
        String number = "+27832252708";
        String text = "Hi Mxo cars ";
        AppCompatButton landLine = findViewById( R.id.landline_button );

        AppCompatButton directionsButton = findViewById( R.id.direction_button );
        // Get directions with google maps
        directionsButton.setOnClickListener( v -> {

            Intent mapIntent = new Intent( Intent.ACTION_VIEW, Uri.parse( "geo:0,0?q=1073 Steve Biko drive" ) );
            mapIntent.addFlags( Intent.FLAG_ACTIVITY_NEW_TASK ); // this will make such that when user returns to your app, your app is displayed, instead of the map app.
            startActivity( mapIntent );

        } );

        // Make a phone call and play a sound
        landLine.setOnClickListener( v -> {
            Intent landLineIntent = new Intent( Intent.ACTION_DIAL );
            landLineIntent.setData( Uri.parse( "tel:012-543-8413" ) );
            startActivity( landLineIntent );
            mediaPlayer2.start();
        } );
        AppCompatButton emailButton = findViewById( R.id.email_button );
        // Email to specific address
        emailButton.setOnClickListener( v -> {
            Intent emailIntent = new Intent( Intent.ACTION_SENDTO ); // it's not ACTION_SEND
            emailIntent.putExtra( Intent.EXTRA_SUBJECT, "Customer from the Mxo cars App" );
            emailIntent.putExtra( Intent.EXTRA_TEXT, "Hi MxoCars" );
            emailIntent.setData( Uri.parse( "mailto:" ) );
            emailIntent.putExtra( Intent.EXTRA_EMAIL, new String[]{"mxolisin@mcmotor.com"} );
            emailIntent.addFlags( Intent.FLAG_ACTIVITY_NEW_TASK ); // this will make such that when user returns to your app, your app is displayed, instead of the email app.
            if (emailIntent.resolveActivity( getPackageManager() ) != null) {
                startActivity( emailIntent );

            }

        } );
        AppCompatButton whatsAppButton = findViewById( R.id.whatsapp_button );
        // Send a what-app message
        whatsAppButton.setOnClickListener( v -> {
            boolean installed = isAppInstalled();
            if (installed) {
                Intent whatsappIntent = new Intent( Intent.ACTION_VIEW );
                whatsappIntent.setData( Uri.parse( "http://api.whatsapp.com/send?phone=" + number + "&text=" + text ) );
                whatsappIntent.addFlags( Intent.FLAG_ACTIVITY_NEW_TASK ); // this will make such that when user returns to your app, your app is displayed, instead of the email app.
                startActivity( whatsappIntent );

            } else {
                Toast.makeText( this, "You don't have whatsapp installed", Toast.LENGTH_SHORT ).show();
            }


        } );
    }

    // Check if WhatsApp is installed
    private boolean isAppInstalled() {
        PackageManager packageManager = getPackageManager();
        boolean isInstalled;
        try {
            packageManager.getPackageInfo( "com.whatsapp", PackageManager.GET_ACTIVITIES );
            isInstalled = true;
        } catch (PackageManager.NameNotFoundException e) {
            isInstalled = false;
            e.printStackTrace();
        }
        return isInstalled;
    }
}




