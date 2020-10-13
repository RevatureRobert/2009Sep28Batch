package com.project0.enums;

public enum CarName {
	KiaSorento("Kia Sorento", 26690.00),
	KiaForte("Kia Forte",17890.00),
	KiaSoul("Kia Soul",17490.00),
	KiaTelluride("Kia Telluride",31890.00),
	KiaSedona("Kia Sedona",27600.00),
	HyundaiElantra("Hyundai Elantra",19300.00),
	HyundaiSonata("Hyundain Sonata", 22300.00),	
	HyundaiKona("Hyundai Kona", 20300.00),
	HyundaiPalisade("Hyundai Palisade", 31975.00),
	HyundaiVeloster("Hyundai Veloster", 18800.00),
	LamborghiniAventador("Lamborghini Aventador",517770.00),
	LamborghiniHuracan("Lamborghini Huracan",261274.00),
	LamborghiniUrus("Lamborghini Urus", 207326.00),
	LamborghiniGallardo("Lamborghini Gallardo",191900.00),
	LamborghiniMurcielago("Lamborghini Murcielago",354000.00),
	NissanLeaf("Nissan Leaf", 31600.00),
	NissanAltima("Nissan Altima", 24300.00),
	NissanFrontier("Nissan Frontier", 19290.00);
			
	
	private String printName;
	private double price;
	private CarName(String name, double price) {
		this.printName = name;
		this.price = price;
	}
	
	public String readable() {
	return printName;
	}
	
	
	
	public double getPrice() {
		return price;
	}
	
	
	
	

}
