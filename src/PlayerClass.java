
import java.util.ArrayList;
import java.util.List;

/*
 * @author devonnair
 */
public class PlayerClass {
    
   private String classType;
   private int classlvl;
    private List<String> classSkills;
    
        //constructor
    public PlayerClass(String c,int l)
    {
        classType = c;
        classlvl = l;
        classSkills = new ArrayList<String>();
    }
    public void setLvl(int l)
    {
        classlvl = l;
    }
    //track skills from class 
    public void addSkill(String desc)
    {
	classSkills.add(desc);
    }
    
    //setters
    public String getSkills()
    {
        String skill = "*Class Features*\n";
        for(int i=0;i<classSkills.size();i++)
        {
            skill += i + ". " + classSkills.get(i) + "\n";
        }
        return skill;
    }
    public int getLvl()
    {
        return classlvl;
    }
    @Override
    public String toString()
    {
        return classType + " lvl " + classlvl + ":\n" + getSkills();
        
    }
}
