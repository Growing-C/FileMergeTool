package com.cgy.manager;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "0000001011101010";
		for (int i = 0; i < s.length(); i++) {
			int num = (int) s.charAt(i);
			System.out.println(num);
			if (num == 1) {
				// value += Math.pow(2, len - 1 - i);
			}
		}
	}

}
