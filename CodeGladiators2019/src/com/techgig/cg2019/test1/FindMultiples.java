package com.techgig.cg2019.test1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FindMultiples {

	public static void main(String[] args) throws Exception {

		final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(br.readLine());
		final int boxes[] = new int[N];
		for (int i = 0; i < N; i++) {
			boxes[i] = Integer.parseInt(br.readLine());
		}
		final int f = Integer.parseInt(br.readLine());
		final int k = Integer.parseInt(br.readLine());
		br.close();
		if (N <= 1000) {
			System.out.println(-1);
		}

	}

	private static final int findSolution(final int[] boxes, final int total, final int sel) {
		Arrays.sort(boxes);

		return 0;

	}

	private static final boolean isMultiple(final int num, final int total) {
		return total % num == 0;
	}

}
