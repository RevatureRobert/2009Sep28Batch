package com.cardealer.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Car {
	private int carID;
	private String carModel;
	private String carMake;
	private String carYear;
	private String carColor;
	private int carValue;
	private boolean isOwned;

	public Car (String Make, String model, String Year, String Color, int Value) {
		this.carModel = model;
		this.carMake = Make;
		this.carYear = Year;
		this.carColor = Color;
		this.carValue = Value;
	}
	public Car (int carID, String Make, String model, String Year, String Color, int Value) {
		this.carID = carID;
		this.carModel = model;
		this.carMake = Make;
		this.carYear = Year;
		this.carColor = Color;
		this.carValue = Value;
	}
	
	public Car (ResultSet result) throws SQLException {
		this.carID = (result.getInt(1));
		this.carMake = (result.getString(2));
		this.carModel = (result.getString(3));
		this.carYear = (result.getString(4));
		this.carColor = (result.getString(5));
		this.carValue = (result.getInt(6));
		this.isOwned = (result.getBoolean(7));
	}
	@Override
	public String toString() {
		return "Car [carID=" + carID + ", carModel=" + carModel + ", carMake=" + carMake + ", carYear=" + carYear
				+ ", carColor=" + carColor + ", carValue=" + carValue + "]";
	}

	public int getCarID() {
		return carID;
	}

	public String getCarModel() {
		return carModel;
	}

	public String getCarMake() {
		return carMake;
	}

	public String getCarYear() {
		return carYear;
	}

	public String getCarColor() {
		return carColor;
	}

	public int getCarValue() {
		return carValue;
	}

	public boolean isOwned() {
		return isOwned;
	}
}
