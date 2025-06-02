package problemSolving;

import java.util.*;

public class FindHigherElement<T> {
    private PriorityLib<T> priorityLib;

    public FindHigherElement(PriorityLib<T> priorityLib) {
        this.priorityLib = priorityLib;
    }

    public T getHighestPriorityElement(List<T> list) {
        //Validate that parameter list is not null
        if (list.isEmpty() || list == null)
            return null;
        //if only one element then is the Highest priority
        if (list.size()==1)
            return list.get(0);
        Comparator<T> myComp = (item1, item2) -> {
            if (priorityLib.getHigherPriorityList(List.of(item1),List.of(item2)).get(0) == item1)
                return 1;
            else return -1;

        };

        return list.stream()
                .max((item1, item2)-> priorityLib.getHigherPriorityList(List.of(item1),List.of(item2)).get(0) == item1 ? 1:-1)
                .get();





   // return null;
    }
}


    abstract class PriorityLib<T>{
        public abstract List<T> getHigherPriorityList(List<T> list1, List<T> list2);
    }

