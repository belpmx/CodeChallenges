
/*
Don’t provide setter methods for variables.
Make all mutable fields final so that a field’s value can be assigned only once.
Perform cloning of objects in the getter methods to return a copy rather than returning the actual object reference.
*/

import java.util.HashMap;
import java.util.Iterator;

//Declare the class as final so it can’t be extended.
public final class Inmutable {
    //Make all fields private so that direct access is not allowed.
    private final int id;
    private final String name;
    private final HashMap<String, String> testMap;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    //Perform cloning of objects in the getter methods to return a copy rather than returning the actual object reference.
    public HashMap<String, String> getTestMap() {
        return (HashMap<String, String>) testMap.clone();
    }

    public Inmutable(int id, String name, HashMap<String, String> inputMap) {
        this.id = id;
        this.name = name;
        //Initialize all fields using a constructor method performing deep copy.
        String key, value;
        HashMap<String, String> tempMap = new HashMap<>();
        Iterator<String> iterator = inputMap.keySet().iterator();
        while (iterator.hasNext()) {
            key = iterator.next();
            value = inputMap.get(key);
            tempMap.put(key, value);
        }
        this.testMap = tempMap;
    }

    public static void main(String[] args) {
        HashMap<String, String> inputMap = new HashMap<String,String>();
        inputMap.put("1", "first");
        inputMap.put("2", "second");
        String name = "original";
        int i=10;

        Inmutable inmutableInstance = new Inmutable(i,name, inputMap);

        // print the ce values
        System.out.println("ce id: "+inmutableInstance.getId());
        System.out.println("ce name: "+inmutableInstance.getName());
        System.out.println("ce testMap: "+inmutableInstance.getTestMap());
        // change the local variable values
        i=20;
        name="modified";
        inputMap.put("3", "third");
        // print the values again
        System.out.println("ce id after local variable change: "+inmutableInstance.getId());
        System.out.println("ce name after local variable change: "+inmutableInstance.getName());
        System.out.println("ce testMap after local variable change: "+inmutableInstance.getTestMap());

        HashMap<String, String> hmTest = inmutableInstance.getTestMap();
        hmTest.put("4", "new");

        System.out.println("ce testMap after changing variable from getter methods: "+inmutableInstance.getTestMap());

    }
}
