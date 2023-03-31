package com.clmtra.javaexamples;

import com.google.common.math.BigIntegerMath;

import java.math.BigInteger;
import java.math.RoundingMode;

public class Main {

	public static void main(String[] args) {
		BigInteger sqrtResult = BigIntegerMath.sqrt(BigInteger.TEN, RoundingMode.HALF_UP);
		System.out.println("Result: " + sqrtResult);
	}
}
