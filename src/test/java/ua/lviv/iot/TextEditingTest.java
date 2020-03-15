package ua.lviv.iot;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import ua.lviv.iot.textprocessing.TextEditingWithPatterns;

public class TextEditingTest {
	public static String getInput() {
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}

	@Test
	public void checkText() {
		String input = "abc leader Oleksnds after leaving home developed his own motobike";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		String textToCheck = getInput();

		List<String> listOfFoundStrings = new LinkedList<>();
		listOfFoundStrings = TextEditingWithPatterns.findWordsByCtyteria("\\b[aeyuioAEYUIO]\\w*\\b", textToCheck);
		Comparator<String> compareByFirstConsonantal = Comparator.comparing(o -> o.replaceFirst("[aeyuioAEYUIO]*", ""));
		listOfFoundStrings.sort(compareByFirstConsonantal);
		assertEquals("abc", listOfFoundStrings.get(0));
		assertEquals("after", listOfFoundStrings.get(1));
		assertEquals("Oleksnds", listOfFoundStrings.get(2));
		assertEquals("own", listOfFoundStrings.get(3));
	}

}
