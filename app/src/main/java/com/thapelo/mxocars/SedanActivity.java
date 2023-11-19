package com.thapelo.mxocars;


import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ListView;

import com.thapelo.mxocars.databinding.ActivitySedanBinding;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class SedanActivity extends DrawerBaseActivity {
    private final int[] myImageList = new int[]{R.drawable.a_3_red_side, R.drawable.bm_5series_side, R.drawable.cclass_side, R.drawable.cclass_white_side, R.drawable.corolla_side, R.drawable.new_cclass_side, R.drawable.new_cclass_silver};
    ActivitySedanBinding mActivitySedanBinding;
    private ImageSwitcher imageSwitcher;
    private int currentIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        mActivitySedanBinding = ActivitySedanBinding.inflate( getLayoutInflater() );
        setContentView( mActivitySedanBinding.getRoot() );
        imageSwitcher = findViewById( R.id.vehicle_image_switcher );
        imageSwitcher.setFactory( () -> new ImageView( getApplicationContext() ) );

        Timer t = new Timer();
        //Set the schedule function and rate
        t.scheduleAtFixedRate( new TimerTask() {

            public void run() {

                runOnUiThread( () -> {
                    if (currentIndex == myImageList.length - 1) {
                        currentIndex = 0;
                        imageSwitcher.setImageResource( myImageList[currentIndex] );
                    } else {
                        imageSwitcher.setImageResource( myImageList[++currentIndex] );
                    }
                } );
            }

        }, 0, 5000 );
        // Array List of cars

        ArrayList<Vehicles> vehicles = new ArrayList<>();
        vehicles.add( new Vehicles( R.drawable.a_3_red_side, "Audi", "A3 1.0T FSI ", "2020", "34,500 kms", "Automatic", "R469,999", "Petrol" ) );
        vehicles.add( new Vehicles( R.drawable.bm_5series_side, "Bmw", "520d M", "2021", "34,387 kms", "Automatic", "R869,950", "Diesel" ) );
        vehicles.add( new Vehicles( R.drawable.cclass_side, "Benz", "C180", "2019", "77,000 kms", "Automatic", "R549,899", "Petrol" ) );
        vehicles.add( new Vehicles( R.drawable.cclass_white_side, "Benz", "C220", "2017", "97,500 kms", "Automatic", "R399,899", "Diesel" ) );
        vehicles.add( new Vehicles( R.drawable.corolla_side, "Toyota", "Corolla 2.0 XR", "2021", "48,000 kms", "Manual", "R429,990", "Petrol" ) );
        vehicles.add( new Vehicles( R.drawable.new_cclass_side, "Benz", "C200", "2022", "18,500 kms", "Automatic", "R789,900", "Petrol" ) );
        vehicles.add( new Vehicles( R.drawable.new_cclass_silver, "Benz", "Cla200", "2022", "13,000 kms", "Automatic", "R889,900", "Petrol" ) );


        VehicleAdapter adapter = new VehicleAdapter( this, vehicles );
        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called vehicle_list, which is declared in the
        // vehicle_list.xml layout file.
        ListView listView = findViewById( R.id.vehicle_list_view );
        // Make the {@link ListView} use the {@link VehiclesAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Vehicles} in the list.
        listView.setAdapter( adapter );
        // Set OnClickListener on ListView to identify the item on ListView clicked by user
        // Text on the ListView item clicked is passed on to SpecificationActivity
        // Set a click listener to open Player Activity
        listView.setOnItemClickListener( (adapterView, view, position, l) -> {
            // Get the {@link Titles} object at the given position the user clicked on
            Vehicles vehicleHatch = vehicles.get( position );
            // get image of the vehicle
            int image = vehicleHatch.getImage();
            // get manufacturer name of the vehicle
            String manufacture = vehicleHatch.getVehicleManufacturer();
            // get model name name of the vehicle
            String model = vehicleHatch.getVehicleModel();
            // get the year model of the vehicle
            String year = vehicleHatch.getYear();
            // get the mileage of the vehicle
            String mileage = vehicleHatch.getMileage();
            // get the transmission of the vehicle
            String transmission = vehicleHatch.getTransmission();
            // get the vehicle of the vehicle
            String vehiclePrice = vehicleHatch.getVehiclePrice();
            // get the fuel type of the vehicle
            String vehicleFuel = vehicleHatch.getFuel();

            // Call the Intent source Activity to destination Activity
            // Name intent variable should match that of the Intent that s being called by getIntent in the SpecificationsActivity
            Intent intentSpecifications = new Intent( SedanActivity.this, SpecificationActivity.class );
            // Set the keys
            intentSpecifications.putExtra( "getImage", image );
            intentSpecifications.putExtra( "getVehicleManufacturer", manufacture );
            intentSpecifications.putExtra( "getVehicleModel", model );
            intentSpecifications.putExtra( "getYear", year );
            intentSpecifications.putExtra( "getMileage", mileage );
            intentSpecifications.putExtra( "getTransmission", transmission );
            intentSpecifications.putExtra( "getVehiclePrice", vehiclePrice );
            intentSpecifications.putExtra( "getFuel", vehicleFuel );

            // Start the wanted Activity
            startActivity( intentSpecifications );
        } );
    }
}
