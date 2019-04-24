import java.util.Scanner;


public class DNDdriver {

	public static void main(String[] args) {
		
		int[] ar = {23,22,16,19,11,12};
		Sheet two = new Sheet("Connor","elf",ar,12);
		two.setHp(125);
		two.setHpMax(125);
		two.setAlignment("Neutral Good");
		two.setBackground("Acolyte");
		String skill = "Martial Arts: make an unarmed attack as a bonus action.";
		two.addSkill(skill);
		two.setSavingThrows(1, true);
		two.setSavingThrows(2, true);
		two.setSavingThrows(3, true);
		System.out.println(two.printSheet());
		
	}

}
