package java;
/*
* Length of Last Word
* Given a string s consists of some words separated by spaces, return the length of the last word in the string. If the last word does not exist, return 0.
* A word is a maximal substring consisting of non-space characters only.
*
* Example 1:
* ----------
* Input: s = "Hello World"
* Output: 5
*/

public class LastWordCount {
    public int lengthOfLastWord(String s) {
        int k = s.length()-1;
        int count = 0;
        while(s.charAt(k) == ' ') {
            k--;
        }
        while(true) {
            if (k < 0) break;
            if (s.charAt(k) == ' ') {
                break;
            }
            count++;
            k--;
        }

        return count;
    }
}