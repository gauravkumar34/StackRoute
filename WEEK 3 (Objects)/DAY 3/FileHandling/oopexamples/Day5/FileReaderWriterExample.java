import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
public class FileReaderWriterExample {
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    static int fileLineCount(String fileName) {
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while (br.readLine() != null) {
                count++;
            }
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return count;
    }

    static Person[] readFromFile(String fileName) {
        int numberOfPersons = fileLineCount(fileName);
        Person[] persons = new Person[numberOfPersons - 1];
        

        // objects of different persons
        try (BufferedReader br1 = new BufferedReader(new FileReader(fileName))) {
            br1.readLine();
            int index = 0;
            String line = null;
            while ((line = br1.readLine()) != null) {
                String[] arr = line.split(",");
                Person p = new Person();
                p.setAge(Integer.parseInt(arr[1]));
                p.setName(arr[0]);
                p.setAddr(arr[2]);                
                try {
                    
                    p.setDate(sdf.parse(arr[3]));
                } catch (ParseException e) {
                    
                    e.printStackTrace();
                }
             persons[index] = p;
            index++;

            }
        
              
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
           e.printStackTrace();
        }
    
        return persons;
    }

    static void writeToFile()
    {
        try(FileWriter fw = new FileWriter("writerOut.txt")){
            fw.write("Hello Good Morning !!!!!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    public static void main(String[] args) {
       // System.out.println(args[0]);
        Person p[] = readFromFile("sample.csv");
        
        System.out.println(p.length);
        for(int i =0;i<p.length;i++)
        {
            System.out.println(p[i].getName() +" :: "+p[i].getAge()+" :: "+p[i].getAddr()+" :: "+sdf.format(p[i].getDate()));
           
        }
        //writeToFile();
    }

    
}
