import java.util.*;

public class MergeIntervals {  

    public static void main(String[] args) {

        int[][] intervals = {
            {1,3}, {2,6}, {8,10}, {15,18}
        };

        Solution sol = new Solution();
        int[][] result = sol.merge(intervals);

        // Print result
        for (int[] interval : result) {
            System.out.println(Arrays.toString(interval));
        }
    }
}

class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();

        int[] current = intervals[0];
        result.add(current);

        for (int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];

            if (next[0] <= current[1]) {
                current[1] = Math.max(current[1], next[1]);
            } else {
                current = next;
                result.add(current);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}