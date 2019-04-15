/**
 * 
 * Given a square matrix of alphabets which contain English letters in arbitrary manner. While searching a word in it, you can go left to right horizontally, vertically downwards or diagonally towards left (both upwards and downwards).
 
You have to find the number of matches of a given word in the matrix.

For example, In the given square matrix {A#A#K,A#S#K,A#K#K},

[A A K]
[A S K]
[A K K]


The word "ASK"  is matched four times in the input matrix. So the output will be 4.


Input Format
First line  contain N, size of array of string.
Next N line contain strings containing N uppercase alphabets separated by #
Second line contain String (Word to be searched) 


Constraints
1 <= Size of string <= 10000

Output Format
Print number of occurrences of the word in the matrix {an integer}



Sample TestCase 1
Input
2
A#S
S#T
AS
Output
2
Explanation
In this example, "DISK" is matched only one time in the input matrix. So the output will be 1.
 * 
 * */

package com.techgig.mphasis.code1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SquareMatrix {

	public static void main(String[] args) throws Exception {
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		Integer input = Integer.valueOf(rd.readLine());
		String k[] = new String[input];

		for (int i = 0; i < input; ++i) {
			k[i] = rd.readLine();
		}
		String wordToFind = rd.readLine();
		String mtx[][] = getMatrix(k);
		int occurances = findOccurances(mtx, wordToFind);
		System.out.print(occurances);

	}

	private static final int findOccurances(String[][] mtx, String word) {
		int count = 0;
		for (int i = 0; i < mtx.length; ++i) {
			for (int j = 0; j < mtx[i].length; ++j) {
				count += checkPresent(mtx, i, j, word);
			}

		}

		return count;
	}

	private static int checkPresent(String[][] mtx, int i, int j, String word) {
		int count = 0;
		// check right
		if ((mtx[0].length - j) >= word.length()) {
			if (checkRight(mtx, i, j, word.toCharArray())) {
				++count;
			}
		}
		// check down
		if ((mtx.length - i) >= word.length()) {
			if (checkDown(mtx, i, j, word.toCharArray())) {
				++count;
			}
		}
		// check diagonal
		if ((mtx[0].length - j) >= word.length() & (mtx.length - i) >= word.length()) {
			if (checkDiag(mtx, i, j, word.toCharArray())) {
				++count;
			}
		}

		return count;
	}

	private static final boolean checkRight(String[][] mtx, int i, int j, char[] wrds) {
		int count = 0;
		for (int r = j; r < wrds.length; ++r) {
			if (!checkWord(mtx, i, r, wrds[count])) {
				return false;
			}
			++count;
		}

		return true;

	}

	private static final boolean checkDown(String[][] mtx, int i, int j, char[] wrds) {
		int count = 0;
		for (int r = i; r < wrds.length; ++r) {
			if (!checkWord(mtx, r, j, wrds[count])) {
				return false;
			}
			++count;
		}

		return true;

	}

	private static final boolean checkDiag(String[][] mtx, int i, int j, char[] wrds) {
		int count = 0;

		for (int d = 0; d < wrds.length; ++d) {
			if (i < mtx.length && j < mtx[0].length) {
				if (checkWord(mtx, i, j, wrds[d])) {
					++i;
					++j;
				} else {
					return false;
				}
			}
		}

		return true;

	}

	private static final boolean checkWord(String[][] mtx, int i, int j, char ltr) {
		/*
		 * if(mtx.length > i) { return false; }else if(mtx[i].length > j) { return
		 * false; }else {
		 */
		return mtx[i][j].equals(Character.toString(ltr));
		// }
	}

	private static final String[][] getMatrix(String[] k) {
		int splitL = k[0].split("#").length;
		String ret[][] = new String[k.length][splitL];
		for (int i = 0; i < k.length; ++i) {
			String val[] = k[i].split("#");
			for (int j = 0; j < splitL; j++) {
				ret[i][j] = val[j];
			}
		}

		return ret;
	}

}
