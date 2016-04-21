package com.kkontus.stringhelper;

/**
 * Created by kristijan on 19/11/15.
 */
public class StringHelper {

	public static String breakString(String originalString, int size) {
		StringBuilder stringBuilder = new StringBuilder(originalString);
		int pos = 0;

		// check which while is faster (replace or setCharAt)
		while ((pos = stringBuilder.indexOf(" ", pos + size)) >= 0) {
			stringBuilder.setCharAt(pos, '\n');
		}
		// while ((pos = stringBuilder.indexOf(" ", pos + size)) != -1) {
		// stringBuilder.replace(pos, pos + 1, "\n");
		// }
		return stringBuilder.toString();
	}

	public static String trimString(String originalString, int size, String replaceString) {
		if (originalString.length() <= size) {
			return originalString;
		}
		return originalString.substring(0, size) + replaceString;
	}

	public String test() {
		return "";
	}

}