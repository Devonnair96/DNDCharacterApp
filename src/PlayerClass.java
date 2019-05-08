
import java.util.ArrayList;
import java.util.List;

/*
 * @author devonnair
 */
public class PlayerClass {
    
    private String className;
    private int classlvl;
    private List<String> classSkills;
    private List<String> weaponProf;
    private List<String> armorProf;
    
        //constructor
    public PlayerClass(String c,int l)
    {
        className = c;
        classlvl = l;
        classSkills = new ArrayList<String>();
        weaponProf = new ArrayList<String>();
        armorProf = new ArrayList<String>();
        
    }
    
    
    //setters
    public void setLvl(int l)
    {
        classlvl = l;
    }
    //track skills from class 
    public void addSkill(String desc)
    {
	classSkills.add(desc);
    }
    public void addWeapProf(String weapon)
    {
        weaponProf.add(weapon);
    }
    public void addArmProf(String armor)
    {
        armorProf.add(armor);
    }
    
    //getters
    public int getLvl()
    {
        return classlvl;
    }
    public String getClassName()
    {
        return className;
    }
    public String getSkills()
    {
        String skill = "*Class Features*\n";
        for(int i=0;i<classSkills.size();i++)
        {
            skill += i + ". " + classSkills.get(i) + "\n";
        }
        return skill;
    }
    public String getWeapProf()
    {
        if(weaponProf.size()>=1)
        {
            String weapons = weaponProf.get(0);
            for(int i=1;i<weaponProf.size();i++)
            {
                weapons+= ", " + weaponProf.get(i);
            }
            return weapons;
        }
        else
        {
            return "";
        }
    }
    public String getArmProf()
    {
        if(armorProf.size()>=1)
        {    
            String armor = armorProf.get(0);
            for(int i=1;i<armorProf.size();i++)
            {
                armor += ", " + armorProf.get(i);
            }
            return armor;
        }
        else
        {
            return "";
        }
    }
    @Override
    public String toString()
    {
        return className + " lvl " + classlvl + " ";
        
    }
}
