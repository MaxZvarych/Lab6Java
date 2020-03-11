package ua.lviv.iot;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import ua.lviv.iot.textprocessing.InputOutput;
import ua.lviv.iot.textprocessing.InputOutput.*;
import ua.lviv.iot.textprocessing.TextEditingWithPatterns;

public class TextEditingTest {
	//Scanner text = new Scanner(System.in);
	
	@Test
	public void checkText() {
		 InputOutput inputOutput= new InputOutput();
		  String input = "abc leader Oleksnds after leaving home died";
		    InputStream in = new ByteArrayInputStream(input.getBytes());
		    System.setIn(in);
		 String textToCheck = InputOutput.getInput();
		//String textToCheck = text.nextLine();
		List<String> listOfFoundStrings = new LinkedList<>();
	//	System.out.println("Your text:" + textToCheck);
		listOfFoundStrings=TextEditingWithPatterns.findWordsByCtyteria("\\b[aeyuioAEYUIO]\\w*\\b", textToCheck);
//		for (String temporaryList : listOfFoundStrings) {
//			System.out.println(temporaryList);
//		}
		//System.out.println("\n");
		Comparator<String> compareByFirstConsonantal = Comparator.comparing(o -> o.replaceFirst("[aeyuioAEYUIO]*", ""));
		listOfFoundStrings.sort(compareByFirstConsonantal);
	//	System.out.println("Sorted List:");
//		for (String temporaryList : listOfFoundStrings) {
//			System.out.println(temporaryList);
//		}
		assertEquals("abc", listOfFoundStrings.get(0));
		assertEquals("after", listOfFoundStrings.get(1));
		assertEquals("Oleksnds", listOfFoundStrings.get(2));
	}

}
