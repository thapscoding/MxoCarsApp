package com.thapelo.mxocars;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

public class DrawerBaseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;


    @Override

    public void setContentView(View view) {
        drawerLayout = (DrawerLayout) getLayoutInflater().inflate( R.layout.activity_drawer_base, null );
        final MediaPlayer mediaPlayer = MediaPlayer.create( this, R.raw.please_ask_for_mxo );
        FrameLayout container = drawerLayout.findViewById( R.id.activityContainer );
        container.addView( view );
        super.setContentView( drawerLayout );
        Toolbar toolbar = drawerLayout.findViewById( R.id.toolBar );
        setSupportActionBar( toolbar );
        NavigationView navigationView = drawerLayout.findViewById( R.id.nav_view );
        navigationView.setNavigationItemSelectedListener( this );
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle( this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close );
        drawerLayout.addDrawerListener( toggle );
        toggle.syncState();
        // float will be shared across Categories
        FloatingActionButton floatingActionButton = findViewById( R.id.contact_fab );
        floatingActionButton.setOnClickListener( v -> {
            Intent intent = new Intent( Intent.ACTION_DIAL );
            intent.setData( Uri.parse( "tel:012-543-8413" ) );
            startActivity( intent );
            mediaPlayer.start();
        } );
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_finance:
                Intent intentFinance = new Intent( DrawerBaseActivity.this, VehicleApplication.class );
                // Start the wanted Activity
                startActivity( intentFinance );

                // start activity 1
                return true;
            case R.id.nav_enquiries:
                Intent intentEnquire = new Intent( DrawerBaseActivity.this, AboutUsActivity.class );
                // Start the wanted Activity
                startActivity( intentEnquire );
                // start activity 2
                return true;
            case R.id.nav_customers:
                Intent intentCustomers = new Intent( DrawerBaseActivity.this, ViewPagerActivity.class );
                // Start the wanted Activity
                startActivity( intentCustomers );
                // start activity 3


                return true;
            default:
                //default intent
                return true;
        }
    }
}
