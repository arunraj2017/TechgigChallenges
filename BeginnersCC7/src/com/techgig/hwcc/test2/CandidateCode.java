package com.techgig.hwcc.test2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CandidateCode {
	
	public static void main(String[] args) throws Exception {
		final BufferedReader rdr = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(rdr.readLine());
		if(n > 100) {
			throw new RuntimeException("class limit exceeded");
		}
		String inputs = rdr.readLine();
		
		String inp[] = inputs.split("\\s+");
		int inpts[] = new int[n];
		for(int i=0; i<inp.length; i++) {
			inpts[i] = Integer.parseInt(inp[i]);
		}
		
		int duplicates[] = getAbsentees(inpts);
		String ret = "";
		for(int i=0; i<duplicates.length; i++) {
			if(duplicates[i] != 0) {
				if(i == 0) {
					ret = String.valueOf(duplicates[i]);
				}else {
					ret = ret + " "+ String.valueOf(duplicates[i]);
				}
			}
			
		}
		System.out.println(ret);
		
	
		
	}

	private static int[] getAbsentees(final int[] inputs) {
		Arrays.sort(inputs);
		int[] data = removeDuplicates(inputs);
		int[] retval = new int[inputs.length];
		int counter = 1;
		int retValCounter = 0;
		int ccounter = 0;
		while(counter <= inputs.length) {
			if(data[ccounter] == counter) {
				++ccounter;
			}else {
				retval[retValCounter] = counter;
				++retValCounter;
			}
			++counter;
		}
		
		return retval;
	}
	
	private static int[] removeDuplicates(final int[] inputs) {
		int ret[] = new int[inputs.length];
		int counter = 0;
		for(int i=0; i<inputs.length; i++) {
			
			if(i !=0 && (inputs[i-1] == inputs[i] )) {
				continue;
			}else {
				ret[counter] = inputs[i];
				++counter;
			}
		}
		return ret;
	}
}
