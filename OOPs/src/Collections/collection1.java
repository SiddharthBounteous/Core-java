package Collections;

import java.util.*;

public class collection1 {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
//        HashSet<String>st=new HashSet<>();
//
//
//        System.out.println("Enter Values:");
//
//        while(true){
//
//            String line=sc.nextLine();
//
//            if(line.isEmpty()){
//                break;
//            }
//            st.add(line);
//        }
//
//
//        for(String it:st){
//            System.out.println(it);
//        }


//        ArrayList<String>arr=new ArrayList<>();
//
//        System.out.println("Enter Values:");
//
//        while(true){
//
//            String line=sc.nextLine();
//
//            if(line.isEmpty()){
//                break;
//            }
//            arr.add(line);
//        }
//
//        for(String it:arr){
//            System.out.println(it);
//        }

//        HashMap<String,Integer>mp=new HashMap<>();
//
//        System.out.println("Enter Values:");
//
//        while(true){
//
//            String line=sc.nextLine();
//
//            if(line.isEmpty()){
//                break;
//            }
//
//            mp.put(line, mp.getOrDefault(line,0)+1);
//        }
//
//        mp.forEach((key,value)->{
//            System.out.println(key+" "+value);
//        });


//        HashSet<Integer>st=new HashSet<>();
//
//
//        System.out.println("Enter Values:");
//
//        while(true){
//
//            String line=sc.nextLine();
//
//            if(line.isEmpty()){
//                break;
//            }
//            String[] parts=line.split(" ");
//            for(String it:parts){
//                int val=Integer.parseInt(it);
//                st.add(val);
//            }
//
//        }
//
//
//        for(Integer it:st){
//            System.out.println(it);
//        }

//        ArrayList<Integer>arr=new ArrayList<>();
//
//        System.out.println("Enter Values:");
//
//        while(true){
//
//            String line=sc.nextLine();
//
//            if(line.isEmpty()){
//                break;
//            }
//            String[] parts=line.split(" ");
//            for(String it:parts){
//                int val=Integer.parseInt(it);
//                arr.add(val);
//            }
//        }
//
//        Collections.sort(arr);
//        int n=arr.size();
//        System.out.println(arr.get(n-1));

//        List<String>li=new ArrayList<>();
//        System.out.println("Enter Values:");
//
//        while(true){
//            String line=sc.nextLine();
//
//            if(line.isEmpty()){
//                break;
//            }
//
//            li.add(line);
//        }
//
//        for(String it:li){
//            System.out.println(it);
//        }

//        ArrayList<String>arr=new ArrayList<>();
//        System.out.println("Enter Names");
//
//        while(true){
//            String line=sc.nextLine();
//
//            if(line.isEmpty()){
//                break;
//            }
//
//            arr.add(line);
//        }
//
//        Collections.sort(arr);
//        for(String it:arr){
//            System.out.print(it+ " ");
//        }
//        System.out.println();


//        HashSet<Integer>hs=new HashSet<>();
//        System.out.println("Enter Numbers");
//
//        while(true){
//            String line=sc.nextLine();
//
//            if(line.isEmpty()){
//                break;
//            }
//            String [] str=line.split(" ");
//
//            for(String it:str){
//                int val=Integer.parseInt(it);
//                if(!hs.contains(val)){
//                    hs.add(val);
//                }
//                else{
//                    System.out.print(val+" ");
//                }
//            }
//        }
//        System.out.println();

//        Queue<String>qu=new LinkedList<>();
//
//        System.out.println("Enter Patients");
//
//        while(true){
//            String line=sc.nextLine();
//
//            if(line.isEmpty()){
//                break;
//            }
//
//            qu.add(line);
//        }
//
//        while(!qu.isEmpty()){
//            System.out.println("Serving: "+qu.peek());
//            qu.poll();
//        }

        System.out.println("Enter number of employees");
        int n=sc.nextInt();

        HashMap<Integer,String>mp=new HashMap<>();
        int a;String b;

        for(int i=0;i<n;i++){
            System.out.println("Enter id and name for "+i+1+" Employee");
            a=sc.nextInt();
            b=sc.nextLine();

            mp.put(a,mp.getOrDefault(a,b));
        }

        mp.forEach((key,value)->{
            System.out.println(key+" "+value);
        });
    }
}


