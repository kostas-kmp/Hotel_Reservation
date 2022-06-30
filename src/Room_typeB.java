import java.util.Scanner;
import javax.swing.JOptionPane;
public class Room_typeB extends Room_typeA{
    private double discount_per_day;
    public Room_typeB(int discount_per_day, double price_per_day, int room_capacity, double price_per_person){
        super(price_per_day, room_capacity, price_per_person);
        this.discount_per_day = discount_per_day;
    }
    public double Payment(int room_number){
        int i;
        double price = 0;
        int counter = 0;
        boolean flag = true;
        for(i=0; i<table.length; i++){
            if(table[i] != null && table[i].room.room_number == room_number){
                counter++;
            }
        }
        if(counter != 0){
            double[] seperatePrices = new double[counter];
            seperatePrices[0] = super.price_per_day;
            for(i=1; i<counter; i++){
                seperatePrices[i] = seperatePrices[i-1] - (double)discount_per_day*seperatePrices[i-1]/100;
                if(seperatePrices[i] <= seperatePrices[0]/2.0){seperatePrices[i] = seperatePrices[0]/2.0;}
            }
            for(i=0; i<counter; ++i){
                price += seperatePrices[i];
            }
        }
        return price;
    }
    public boolean Cancelation(int re_number){return false;}
}
