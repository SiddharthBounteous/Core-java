package Algortihms;

import java.util.HashSet;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        if(nums.length==1){
            return false;
        }
        HashSet<Integer>st=new HashSet<>();

        for(int num:nums){
            if(st.contains(num)){
                return true;
            }
            st.add(num);
        }
        return false;
    }
}
