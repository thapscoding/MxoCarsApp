package com.thapelo.mxocars;

public enum ModelObject {
    // Create objects from
    //ObjectName(reference layout)
    Home( R.layout.happy_customer_home ),
    Customer1( R.layout.customer_one ),
    Customer2( R.layout.customer_two ),
    Customer3( R.layout.customer_three ),
    Customer4( R.layout.customer_four ),
    Customer5( R.layout.customer_five );
    private final int mLayoutResId;

    ModelObject(int layoutResId) {

        mLayoutResId = layoutResId;
    }

    public int getLayoutResId() {
        return mLayoutResId;
    }
}
