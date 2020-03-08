package ua.lviv.iot.textprocessing;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextEditingWithPatterns {
	public static List<String> listOfFoundStrings = new LinkedList<>();

	public static void findWordsByCtyteria(final String patternString, String textToCheck) {
		Pattern cryteria = Pattern.compile(patternString);
		Matcher match = cryteria.matcher(textToCheck);
		while (match.find()) {
			System.out.println(match.group());
			listOfFoundStrings.add(match.group());
		}

	}
}
