// I need to eat a number x of bananas splited in n piles, right?
// I can eat k bananas from a pile each hour, I don't need to finish 
// the whole pile to go to another, but I can't each two piles at same hour
// The trick part is the size of each pile, but I can't figure out yet
// how my solution will be build arround the banana pile size
// If I order my array and check based for each pile size, with I can finish it
// within h hours, I will subtract from the hours multiplying the pile size per
// my k, in that case the k will start with pile[i] value. After passing through
// my whole array I will check with my hours are negative, if so, this mean that
// I haven't enough hours to finish all piles. Then I go to next index.

// Okay, here my pseudo code
// First of wall I will define my k, low and high as 1
// Then iterate through my array looking for the bigger
// pile to set as my high value
// while my low less or equal high, I gonna calculate my mid
// that is the average k value, i.e (left + right) / 2
// next I will declare spentHours and iterate through my 
// array calculating the hours required to finish each pile in my mid rate
// then I'll check I spent less or equal hours compared to
// my available hours, if so I set my minimum k as the current mid
// and set my right as mid - 1
// otherwise I set my left as mid + 1
// When my loop finishes I return my mininumK

// Obs.: My spentHours needs to be long, because pile constraints
// are 10^4 to length and 10^9 to pile size
// so in worst case we can spent 10^13 hours, that doesn't fit java integer
// No need to convert h to long during the comparison, Java already do that

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int minimumK = 1;
        int low = 1;
        int high = 1;

        for(int i = 0; i < piles.length; i++) {
            if(piles[i] > high)
                high = piles[i];
        }

        while(low <= high) {
            int mid = (low + high) / 2;
            long spentHours = 0;

            for(int j = 0; j < piles.length; j++) {
                spentHours += piles[j] / mid;
                
                if(piles[j] % mid > 0)
                    spentHours++;
            }

            if(spentHours <= h) {
                minimumK = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return minimumK;
    }
}
