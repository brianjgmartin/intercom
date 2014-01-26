package test;

import util.WordSequenceUtil;

public class WordSequenceTest {
	WordSequenceUtil ws = new WordSequenceUtil();
	String dictionaryFilePath;
	String src;
	String des;
	int pathSize;

	/**
	 * Passing invalid dictionary path
	 */
	private void Test1() {
		dictionaryFilePath = "dictionary.txt1";
		src = "cold";
		des = "warm";
		pathSize = 6;
		TestMessages(1, "Passing invalid dictionary", dictionaryFilePath, src,
				des, pathSize);
		ws.init(dictionaryFilePath, src, des, pathSize);
		System.out.println();
	}

	/**
	 * Passing different length input
	 */
	private void Test2() {
		dictionaryFilePath = "dictionary.txt";
		src = "cold";
		des = "dog";
		pathSize = 6;
		TestMessages(2, "Passing different length input", dictionaryFilePath,
				src, des, pathSize);
		ws.init(dictionaryFilePath, src, des, pathSize);
		System.out.println();
	}

	/**
	 * Pass null as one of the input
	 */
	private void Test3() {
		dictionaryFilePath = "dictionary.txt";
		src = "cold";
		des = null;
		pathSize = 6;
		TestMessages(3, "Pass null as one of the input", dictionaryFilePath,
				src, des, pathSize);
		ws.init(dictionaryFilePath, src, des, pathSize);
		System.out.println();
	}

	/**
	 * Passing invalid input
	 */
	private void Test4() {
		dictionaryFilePath = "dictionary.txt";
		src = "co1d";
		des = "warm";
		pathSize = 10;
		TestMessages(4, "Passing incorrect/invalid input", dictionaryFilePath, src, des,
				pathSize);
		ws.init(dictionaryFilePath, src, des, pathSize);
		System.out.println();
	}
	
	/**
	 * Passing correct input
	 */
	private void Test5() {
		dictionaryFilePath = "dictionary.txt";
		src = "cold";
		des = "warm";
		pathSize = 10;
		TestMessages(5, "Passing correct input", dictionaryFilePath, src, des,
				pathSize);
		ws.init(dictionaryFilePath, src, des, pathSize);
		System.out.println();
	}

	public static void main(String[] args) {
		WordSequenceTest test = new WordSequenceTest();
		test.Test1();
		test.Test2();
		test.Test3();
		test.Test4();
		test.Test5();
	}

	private void TestMessages(int testNumber, String testDesc, String filePath,
			String src, String des, int pathSize) {
		System.out.println("Test No  :" + testNumber);
		System.out.println("Test Desc:" + testDesc);
		System.out.println("Input : file:" + filePath + " " + src + " ... -> "
				+ des + " pathSize:" + pathSize);
	}

}
