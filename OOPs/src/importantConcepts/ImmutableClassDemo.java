package importantConcepts;

import java.util.ArrayList;
import java.util.List;

final class UserProfile{
    private final String username;
    private final String email;
    private final List<String>courses;

    UserProfile(String username, String email, List<String> courses) {
        this.username = username;
        this.email = email;
        //this.courses = courses; //not like this
        //create a list which is a new copy
        this.courses=new ArrayList<>(courses);
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public List<String> getCourses(){
//        return courses;
        //return the copy of original reference
        return new ArrayList<>(courses);
    }
}
public class ImmutableClassDemo {
    public static void main(String[] args) {
        List<String> courses=new ArrayList<>();
        courses.add("java");
        courses.add("spring boot");
        courses.add("react");
        UserProfile userProfile=new UserProfile("rahul","kumarRahul@gmail.com",courses);
        System.out.println(userProfile.getUsername());
        System.out.println(userProfile.getEmail());
        System.out.println(userProfile.getCourses());
        courses.add("angular");
        System.out.println(userProfile.getCourses());
        userProfile.getCourses().add("c++");
        System.out.println(userProfile.getCourses());
    }
}
