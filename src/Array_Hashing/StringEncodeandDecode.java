package Array_Hashing;

import java.util.*;
/*
Design an algorithm to encode a list of strings to a single string. The encoded string is then decoded back to the original list of strings.
Please implement encode and decode
Example 1:
Input: ["neet","code","love","you"]
Output:["neet","code","love","you"]
Example 2:
Input: ["we","say",":","yes"]
Output: ["we","say",":","yes"]
 */

/*
Encode add length of the String an # at beginning of the string.Repeat it for all string
Decoding of the string use two pointers i and j.
Here i will keep track of starting of string and j loops through till it encounters # and finds the length of the string.
Then change i j+1+length.
Get the string from j to i.
 */
public class StringEncodeandDecode {
    public String encode(List<String> strs) {
        StringBuilder strbuild=new StringBuilder();
        for(String str:strs){
            strbuild.append(str.length()).append("#").append(str);
        }
        return strbuild.toString();
    }
    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') j++;

            int length = Integer.valueOf(str.substring(i, j));
            i = j + 1 + length;
            list.add(str.substring(j + 1, i));
        }
        return list;
    }
}
