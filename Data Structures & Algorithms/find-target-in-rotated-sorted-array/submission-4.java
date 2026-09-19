// it's a classic binary search problem
// and I gonna tell you why
// the fact of the array was rotated doesn't affect
// the efficiency of the binary search alg
// In that case I know that my array is still
// ordered, but I need to check based on my right
// element which side the numbers are asceding to
// with that comparison I can decide which branch
// may I discard
// of course if my middle element is different from my target
// it also makes sense to you?

/*
nums = [3,4,5,6,1,2] target = 6
mid = 5
so my left side is ordered, which means (3,4,5)
but my mid is smaller than my target
what am I supposed to do in that situation?
I know that my left side is in the ascending ordered, so in that case I can discard my left side
setting it as left = mid + 1, right?

if my target was maybe 3, I discard my right side
setting right as mid - 1

In the reverse situation, I just invert my loggic
I mean if my right side is ordered and my target is
bigger than mid, I pick my left. right = mid - 1
if is smaller I pick right side. left = mid + 1

that's it?

nums = [3,4,5,6,1,2] target = 1 (edge case for the proposal solution above)

mid = 5
3 < 5
left side is ordered
1 > 5 && 1 > 3 no
1 > 5 && 1 < 3 no
1 < 5 && 1 < 3 yes (that means that 1 isn't between the left interval) so I need to pick the right side

lets try the first target 6
6 > 5 && 6 > 3 yes (that means that 6 isn't between the left interval too) again pick right side

lets try to pick 4
4 > 5 && 4 > 3 no
4 > 5 && 4 < 3 no
4 < 5 && 4 < 3 no
4 < 5 && 4 > 3 yes (that menas that 4 is within left interval) I may pick left side

I'm think about what this logic actually means to me, how can I simplify it

And once you have both conditions, what does your overall decision tree look like? Try writing the full pseudocode now:

Determine which half is sorted (using nums[left] vs nums[mid])
Depending on which half is sorted, check if target falls within that sorted range
Move left/right accordingly

[3,4,5,6,1,2]

if nums[mid] == target
    return mid
if nums[mid] > nums[left]
    if(nums[left] <= target < nums[mid])
        right = mid - 1
    else
        left = mid + 1
else
    if(nums[right] >= target > nums[mid])
        left = mid + 1
    else
        right = mid - 1
*/


/*
int left = 0;
int right = length - 1;

while left smaller or equal to rigth do
calculate mid dividing left and right sum by 2
check if middle value is the target and return
otherwise check the array right ordered side

if middle value is greater than left my left side is ordered
check if my target is between left and mid then pick the left branch
otherwise pick the right branch

else (my right side is ordered) check if my target is between mid 
and right then pick right branch
otherwise pick the left one

loops condition ends
return -1
*/

class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {
            int mid = (left + right) / 2;

            if(nums[mid] == target)
                return mid;
            
            if(nums[mid] >= nums[left]){
                if(nums[left] <= target && target < nums[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            }
            else {
                if(nums[mid] < target && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }

        return -1;
    }
}
