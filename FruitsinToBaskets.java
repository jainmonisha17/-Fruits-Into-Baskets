import java.util.*;

public class FruitsinToBaskets {

    public static int findMaxFruits(int[] arr) {
        int n = arr.length;
        int maxFruits = 0;

        HashMap<Integer, Integer> fruitFrequency = new HashMap<>();

        for(int start = 0; start < n; start++) {
            for(int end = start; end < n; end++) {
                int currentFruit = arr[end];
                int currentFruitFrequency = fruitFrequency.getOrDefault(currentFruit, 0);
                currentFruitFrequency = currentFruitFrequency + 1;
                fruitFrequency.put(currentFruit, currentFruitFrequency);

                // if there are more than 2 distinct fruits in the substring, break
                if(fruitFrequency.size() > 2) {
                    break;
                }

                // updatae maxFruits if the current substring length is greater
                maxFruits = Math.max(maxFruits, end - start + 1);
            }
        }
    return maxFruits;
    }
}