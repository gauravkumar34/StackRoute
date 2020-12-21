package JavaBasicArraysAndMethods;

public class ArraysExample {
    public static void main(String[] args) {
        //Arrays -> multiple values
        // 100 numbers -> int [] a = new int[100];
        // continuos xx01 - xx100, homogenous, similar data
        //indexing 100 -> 0 - 99

        //declaring
        int a[] = new int[10];
        //initialize
        // a[0] = 10;
        // a[1] = 20;
        // a[2] = 30;
        // a[3] = 40;
        // a[4] = 50;

        int temp = 0;
        for(int i = 0;i<a.length;i++)
        {
            a[i] = 10 + temp;
            temp =temp+10;
        }

        //print values of the array
        //System.out.println(a);

        // runs for 10 -> definite loop
        // initialize i = 0 ; i<10 ; i++)
        for(int i = 0;i<a.length;i++)
        {
            //0,1,2,3,4 -> 
            System.out.println(a[i]);
        }



    }
}
