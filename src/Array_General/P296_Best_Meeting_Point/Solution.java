package Array_General.P296_Best_Meeting_Point;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public int minTotalDistance(int[][] grid) {
		int m = grid.length, n = grid[0].length;

		List<Integer> I = new ArrayList<>();
		List<Integer> J = new ArrayList<>();

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					I.add(i);
				}
			}
		}
		for (int j = 0; j < n; j++) {
			for (int i = 0; i < m; i++) {
				if (grid[i][j] == 1) {
					J.add(j);
				}
			}
		}
		return minTotalDistance(I) + minTotalDistance(J);
	}

	public int minTotalDistance(List<Integer> grid) {
		int i = 0, j = grid.size() - 1, sum = 0;
		while (i < j) {
			sum += grid.get(j--) - grid.get(i++);
		}
		return sum;
	}
}