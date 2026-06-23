class Solution {
    // nums[i] where num has length 3 and i is 2, is nums[1] *  nums[2]
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];

        int prefix = 1;
        for(int i = 0; i < nums.length; i++) {
            output[i] = prefix;
            prefix *= nums[i];
        }

        int posfix = 1;
        for(int j = nums.length - 1; j >= 0; j--){
            output[j] *= posfix;
            posfix *= nums[j];
        }

        return output;
    }
}  
