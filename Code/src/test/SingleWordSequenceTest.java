package test;

import util.SingleWordSequenceUtil;

public class SingleWordSequenceTest {
	SingleWordSequenceUtil ws = new SingleWordSequenceUtil();
	String dictionaryFilePath;
	String src;
	String des;
	
	/**
	 * Passing invalid dictionary path
	 */
	private void Test1() {
		dictionaryFilePath = "dictionary.txt1";
		src = "cold";
		des = "warm";
		TestMessages(1, "Passing invalid dictionary", dictionaryFilePath, src, des);
		ws.init(dictionaryFilePath, src, des);	
		System.out.println();
	}
	
	/**
	 * Passing different length input
	 */
	private void Test2() {
		dictionaryFilePath = "dictionary.txt";
		src = "cold";
		des = "dog";
		TestMessages(2, "Passing different length input", dictionaryFilePath, src, des);
		ws.init(dictionaryFilePath, src, des);
		System.out.println();
	}
	
	/**
	 * Pass null as one of the input
	 */
	private void Test3() {
		dictionaryFilePath = "dictionary.txt";
		src = "cold";
		des = null;
		TestMessages(3, "Passing null as input", dictionaryFilePath, src, des);
		ws.init(dictionaryFilePath, src, des);
		System.out.println();
	}
	

	/**
	 * Passing correct input
	 */
	private void Test4() {
		dictionaryFilePath = "dictionary.txt";
		src = "co1d";
		des = "warm";
		TestMessages(4, "Passing invalid input", dictionaryFilePath, src, des);
		ws.init(dictionaryFilePath, src, des);
		System.out.println();
	}
	
	/**
	 * Passing correct input
	 */
	private void Test5() {
		dictionaryFilePath = "dictionary.txt";
		src = "cold";
		des = "warm";
		TestMessages(5, "Passing correct input", dictionaryFilePath, src, des);
		ws.init(dictionaryFilePath, src, des);
		System.out.println();
	}
	
	public static void main(String[] args) {
		SingleWordSequenceTest test = new SingleWordSequenceTest();
		test.Test1();
		test.Test2();
		test.Test3();
		test.Test4();
		test.Test5();
	}
	
	
	private void TestMessages(int testNumber, String testDesc, String filePath , String src, String des) {
		System.out.println("Test No  :" + testNumber);
		System.out.println("Test Desc:" + testDesc);
		System.out.println("Input : file:" + filePath + " "+src + " ... -> " + des);
	}
	
}
