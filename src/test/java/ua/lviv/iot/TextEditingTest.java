package ua.lviv.iot;


import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;
import ua.lviv.iot.textprocessing.TextEditingWithPatterns;

public class TextEditingTest extends TestCase {
	Scanner text = new Scanner(System.in);
	@Test
	public void checkText() {
		String textToCheck = text.nextLine();
		System.out.println("Your text:" + textToCheck);
		TextEditingWithPatterns.findWordsByCtyteria("\\b[aeyuioAEYUIO]\\w*\\b", textToCheck);
		System.out.println("\n");
		Comparator<String> compareByFirstConsonantal = Comparator.comparing(o -> o.replaceFirst("[aeyuioAEYUIO]*", ""));
		TextEditingWithPatterns.listOfFoundStrings.sort(compareByFirstConsonantal);
		System.out.println("Sorted List:");
		for (String listOfFoundStrings : TextEditingWithPatterns.listOfFoundStrings) {
			System.out.println(listOfFoundStrings);
		}

	}

	
}
