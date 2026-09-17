// okay as they're ordered I can use the binary search approach
// so I gonna iterate through my array picking the mid value
// every time
// I'll have two variables to establish my search array, left and right
// left will start at the array begin (0) and right at the end (length - 1)
// so while left is smaller or equal right I keep iterating through my array
// when it breaks that condition it means that I checked my whole array
// and I can return -1
// but during my loop I will check if the value in mid position is equal my target
// if it's I return my mid, otherwise I need to check if is bigger
// then positioning my starting position (left) at mid + 1
// or if is smaller then positioning my array end pointer to mid - 1
// this solution can provide the target search in O(log n) time complexity
// and O(1) space complexity because no extra space will need at all

// intialize left and right
// while left if smaller or equal to right keep looping
// calculate mid using left plus right divided by 2
// then I check is nums mid position value equals my target
// if is return mid value;
// else check if my target is bigger than my mid
// if is left gonna point to mid + 1
// else I know that my target is smaller and I move right to mid - 1

// left (right - left) / 2
// above we've an alternative approach to prevent bigger int
// numbers to overflow 32 bits and get a negative int

class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {
            int mid = (left + right) / 2; 

            if(target == nums[mid])
                return mid;
            else if(target > nums[mid])
                left = mid + 1;
            else
                right = mid - 1;
        }

        return -1;
    }
}
