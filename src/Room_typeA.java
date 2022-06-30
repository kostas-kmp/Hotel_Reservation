public class Room_typeA extends Room{
    double price_per_day;
    public Room_typeA(double price_per_day, int room_capacity, double price_per_person){
        super(room_capacity, price_per_person);
        this.price_per_day = price_per_day;
    }
    public double Payment(int room_number){
        int i;
        double price = 0;
        for(i=0; i<table.length; ++i){
            if(table[i] != null && table[i].room.room_number == room_number){price += price_per_day;}
        }
        return price;
    }
}