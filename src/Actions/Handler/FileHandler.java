package Actions.Handler;

import Actions.Elements.Person;

import java.io.*;

public class FileHandler {

    public static void SavePerson(Person object){
        try
        {
            String path = "bin/persons/"+object.getFileName()+".person";
            File f = new File(path);
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(object);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static Person LoadPerson(File file){
        try{
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            return (Person) ois.readObject();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
