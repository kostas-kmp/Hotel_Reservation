public class Room_typeD extends Room_typeA{
    private String typeOfFood;
    public Room_typeD(int room_capacity, double price_per_person, double price_per_day, String typeOfFood ){
        super(price_per_day, room_capacity, price_per_person);
        this.typeOfFood = typeOfFood;
    }
    public double Payment(int room_number){
        int i, counter = 0;
        double price = 0;
        double extraPrice = 0;
        boolean flag = true;
        for(i=0; i<table.length; ++i){
            if(table[i] != null && table[i].room.room_number == room_number){
                counter++;
                price += price_per_day;
            }
        }
        if(typeOfFood == "breakfast"){extraPrice = counter*5.0;}
        else if(typeOfFood == "lunch"){extraPrice = counter*8.0;}
        else if(typeOfFood == "dinner"){extraPrice = counter*7.0;}
        else if(typeOfFood == "full meal"){extraPrice = counter*15.0;}
        return price + extraPrice;
    }
}

