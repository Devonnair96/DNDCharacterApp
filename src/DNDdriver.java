/*
Author: Devon Nair
Description: This app is designed to be a supplemental material to keep track of and edit a D&D 5e 
style character. Eventually intend to add in randomization functionality where it will be able to 
create a randomized character using an SQL database, as well as be able to print sheet to a text file
if the user chooses. once the app is fleshed out a bit more will work on making a better UI. possibly 
with Android Studio. 
*DISCLAIMER*: This project is intended for programming practice purposes only. It is intended only for
personal use, I do not own D&D, Wizards of the Coast please dont sue me. 
*/
import java.util.Scanner;


public class DNDdriver {

	public static void main(String[] args) {
		
                //array represents characters physical and mental statistics. 
		int[] ar = {23,22,16,19,11,12};
		Sheet two = new Sheet("Connor","elf",ar,12);    //creates a new character and add attributes.
		two.setHp(125);
		two.setHpMax(125);
		two.setAlignment("Neutral Good");
		two.setBackground("Acolyte");
		String skill = "Martial Arts: make an unarmed attack as a bonus action.";
		two.addSkill(skill);
		two.setSavingThrows(1, true);   //has proficiency in dexerity, constitution, and wisdom saving throws
		two.setSavingThrows(2, true);
		two.setSavingThrows(3, true);
		System.out.println(two.printSheet()); //output 
		
	}

}
