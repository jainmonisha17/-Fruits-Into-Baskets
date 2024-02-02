import java.util.*;

public class FruitsinToBasketsSlidingWindow {

    public int findLength(char[] arr) {
        int n = arr.length;
        int start = 0;
        int end = 0;
        int maxFruits = 0;

        HashMap<Character, Integer> distChar = new HashMap<>();

        while (end < n) {

            if (distChar.containsKey(arr[end]) || distChar.size() < 2) {
                distChar.put(arr[end], distChar.getOrDefault(arr[end], 0) + 1);
                end++;
                maxFruits = Math.max(maxFruits, end - start + 1);
            } else {
                distChar.put(arr[end], distChar.get(arr[start]) - 1);

                if (distChar.get(arr[start]) == 0) {
                    distChar.remove(arr[start]);
                }
                start++;
            }
        }

        return maxFruits;
    }

    public static void main(String[] args) {
        FruitsinToBasketsSlidingWindow sol = new FruitsinToBasketsSlidingWindow();
        System.out.println("Maximum number of fruits: " +
                sol.findLength(new char[] { 'A', 'B', 'C', 'A', 'C' }));
        System.out.println("Maximum number of fruits: " +
                sol.findLength(new char[] { 'A', 'B', 'C', 'B', 'B', 'C' }));
    }
}
