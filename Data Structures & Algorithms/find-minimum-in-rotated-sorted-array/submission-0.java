// Okay I thinking about how can I check how many times my array was rotated
// Because achieving that I can infer what are my
// minimum number position based on my array length
// If the rotated time is a multiple of my array
// length this means that elements are in the original position
// Every time I rotate my array I move the last element to the beginning, right?
// That's why if I do the rotation 6 times in an array of size 6, it become the original one again
// Is there a constraint for how many times my array can be rotated?

/*
nums = [4,5,6,7]

left = 0
right = 3

mid = 1

nums[1] = 5
nums[3] = 7
5 > 7 no
5 < 7 yes
right = mid - 1;

mid = 1

nums[2] = 6
5 > 6 no
5 < 6 yes
right = mid - 1

mid = 0
nums[1] = 5

4 > 5 no
4 < 5 yes
right = mid - 1

left <= right
0 <= -1
left = 0
right = -1

which one I choose?
lets do another dry run

nums = [6,7,4,5]
left = 0
right = 3

mid = 1
nums[1] = 7
nums[3] = 5

7 > 5 yes
left = mid + 1

mid = 2
nums[2] = 4
nums[3] = 5

4 > 5 no
4 < 5 yes
right = mid - 1

left <= right
2 <= 1

left = 2
right = 1

my left indicates the right position
*/

/*
Set left as 0 and right as my array length - 1
while left is smaller then right do (in that case I want to stop when they're equal
because that indicates I find the mimimum value)
calculate mid with (left + right) / 2
check if mid is bigger than my right element
if yes I discard the I discard my left side
because it gonna have bigger elements
otherwise I keep my mid to find if is my minimum element
when my condition fail
I can return either nums[left] or nums[right] because they gonna to have the same value
*/

class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while(left < right) {
            int mid = (left + right) / 2;

            if(nums[mid] > nums[right])
                left = mid + 1;
            else
                right = mid;
        }

        return nums[left];
    }
}
