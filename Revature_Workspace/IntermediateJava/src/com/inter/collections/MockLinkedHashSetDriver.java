package com.inter.collections;

public class MockLinkedHashSetDriver {
	public static void main(String[] args) {
		MockLinkedHashSet<Integer> testMLHS = new MockLinkedHashSet<>();
		testMLHS.ourAdd(1);
		testMLHS.ourAdd(6);
		testMLHS.ourAdd(7);
		testMLHS.ourAdd(3);
		testMLHS.ourAdd(4687);
		testMLHS.ourAdd(26);
		testMLHS.ourAdd(357);
		testMLHS.ourAdd(72345);
		testMLHS.ourAdd(8672354);
		testMLHS.ourAdd(124);
		testMLHS.ourAdd(983);
		testMLHS.ourAdd(34875);
//		testMLHS.ourAdd(23978);
//		testMLHS.ourAdd(28763532);
		testMLHS.ourAdd(478);
		testMLHS.ourAdd(34573);
		testMLHS.ourAdd(748756);
		testMLHS.ourAdd(567853);
		testMLHS.ourAdd(4657887);
		testMLHS.ourAdd(2647658);
		testMLHS.ourAdd(358757);
		testMLHS.ourAdd(726784345);
		testMLHS.ourAdd(78345);
		testMLHS.ourAdd(1456724);
		testMLHS.ourAdd(9456783);
		testMLHS.ourAdd(896745);

		//		testMLHS.ourAdd(23978);
//		testMLHS.ourAdd(28763532);
		
		MockLinkedHashSet<Integer> testMLHS1 = new MockLinkedHashSet<>(18, .5);
		testMLHS1.ourAdd(1);
		testMLHS1.ourAdd(6);
		testMLHS1.ourAdd(7);
		testMLHS1.ourAdd(3);
		testMLHS1.ourAdd(4687);
		testMLHS1.ourAdd(26);
		testMLHS1.ourAdd(357);
		testMLHS1.ourAdd(72345);
		testMLHS1.ourAdd(8672354);
		testMLHS1.ourAdd(124);
		testMLHS1.ourAdd(983);
//		testMLHS1.ourAdd(34875);

		MockLinkedHashSet<Integer> testMLHS2 = new MockLinkedHashSet<>(.5);
		testMLHS2.ourAdd(1);
		testMLHS2.ourAdd(6);
		testMLHS2.ourAdd(7);
		testMLHS2.ourAdd(3);
		testMLHS2.ourAdd(4687);
		testMLHS2.ourAdd(26);
		testMLHS2.ourAdd(357);
		testMLHS2.ourAdd(357);

		
//		MockLinkedHashSet<Integer> testMLHS1 = new MockLinkedHashSet<>(18);
//		testMLHS1.ourAdd(1);
//		testMLHS1.ourAdd(6);
//		testMLHS1.ourAdd(7);
//		testMLHS1.ourAdd(3);
//		testMLHS1.ourAdd(4687);
//		testMLHS1.ourAdd(26);
//		testMLHS1.ourAdd(357);
//		testMLHS1.ourAdd(72345);
//		testMLHS1.ourAdd(8672354);
//		testMLHS1.ourAdd(124);
//		testMLHS1.ourAdd(983);
//		testMLHS1.ourAdd(34875);

//		System.out.println(testMLHS.toString());
//		System.out.println(testMLHS1.toString());
		System.out.println(testMLHS2.toString());
	}
}
