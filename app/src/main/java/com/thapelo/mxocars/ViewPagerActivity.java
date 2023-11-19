package com.thapelo.mxocars;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class ViewPagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.view_pager );
        // Call the view pager by ID
        ViewPager viewPager = findViewById( R.id.my_view_pager );
        // set up the custom page adapter
        viewPager.setAdapter( new CustomPagerAdapter( this ) );
    }
}