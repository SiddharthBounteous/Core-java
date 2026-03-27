package org.example.day5;

class Document{

    String text;

    public Document(String text){
        this.text=text;
    }

    public void sendToPrinter(Printer p){
        p.printDocument(this);
    }

}
class Printer{
    public void printDocument(Document doc){
        System.out.println("Printing document: "+doc.text);
    }
}
public class Question6 {
    static void main(String[] args) {
        Document d=new Document("I am trying to code");
        Printer p=new Printer();
        p.printDocument(d);
    }
}
