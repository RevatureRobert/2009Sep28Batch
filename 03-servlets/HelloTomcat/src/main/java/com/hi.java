package com;

public class hi {
	public static int main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };

		int sum = 0;
		for (int i : arr) {
			sum += i;
		}

		return sum;
	}
}
