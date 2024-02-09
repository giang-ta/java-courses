package data_structures;

import java.util.*;

public class CollectionsDemo {
    public static void main(String[] args) {
        setDemo();
    }

    public static void setDemo(){
        Set fruits = new HashSet();
        fruits.add("apple");
        fruits.add("banana");
        fruits.add("lemon");
        fruits.add("apple");
        System.out.println(fruits);
        fruits.remove("lemon");
        System.out.println("contains lemon? " + fruits.contains("lemon"));
    }

    public static void listDemo() {
        List fruits = new ArrayList();
        fruits.add("apple");
        fruits.add("banana");
        fruits.add("lemon");
        fruits.set(2, "grape");
        fruits.add("lemon");
        fruits.remove("lemon"); // remove first found
        fruits.remove(3);
        System.out.println(fruits);
        System.out.println("index 2: " + fruits.get(2));
        System.out.println("index of grape: " + fruits.indexOf("grape"));
        System.out.println("last index of lemon: " + fruits.lastIndexOf("lemon"));
    }

    public static void queueDemo() {
        Queue fruits = new LinkedList();
        fruits.add("apple");
        fruits.add("banana");
        fruits.add("lemon");
        fruits.add("apple");
        var removed = fruits.remove();
        System.out.println("Remove " + removed);
        System.out.println("Head of queue: " + fruits.peek());
        System.out.println(fruits);
    }

    public static void mapDemo() {
        Map<String, Integer> fruitsCalories = new HashMap();
        fruitsCalories.put("apple", 95);
        fruitsCalories.put("lemon", 200);
        fruitsCalories.put("orange", 21);
        fruitsCalories.put("apple", 95);
        fruitsCalories.putIfAbsent("strawberry", 100);
        fruitsCalories.remove("lemon");
        System.out.println(fruitsCalories);
        System.out.println(fruitsCalories.get("lemon"));

        for (Map.Entry calorieInfo: fruitsCalories.entrySet()){
            System.out.println(calorieInfo.getKey() + ": " + calorieInfo.getValue());
        }
    }
}
