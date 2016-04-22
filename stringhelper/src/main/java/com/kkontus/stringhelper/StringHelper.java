package com.kkontus.stringhelper;

import com.squareup.phrase.Phrase;
import java.util.Map;

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

	public static String stringFormatter(String originalString, String[][] valueMapping) {
		String modifiedString = originalString;
		for(String[] replacement: valueMapping) {
			modifiedString = modifiedString.replace(replacement[0], "{" + replacement[0] + "}");
		}

		Phrase phrase = Phrase.from(modifiedString);
		for(String[] replacement: valueMapping) {
			phrase.put(replacement[0], replacement[1]);
		}

		CharSequence formatted = phrase.format();
		return formatted.toString();
	}

	public static String stringFormatter(String originalString, Map<String, String> valueMapping) {
		String modifiedString = originalString;
		for (Map.Entry<String, String> entry : valueMapping.entrySet()) {
			modifiedString = modifiedString.replace(entry.getKey(), "{" + entry.getKey() + "}");
		}

		Phrase phrase = Phrase.from(modifiedString);
		for (Map.Entry<String, String> entry : valueMapping.entrySet()) {
			phrase.put(entry.getKey(), entry.getValue());
		}

		CharSequence formatted = phrase.format();
		return formatted.toString();
	}

	public static String stringFormatter(String originalString, String[] partToChange, String[] newValues) {
		String modifiedString = originalString;
		for(String replacement: partToChange) {
			modifiedString = modifiedString.replace(replacement, "{" + replacement + "}");
		}

		Phrase phrase = Phrase.from(modifiedString);
		for (int i = 0; i < partToChange.length; i++) {
			phrase.put(partToChange[i], newValues[i]);
		}

		CharSequence formatted = phrase.format();
		return formatted.toString();
	}

}