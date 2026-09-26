// [1, 2, 3, 3] k = 3, which means every time I add a number I must return my third largest integer, right?
// [1, 2, 3, 3, 3] 3
// [1, 2, 3, 3, 3, 5] 3
// [1, 2, 3, 3, 3, 5, 6] 3
// [1, 2, 3, 3, 3, 5, 6, 7] 5
// [1, 2, 3, 3, 3, 5, 6, 7, 8] 6
// So every time I add a number I need to update my top k largest numbers
// I need to maintain the exactly top k numbers, so I can return my last or first position depending on the sort order, right?
// is k equal to nums.length?
// what's the numbers within array and to be added interval?

// I gonna use a min heap to maintain my top k elements, everytime I add a element and my heap exceed k, I'll be able to remove the top element which means my candidate with last chance to be in my top k
class KthLargest {
    PriorityQueue<Integer> topK = new PriorityQueue<Integer>();
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;

        for(int n: nums) {
            topK.offer(n);
        }

        while(topK.size() > k){
            topK.poll();
        }
    }
    
    public int add(int val) {
        topK.offer(val);

        while(topK.size() > k){
            topK.poll();
        }

        return topK.peek();
    }
}
