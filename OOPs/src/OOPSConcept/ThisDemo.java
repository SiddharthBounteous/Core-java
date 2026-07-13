package OOPSConcept;

class CA
{
    int value = 10;

    CA()
    {
        // Passing current instance of A to B's constructor
        CB b = new CB(this);
    }
    
    CA setValue(int value)
    {
        this.value = value;
        return this; // returning current object
    }
}

class CB
{
    // Constructor of class B that accepts a reference to class A
    CB(CA obj)
    {
        System.out.println("Constructor of CB is called");
        System.out.println("Value from class CA: " + obj.value);
    }
}

public class ThisDemo
{
    public static void main(String[] args)
    {
        CA a = new CA();
        CA b=a.setValue(20);
        System.out.println(b.value);
    }
}
