package ua.lviv.iot.textprocessing;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextEditingWithPatterns {

	public static List<String> findWordsByCtyteria(final String patternString, String textToCheck) {
		List<String> listOfFoundStrings = new LinkedList<>();
		Pattern cryteria = Pattern.compile(patternString);
		Matcher match = cryteria.matcher(textToCheck);
		while (match.find()) {
			listOfFoundStrings.add(match.group());
		}
		return listOfFoundStrings;
	}
}
