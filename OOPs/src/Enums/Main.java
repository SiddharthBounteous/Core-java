package Enums;

public class Main {
    static void main(String[] args) {
        for(EnumSample sample: EnumSample.values()){
            System.out.println(sample.ordinal());
        }

        EnumSample enumVariable=EnumSample.valueOf("FRIDAY");
        System.out.println(enumVariable.name());

        EnumSample2 sample2=EnumSample2.getEnumValue(2);
        System.out.println(sample2.getComment());

        EnumSample sampleMonday=EnumSample.MONDAY;
        sampleMonday.dummyMethod();
    }
}
