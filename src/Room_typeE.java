public class Room_typeE extends Room{
    private boolean smoking;
    private static final int tax = 5;
    public Room_typeE(int room_capacity, double price_per_person, boolean smoking){
        super(room_capacity, price_per_person);
        this.smoking = smoking;
    }
    public double Payment(int room_number){
        int i;
        double price = 0;
        boolean flag = true;
        if(smoking){
            for(i=0; i<table.length; ++i){
                if(table[i] != null && table[i].room.room_number == room_number){
                    price += table[i].room.price_per_person*table[i].persons + tax;
                }
            }
        }
        else{
            for(i=0; i<table.length; ++i){
                if(table[i] != null && table[i].room.room_number == room_number){
                    price += table[i].room.price_per_person*table[i].persons;
                }
            }
        }
        return price;
    }
}

