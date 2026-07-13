package importantConcepts;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Person{
    String name;
    int age;

    public Person(String name,int age){
        this.name=name;
        this.age=age;
    }

//    So HashSet says:
//    Both objects may be duplicates. Let me check equals().
//    Important: hashCode() does not finally prove equality. It only helps find the bucket.
    public boolean equals(Object obj){

        //This checks whether both references point to the exact same object.
        if(this==obj) return true;

        //This checks whether the object being compared is actually a Person.
        if(!(obj instanceof Person)) return false;

        //Now Java knows obj is a Person, so we safely typecast it.
        Person other=(Person) obj;

        //this is actual comparison
        //Two Person objects are equal if:
        //age is same
        //and name is same
        return age==other.age && Objects.equals(name,other.name);
    }

    //This generates a hash value based on:
    //name
    //age
    //So for both objects:
    //new Person("Alice", 30)
    //new Person("Alice", 30)
    //hash code will be same because name and age are same.
    public int hashCode(){
        return Objects.hash(name,age);
    }
}
public class HashCodeAndEqualsDemo {
    public static void main(String[] args) {
        Set<Person> st=new HashSet<>();

        //Memory-wise, they are different objects
        //But logically, for program, both represent the same person.
        //To check duplicates, HashSet uses two things:
        //1. hashCode()
        //2. equals()
        st.add(new Person("Alice",30));
        st.add(new Person("Alice",30));

        System.out.println(st.size());

        //What happens if you do not override equals() and hashCode()?
        //Then Java uses default methods from Object class.
        //Default equals() checks reference equality:
        //Are both references pointing to the same object?
        //But in your code:
        //new Person("Alice", 30)
        //new Person("Alice", 30)
        //both are different objects in memory.
        //So without overriding, output would be:
        //2
        //Because Java would think:
        //different memory address = different object
    }
}
