package Enums;

public enum EnumSample {
    MONDAY{
        @Override
        public  void dummyMethod(){
            System.out.println("monday method");
        }
    },
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;

    public void dummyMethod(){
        System.out.println("default method");
    }
}
