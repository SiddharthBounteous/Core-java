package OOPSConcept.relationship;

class Room {
    void display() {
        System.out.println("Room exists");
    }
}

class House {

    private Room room;

    House() {
        room = new Room(); // Created internally
    }

    void showHouse() {
        room.display();
        System.out.println("House exists");
    }
}
public class StrongAssociation {
    public static void main(String[] args) {
        House house = new House();

        house.showHouse();
        //House ----owns----> Room
        //House creates Room.
        //Room's lifecycle depends on House.
        //If House is destroyed, Room is also gone.
    }
}
