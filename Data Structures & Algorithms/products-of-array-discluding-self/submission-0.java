class Solution {
    // nums[i] where num has length 3 and i is 2, is nums[1] *  nums[2]
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        Map<Integer, Integer> products = HashMap.newHashMap(nums.length);

        for(int i = 0; i < nums.length; i++) {
            products.put(i, 1);
        }

        for(int i = 0; i < nums.length; i++) {
            for(Map.Entry<Integer, Integer> product : products.entrySet()) {
                if(product.getKey() != i) {
                    product.setValue(product.getValue() * nums[i]);
                }
            }
        }

        for(int j = 0; j < output.length; j++) {
            output[j] = products.get(j);
        }

        return output;
    }
}  
