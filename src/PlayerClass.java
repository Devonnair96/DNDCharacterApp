
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author devonnair
 */
public class PlayerClass {
    
   private String classType;
    private List<String> classSkills;
    
        //constructor
    public PlayerClass(String c)
    {
        classType = c;
        classSkills = new ArrayList<String>();
    }
    //track skills from class 
    public void addSkill(String desc)
    {
	classSkills.add(desc);
    }
    public String getSkills()
    {
        String skill = " Skills:\n";
        for(int i=0;i<classSkills.size();i++)
        {
            skill += i + ". " + classSkills.get(i) + "\n";
        }
        return skill;
    }
    
    @Override
    public String toString()
    {
        return classType + ":\n" + getSkills();
    }
}
