package Binary_Search;
import java.util.*;
/*

Design a time-based key-value data structure that can store multiple values for the same key at different time stamps and retrieve the key's value at a certain timestamp.
Implement the TimeMap class:
TimeMap() Initializes the object of the data structure.
void set(String key, String value, int timestamp) Stores the key key with the value value at the given time timestamp.
String get(String key, int timestamp) Returns a value such that set was called previously, with timestamp_prev <= timestamp. If there are multiple such values, it returns the value associated with the largest timestamp_prev. If there are no values, it returns "".
Example 1:
Input
["TimeMap", "set", "get", "get", "set", "get", "get"]
[[], ["foo", "bar", 1], ["foo", 1], ["foo", 3], ["foo", "bar2", 4], ["foo", 4], ["foo", 5]]
Output
[null, null, "bar", "bar", null, "bar2", "bar2"]
Explanation
TimeMap timeMap = new TimeMap();
timeMap.set("foo", "bar", 1);  // store the key "foo" and value "bar" along with timestamp = 1.
timeMap.get("foo", 1);         // return "bar"
timeMap.get("foo", 3);         // return "bar", since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 is "bar".
timeMap.set("foo", "bar2", 4); // store the key "foo" and value "bar2" along with timestamp = 4.
timeMap.get("foo", 4);         // return "bar2"
timeMap.get("foo", 5);         // return "bar2"

All the timestamps timestamp of set are strictly increasing.
 */
public class TimeBasedKey_ValueStore {
    /*
     Here we create a class Pair that contains String value and its timestamp
     we create a hashmap ie contains string as key and a list of pairs as value
     In set method we add key and current pair to the list
     In get method if key is not present return an empty string
        Otherwise find the value for given timestamp using binary search.Here if timestamp is not found then we can take recent lower value to given timestamp if both options are unavailable return empty string
     */
    private class Pair{
        private String val;
        private int timeStamp;

        public Pair(String val,int timeStamp){
            this.val=val;
            this.timeStamp=timeStamp;
        }
    }
    private Map<String,List<Pair>> timeMap;

    public TimeBasedKey_ValueStore() {
        this.timeMap=new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if(!timeMap.containsKey(key)){
            timeMap.put(key,new ArrayList<>());
        }
        timeMap.get(key).add(new Pair(value,timestamp));
    }

    public String get(String key, int timestamp) {
        if(!timeMap.containsKey(key)){
            return "";
        }
        Pair res=binarySearch(timeMap.get(key),timestamp);
        return res==null?"":res.val;
    }

    private Pair binarySearch(List<Pair> pairs,int timeStamp){
        if(pairs.isEmpty()){
            return null;
        }
        Pair res=null;
        int left=0,right=pairs.size()-1;
        while(left<=right){
            int mid=(left+right)>>1;//>>1 is a bitwise operator that divides sum by 2 it is faster for positive integer
            Pair current=pairs.get(mid);
            if(current.timeStamp==timeStamp){
                return current;
            }else if(current.timeStamp>timeStamp){
                right=mid-1;
            }else{
                res=current;
                left=mid+1;
            }
        }
        return res;
    }
}
