package org.example.day5;
class User{
    private static int count=0;
    private int count1=0;

    public User(){
        count++;
        count1++;
    }

    public static int getTotalUsers(){
        return count;
    }

    public int getUsers(){
        return count1;
    }
}
public class Question10 {
    static void main(String[] args) {
        User u1=new User();

        System.out.println(User.getTotalUsers());

        User u2=new User();
        User u3=new User();

        System.out.println(User.getTotalUsers());

        System.out.println(u1.getUsers());
        System.out.println(u2.getUsers());
    }
}
