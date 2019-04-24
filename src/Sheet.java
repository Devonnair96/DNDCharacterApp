import java.util.ArrayList;
import java.util.List;


public class Sheet {
        //Class variables representing character attributes.
	Stats playerstats;
	private String name, race;
	private String[] stat = {"str","dex","con","wis","int","cha"};
	private int level, prof, init, ac, speed, hp, hpmax, tempHP;
	private String alignment,background,ideals;
	private List<String> skills;
	private boolean inspiration = false;
	private boolean[] hassave = {false,false,false,false,false,false};

	
	//constructors
	public Sheet(String n)
	{
		name = n;
		playerstats = new Stats();
	}
	
	//Set base character traits manually to keep track of them
	public Sheet(String n, String r, int[] stat, int l)
	{
		playerstats = new Stats();
		name = n;
		race = r;
		playerstats.setStatsManually(stat);
		level = l;
		setProf();
		skills = new ArrayList<String>();
	}
	
	//track skills
	public void addSkill(String desc)
	{
		skills.add(desc);
	}
	
	//setters
	public void setTempHP(int tempHP) {
		this.tempHP = tempHP;
	}
	private void setProf()
	{
		prof = (int) Math.ceil((level/4))+1;
	}
	public void setAlignment(String s)
	{
		alignment = s;
	}
	public void setBackground(String background) {
		this.background = background;
	}
	public void setSavingThrows(int i, boolean has)
	{
		if(has==true)
		{
			hassave[i] = has;
		}
	}
	public void setInitManual(int init) {
		this.init = init;
	}
	public void setInit()
	{
		init = playerstats.getModifier(1);
	}
	public void setName(String name) {
		this.name = name;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	
	public void setAc(int ac) {
		this.ac = ac;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public void setHpMax(int hpmax) {
		this.hpmax = hpmax;
	}


	//getters
	public String getBackground() {
		return background;
	}

	public String getName() {
		return name;
	}

	public String getRace() {
		return race;
	}

	public int getLevel() {
		return level;
	}

	public int getProf() {
		return prof;
	}

	public String getAlignment() {
		return alignment;
	}
	public int getSavingThrow(int ind)
	{
		if(hassave[ind] == true)
		{
			return (playerstats.getModifier(ind) + prof);
		}
		else
		{
			return playerstats.getModifier(ind);
		}
	}
	public int getInit() {
		return init;
	}
	public int getAc() {
		return ac;
	}
	public int getSpeed() {
		return speed;
	}
	public int getHp() {
		return hp;
	}
	public int getmaxHP() {
		return hpmax;
	}
	public int getTempHP() {
		return tempHP;
	}
	
	//Prints
	public String printSheet()
	{
		String a = printBaseTraits();
		String b = printDesc();
		String c = "**********\nStats(Modifier): " + playerstats.printStatsAndMod() + "\n";
		String d = printSaves();
		return a + b + c + d;
	}
	public String printBaseTraits()
	{
		String a = "**********\n";
		a += "Name: " + name + "\n" + "Race: " + race + "\n" + "Player Level: " + level + "\nHP: " + hpmax + "/" + hp + 
				"\nProficiency Bonus: +" + prof + "\n"; 
		return a;
	}
	public String printDesc()
	{
		String b = "**********\n";
		b += "Background: " + getBackground() + "\nAlignment: " + getAlignment() + "\nSkills: " + printSkills() + "\n";
		return b;
	}
	public String printSkills()
	{
		String s = "";
		for(int i=0;i<skills.size();i++)
		{
			s+="\n" + i + ". ";
			s+=skills.get(i);
			
		}
		return s;
	}
	public String printSaves()
	{
		String d = "Saving Throws: ";
		for(int i=0;i<stat.length;i++)
		{
			d += (stat[i] + playerstats.plusminus(getSavingThrow(i)) + " ");
		}
		return d;
		
	}
	

}
