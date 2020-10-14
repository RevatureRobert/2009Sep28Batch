package com.project.model;

public class Car {
	
	private int ID;
	private String make;
	private String model;
	private int year;
	private String color;
	private String condition;
	private int belongsTo;
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSize() {
		return condition;
	}
	public void setSize(String size) {
		this.condition = size;
	}
	public int getBelongsTo() {
		return belongsTo;
	}
	public void setBelongsTo(int belongsTo) {
		this.belongsTo = belongsTo;
	}
	
	public Car(int ID, int belongsTo) {
		this.ID = ID;
		this.belongsTo = belongsTo;
	}
	
	public Car() {
		this.ID=-1;
	}
	
	public Car(int ID, String make, String model, int year, String color, String condition) {
		this.ID = ID;
		this.make = make;
		this.model = model;
		this.year = year;
		this.color = color;
		this.condition = condition;
	}
	
	public Car(String make, String model, int year, String color, String condition) {
		this.make = make;
		this.model = model;
		this.year = year;
		this.color = color;
		this.condition = condition;
	}
	
	@Override
	public String toString() {
		return ("Car #"+this.ID+" | Make: "+this.make.toUpperCase()+" | Model: "+this.model.toUpperCase()+" | Year: "+this.year+" | Color: "+this.color.toUpperCase()+" | Condition: "+this.condition.toUpperCase());
	}
	
	public String whoOwns() {
		return String.valueOf(this.belongsTo);
	}
	
	public String condensedDescription() {	// Displays the main descriptors of a car
		return (this.color.toUpperCase()+" "+this.make.toUpperCase()+" "+this.model.toUpperCase());
	}
	
	// For when I figure out how to use log.4j
	
//	final static Logger logger = Logger.getLogger("Car");
	
}
