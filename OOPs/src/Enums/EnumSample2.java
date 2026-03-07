package Enums;

public enum EnumSample2 {

    MONDAY(1,"First"),
    TUESDAY(2,"Second"),
    WEDNESDAY(3,"Third"),
    THURSDAY(4,"Fourth"),
    FRIDAY(5,"Fifth"),
    SATURDAY(6,"Sixth"),
    SUNDAY(7,"Seventh");

    private int val;
    private  String comment;

    EnumSample2(int val, String comment) {
        this.val = val;
        this.comment = comment;
    }

    public int getVal() {
        return val;
    }

    public String getComment() {
        return comment;
    }

    public static EnumSample2 getEnumValue(int value){
        for(EnumSample2 sample:EnumSample2.values()){
            if(sample.val==value){
                return sample;
            }
        }
        return null;
    }
}
