package Actions.Elements;

import java.io.Serializable;
import java.time.LocalDate;

public class Person implements Serializable{

    private final int refnum;               //automatic
    private final String prename;           //*
    private final String sirname;           //*
    private final LocalDate birthday;   //*
    //private final String starsign;        //automatic
    private String religion;                //optional
    private final Person mother;            //*
    private final Person father;            //*
    private String notes;                   //optional
    private String password;
    private byte[] salt;

    public Person(int refnum, String prename, String sirname, LocalDate bday, Person mother, Person father, String religion, String notes, String password, byte[] salt){
        this.refnum = refnum;
        this.prename = prename;
        this.sirname = sirname;
        this.birthday = bday;
        this.mother = mother;
        this.father = father;
        this.religion = religion;
        this.notes = notes;
        this.password = password;
        this.salt = salt;
        //calculate Starsign
    }

    public int getRefnum() {
        return refnum;
    }

    public String getPrename() {
        return prename;
    }

    public String getSirname() {
        return sirname;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getReligion() {
        return religion;
    }

    public Person getMother() {
        return mother;
    }

    public Person getFather() {
        return father;
    }

    public String getNotes() {
        return notes;
    }

    public String getPassword(){
        return password;
    }

    public byte[] getSalt(){
        return salt;
    }

    public String getFileName(){
        return prename.toLowerCase()+"_"+sirname.toLowerCase()+"_"+refnum;
    }
}
