package com.techgig.expedia.code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * There are N numbers in array.K iterations have to be performed on the array elements. In each iteration largest element Ai of the array is chosen and added to the answer and removed from array. At the same time floor(Ai/2) is inserted back to the array. 

Find the value of answer. Initially answer is 0.

Print answer modulo 1000000009


Input Format
First line contain 2 integers N followed by K.
Next line contain N space separated integers.


Constraints
1 <= N, K <= 10000
1 <= Ai <= 1000000


Output Format
Print the value of answer.

Sample TestCase 1
Input
2 4
8 9

output
25


explanation : 9 + 8 + 4 + 4
 * */

public class CandidateCode {
	private static int mod = 1000000009;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String input1 = reader.readLine();
		String input2 = reader.readLine();
		String splits[] = input1.split(" ");
		int n = Integer.parseInt(splits[0]);
		int k = Integer.parseInt(splits[1]);

		String split1[] = input2.split(" ");
		int[] inputData = new int[n];
		for (int i = 0; i < n; i++) {
			inputData[i] = Integer.parseInt(split1[i]);
		}

		int output = findOutput(n, inputData, k);
		System.out.print(output);
	}

	private static int findOutput(int n, int[] inputData, int k) {
		int sum = 0;
		for (int j = 0; j < k; j++) {
			Arrays.sort(inputData);
			int max = inputData[n - 1];
			sum += max;
			inputData[n - 1] = getFloor(max).intValue();
		}

		return sum % mod;
	}

	private static Double getFloor(int data) {
		return Math.floor(data / 2);
	}

}
