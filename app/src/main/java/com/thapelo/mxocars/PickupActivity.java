package com.thapelo.mxocars;


import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ListView;

import com.thapelo.mxocars.databinding.ActivityPickupBinding;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class PickupActivity extends DrawerBaseActivity {
    private final int[] myImageList = new int[]{R.drawable.mahindra_side, R.drawable.benze_van_side, R.drawable.amarok_side, R.drawable.nissan_side};
    ActivityPickupBinding mActivityPickupBinding;
    private ImageSwitcher imageSwitcher;
    private int currentIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        mActivityPickupBinding = ActivityPickupBinding.inflate( getLayoutInflater() );
        setContentView( mActivityPickupBinding.getRoot() );
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
        vehicles.add( new Vehicles( R.drawable.mahindra_side, "Mahindra", "M hawk", "2022", "6,347 kms", "Manual", "R269,999", "Diesel" ) );
        vehicles.add( new Vehicles( R.drawable.benze_van_side, "Benz", "X250d", "2018", "45,000 kms", "Manual", "R599,899", "Diesel" ) );
        vehicles.add( new Vehicles( R.drawable.amarok_side, "Volkswagen", "Amarok", "2020", "48,000 kms", "Automatic", "R789,995", "Diesel" ) );
        vehicles.add( new Vehicles( R.drawable.nissan_side, "Nissan", "Navara", "2022", "Low kms", "Manual", "R379,900", "Diesel" ) );
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
            Intent intentSpecifications = new Intent( PickupActivity.this, SpecificationActivity.class );
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
