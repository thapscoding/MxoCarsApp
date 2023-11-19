package com.thapelo.mxocars;


import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ListView;

import com.thapelo.mxocars.databinding.ActivitySuvBinding;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class SuvActivity extends DrawerBaseActivity {
    private final int[] myImageList = new int[]{R.drawable.x_1_side, R.drawable.g_63_white_side, R.drawable.g_400_side, R.drawable.jag_side, R.drawable.audi_q_side, R.drawable.range_evogue_side, R.drawable.range_vogue_side, R.drawable.range_rover_side, R.drawable.t_cross_side, R.drawable.tuscan_side, R.drawable.g_400_side, R.drawable.glc_43_side};
    ActivitySuvBinding mActivitySuvBinding;
    private ImageSwitcher imageSwitcher;
    private int currentIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        mActivitySuvBinding = ActivitySuvBinding.inflate( getLayoutInflater() );
        setContentView( mActivitySuvBinding.getRoot() );
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
        vehicles.add( new Vehicles( R.drawable.x_1_side, "Bmw ", "X1", "2021", "21,737 kms", "Automatic", "R679,990", "Diesel" ) );
        vehicles.add( new Vehicles( R.drawable.g_63_white_side, "Benz", "G63", "2022", "low kms", "Automatic", "R4,249,900", "Petrol" ) );
        vehicles.add( new Vehicles( R.drawable.g_400_side, "Benz ", "G400d", "2021", "22,000 kms", "Automatic", "R2,999,899", "Diesel" ) );
        vehicles.add( new Vehicles( R.drawable.jag_side, "Jaguar", "F-Pace", "2019", "46,272 kms", "Automatic", "R769,950", "Diesel" ) );
        vehicles.add( new Vehicles( R.drawable.audi_q_side, "Audi", "Q2", "2020", "35,133 kms", "Automatic", "R519,999", "Petrol" ) );
        vehicles.add( new Vehicles( R.drawable.range_evogue_side, "Land Rover", "E vogue", "2019", "17,200 kms", "Automatic", "R979,950", "Diesel" ) );
        vehicles.add( new Vehicles( R.drawable.range_vogue_side, "Range Rover", "Vogue", "2018", "46,000 kms", "Automatic", "R1,349,900", "Petrol" ) );
        vehicles.add( new Vehicles( R.drawable.range_rover_side, "Range Rover", "Velar", "2020", "39,920 kms", "Automatic", "R1,389,950", "Diesel" ) );
        vehicles.add( new Vehicles( R.drawable.t_cross_side, "Volkswagen", "T-cross", "2021", "11,000 kms", "Automatic", "R419,900", "Petrol" ) );
        vehicles.add( new Vehicles( R.drawable.tuscan_side, "Hyundai", "Tuscan", "2021", "17,600 kms", "Manual", "R419,999", "Petrol" ) );
        vehicles.add( new Vehicles( R.drawable.g_side, "Benz", "Gls400d", "2022", "11,000 kms", "Automatic", "R2,199,899", "Diesel" ) );
        vehicles.add( new Vehicles( R.drawable.glc_43_side, "Benz", "Glc43", "2022", "10,000 kms", "Automatic", "R1,349,900", "Petrol" ) );

        // adapter knows how to create list items for each item in the list.
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
            Intent intentSpecifications = new Intent( SuvActivity.this, SpecificationActivity.class );
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