/*
 * Power Puff Girls
 * 
 * Maximum number of power puff girls that can be manufactured using 
 * given ingredients and quantity
 * 
 * input 1: # ingredients required
 * input 2: # quantity of ingredients required
 * input 3: # the amount of ingredients we have for preparation
 * 
 * 
 * 
 * */

package com.techgig.msft.code;

import java.util.Arrays;
import java.util.Scanner;

public class CandidateCode {
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		long numberOfIng = scanner.nextLong();
		long quantityArray[] = new long[(int) numberOfIng];
		for(int i=0; i < numberOfIng; i++) {
			quantityArray[i] = scanner.nextLong();
		}
		long totalQuantityArray[] = new long[(int) numberOfIng];
		for(int i=0; i < numberOfIng; i++) {
			totalQuantityArray[i] = scanner.nextLong();
		}
		
		scanner.close();
		getPowerPuffGirlsCount(numberOfIng, quantityArray, totalQuantityArray);
	}
	
	private static void getPowerPuffGirlsCount(final long ingredientsCount, final long[] quantityArray, final long[] totalQuantityArray) {
		//iterate over arrays, get the reminder, get the lowest
		
		long tempCalc[] = new long[(int)ingredientsCount];
		for(int i=0; i<ingredientsCount; i++) {
			tempCalc[i] = totalQuantityArray[i]/quantityArray[i];	
		}
		System.out.println(findLowest(tempCalc));
	}
	
	private static long findLowest(final long[] processedData) {
		 Arrays.sort(processedData);
		 return processedData[0];
	}

}
