import java.io.FileOutputStream;
import java.io.IOException;

public class OutputStreamExample {
    public static void main(String[] args) {
        String str = "Wednesday....";

        byte[] b = str.getBytes();

        try{
            FileOutputStream out = new FileOutputStream("writeOutput.txt");
            out.write(b);
            //appending data -> find

        
        }
        catch(IOException e){e.printStackTrace();}
    }
}
