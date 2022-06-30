import java.io.Serializable;
abstract class Room implements Serializable{
    static int number = 99;
    int room_number;
    int room_capacity;
    double price_per_person;
    Reservation[] table = new Reservation[30];
    public Room(int room_capacity, double price_per_person){
        this.room_capacity = room_capacity;
        this.price_per_person = price_per_person;
        room_number = number++;
    }
    public boolean add (Reservation reservation){
        boolean date = true;
        int i = reservation.arrival;
        while(i < (reservation.arrival + reservation.days) && date == true){
            if(table[i-1] != null) {date = false;}
            else{
                if(room_capacity < reservation.persons){date = false;}
            }
            i++;
        }
        if(date == true){
            for(i=(reservation.arrival-1); i< (reservation.arrival + reservation.days-1); ++i){table[i] = reservation;}
            reservation.RoomAssign(this);
        }
        return date;
    }
    abstract double Payment(int room_number);
    public boolean Cancelation(int re_number){
        int i;
        boolean flag = true;
        for(i=0; i<table.length; ++i){
            if(table[i] != null && table[i].re_number == re_number){
                if(table[i] == null){flag = false;}
                while(table[i] != null && table[i].re_number == re_number){
                    table[i] = null;
                    i++;
                }
            }
        }
        return flag;
    }
    public double Occupancy(){
        int counter = 0;
        int i;
        for(i=0; i<this.table.length; ++i){
            if(this.table[i]  != null){counter++;}
        }
        return ((double)counter/this.table.length)*100.0;
    }
}
