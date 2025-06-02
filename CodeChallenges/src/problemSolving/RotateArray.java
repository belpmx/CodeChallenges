package problemSolving;

public class RotateArray {
    /*
    let input = [1,2,3,4,5] n = 1; output = [5,1,2,3,4]
    Ans. Rotate array to the right by n positions
     */
    public static void main(String[] args) {
        int n = 3; //n = number of rotations
        int array [] = new int[]{1,2,3,4,5};
        if(n==0){
            //case scenario when array is not rotated
            //return array;
        }

    int solution [] = new int[array.length];

    //calculate the residue and use as startpoint of the for
        // System.out.println("residue: "+ rotate%array.length);
        for (int i = n % array.length, j = 0; i< array.length; i++,j++){
            solution[i]= array[j];
        }
        for (int element: solution){
            System.out.print(element+",");
        }
        System.out.println();
        //insert on the solution array, started from 0 to n % array.length -1
        //calculate array.length -1, minus n% array.length -1 -k
        for (int k = 0; k<= n % array.length -1; k++){
            solution[k]= array[(array.length -1) -(n %array.length-1 -k)];
        }
        for (int element: solution){
            System.out.print(element+",");
        }
    }
}
