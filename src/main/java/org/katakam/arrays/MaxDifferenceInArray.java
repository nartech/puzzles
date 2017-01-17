/*

The maximum difference between elements in some array, a, is defined as the largest difference between any a[i] and a[j]
where i < j and a[i] < a[j]. For example, if a = [4, 1, 2, 3], the maximum difference would be a[3] − a[1] = 3 − 1 = 2
because this is the largest difference between any two elements satisfying the aforementioned criteria.



Complete the maxDifference function in the editor below. It has 1 parameter: an array of integers, a. It must return
an integer denoting the maximum difference between any pair of elements in a; if no such number exists (e.g., if a is
in descending order and all a[j] < a[i]), return −1 instead.



Input Format

Locked stub code in the editor reads the following input from stdin and passes it to the function:

The first line contains a single integer, n, denoting the number of elements in array a.

Each line i of the n subsequent lines (where 0 ≤ i < n) contains a single integer describing element a[i].



Constraints

    1 ≤ n ≤ 106
    −106 ≤ a[i] ≤ 106 ∀ i ∈ [0, n − 1]



Output Format

The function must return an integer denoting the maximum difference in a. This is printed to stdout by locked
stub code in the editor.



Sample Input 0

7
2
3
10
2
4
8
1



Sample Output 0

8



Explanation 0

n = 7, a = [2, 3, 10, 2, 4, 8, 1]

As a[2] = 10 is largest element in the array, we must find the smallest a[i] where 0 ≤ i < 2. This ends up being 2 at index i = 0.

We then calculate the difference between the two elements: a[2] − a[0] = 10 − 2 = 8, and return the result (8).



Note: While the largest difference between any two numbers in this array is 9 (between a[2] = 10 and a[6] = 1),
this cannot be the maximum difference because the element having the smaller value (a[6]) must be of a lesser index
than the element having the higher value (a[2]). As j = 2 is not less than i = 6, these elements cannot be used to
calculate the maximum difference.



Sample Input 1

6
7
9
5
6
3
2



Sample Output 1

2



Explanation 1

n = 6, a = [7, 9, 5, 6, 3, 2]

The maximum difference returned by the function is a[1] − a[0] = 9 − 7 = 2, because 2 is the largest difference
between any a[i] and a[j] satisfying the conditions that a[i] < a[j] and i < j.


Solution:
    Find the max element in one pass and use it to compute the max diff till the previous index position.
    Time complexity: O(n)


 */
package org.katakam.arrays;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MaxDifferenceInArray {

    /*
 * Complete the function below.
 */

    //brute force O(n^2)
    static int maxDifference1(int[] a) {

        int maxDiff = -1;

        for (int i=0;i<a.length-1;i++){
            for (int j=i;j<a.length;j++){
                if (i<j && (a[j]-a[i] > maxDiff)){
                    maxDiff = a[j]-a[i];
                }

            }

        }
        return maxDiff;
    }

    static int maxDifference(int[] arr){
        int max_elem = arr[0];
        int max_elem_index = 1;
        for (int i=1; i<arr.length; i++) {
            if (arr[i]>max_elem){
                max_elem = arr[i];
                max_elem_index = i;
            }
        }

        int max_diff  = -1;
        for (int i=0;i<max_elem_index;i++) {

            int temp_diff = max_elem - arr[i];
            if (temp_diff > max_diff){
                max_diff = temp_diff;
            }

        }

        return max_diff;
    }

    public static void main(String[] args) throws IOException{
/*
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        int res;

        int _a_size = 0;
        _a_size = Integer.parseInt(in.nextLine());
        int[] _a = new int[_a_size];
        int _a_item;
        for(int _a_i = 0; _a_i < _a_size; _a_i++) {
            _a_item = Integer.parseInt(in.nextLine());
            _a[_a_i] = _a_item;
        }

        res = maxDifference(_a);
        bw.write(String.valueOf(res));
        bw.newLine();

        bw.close();
*/


        int[] samp1 = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("Maximum Difference matching the cirteria SubArray "+ maxDifference(samp1));
    }
}

