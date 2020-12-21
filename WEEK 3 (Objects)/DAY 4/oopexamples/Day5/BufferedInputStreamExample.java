import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BufferedInputStreamExample {
    //method @param fileName

    static void readFile(String fileName)
    {
        try{
        BufferedInputStream br = new BufferedInputStream(new FileInputStream(fileName));
        //character by character
            // -1
        int character = 0;
        while((character = br.read())!=-1) //until eof is reached -1 is the flag set for eof
        {
            char c = (char) character;
            System.out.println(c);
        }

        }
        catch(FileNotFoundException e){e.printStackTrace();}
        catch(IOException e){e.printStackTrace();}
    }


    public static void main(String[] args) {
        readFile("notes");
    }
}