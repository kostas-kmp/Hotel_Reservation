import java.io.Serializable;
import javax.swing.JOptionPane;
public class Reservation implements Serializable{
    Arc r1 = new Arc("last_res.txt");
    String name;
    int re_number;
    int arrival, days, persons;
    Room room;
    public Reservation(String name, int arrival, int days, int persons){
        this.name = name;
        this.arrival = arrival;
        this.days = days;
        this.persons = persons;
        re_number = r1.lastRes() + 1;
    }
    public void RoomAssign(Room room){this.room = room;}
    public String printRes(){
        String res = "Reservation with number " + re_number + " in name " + name + " that is valid from " + arrival + " to " + (arrival+days-1) + " and includes " + persons + " persons is assigned to room " + room.room_number +".";
        return res;
    }
}
