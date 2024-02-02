import java.util.*;

public class FruitsinToBasketsSlidingWindow2 {

    public int findLength(char[] arr) {
        int start = 0;
        int maxLength = 0;

        HashMap<Character, Integer> myMap = new HashMap<>();

        for (int end = 0; end < arr.length; end++) {
            myMap.put(arr[end], myMap.getOrDefault(arr[end], 0) + 1);

            // shrink the sliding window, until we are left with 2 fruits in the frequency
            // map

            while (myMap.size() > 2) {
                myMap.put(arr[start], myMap.get(arr[start]) - 1);

                if (myMap.get(arr[start]) == 0) {
                    myMap.remove(arr[start]);
                }
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        FruitsinToBasketsSlidingWindow2 sol = new FruitsinToBasketsSlidingWindow2();
        System.out.println("Maximum number of fruits: " +
                sol.findLength(new char[] { 'A', 'B', 'C', 'A', 'C' }));
        System.out.println("Maximum number of fruits: " +
                sol.findLength(new char[] { 'A', 'B', 'C', 'B', 'B', 'C' }));
    }
}
