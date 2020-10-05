package com.example.oop.encapsulation;

public class EncapsulationChild extends Encapsulation {
		EncapsulationChild(){
			super();
		}
		
		public static void main(String[] args) {
			EncapsulationChild item = new EncapsulationChild();
			
			item.setAccessibleOnlyInClass(10f);
			
			System.out.println(item.getAccessibleOnlyInClass());
		}
}
