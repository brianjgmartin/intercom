package test;

import java.util.ArrayList;
import util.ArrayListUtil;

public class ArrayFlattenerTest {

	/**
	 * Passing null array
	 */
	private void Test1() {
		ArrayList<Object> arrayList = null;
		this.TestMessages(1, "Passing null array", arrayList);
		System.out.println("Output : "
				+ ArrayListUtil.arrayFlattener(arrayList) + "\n");
	}

	/**
	 * Passing empty array
	 */
	private void Test2() {
		ArrayList<Object> arrayList = new ArrayList<Object>();
		this.TestMessages(2, "Passing empty array", arrayList);
		System.out.println("Output : "
				+ ArrayListUtil.arrayFlattener(arrayList) + "\n");
	}

	/**
	 * Passing simple array
	 */
	private void Test3() {
		ArrayList<Object> arrayList = new ArrayList<Object>();
		arrayList.add(1);
		arrayList.add(2);
		arrayList.add(3);
		arrayList.add(4);
		arrayList.add(5);
		this.TestMessages(3, "Passing simple array", arrayList);
		System.out.println("Output : "
				+ ArrayListUtil.arrayFlattener(arrayList) + "\n");
	}

	/**
	 * Passing leve1 nested arrayList with int array
	 */
	private void Test4() {
		ArrayList<Object> arrayList = new ArrayList<Object>();
		arrayList.add(new int[] { 1, 2, 3, 4 });
		this.TestMessages(4, "Passing leve1 nested arrayList with int array",
				arrayList);
		System.out.println("Output : "
				+ ArrayListUtil.arrayFlattener(arrayList) + "\n");
	}

	/**
	 * Passing leve1 nested arrayList with int array and integer
	 */
	private void Test5() {
		ArrayList<Object> arrayList = new ArrayList<Object>();
		arrayList.add(new int[] { 1, 2, 3, 4 });
		arrayList.add(5);
		arrayList.add(6);
		this.TestMessages(5,
				"Passing leve1 nested arrayList with int array and integer",
				arrayList);
		System.out.println("Output : "
				+ ArrayListUtil.arrayFlattener(arrayList) + "\n");
	}

	/**
	 * Passing integer, leve1 nested arrayList and level2 nested arrayList
	 */
	private void Test6() {
		ArrayList<Object> arrayList = new ArrayList<Object>();
		arrayList.add(new int[] { 1, 2, 3, 4 });
		arrayList.add(5);
		arrayList.add(6);

		ArrayList<Object> arrayList2 = new ArrayList<Object>();
		arrayList2.add(7);
		arrayList2.add(8);
		arrayList2.add(new int[] { 9, 10, 11, 12 });

		arrayList.add(arrayList2);
		this.TestMessages(
				6,
				"Passing integer, leve1 nested arrayList and level2 nested arrayList",
				arrayList);
		System.out.println("Output : "
				+ ArrayListUtil.arrayFlattener(arrayList) + "\n");
	}

	/**
	 * Passing integer, leve1 nested arrayList and deeper than level2 nested
	 * arrayList
	 */
	private void Test7() {
		ArrayList<Object> arrayList = new ArrayList<Object>();
		arrayList.add(new int[] { 1, 2, 3, 4 });
		arrayList.add(5);
		arrayList.add(6);

		ArrayList<Object> arrayList2 = new ArrayList<Object>();
		arrayList2.add(7);
		arrayList2.add(8);
		arrayList2.add(new int[] { 9, 10, 11, 12 });

		ArrayList<Object> arrayList3 = new ArrayList<Object>();
		arrayList3.add(13);
		arrayList3.add(14);
		arrayList3.add(new int[] { 15, 16, 17, 18 });

		arrayList2.add(arrayList3);

		arrayList.add(arrayList2);
		this.TestMessages(
				7,
				"Passing integer, leve1 nested arrayList and deeper than level2 nested arrayList",
				arrayList);
		System.out.println("Output : "
				+ ArrayListUtil.arrayFlattener(arrayList) + "\n");
	}

	/**
	 * Passing Invalid arrayList
	 */
	private void Test8() {
		ArrayList<Object> arrayList = new ArrayList<Object>();
		arrayList.add(1);
		arrayList.add("ab");
		this.TestMessages(8, "Passing Invalid arrayList", arrayList);
		try {
			ArrayListUtil.arrayFlattener(arrayList);
		} catch (ArrayStoreException ex) {
			System.out.println("Invalid Input");
			System.err.println(ex);
		}
	}

	public static void main(String[] args) {
		ArrayFlattenerTest test = new ArrayFlattenerTest();
		test.Test1();
		test.Test2();
		test.Test3();
		test.Test4();
		test.Test5();
		test.Test6();
		test.Test7();
		test.Test8();
	}

	private void TestMessages(int testNumber, String testDesc,
			ArrayList<Object> inputArrayList) {
		System.out.println("Test No  :" + testNumber);
		System.out.println("Test Desc:" + testDesc);
		System.out.println("Input : " + inputArrayList);
	}
}
