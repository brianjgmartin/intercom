package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TopN {

	public static void topN(String filePath, int n) {
		if (filePath == null || "".equals(filePath)) {
			System.out.println("Invalid File Name");
			return;
		}
		if (n < 0) {
			System.out.println("N cannot be negative : " + n);
			return;
		}

		File file = new File(filePath);
		FixedCapacityMinHeap<Double> heap = new FixedCapacityMinHeap<Double>(n,
				true);
		// FixedCapacityMinHeap<Integer> heap = new
		// FixedCapacityMinHeap<Integer>(n,true);
		Scanner sc = null;
		try {
			sc = new Scanner(file);
			while (sc.hasNext()) {
				// double val = sc.nextDouble();
				heap.add(sc.nextDouble());
				// heap.add(sc.nextInt());
			}
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found : " + file + " absolutePath:"
					+ file.getAbsolutePath());
			// e.printStackTrace();
		} catch (InputMismatchException e) {
			System.out.println("Invalid Input, not an integer:" + sc.next());
			return;
		} catch (Exception e) {
			System.out.println(e);
			return;
		}

		if (sc != null) {
			heap.print();
			sc.close();
		}
	}
}
