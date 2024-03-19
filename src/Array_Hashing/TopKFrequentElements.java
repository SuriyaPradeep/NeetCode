package Array_Hashing;

import java.util.*;

/*
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
Example 1:
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:
Input: nums = [1], k = 1
Output: [1]
 */
public class TopKFrequentElements {
    /*
    Top K Frequent Elements using Priority queue.
    Create a frequency table using hashmap.
    Now create a maximum priority queue using values of hashtable(frequency).
    now get the elements from the queue for k times.
    Add it to an array and return it.
    Even though it is a nice way to tackle the problem.It takes O(N LogN).
    Time:O(N LogN)
     */
    public int[] topKFrequentPQ(int[] nums, int k) {
        HashMap<Integer,Integer>hash=new HashMap<>();
        for(int num:nums){
            hash.put(num,hash.getOrDefault(num,0)+1);
        }
        PriorityQueue<HashMap.Entry<Integer,Integer>> pq=new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
        for(HashMap.Entry<Integer,Integer> freq: hash.entrySet()){
            pq.add(freq);
        }
        int[] res=new int[k];
        for(int i=0;i<k;i++){
            res[i]=pq.poll().getKey().intValue();//converts Integer value to its primitive int key
        }
        return res;
    }
    /*
    More optimized version compared to previous one.
    Here we will not use an pq instead we use an array which will be used to keep track of frequency.
    Create a frequency table like in above.
    Create a List of bucket of length nums+1
    use index as frequency from hashtable
    create a list for given frequency and add the keys.
    iterate through bucket from last and store elements in an array.
     */
    public int[] topKFrequentArray(int[] nums, int k) {
        HashMap<Integer,Integer>hash=new HashMap<>();
        for(int num:nums){
            hash.put(num,hash.getOrDefault(num,0)+1);
        }
        List<Integer>[] bucket=new List[nums.length+1];
        for(int key:hash.keySet()){
            int freq=hash.get(key);
            if(bucket[freq]==null){
                bucket[freq]=new ArrayList<>();
            }
            bucket[freq].add(key);
        }
        int[] res=new int[k];
        int count=0;
        for(int i=bucket.length-1;i>0 && k>count;i++){
            if(bucket[i]!=null){
                for(Integer integer:bucket[i]) {
                    res[count++]=integer;
                }
            }
        }
        return res;
    }
}
