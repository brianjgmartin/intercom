package util;

import java.util.ArrayList;

/**
 * Util class containing in-house method(s) for ArrayList
 * 
 * @author harshit
 * 
 */
public class ArrayListUtil {

	/**
	 * Flatten an arrayList of arbitrarily nested arrays of integer into a flat
	 * array of integer.<br>
	 * 
	 * @param arrayList
	 *            - - arrayList with arbitrarily nested arrays of integer
	 * @return arrayList containing (non-nested) array of integer. If <b>input
	 *         is null empty arrayList is returned</b>
	 * @throws ArrayStoreException
	 *             - when arrayList contains any other object type then integer,
	 *             int[], arrayList indicate that an attempt has been made to
	 *             store the wrong type of object into an array of integer
	 */
	public static ArrayList<Integer> arrayFlattener(ArrayList<Object> arrayList)
			throws ArrayStoreException {
		ArrayList<Integer> resultArrayList = new ArrayList<Integer>();
		if (arrayList != null) {
			for (int i = 0; i < arrayList.size(); i++) {
				if (arrayList.get(i) instanceof Integer) {
					resultArrayList.add((Integer) arrayList.get(i));
				} else if (arrayList.get(i) instanceof int[]) {
					int[] tmpArray = (int[]) arrayList.get(i);
					for (int j = 0; j < tmpArray.length; j++) {
						resultArrayList.add(tmpArray[j]);
					}
				} else if (arrayList.get(i) instanceof ArrayList) {
					resultArrayList
							.addAll(arrayFlattener((ArrayList<Object>) arrayList
									.get(i)));
				} else {
					throw new ArrayStoreException("Element " + arrayList.get(i)
							+ " is not an Integer or int array or arrayList : "
							+ i);
				}
			}
		}
		return resultArrayList;
	}
}
