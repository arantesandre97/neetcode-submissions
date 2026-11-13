// how many numbers nums array can have?
// what are the numbers values interval?
// does it can have duplicated numbers?
// how many rotation can it have at all?

// well the problem is to find a target number inside this sorted array in more optmized way than O(n)
// so the brute force is trivial there, we want to find a better solution
// especially in a scenario where we can have a huge array with millions of elements

// edge case:
// one element array
// only negative numbers array


/**
so, in a sorted array it will be easy to find a target using a binary search
but in that case the array can be rotated n times, which means that no order is guaranteed
however, even rotating the array we kind of still have a order there in one of it sides
lets take a look at example 1
nums = [3,4,5,6,1,2]

considering the middle element, which side is ordered?
3,4,5 or 5,6,1,2? of course is the left side in that case

what about example 2
nums = [3,5,6,0,1,2]

there is also the left side 3,5,6 instead of 6,0,1,2

so how can we know which side is ordered? in the asceding order the left number must be always lower than right number
so if middle is bigger than right side, the left side is order. Otherwise the right side is ordered, lets try to find out
a example where right position has a bigger number

nums = [6,7,1,2,3,4,5]
our middle is 2, 2 is smaller than right pointer that is 5, so our right side is ordered

okay I guess we have a formula to find which side is ordered

but what if our number isn't between the left or right side numbers interval, lets consider 6 as a target in this last scenario
nums = [6,1,2,3,4,5], target = 6
well we know that the ordered side is right, but 6 isn't between 2 and 5. We'll need to search in the left side in that case, but how?
let me think, let put some extra elements in the array to checkout the logic
in that case we can move our right pointer to mid - 1, and repeat the logic so the left side will be ordered and we gonna try to find our
target
but I'm not certain about the previous scenario where nums = [6,1,2,3,4,5], if we move our right pointer to mid - 1, we gonna have the 0 to 1 interval, right?
if we check mid again, it gonna indicates that left side is order, and we can find six, that's it. I'm confident that my solution can work there
can we follow up for coding?

*/

class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while(l <= r) {
            int mid = (l + r) / 2;

            if(nums[mid] == target)
                return mid;
            if(nums[mid] >= nums[l]){
                if(nums[l] <= target && target < nums[mid])
                    r = mid - 1;
                else
                    l = mid + 1;
            }
            else {
                if(nums[mid] < target && target <= nums[r])
                    l = mid + 1;
                else
                    r = mid - 1;
            }
        }

        return -1;
    }

    /** 
    dry run
            l   m     r
    nums = [3,4,5,6,1,2] target = 1
    mid = 5 / 2 = 2
    nums[2] == 5
    5 == 1
    5 > 2 &&
                m
    nums = [6,1,2,3,4,5], target = 6
    mid = 5 / 2 = 2
    2 != 1
    2 > 5 X
    2 < 5 && 2 < 6
                      m
    nums = [4,5,6,7,0,1,2] target = 0

    mid = 6 / 2 = 3
    7 != 0
    7 > 2 && 7 > 0
    l = 4;

    mid = 7 + 4 = 11 / 2 = 5
    1 != 0
    1 < 2 && 1 > 0 

    nums=[3,5,1] target = 3

    mid = 1
    5 != 3
    5 > 1 && 5 > 3
    */
}
