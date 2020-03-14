package Array_BFS.P1345_Jump_Game_IV;
import java.util.*;

public class Solution {
    public int minJumps(int[] A) {
        int n = A.length;
        if (n == 1) return 0;

        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            map.putIfAbsent(A[i], new ArrayList<>());
            map.get(A[i]).add(i);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        int res = 0;

        while(!queue.isEmpty()) {
            res++;
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int cur_position = queue.poll();
                if (cur_position + 1 < n && map.containsKey(A[cur_position + 1])) {
                    if (cur_position + 1 == n - 1) return res;
                    queue.offer(cur_position + 1);
                }
                if (cur_position - 1 >= 0 && map.containsKey(A[cur_position - 1])) {
                    queue.offer(cur_position - 1);
                }

                if (map.containsKey(A[cur_position])) {
                    for(int next_reachable_pos : map.get(A[cur_position])) {
                        if (next_reachable_pos != cur_position) {
                            if (next_reachable_pos == n - 1) return res;
                            queue.offer(next_reachable_pos);
                        }
                    }
                    map.remove(A[cur_position]);
                }
            }
        }
        return res;
    }
}
