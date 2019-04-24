import java.util.ArrayList;
import java.util.List;

/*IMPORTANT DEV'S NOTE: throughout the code the index 0-5 in the class variables index and mod refers to the six character stats and their 
 * modifiers in this order: Strength, Dexterity, Constitution, Wisdom, Intelligence, and Charisma*/
public class Stats {
	
	private int[] mod = new int[6];
	private int[] index = new int[6];
	
	
	
	
	//initialize index array
	public Stats()
	{
		for(int i=0;i<6;i++)
		{
			index[i] = rollStat();
		}
		setModifiers();
		
	}
	
	//manual set to array
	public void setStatsManually(int[] stat)
	{
		for(int i=0;i<stat.length;i++)
		{
			index[i] = stat[i];
		}
		setModifiers();
	}
	
	//setter
	private void setModifiers()
	{
		double temp;
		for(int i=0;i<index.length;i++)
		{
			temp = index[i]-10;
			mod[i] = (int) Math.floor(temp/2);
		}
	}
	
	//getters
	public int getModifier(int i)
	{
		return mod[i];
	}
	
	//rolls 4 dice, returns the sum of the highest three. 
	private int rollStat()
	{
		int one, two, three, four, temp, result = 0;
		one = (int) (Math.random()*6)+1;
		two = (int) (Math.random()*6)+1;
		three = (int) (Math.random()*6)+1;
		four = (int) (Math.random()*6)+1;
		
		
		result = one + two + three + four;
		result = result - Math.min(one, Math.min(two, Math.min(three, four)));
		return result;
	}
	
	//swaps 2 stats. 
	public void swapStats(int a, int b)
	{
		int temp;
		temp = index[a];
		index[a] = index[b];
		index[b] = temp;
	}
	
	//prints
	public String printStats()
	{
		return "str: " + index[0] + " " + "dex: " + index[1] + " " + "con: " + index[2] + " " + "wis: " + index[3] + " " + "int: " + index[4] + " " + "cha: " + index[5];
	}
	public String printStatsAndMod()
	{
		return "str:" + index[0] + "(" + plusminus(mod[0]) + ") dex:" + index[1] + "(" + plusminus(mod[1]) + ") con:" + index[2] + "(" + plusminus(mod[2]) + ") wis:" + index[3] + "(" + plusminus(mod[3]) + ") int:" +index[4] + "(" + plusminus(mod[4]) + ") cha:" + index[5] + "(" + plusminus(mod[5]) + ")";
	}
	public String toString()
	{
		return "str: " + index[0] + "\ndex: " + index[1] + "\ncon: " + index[2] + "\nwis: " + index[3] + "\nint: " + index[4] + "\ncha: " + index[5];
	}
	public String plusminus(int i)
	{
		if(i < 0)
		{
			return "" + i;
		}
		else
		{
			return "+" + i;
		}
	}

}
