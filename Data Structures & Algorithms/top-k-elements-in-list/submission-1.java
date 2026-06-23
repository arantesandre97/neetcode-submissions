class Solution {
    // In the worst case the count of a number frequenct will not
    // be greater than the array size, especially when a unique
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numsCount = new HashMap<>();
        for(int num : nums) {
            Integer numCount = numsCount.getOrDefault(num,0) + 1;
            numsCount.put(num, numCount);
        }

        List<Integer>[] frequencies = new List[nums.length + 1];
        for (int i = 0; i < frequencies.length; i++) {
            frequencies[i] = new ArrayList<>();
        }

        for(Map.Entry<Integer, Integer> numCount : numsCount.entrySet()) {
            int frequency = numCount.getValue();
            int number = numCount.getKey();
            frequencies[frequency].add(number);
        }

        int[] result = new int[k];
        int index = 0;
        
        for (int i = frequencies.length - 1; i >= 0 && index < k; i--) {
            for (int number : frequencies[i]) {
                result[index++] = number;
                if (index == k) {
                    break;
                }
            }
        }

        return result;
    }
}
