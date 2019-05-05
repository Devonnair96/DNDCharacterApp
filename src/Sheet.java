import java.util.ArrayList;
import java.util.List;


public class Sheet {
        //Class variables representing character attributes.
	private Stats playerstats;
        private List<PlayerClass> pclass;
        private List<SkillProficiencies> skillProf;
       
	private String name, race;
	private final String[] stat = {"str","dex","con","wis","int","cha"};
	private int level, prof, init, ac, speed, hp, hpmax, tempHP;
	private String alignment,background;
	
	private boolean inspiration = false;
	private boolean[] hassave = {false,false,false,false,false,false};
        

	
	//constructor
	//Set base character traits manually to keep track of them
	public Sheet(String n, String r, int[] stat, int l)
	{
            pclass = new ArrayList<>();
            playerstats = new Stats();
            skillProf = new ArrayList<>();
            name = n;
            race = r;
            playerstats.setStatsManually(stat);
            level = l;
            setProf();
		
	}
        
	public void addClass(String c,int l)            //manually enter a character class
        {
            pclass.add(new PlayerClass(c,l));
            if(level != getClasslvl())
            {
                setLevel(getClasslvl());
            }
            
        }
        public int getClasslvl()
        {
            int l=0;
            for(int i=0;i<pclass.size();i++)
            {
                l+=pclass.get(i).getLvl();
            }
            return l;
        }
        public void addClassSkill(int pos,String desc)      //manually add class features
	{
            pclass.get(pos).addSkill(desc);
	}
	public void addProficiencies(String skill,int param)
        {
            skillProf.add(new SkillProficiencies(skill,param));
        }
        
	//setters
        public void setName(String name) {
		this.name = name;
	}
        public void setRace(String race) {
		this.race = race;
	}
        public void setLevel(int level) {
		this.level = level;
                setProf();
	}
        public void setHpMax(int hpmax) {
		this.hpmax = hpmax;
	}
        public void setHp(int hp) {
		this.hp = hp;
	}
        public void setTempHP(int tempHP) {
		this.tempHP = tempHP;
	}
        private void setProf()
	{
		prof = (int) Math.ceil((level/4))+1;
	}
	public void setBackground(String background) {
		this.background = background;
	}
	public void setAlignment(String s)
	{
		alignment = s;
	}
        public void setInspiration(boolean has)
        {
         inspiration = has;   
        }
        public void setAc(int ac) {
		this.ac = ac;
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
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
        
        
	//getters
        public String getName() {
		return name;
	}
        public String getRace() {
		return race;
	}
        public int getLevel() {
		return level;
	}
	public int getmaxHP() {
		return hpmax;
	}
        public int getHp() {
		return hp;
	}
        public int getTempHP() {
		return tempHP;
	}
        public int getProf() {
		return prof;
	}
        public String getBackground() {
		return background;
	}
        public String getAlignment() {
		return alignment;
	}
        public String getInspiration()
        {
            if(inspiration == true)
            {return "yes";}
            else
            {return "no";}
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
	
	
	
	
	//Prints
	public String printSheet()
	{
		String a = printBaseTraits()  + printDesc() +
                        "**********\nArmor Class: " + ac + "\nInitiative: " + 
                        playerstats.plusminus(init) + "  Speed: " + speed + 
                        "ft per 6 sec.\nStats(Modifier): " + playerstats.printStatsAndMod() + 
                        "\n" + printSaves() + "\n" + printSkillProf() + "\n" + printClass();
		return a;
	}
	public String printBaseTraits()
	{
		String a = "**********\n";
		a += "Name: " + name + "\n" + "Race: " + race + "\n" + "Player Level: " + level + "\nHP: " + hpmax + "/" + hp + 
				"  Temp HP: " + tempHP + "\nProficiency Bonus: +" + prof + "\n"; 
		return a;
	}
        public String printClass()
        {
            String b = "";
            for(int i=0;i<pclass.size();i++)
            {
                b += pclass.get(i).toString();
            }
            
            return b;
        }
	public String printDesc()
	{
		String c = "**********\nBackground: " + getBackground() + "\nAlignment: " 
                        + getAlignment() + "\nInspiration: " + getInspiration() + "\n";
		return c;
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
	public String printSkillProf()
        {
            String a = "Skill Proficiencies:";
            for(int i=0;i<skillProf.size();i++)
            {
                a += " " + skillProf.get(i).printSkills() + "(" + playerstats.plusminus(playerstats.getModifier(skillProf.get(i).getParam())) + ")";
            }
            return a;
        }

}
