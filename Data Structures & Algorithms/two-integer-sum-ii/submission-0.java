class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int begin = 0;
        int end = numbers.length - 1;

        while(begin < end) {
            if(numbers[begin] + numbers[end] > target)
                end--;

            if(numbers[begin] + numbers[end] < target)
                begin++;

            if(numbers[begin] + numbers[end] == target)
                break;
        }

        return new int[] {begin + 1, end + 1};
    }
}
