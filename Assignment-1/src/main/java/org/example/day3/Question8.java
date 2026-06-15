package org.example.day3;

class Solution8{
    public String validateIPv4(String IP){
        //[1-9][0-9] it means it is a two-digit number
        //[1-9][0-9]{2} it can be written two times -> 2678
        //2[0-4][0-9]=> 200 - 249
        String regex="^(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";

        if(IP.matches(regex)){
            return "IPv4";
        }
        return "Neither";
    }
    public String validIPAddress(String queryIP) {

        if(queryIP==null || queryIP.isEmpty()){
            return "Neither";
        }

        if(queryIP.contains(".")){
            return validateIPv4(queryIP);
        }

        return "Neither";
    }
}
public class Question8 {
    static void main(String[] args) {
        Solution8 obj=new Solution8();

        String ans= obj.validIPAddress("023.16.254.1");

        System.out.println(ans);
    }
}
