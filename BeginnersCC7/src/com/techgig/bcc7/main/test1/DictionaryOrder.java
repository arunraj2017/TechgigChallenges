package com.techgig.bcc7.main.test1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DictionaryOrder {

	public static void main(String[] args) throws Exception {
		int n;
		String inputs[] = null;

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(reader.readLine());
		inputs = new String[n];
		for (int i = 0; i < n; i++) {
			inputs[i] = reader.readLine();
		}

		sort(inputs);
	}

	private static void sort(String[] data) {
		Arrays.sort(data, (a, b) -> a.compareToIgnoreCase(b));
		for (int i = 0; i < data.length; i++) {

			if (i == data.length - 1) {
				System.out.print(data[i]);
			} else {
				System.out.println(data[i]);

			}
		}
	}

}
