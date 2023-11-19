package com.thapelo.mxocars;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class VehicleAdapter extends ArrayAdapter<Vehicles> {


    /**
     * Create a new {@link VehicleAdapter} object.
     *
     * @param context         is the current context (i.e. Activity) that the adapter is being created in.
     * @param vehicles        is the list of {@link Vehicles to be displayed.
     * @param colorResourceId is the resource ID for the background color for this list of vehicles
     */
    public VehicleAdapter(Context context, ArrayList<Vehicles> vehicles) {
        super( context, 0, vehicles );

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from( getContext() ).inflate(
                    R.layout.list_appearance, parent, false );
        }
        // Get the {@link Vehicle } object located at this position in the list
        Vehicles vehicles = getItem( position );
        // Find the TextView in the appearance.xml layout with the ID mimic_brand_name_text_view.
        TextView brandNameTextView = listItemView.findViewById( R.id.mimic_brand_name_text_view );
        // Get the vehicles from the Vehicles object and set this text on
        // the brandNameTextView .
        brandNameTextView.setText( vehicles.getVehicleManufacturer() );
        // Get the vehicles from the Vehicles object and set this text on
        // Find the TextView in the appearances.xml layout with the ID mimic_model_text_view.
        TextView ModelTextView = listItemView.findViewById( R.id.mimic_model_text_view );
        // Get the vehicles from the Vehicles object and set this text on
        // the ModelTextView
        ModelTextView.setText( vehicles.getVehicleModel() );
        // Get the vehicles from the Vehicles object and set this image on
        // the vehicleImage
        ImageView vehicleImage = listItemView.findViewById( R.id.mimic_image_view );
        vehicleImage.setImageResource( vehicles.getImage() );
        // Find the TextView in the appearance.xml layout with the ID mimic_brand_name_text_view.
        TextView yearTextView = listItemView.findViewById( R.id.mimic_year_text_view );
        // Get the vehicles from the Vehicles object and set this text on
        // the brandNameTextView .
        yearTextView.setText( vehicles.getVehicleManufacturer() );
        // Find the TextView in the appearance.xml layout with the ID mimic_brand_name_text_view.
        TextView mileageTextView = listItemView.findViewById( R.id.mimic_mileage_text_view );
        // Get the vehicles from the Vehicles object and set this text on
        // the brandNameTextView .
        mileageTextView.setText( vehicles.getVehicleManufacturer() );
        // Find the TextView in the appearance.xml layout with the ID mimic_mileage_text_view.
        TextView transmissionTextView = listItemView.findViewById( R.id.mimic_transmission_text_view );
        // Get the vehicles from the Vehicles object and set this text on
        // the brandNameTextView .
        transmissionTextView.setText( vehicles.getVehicleManufacturer() );
        // Find the TextView in the appearance.xml layout with the ID mimic_fuel_text_view.
        TextView priceTextView = listItemView.findViewById( R.id.mimic_price_text_view );
        // Get the vehicles from the Vehicles object and set this text on
        // the priceTextView .
        priceTextView.setText( vehicles.getVehicleManufacturer() );
        // Find the TextView in the appearance.xml layout with the ID mimic_mileage_text_view
        TextView fuelTextView = listItemView.findViewById( R.id.mimic_fuel_text_view );
        // Get the vehicles from the Vehicles object and set this text on
        // the fuelTextView .
        fuelTextView.setText( vehicles.getFuel() );

        // Set the theme color for the list item
        //  View textContainer = listItemView.findViewById( R.id.text_container );
        // Find the color that the resource ID maps to
        //  int color = ContextCompat.getColor( getContext(), myColor );
        // Set the background color of the text container View
        //    textContainer.setBackgroundColor( color );
        // Return the whole list item layout (containing 2 TextViews and 1 ImageView) so that it can be shown in
        // the ListView.
        return listItemView;
    }
}


