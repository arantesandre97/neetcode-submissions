// as the timestamps gonna be ordered, I supose that I binary search approach will be a good choice
// specially when there's a lot of timestamps set to the same key
// if there're multiple values I will verify if I can find my target timestamp, otherwise find the
// largest one which is shorter than my target, right?
// About the structure to handle this I was thinking about use a HashMap with a Array List to store
// the sequential timestamp values, what you think?
// So when I value is set, I check if is present than add the new timestamp to my list. Because I
// will need I dynamic array the as I'm adding new values. back to the get point, I will need to
// adapt the classic binary search approach to keeping tracking the largest value where largest <
// target.

/*
data structure for tracking moods
Map<String,List<String>> moods
Map<String, List<Integer>> timestamps;

set logic
getOrDefault(key) the default value will be a empty list
list.add(value)
timestamps.add(timestamp)
set(key, list)

get logic
intialize my left as 0 and right as length - 1
and the best candidate as -1
while left <= right do
calculate mid dividing the sum of left and right by 2
check mid value is equal or less to my target
set as the best and move on to the right side
otherwise move to left side
return best

if best is -1 return "", otherwise return moods.list(best)
*/

class TimeMap {
    Map<String, List<String>> moods; 
    Map<String, List<Integer>> timestamps;

    public TimeMap() {
        moods = new HashMap<>();
        timestamps = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        List<String> personMoods = moods.getOrDefault(key, new ArrayList<>());
        List<Integer> moodsTimestamps = timestamps.getOrDefault(key, new ArrayList<>());

        personMoods.add(value);
        moodsTimestamps.add(timestamp);

        moods.put(key, personMoods);
        timestamps.put(key, moodsTimestamps);
    }

    public String get(String key, int timestamp) {
        if(!moods.containsKey(key) || moods.get(key).isEmpty())
            return "";

        List<Integer> moodsTimstamps = timestamps.get(key);
        int left = 0;
        int right = moodsTimstamps.size() - 1;
        int best = -1;
        
        while(left <= right) {
            int mid = (left + right) / 2;

            if(moodsTimstamps.get(mid) <= timestamp) {
                best = mid;
                left = mid + 1;
            } else
                right = mid - 1;
        }

        if(best == -1)
            return "";
        
        return moods.get(key).get(best);
    }
}
