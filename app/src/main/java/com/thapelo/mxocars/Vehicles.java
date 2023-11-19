package com.thapelo.mxocars;

/**
 * This class provides information about vehicles
 */
public class Vehicles {
    // Images of the vehicles
    private final int image;
    // Vehicle Manufacturer
    String vehicleManufacturer;
    // Vehicle Model
    String vehicleModel;
    // Year model of vehicle
    String year;
    // Mileage of vehicle
    String mileage;
    // Transmission of vehicle
    String transmission;
    // Price of vehicle
    String vehiclePrice;
    // Fuel type of the vehicle
    String fuel;

    /**
     * @param image-               The image of the vehicle
     * @param vehicleManufacturer- The name of the vehicle manufacturer
     * @param vehicleModel-        The name of the model of the vehicle
     * @param year-                The year model of the vehicle
     * @param mileage-             The mileage of the vehicle
     * @param transmission-        The transmission of vehicle
     * @param vehiclePrice-        The price of the vehicle
     * @param fuel-                The fuel type of the vehicle
     */
    public Vehicles(int image, String vehicleManufacturer, String vehicleModel, String year, String mileage, String transmission, String vehiclePrice, String fuel) {
        this.image = image;
        this.vehicleManufacturer = vehicleManufacturer;
        this.vehicleModel = vehicleModel;
        this.year = year;
        this.mileage = mileage;
        this.transmission = transmission;
        this.vehiclePrice = vehiclePrice;
        this.fuel = fuel;
    }

    /**
     * @return- The image of the vehicle
     */
    public int getImage() {
        return image;
    }

    /**
     * @return- The names of the vehicle manufacturer
     */
    public String getVehicleManufacturer() {
        return vehicleManufacturer;
    }

    /**
     * @return- The name of the vehicle model
     */
    public String getVehicleModel() {
        return vehicleModel;
    }

    /**
     * @return- The year model of the vehicle
     */
    public String getYear() {
        return year;
    }

    /**
     * @return- The mileage of the vehicle
     */
    public String getMileage() {
        return mileage;
    }

    /**
     * @return- The transmission of the vehicle
     */
    public String getTransmission() {
        return transmission;
    }

    /**
     * @return- The price of the vehicle
     */
    public String getVehiclePrice() {
        return vehiclePrice;
    }

    /**
     * @return - The fuel type of the car
     */
    public String getFuel() {
        return fuel;
    }
}
