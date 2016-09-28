package FamilyTree;
import java.util.*;
import java.io.*;

public class FamilyInfo {
    private Person person;
    private ArrayList<Person> persons;

    public FamilyInfo(){
        person = null;
        persons = new ArrayList<Person>();    
    }
    
    public void read (Scanner input) {
        //int index = 0;
        //input.useDelimiter("[^a-zA-Z']");

        String name;
        String personName, motherName, fatherName;
        
        name = input.nextLine();
        
        while (name.length() > 0 && !name.equals("END OF NAMES, CHILD/MOTHER/FATHER records follow:")) {
            if(!found(name)){
                persons.add(new Person(name));
            }
            
            name = input.nextLine();
        }
        
        name = input.nextLine();
        
        while (name.length() > 0 && !name.equals("END OF FILE")) {
            if (name.equals("-")) {
                name = input.nextLine();
                continue;
            }
            
            // Process each CHILD/MOTHER/FATHER records
            
            if(!found(name)){
                System.out.println("Not possible.Input wrong");
                System.exit(1);
            } else{
                personName = name;
                motherName = input.nextLine();
                fatherName = input.nextLine();
                
                processParents(personName, motherName, fatherName);
            }
            
            name = input.nextLine();
          
        }
        
    }
    
    public Boolean found(String name) {
        
        if (persons.isEmpty()) {
    		return false;
    	}
    	
        for(Person person:persons) {
            if (person.getName().equals(name)) {
                return true;
            }
        }
        
        return false;
    }
            
    public Person getPerson(String name) {
        for(Person person:persons) {
            if (person.getName().equalsIgnoreCase(name)) {
                return person;
            }
        }
        return null;
    }
        
        
    private void processParents(String personName, String motherName, String fatherName) {

        Person p = getPerson(personName);
            if (!motherName.equals("unknown")) {
                Person mother = getPerson(motherName);
                
                if(mother == null){
                    System.out.println("Mother not found.Not possible.Input wrong");
                    System.exit(1);
                }
                
                p.setMother(mother);
                mother.addChild(p);
            }
            
            if (!fatherName.equals("unknown")) {
                Person father = getPerson(fatherName);
                
                if(father == null){
                    System.out.println("Father not found.Not possible.Input wrong");
                    System.exit(1);
                }
                
                p.setFather(father);
                father.addChild(p);
            }
    }
 }
    