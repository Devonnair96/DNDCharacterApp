
import java.util.ArrayList;
import java.util.List;

/*
This class is here to hold the physical description and traits of a character sheet object.
 */

/**
 *
 * @author devonnair
 */
public class BackgroundTraits {
    private String background,alignment,gender,age,height,weight,eye,hair,size,personality,ideals,flaws,bonds;
    private List<String> languages,raceTraits;
    
    public BackgroundTraits(String back, String align,String gen,String age, String height, String weight,String eye, String hair, String size, String personality, String ideal, String flaw,String bond)
    {
        languages = new ArrayList<>();
        raceTraits = new ArrayList<>();
        background = back;
        alignment = align;
        gender = gen;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.eye = eye;
        this.hair = hair;
        this.size = size;
        this.personality = personality;
        ideals = ideal;
        flaws = flaw;
        bonds = bond;
    }
    public void addLang(String lang)
    {
        languages.add(lang);
    }
    public String getLang()
    {
        String lang = languages.get(0);
        for(int i=1;i<languages.size();i++)
        {
            lang+=", " + languages.get(i);
        }
        return lang;
    }
    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public void setHeight(String height) {
        this.height = height;
    }
    public void setWeight(String weight) {
        this.weight = weight;
    }
    public void setEye(String eye) {
        this.eye = eye;
    }
    public void setHair(String hair) {
        this.hair = hair;
    }
    public void setSize(String size) {
        this.size = size;
    }
    public void setPersonality(String personality) {
        this.personality = personality;
    }
    public void setIdeals(String ideals) {
        this.ideals = ideals;
    }
    public void setFlaws(String flaws) {
        this.flaws = flaws;
    }
    public void setBonds(String bonds) {
        this.bonds = bonds;
    }
    
    public String getBack()
    {
        return background;
    }
    public String getAlign()
    {
        return alignment;
    }
    public String getGender() {
        return gender;
    }
    public String getAge() {
        return age;
    }
    public String getHeight() {
        return height;
    }
    public String getWeight() {
        return weight;
    }
    public String getEye() {
        return eye;
    }
    public String getHair() {
        return hair;
    }
    public String getSize() {
        return size;
    }
    public String getPersonality() {
        return personality;
    }
    public String getIdeals() {
        return ideals;
    }
    public String getFlaws() {
        return flaws;
    }
    public String getBonds() {
        return bonds;
    }
    
    //print
    public String printDesc()
    {
        String prin = "****Character Description****\n  Gender: " + getGender() + "  Age:" + 
                getAge() + "\n  Eye Color:" + getEye() + "  Hair Color: " + getHair() + 
                "\n  Height:" + getHeight() + "  Weight:" + getWeight() + "  Size:"  + getSize() + 
                "\n  Personality: " + getPersonality() + "\n  Ideals: " + getIdeals() + 
                "\n  Bonds: " + getBonds() + "\n  Flaws: " + getFlaws();
        return prin;
        
    }
}
