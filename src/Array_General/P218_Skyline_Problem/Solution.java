package Array_General.P218_Skyline_Problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class Solution {
	public static class BuildingPoint implements Comparable<BuildingPoint> {
		int x;
		boolean isStart;
		int height;

		@Override
		public int compareTo(BuildingPoint pt) {
			if (this.x != pt.x) {
				return this.x - pt.x;
			} else {
				return (this.isStart ? -this.height : this.height) - (pt.isStart ? -pt.height : pt.height);
			}
		}
	}

	public List<List<Integer>> getSkyline(int[][] buildings) {
		BuildingPoint[] buildingPoints = new BuildingPoint[buildings.length * 2];
		int index = 0;
		for (int[] building : buildings) {
			buildingPoints[index] = new BuildingPoint();
			buildingPoints[index].x = building[0];
			buildingPoints[index].isStart = true;
			buildingPoints[index].height = building[2];

			buildingPoints[index + 1] = new BuildingPoint();
			buildingPoints[index + 1].x = building[1];
			buildingPoints[index + 1].isStart = false;
			buildingPoints[index + 1].height = building[2];
			index += 2;
		}

		Arrays.sort(buildingPoints);

		TreeMap<Integer, Integer> queue = new TreeMap<>();
		queue.put(0, 1);
		int prevMaxHeight = 0;

		List<List<Integer>> res = new ArrayList<>();

		for (BuildingPoint buildingPoint : buildingPoints) {
			if (buildingPoint.isStart) {
				queue.compute(buildingPoint.height, (key, value) -> {
					if (value != null)
						return value + 1;
					return 1;
				});
			} else {
				queue.compute(buildingPoint.height, (key, value) -> {
					if (value == 1)
						return null;
					return value - 1;
				});
			}

			int curMaxHeight = queue.lastKey();

			if (prevMaxHeight != curMaxHeight) {
				res.add(Arrays.asList(buildingPoint.x, curMaxHeight));
				prevMaxHeight = curMaxHeight;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[][] input = {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
		Solution solution = new Solution();
		System.out.println(solution.getSkyline(input));
	}
}
