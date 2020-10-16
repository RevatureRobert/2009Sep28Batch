package com.friday.factory;

public class CarFactory {
	public static Car buildACar(FuelTypes t) {
		switch(t){
			case electric:
				return new ElectricCar();
			case gas:
				return new GasGuzzler();
			case diesel:
			
			default:
				throw new IllegalArgumentException();
		}
	}
	
	public static void main(String[] args) {
		Car gas = CarFactory.buildACar(FuelTypes.gas);
		Car electric = CarFactory.buildACar(FuelTypes.gas);
		gas.makeSound();
		Car diesel = CarFactory.buildACar(FuelTypes.diesel);
	}
}
