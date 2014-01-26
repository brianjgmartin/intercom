package test;

import util.TopN;

public class TopNTest {

	private void Test1() {
		String filePath = "numbers.txt1";
		int n = 1;
		this.TestMessages(1, "Passing wrong file path", filePath, n);
		TopN.topN(filePath, n);
		System.out.println();
	}
	
	private void Test2() {
		String filePath = "numbers.txt";
		int n = -1;
		this.TestMessages(2, "Passing negative N", filePath, n);
		TopN.topN(filePath, n);
		System.out.println();
	}
	
	private void Test3() {
		String filePath = "invalidNumbers.txt";
		int n = 10;
		this.TestMessages(3, "Passing file with invalid input", filePath, n);
		TopN.topN(filePath, n);
		System.out.println();
	}
	
	private void Test4() {
		String filePath = "numbers.txt";
		int n = 100;
		this.TestMessages(4, "Passing file with correct input and getting all in output", filePath, n);
		TopN.topN(filePath, n);
		System.out.println();
	}
	
	private void Test5() {
		String filePath = "numbers.txt";
		int n = 10;
		this.TestMessages(5, "Passing file with correct input and getting few in output", filePath, n);
		TopN.topN(filePath, n);
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		TopNTest test = new TopNTest();
		test.Test1();
		test.Test2();
		test.Test3();
		test.Test4();
		test.Test5();
	}
	
	private void TestMessages(int testNumber, String testDesc, String filePath , int n) {
		System.out.println("Test No  :" + testNumber);
		System.out.println("Test Desc:" + testDesc);
		System.out.println("Input : file:" + filePath + " n="+n);
	}

}
