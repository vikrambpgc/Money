package FamilyTree;
import java.util.*;

public class Person {
 
    // insert instance variables here
    private String name;
    
    private Person mother;
    private Person father;
    private ArrayList<Person> children; 

    
    /** Creates a new instance of Person */
    public Person(String name) 
    {
        this.name = name;
        this.mother = null;
        this.father = null;
        this.children = null;
    }
    
    public void setMother(Person mother){
        this.mother = mother;
    }
    
    public void setFather(Person father){
        this.father = father;
    }
    
    public void addChild(Person child) {
        if (children == null) {
        	children = new ArrayList<Person>();
        }
        children.add(child);
    }
    
    public ArrayList<Person> getChildren(){
        return this.children;
     }
     
    public int numKids(){
        if(children == null){
            return 0;
        }
        return children.size();
    }
    
    public Person nthKid(int childNumber) {
        if(children == null){
            return null;
        }
        return children.get(childNumber);
    }
    
    public Person getMother(){
        return this.mother;
     }
    
    public Person getFather(){
        return this.father;
     }
     
    public String getName(){
       return name;
    }
}