package Array_Hashing;

import java.util.*;

/*
Given an array of strings strs, group the anagrams together. You can return the answer in any order.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
Example 1:
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Example 2:
Input: strs = [""]
Output: [[""]]
Example 3:
Input: strs = ["a"]
Output: [["a"]]
 */
public class GroupAnagrams {
    /*
    Here we use a hashmap which stores a string value and a ArrayList of strings.
    We go through each word in array and sort them lexicographically.
    Check if word is in hash or not.
    If not add that sorted word to graph with a new array list.
    then add the original word to the list.
    create new arraylist which stores other array list go through the keys of hash.
    Get the array list and add to answer array list
    Time:O(N LogN)
    Space:O(N)
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> hash=new HashMap<>();
        for(String str:strs){
            char[] c=str.toCharArray();
            Arrays.sort(c);
            String sortedString=new String(c);
            if(!hash.containsKey(sortedString)){
                hash.put(sortedString,new ArrayList<String>());
            }
            hash.get(sortedString).add(str);
        }
        List<List<String>> ans = new ArrayList<>(hash.values());
        return ans;
    }
}
