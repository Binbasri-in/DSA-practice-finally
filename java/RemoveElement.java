package java;
/*
* Remove Element
* Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.
* Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:
* Change the array nums such that the first k elements of nums contain the elements which are not equal to val. The remaining elements of nums are not important as well as the size of nums.
* Return k.
*
* Example 1:
* ----------
* Input: nums = [3,2,2,3], val = 3
* Output: 2, nums = [2,2,_,_]
* Explanation: Your function should return k = 2, with the first two elements of nums being 2.
* It does not matter what you leave beyond the returned k (hence they are underscores).
*
* Example 2:
* ----------
* Input: nums = [0,1,2,2,3,0,4,2], val = 2
* Output: 5, nums = [0,1,4,0,3,_,_,_]
*/

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int count = 0;  // Number of elements not equal to val
        int l = nums.length;
        int s = l - 1;  // End index
        int i = 0;      // Start index

        while (i <= s) {
            if (nums[i] == val) {
                // Find a non-val element from the end
                while (i < s && nums[s] == val) {
                    s--;
                }
                if (i == s && nums[i] == val) {
                    // All remaining elements are val
                    break;
                }   
                // Swap the val element with a non-val element from the end
                nums[i] = nums[s];
                s--;
            }   
            i++;
            count++;
        }
        return count;  // Return count of elements not equal to val
    }
}
