/*
 In computer science, the maximum subarray problem is the task of finding the contiguous subarray
 within a one-dimensional array of numbers which has the largest sum.
 For example, for the sequence of values −2, 1, −3, 4, −1, 2, 1, −5, 4;
 the contiguous subarray with the largest sum is 4, −1, 2, 1, with sum 6.

 Solution: https://en.wikipedia.org/wiki/Maximum_subarray_problem

 As per Kadane's algorithm

  def max_subarray(A):
     max_ending_here = max_so_far = a[0]
     for x in A:
     max_ending_here = max(x, max_ending_here + x)
     max_so_far = max(max_so_far, max_ending_here)
     return max_so_far

Another version:
The algorithm keeps track of the tentative maximum subsequence in (maxSum, maxStartIndex, maxEndIndex).
It accumulates a partial sum in currentMaxSum and updates the optimal range when this partial sum becomes larger than maxSum.
Kadane's Algorithm(array[1..n])
begin
    (maxSum, maxStartIndex, maxEndIndex) := (-INFINITY, 0, 0)
    currentMaxSum := 0
    currentStartIndex := 1
    for currentEndIndex := 1 to n do
        currentMaxSum := currentMaxSum + array[currentEndIndex]
        if currentMaxSum > maxSum then
            (maxSum, maxStartIndex, maxEndIndex) := (currentMaxSum, currentStartIndex, currentEndIndex)
        endif

        if currentMaxSum < 0 then
            currentMaxSum := 0
            currentStartIndex := currentEndIndex + 1
        endif
    endfor

    return (maxSum, maxStartIndex, maxEndIndex)
end



 */
package org.katakam.arrays;

import java.util.Arrays;

public class MaxSubArray{

    static int max(int first, int second){
        if (first > second)
            return first;
        else
            return second;
    }
    static int max_subarray(int[] arr){
        int max_ending_here = arr[0];
        int max_so_far  = arr[0];
        for (int anArr : arr) {
            max_ending_here = max(max_ending_here + anArr, anArr);
            max_so_far = max(max_so_far, max_ending_here);
        }
        return max_so_far;

    }

    public static void main(String[] args) {
        int[] samp1 = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("MaxSubArray "+max_subarray(samp1));
    }
}
