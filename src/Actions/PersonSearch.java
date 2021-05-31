package Actions;

import Actions.Elements.Person;
import Actions.Handler.FileHandler;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PersonSearch {

    // tmp (can be made with Person integrated function)
    private static String path(String prename, String name){
        return "bin/persons"+prename+"_"+name+".person";
    }

    public static Person[] fileSearcher(String prename, String lastname, String refnum, String day, String month, String year) {
        //build pattern
        String builtName = prename.toLowerCase() + "_" + lastname.toLowerCase();
        String builtDate = null;
        if(!day.equals("") && !month.equals("") && !year.equals("")){
            builtDate = day+"."+month+"."+year;
        }

        //Get all Files listed
        File f = new File("bin/persons");
        String[] filenames = f.list();
        List<Person> validFiles = new ArrayList<>();

        assert filenames != null;
        for (String filename : filenames) {
            if (filename.contains(builtName) && filename.contains(".person") && filename.contains(refnum)) {
                File tmp = new File("bin/persons/" + filename);
                Person cached = FileHandler.LoadPerson(tmp);
                if(builtDate != null){
                    if(cached.getBirthday().equals(formatTime(builtDate))){
                        validFiles.add(cached);
                    }
                }else {
                    validFiles.add(cached);
                }
            }
        }

        Person[] personArray = new Person[validFiles.size()];
        return validFiles.toArray(personArray);
    }

    private static LocalDate formatTime(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");  //exp. 18.04.2004
        return LocalDate.parse(date, formatter);
    }
}
