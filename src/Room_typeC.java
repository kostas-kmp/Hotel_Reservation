public class Room_typeC extends Room{
    private int leastPersons;
    private int leastDays;
    public Room_typeC(int leastPersons, int leastDays, int room_capacity, double price_per_person){
        super(room_capacity, price_per_person);
        this.leastPersons = leastPersons;
        this.leastDays = leastDays;
    }
    public boolean add(Reservation reservation){
        boolean date = true;
        int i = reservation.arrival;
        if(reservation.days >= leastDays && reservation.persons >= leastPersons){
            while(i < (reservation.arrival + reservation.days) && date == true){
                if(table[i-1] != null) {date = false;}
                else{
                    if(room_capacity < reservation.persons){date = false;}
                }
                i++;
            }
            if(date == true){
                for(i=reservation.arrival; i<= (reservation.arrival + reservation.days); ++i){table[i]= reservation;}
                reservation.RoomAssign(this);
            }
        }
        else{date = false;}
        return date;
    }
    public double Payment(int room_number){
        int i;
        double price = 0;
        for(i=0; i<table.length; ++i){
            if(table[i] != null && table[i].room.room_number == room_number){
                price += table[i].room.price_per_person*table[i].persons;
            }
        }
        return price;
    }
}
