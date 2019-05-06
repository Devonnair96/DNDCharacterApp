/**
 * Abstract: basically a struct to keep track of the name and modifier of a skill proficiency. 
 * @author devonnair
 */
public class SkillProficiencies {
    private String name;
    private int param;
    private final String[] stat = {"str","dex","con","wis","int","cha"};
    
    public SkillProficiencies(String n, int p)
    {
        name = n;
        param = p;
    }
    public String getName()
    {
        return name;
    }
    public int getParam()
    {
        return param;
    }
    public String printSkills()
    {
        return name + "(" + stat[param] + ")";
    }
}
