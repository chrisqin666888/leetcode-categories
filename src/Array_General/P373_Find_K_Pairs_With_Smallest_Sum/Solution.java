package Array_General.P373_Find_K_Pairs_With_Smallest_Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
	public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] + a[1] - b[0] - b[1]);
		List<List<Integer>> res = new ArrayList<>();

		if (nums1.length == 0 || nums2.length == 0 || k == 0)
			return res;

		for (int i = 0; i < nums1.length && i < k; i++)
			heap.offer(new int[] { nums1[i], nums2[0], 0 });
		
		while(k-- > 0 && !heap.isEmpty()) {
			int[] cur = heap.poll();
			res.add(Arrays.asList(cur[0], cur[1]));
			if (cur[2] == nums2.length - 1) continue;
			heap.offer(new int[]{cur[0], nums2[cur[2] + 1], cur[2] + 1});
		}
		return res;
	}
}
