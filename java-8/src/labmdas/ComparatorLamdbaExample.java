package labmdas;

import java.util.Comparator;

public class ComparatorLamdbaExample {
    public static void main(String[] args) {
        /*
        prior java 8
         */

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
                // 0 means equals
                // 1 means a1>a2
                // -1 means  a1<a2
            }
        };
        System.out.println("Result of the comparator is : "+comparator.compare(3,2));

        Comparator<Integer> comparatorLambda = (Integer a, Integer b) -> a.compareTo(b);

        System.out.println("Result of the comparator lambda : "+comparatorLambda.compare(3,2));

        Comparator<Integer> comparatorLambdaE = (a,b) -> a.compareTo(b);
        System.out.println("Result of the comparator lambda : "+comparatorLambdaE.compare(3,2));
    }
}
