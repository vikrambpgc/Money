package FamilyTree;
import java.util.*;
import java.io.*;

public class FamilyTree {
    private Person rootPerson;
    private FamilyInfo rootFamily;
    
    public FamilyTree(Person rootPerson) {
        this.rootPerson = rootPerson;
    }
    
    public void buildTree(FamilyInfo family) {
        rootFamily = family;
            
        if (rootPerson == null) {
            System.out.println("No person with that name");
            System.exit(1);
                
            /*
             * No need to build any more family as all info
             * is there in the rootNode of our tree rootPerson
             */
            }
    }
    
    public void printSideways() {
            Person current, mother, father;
            if (rootPerson == null) {
                System.out.println("No person in family with that name");
                return;
            }
            
        Queue<Person> q = new LinkedList<Person>();
		q.add(rootPerson);
		q.add(null);
		
		while(!q.isEmpty()) {
			current = q.remove();
			
			if (current == null) {
				System.out.println();
				if (!q.isEmpty()) {
					q.add(null);
				}
			} else {
				System.out.print(":" + current.getName()  + ": ");
				mother = current.getMother();
				father = current.getFather();
				if (mother != null) q.add(mother);
				if (father != null) q.add(father);
			}
		}
    }
}