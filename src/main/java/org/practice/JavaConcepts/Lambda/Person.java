package org.practice.JavaConcepts.Lambda;
public class Person{
    private int id;
    private String firstName;
    private String lastName;

    public Person(int id, String fn, String ln) {
        this.id=id;
        firstName=fn;
        lastName=ln;
    }

    
    public int getId() {
        return id;
    }

    
    public String getLastName() {
        return lastName;
    }

    public String getFirstName(){
        return firstName;
    }

    
    public void setId(int id) {
        this.id = id;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String toString(){
        return "Person: [id: "+this.id+", firstName: "+this.firstName+", lastName: "+this.lastName+"]";
    }
}
