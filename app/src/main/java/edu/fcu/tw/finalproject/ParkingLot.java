package edu.fcu.tw.finalproject;

import android.util.Log;

import java.io.Serializable;

/**
 * Created by sky_h on 6/20/2017.
 */

public class ParkingLot implements Serializable {
    private static final long serialVersionUID = 1L;
    private String latitude;
    private String lng;
    private String name;
    private String address;
    private String price;
    private String available;
    private String opR;
    private String distance;


    public ParkingLot(String latitude, String lng, String name, String address, String nPrice, String opR, String available,String distance) {
        super();
        this.latitude = latitude;
        this.lng = lng;
        this.name = name;
        this.address = address;
        this.price = nPrice;
        this.opR = opR;
        this.available = available;
        this.distance = distance;

    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public String getOpR() {
        return opR;
    }

    public void setOpR(String opR) {
        this.opR = opR;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public void printAll(){
        System.out.println(this.name);
        System.out.println(this.address);
        System.out.println(this.available);
        System.out.println(this.price);
        System.out.println(this.opR);

    }

//	public ParkingLot(double nLat, double nLon, String cName, String cAdd, int nPrice, String cPR) {
//		// TODO Auto-generated constructor stub
//	}


    public static void main(String[] args) {

        System.out.println("asdasd");
    }


}
