package org.example.day4;

import java.util.ArrayList;
import java.util.List;

class Solution11{
    public void solve(List<String> temp,int idx,String str,List<List<String>>result){
        if(idx>=str.length()){
            result.add(new ArrayList<>(temp));
            return;
        }
        temp.add(String.valueOf(str.charAt(idx)));
        solve(temp,idx+1,str,result);
        temp.remove(temp.size()-1);
        solve(temp,idx+1,str,result);
    }
    public List<List<String>> subsets(String str) {
        List<String>temp=new ArrayList<>();
        List<List<String>>result=new ArrayList<>();

        solve(temp,0,str,result);

        return result;
    }
}
public class Question11 {
    static void main(String[] args) {
        Solution11 obj=new Solution11();
        List<List<String>>result=obj.subsets("abc");
        for(List<String>temp:result){
            for(String it:temp){
                System.out.print(it+" ");
            }
            System.out.println();
        }
    }
}
