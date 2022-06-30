import java.io.*;
import java.util.ArrayList;
public class Arc implements Serializable{
    private String name;
    public Arc(String name){this.name = name;}
    public void arc(int s1){
        try{
            FileWriter f1 = new FileWriter(name, true);
            BufferedWriter b1 = new BufferedWriter(f1);
            b1.write("Res No : " + s1  );
            b1.close();
            f1.close();
        }
        catch(Exception ex){System.out.println(ex.toString());}
    }
    public int lastRes(){
        String line = null;
        int a = 0;
        try {
            FileReader f2 = new FileReader(name);
            BufferedReader r1 = new BufferedReader(f2);
            line = r1.readLine();
            r1.close();
            f2.close();
        }
        catch(Exception ex){System.out.println(ex.toString());}
        try{a = Integer.parseInt(line);}
        catch(NumberFormatException nfe){System.out.println(nfe.toString());}
        return a;
    }
    public void arc1(int s1){
        try{
            FileWriter f1 = new FileWriter(name);
            f1.write("Last reservation is : " + s1);
            f1.close();
        }
        catch(Exception ex){System.out.println(ex.toString());}
    }
    public void save(Hotel h){
        try{
            ObjectOutputStream os = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(name)));
            os.writeObject(h);
            os.close();
        }
        catch(Exception e){System.out.println(e.toString());}
    }
    public Hotel load(){
        Object hotel = null;
        try{
            ObjectInputStream os = new ObjectInputStream(new BufferedInputStream(new FileInputStream(name)));
            hotel = os.readObject();
            os.close();
        }
        catch(Exception e){System.out.println(e.toString());}
        return (Hotel)hotel;
    }
}
