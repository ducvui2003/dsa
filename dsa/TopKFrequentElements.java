package dsa;

import java.util.*;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        // key = number, value = count
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];
            int value = map.get(key) != null ? map.get(key) + 1 : 1;
            map.put(key, value);
        }
        List<Integer> keys = map.keySet().stream().toList();
        int[] result = new int[k];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((i1, i2) -> map.get(i2) - map.get(i1));
        priorityQueue.addAll(keys);
        for (int i = 0; i < result.length; i++) {
            result[i] = priorityQueue.poll();
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 3, 3, 3};
        TopKFrequentElements t = new
                TopKFrequentElements();
        System.out.println(t.topKFrequent(nums, 2));
    }
}
