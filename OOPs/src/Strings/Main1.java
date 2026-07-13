package Strings;

import java.nio.channels.Pipe.SourceChannel;

public class Main1 {
	public static void main(String [] args) {
		String s = "😊👍";
		System.out.println(s.length());
		
//		String s1="Java";
//		String str=new String("Java");
//		String s2=s1.intern();
//		String s3=s2.intern();
//		String s4=str.intern();
//		String s5=s1;
//		StringBuilder sBuilder=new StringBuilder();
//		sBuilder.append(s1.intern());
//		System.out.println(s1);
//		System.out.println(s2);
//		System.out.println(s1==s2);
//		System.out.println(s1==s3);
//		System.out.println(s2==s3);
//		System.out.println(s2==str);
//		System.out.println(s4==str);
//		System.out.println(s1==s5);
//		System.out.println(sBuilder.toString()==s1);
		String s1="java";
		System.out.println(s1.concat("love"));
		System.out.println(s1);
		s1=s1.concat("love");
		System.out.println(s1);
		s1="java";
		String s2="java";
		System.out.println(s1==s2);
	}
}
