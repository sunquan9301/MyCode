package exam2;

import java.io.*;

public class Deserialization {
    public static void main(String[] args){
        String filename = "movie.data";
        FileInputStream file = null;
        ObjectInputStream inStream = null;
        try {
            file = new FileInputStream(filename);
            inStream = new ObjectInputStream(file);
            Object obj = inStream.readObject();
//            if(obj instanceof Movie){
//                Movie m = (Movie)obj;
//                System.out.println(m.toString());
//            }
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (FileNotFoundException e1){
            e1.printStackTrace();
        }catch (IOException e2){
            e2.printStackTrace();
        }catch (Exception e3){
            e3.printStackTrace();
        }
    }
}
