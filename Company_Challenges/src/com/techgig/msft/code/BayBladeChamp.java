/*
 * 
 * Bay Blade Championship
 * 
 * find best optimal arrangement for winning
 * input 1: #of  test cases
 * input 2: team size
 * input 3: master team blade strength
 * input 4: enemy blade strength
 * 
 * purpose: arrange input3 & 4 such that max games are won by master
 * 
 * 
 * 1
 * 10
 * 3 6 7 5 3 5 6 2 9 1 
 * 2 7 0 9 3 6 0 6 2 6 
 * 
 * result: 7
 * 
 * */

package com.techgig.msft.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class BayBladeChamp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long testCaseInput = scanner.nextLong();
		List<TestCase> testCases = new ArrayList<>();
		for (long i = 0; i < testCaseInput; i++) {
			TestCase tc = new TestCase();
			long teamSize = scanner.nextLong();
			long gRev[] = new long[(int) teamSize];
			long tPow[] = new long[(int) teamSize];
			for (long tz1 = 0; tz1 < teamSize; tz1++) {
				gRev[(int) tz1] = scanner.nextLong();
			}
			for (long tz2 = 0; tz2 < teamSize; tz2++) {
				tPow[(int) tz2] = scanner.nextLong();
			}
			tc.setTeamSize(teamSize);
			tc.setgRevolution(gRev);
			tc.setTeamPower(tPow);
			testCases.add(tc);
		}
		scanner.close();
		//long a[] = {3L, 6L, 7L, 5L, 3L, 5L, 6L, 2L, 9L, 1L };
		//long b[] = {2L, 7L, 0L, 9L, 3L, 6L, 0L, 6L, 2L, 6L};
		//List<TestCase> testCases = Arrays.asList(new TestCase(10, a, b));
		//long testCaseInput = 1L;
		
		long result[] = processData(testCaseInput, testCases);
		for(long i=0; i< testCaseInput; i++) {
			System.out.println(result[(int) i]);
		}

	}

	private static long[] processData(final long testCaseInput, final List<TestCase> testCases) {
		long result[] = new long[(int) testCaseInput];

		for (long i = 0; i < testCaseInput; i++) {
			TestCase tc = testCases.get((int) i);
			Arrays.sort(tc.getgRevolution());
			Arrays.sort(tc.getTeamPower());
			long count = 0;
			
//			for(long j=0; j<tc.getTeamSize(); j++) {
//				if(tc.getgRevolution()[(int) j] > tc.getTeamPower()[(int) j] ) {
//					++count;
//				}else {
//					break;
//				}
//			}
			
			long p1 =0; long p2 =0;
			while(p1 < tc.getTeamSize()  && p2 <= p1) {
				if( tc.getgRevolution()[(int)p1] > tc.getTeamPower()[(int)p2]) {
					++p1; ++p2;++count;
				}else {
					++p1;
				}
			}
			
			result[(int) i] = count;
		}

		return result;
	}

}

class TestCase {
	public TestCase() {
	}
	
	public TestCase(long teamSize, long[] gRevolution, long[] teamPower) {
		super();
		this.teamSize = teamSize;
		this.gRevolution = gRevolution;
		this.teamPower = teamPower;
	}

	private long teamSize;
	private long[] gRevolution;
	private long[] teamPower;

	public long getTeamSize() {
		return teamSize;
	}

	public void setTeamSize(long teamSize) {
		this.teamSize = teamSize;
	}

	public long[] getgRevolution() {
		return gRevolution;
	}

	public void setgRevolution(long[] gRevolution) {
		this.gRevolution = gRevolution;
	}

	public long[] getTeamPower() {
		return teamPower;
	}

	public void setTeamPower(long[] teamPower) {
		this.teamPower = teamPower;
	}

}
