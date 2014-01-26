package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class SingleWordSequenceUtil {

	public void init(String dictonaryFilePath, String src, String des) {
		Set<String> dictionary = buildDictionary(dictonaryFilePath);
		if (isValidInput(src, des)) {
			getWordSequence(src, des, dictionary);
		}
	}

	/**
	 * Print path to get sequence of valid words (in a dictionary), where each
	 * pair of adjacent words are only different by 1 character. e.g. dog -> dot
	 * -> cot -> cat.
	 * 
	 * @param src
	 *            - start word of sequence
	 * @param des
	 *            - end word of sequence
	 * @param dictionary
	 *            - list of all valid words
	 */
	public void getWordSequence(String src, String des, Set<String> dictionary) {
		// q to store all the transformed element
		Queue<String> q = new LinkedList<String>();

		// set to keep track of already visited/inqueue elements so to avoid
		// cyclic pattern
		Set<String> visited = new HashSet<String>();

		// path map to keep track of parent(s) of particular word which differ
		// by 1 char
		HashMap<String, String> pathMap = new HashMap<String, String>();

		q.add(src);
		visited.add(src);
		// Will transform the src and keep populating the words in queue and at
		// any point if we encounter destination word will go to path map find
		// the path and prints the same.
		while (!q.isEmpty()) {
			String top = q.poll();
			if (des.equalsIgnoreCase(top)) {
				// Reached destination, will now construct from destination to
				// src path and print it
				ArrayList<String> resultPathList = new ArrayList<String>();
				while (top != null) {
					resultPathList.add(top);
					top = pathMap.get(top);
				}
				Collections.reverse(resultPathList);
				System.out.println(resultPathList);
			} else {
				Set<String> transformedSet = getTransformedSet(top, dictionary);
				for (String key : transformedSet) {
					if (!visited.contains(key)) {
						visited.add(key);
						q.add(key);
						pathMap.put(key, top);
					}
				}

			}
		}
	}

	/**
	 * Return all possible (dictionary valid) same length and differ by one
	 * letter word for a given word
	 * 
	 * @param key
	 *            - given word for which all possible word need to be generated
	 * @param dictionary
	 *            - list of all valid word
	 * @return set of all possible valid same length and one differ by one
	 *         letter word
	 */
	private static Set<String> getTransformedSet(String key,
			Set<String> dictionary) {
		Set<String> resultSet = new HashSet<String>();
		String transformedWord = null;
		for (int i = 0; i < key.length(); i++) {
			for (char c = 'A'; c <= 'Z'; c++) {
				transformedWord = key.substring(0, i) + c
						+ key.substring(i + 1);
				transformedWord = transformedWord.toLowerCase();
				if (!key.equalsIgnoreCase(transformedWord)
						&& dictionary.contains(transformedWord)) {
					resultSet.add(transformedWord);
				}
			}
		}
		return resultSet;
	}

	/**
	 * Return list of words obtained from file
	 * 
	 * @param filePath
	 *            - file path from where words need to be read
	 * @return list of all words read from a file
	 */
	public Set<String> buildDictionary(String filePath) {
		Set<String> dictonary = new HashSet<String>();
		File file = new File(filePath);
		try {
			Scanner sc = new Scanner(file);
			while (sc.hasNext()) {
				dictonary.add((sc.next()).toLowerCase());
			}
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found " + file.getAbsolutePath());
			// e.printStackTrace();
		}
		return dictonary;
	}

	/**
	 * Return whether src/des pair is valid input to find word sequence or not
	 * 
	 * @param src
	 * @param des
	 * @return true / false (if null or different length or contains anything
	 *         apart from alphabets)
	 */
	private boolean isValidInput(String src, String des) {
		if (src == null || des == null) {
			System.out.println("Invalid Input, either of one is null src/des:"
					+ src + "/" + des);
			return false;
		}
		if (src.length() != des.length()) {
			System.out
					.println("Size of src and des differe, subsitution change wont be able to convert src to des by anymeans : src,des:"
							+ src + "," + des);
			return false;
		}
		if (!(src.matches("[a-zA-Z]+") && des.matches("[a-zA-Z]+"))) {
			System.out
					.println("Invalid input, either of one contain non-alpha character src/des :"
							+ src + "/" + des);
			return false;
		}
		return true;
	}
}
