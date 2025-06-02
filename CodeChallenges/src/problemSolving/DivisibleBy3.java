package problemSolving;

import java.util.ArrayList;

public class DivisibleBy3 {
    /*
    Write a program to find the numbers divisible by 3 in a string - and reverse its indexes
    eg : - input : String s = "123456789" output String s = "129456783"
    123456789
    12x45x78x
    divisible by 3 : 3,6,9
    replace in target array 12x945x678x3
     */

    public static void main (String[] args){
        int [] array = new int[]{1,2,3,4,5,6,7,8,9,6,9 };
        ArrayList<Integer> list = new ArrayList<>();
        int value =-1;

        for (int i=0; i< array.length;i++){
            //find all ocurrences and save them on arraylist
            if ((array[i]%3)==0)
                list.add(array[i]);
        }
        for(int element :list){
            System.out.print(element+",");
        }
        //reverse the index
        for (int j=array.length -1, index=0; j>0;j--){
            // start backwards
            if ((array[j]%3)==0){
                System.out.println("found reverse "+array[j]);
                array[j]= list.get(index);
                index++;
            }
        }
        System.out.println("Reverse index");
        for(int element: array){
            System.out.print(element +",");
        }


    }
}
