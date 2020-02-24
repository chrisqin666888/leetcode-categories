package Graph_BFS.P1136_Parallel_Courses;
import java.util.*;

public class Solution {
    public int minimumSemesters(int N, int[][] relations) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[N + 1];
        for(int[] relation : relations) {
            graph.putIfAbsent(relation[0], new ArrayList<>());
            graph.get(relation[0]).add(relation[1]);
            indegree[relation[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }

        int semester = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int cur_course = queue.poll();
                N--;

                if (!graph.containsKey(cur_course)) continue;
                List<Integer> subcourses = graph.get(cur_course);
                if (subcourses != null) {
                    for (int course : subcourses) {
                        if (--indegree[course] == 0) queue.offer(course);
                    }
                }
            }
            ++semester;
        }
        return N == 0 ? semester : -1;
    }
}

















