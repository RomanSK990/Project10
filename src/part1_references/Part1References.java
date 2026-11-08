package part1_references;

class CreateClass{ // Class creation
	String nonsense;
	CreateClass(String nonsense){
		this.nonsense=nonsense;
	}
}
class ChangeClass{
    String nonsense2;
    ChangeClass(String nonsense2){
        this.nonsense2 = nonsense2;
    }
    public static void modifyObject(ChangeClass obj) {
        obj.nonsense2 = "nonsense3"; // Changing it
    }
}

public class Part1References {
    public static void main(String[] args) {

        CreateClass c1 = new CreateClass("aaaaa"); // Object creation
        CreateClass c2 = c1; // Assigning reference to first variable
        CreateClass c3 = c1; // Assigning reference to second variable

        c2.nonsense="nonsense"; // Changing object properties
        c3.nonsense="true nonsense"; // Changing object properties
        System.out.println(c1.nonsense);
        System.out.println(c2.nonsense);
        System.out.println(c3.nonsense);

        String nonsense2 = "nonsense2";
        ChangeClass c4 = new ChangeClass(nonsense2); // Creating oblect

        ChangeClass.modifyObject(c4); // Passing our object into a method
        System.out.println(c4.nonsense2); // Output changed object
    }
}