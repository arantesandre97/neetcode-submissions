class Solution {
    // iterate the array to calculate the prefixes then prefixes values, 
    // at the second iteration the values will be multiplied
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
