// ********************************************************************* //
// * Daily Programmer 2016-12-19 easy                                  * //
// * The Twelve Days of...                      						* //
// * https://www.reddit.com/r/dailyprogrammer/comments/5j6ggm/         * //
// ********************************************************************* //

package com.trilog.dailyjava;

import java.io.*;
import java.util.ArrayList;

public class TwelveDays {
	private String[] cardinal = { "a", "two", "three", "four", "five", "six", 
			"seven", "eight", "nine", "ten", "eleven", "twelve" };
	private String[] ordinal = { "first", "second", "third", "fourth", "fifth", "sixth", 
			"seventh", "eighth", "ninth", "tenth", "eleventh", "twelfth" }; 
	private ArrayList<String> openedGifts = new ArrayList<String>(cardinal.length);

	private String Cardinal(int i) {
		if (i < cardinal.length) return cardinal[i];
		else return new String("" + i + 1);
		// There's probably a more elegant way to do this
	}
	
	private String Ordinal(int i) {
		if (i < ordinal.length) return ordinal[i];
		else return new String(i + 1+"th");
		// Obviously this does not return "st", "nd", "rd"
	}
	
	public static void main(String[] args) {
		new TwelveDays().go(); // I still can't believe this is allowed.
	}
	
	public void go () {
		try {
			File giftFile 		  = new File("gifts.txt");
			FileReader fileReader = new FileReader(giftFile);
			BufferedReader reader = new BufferedReader(fileReader);
			String line 		  = null;
			int dayIndex 		  = 0;
			while ((line = reader.readLine()) != null) {
				openedGifts.add(line);
				System.out.println("On the " + Ordinal(dayIndex) + " of Christmas");
				System.out.println("my true love sent to me:");
				for (int i = dayIndex; i >= 0; --i)
				{
					if ((dayIndex > 0) && (i == 0)) System.out.print("and ");
					System.out.println(Cardinal(i) + " " + openedGifts.get(i));
				}
				++dayIndex;
				System.out.println();
			}
			reader.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}