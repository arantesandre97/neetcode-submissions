class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numsSet = new HashSet<>(nums.length);

        for(int num: nums) {
            numsSet.add(num);
        }
        int longestSequence = 0;
        for(Integer num: numsSet) {
            int count = 0;
            if(!numsSet.contains(num - 1)) {
                count += 1;
                int sequenceNumber = num+1;
                while(numsSet.contains(sequenceNumber)) {
                    sequenceNumber += 1;
                    count += 1;
                }
            }

            if(count > longestSequence) {
                longestSequence = count;
            }
        }

        return longestSequence;
    }
}
