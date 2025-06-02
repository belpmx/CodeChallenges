package problemSolving;

import java.util.ArrayList;
import java.util.List;

public class LeftRotation {
    public static void main(String[] args) {
        int d = 4; //n = number of rotations
        List<Integer> array = new ArrayList<>();
        List<Integer> result ;
        array.add(0,1);
        array.add(1,2);
        array.add(2,3);
        array.add(3,4);
        array.add(4,5);
        result = rotLeft(array,d);
        for (Integer element:result){
            System.out.print(element+",");
        }

    }

    public static List<Integer> rotLeft(List<Integer> a, int d) {
        List<Integer> rotations = new ArrayList<>();
        // Elements from index d to the end
        rotations.addAll(a.subList(d, a.size()));
        // Elements from the start to index d
        rotations.addAll(a.subList(0, d));
        return rotations;
    }
}

