import java.util.*;
//https://www.hackerrank.com/challenges/java-dequeue/problem?isFullScreen=true
public class JavaDeque {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque deque = new ArrayDeque<>();
        int n = in.nextInt();
        int m = in.nextInt();

        int max = Integer.MIN_VALUE;
        //this will have the unique elements
        Set uniques = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.add(num);
            uniques.add(num);
            max = Math.max(max, uniques.size());

            if (deque.size()== m){
                //when my deque is a the max size, need to remove head element to let other element enter on next iteration
                int removedVal =(int) deque.remove();
                //validate is removed element is a duplicated on the deque
                //if element is not duplicated removed from the uniques
                if (!deque.contains(removedVal)){
                    uniques.remove(removedVal);
                }

            }

        }
        System.out.println(max);
    }
}
