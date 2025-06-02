package problemSolving;
import java.util.HashSet;
public class MinimunUniqueArraySum {
    /*
    * Given an array, increment any duplicate elements until all elements are unique.
    * The sum of the elements must be the minimun possible.
    * arr[3,2,1,2,7] sum = 3+2+1+4(this was incremented)+7= 17
    * arr[2,2,2]= [2,3,4]= 9
    * */

    static int getMininumUniqueSum(int [] array){
        HashSet<Integer> setOfUnique = new HashSet<>();
        int sum =0;
        for (int index =0; index < array.length; index++){
            //if the value already inserted on the set then increment the value
            while (setOfUnique.contains(array[index])){
                array[index] = array[index]+1;
            }
            setOfUnique.add(array[index]);
            sum += array[index];
        }
        return sum;
    }
    public static void main(String[] args) {
        int [] array1 = {3,2,1,2,7};
        int [] array2 = {2,2,2};
        System.out.println("Array 1 = "+getMininumUniqueSum(array1));
        System.out.println("Array 2 = "+getMininumUniqueSum(array2));
    }
}
