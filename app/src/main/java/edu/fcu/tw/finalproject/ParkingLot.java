package edu.fcu.tw.finalproject;

import java.io.Serializable;

public class ParkingLot implements Serializable {
	
	private double lattitude;
	private double lng;
	private String name;
	private String address;
	private double price;
	private double available;
	private String opR;
    private double distance;
	
	public ParkingLot(double lattitude, double lng, String name, String address, double nPrice, String opR, double available) {
		super();
		this.lattitude = lattitude;
		this.lng = lng;
		this.name = name;
		this.address = address;
		this.price = nPrice;
		this.opR = opR;
		this.available = available;
	}

	public double getLattitude() {
		return lattitude;
	}

	public void setLattitude(double lattitude) {
		this.lattitude = lattitude;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
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


	public String getOpR() {
		return opR;
	}

	public void setOpR(String opR) {
		this.opR = opR;
	}

	public double getAvailable() {
		return available;
	}

	public void setAvailable(double available) {
		this.available = available;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public double getPrice() {
		return this.price;
	}

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
//	public ParkingLot(double nLat, double nLon, String cName, String cAdd, int nPrice, String cPR) {
//		// TODO Auto-generated constructor stub
//	}

	
	
	
	
	
	

}
