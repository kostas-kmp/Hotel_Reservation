import java.util.ArrayList;
import java.io.Serializable;
import javax.swing.*;
import java.awt.*;
public class Hotel implements Serializable{
    Arc r1 = new Arc("reservation.txt");
    private String hotelName;
    private boolean flag = true;
    ArrayList<Room> rooms = new ArrayList<Room>();
    ArrayList<Reservation> reservations = new ArrayList<Reservation>();
    public Hotel(String hotelName){this.hotelName = hotelName;}
    public void addRoom(Room room){rooms.add(room);}
    public Room retrieveRoom(int room_number){
        int i;
        Room r = null;
        for(Room room : rooms){
            if(room != null && room.room_number == room_number){r = room;}
        }
        return r;
    }
    public Reservation retrieveReservation(int re_number){
        Reservation r = null;
        for(Reservation res : reservations){
            if(res != null && res.re_number == re_number){r = res;}
        }
        return r;
    }
    public boolean attachResToRoom(int room_number, Reservation res){
        boolean check = false;
        Room r = null;
        if(this.retrieveRoom(room_number)!= null){
            check = true;
            r = retrieveRoom(room_number);
            if(r.add(res)){reservations.add(res);}
            else {check = false;}
        }
        if(check){JOptionPane.showMessageDialog(null,"Successfull reservation\nYou assigned in room: " +room_number ,"Reservation",JOptionPane.PLAIN_MESSAGE);}
        else {JOptionPane.showMessageDialog(null,"Reservation not valid", "Reservation", JOptionPane.PLAIN_MESSAGE);}
        return check;
    }
    public int addRes(Reservation res){
        int room_number = 0;
        for(Room room : rooms){
            if(room.add(res)){
                room_number = room.room_number;
                reservations.add(res);
                JOptionPane.showMessageDialog(null,"Successfull reservation. You assigned in room: " +room_number, "Reservation", JOptionPane.PLAIN_MESSAGE);
                JOptionPane.showMessageDialog(null,"Your reservation number is: " + res.re_number,  "Reservation", JOptionPane.PLAIN_MESSAGE);
                flag = true;
                break;
            }
            else{flag = false;}
        }
        if(!flag){JOptionPane.showMessageDialog(null,"Cant make this reservation", "Reservation", JOptionPane.PLAIN_MESSAGE);}
        return room_number;
    }
    public void resCancelation(int re_number){
        Reservation r;
        if(this.retrieveReservation(re_number) != null){
            r = this.retrieveReservation(re_number);
            if(r.room.Cancelation(re_number)){this.reservations.remove(r); JOptionPane.showMessageDialog(null,"Successfully canceled", "Reservation", JOptionPane.PLAIN_MESSAGE);}
            else{JOptionPane.showMessageDialog(null,"Cant make the cancelation", "Reservation", JOptionPane.PLAIN_MESSAGE);}
        }
    }
    public void incomes(int room_number){
        Reservation r = null;
        double price = 0;
        for(Room room : rooms){
            if(room.room_number == room_number){
                price = room.Payment(room_number);
            }
        }
        JOptionPane.showMessageDialog(null,"The incomes from this room are: " + price, "Reservation", JOptionPane.PLAIN_MESSAGE);
    }
    public void incomes(){
        double price = 0;
        for(Room room : rooms){
            if(room != null){price += room.Payment(room.room_number);}
        }
        JOptionPane.showMessageDialog(null, "The total incomes are: " + price, "Reservation", JOptionPane.PLAIN_MESSAGE);
    }
    public void roomsView(){
        int i;
        System.out.print("Rooms\t\t");
        for(i=0; i<30; ++i){System.out.print((i+1) + "\t");}
        System.out.print("\n");
        for(Room room : rooms){
            System.out.print(room.room_number + "\t\t");
            for(i=0; i<room.table.length; ++i){
                if(room.table[i] == null){System.out.print("_\t");}
                else{System.out.print("*\t");}
            }
            System.out.println("\n");
        }
    }
}