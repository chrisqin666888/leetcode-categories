package Graph_DFS.P582_Kill_Process;
import java.util.*;

public class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        if (kill == 0) return pid;
        int n = pid.size();

        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for(int i = 0; i < n; i++) {
            if (!graph.containsKey(ppid.get(i))) {
                graph.put(ppid.get(i), new HashSet<>());
            }
            graph.get(ppid.get(i)).add(pid.get(i));
        }

        List<Integer> res = new ArrayList<>();
        dfs(graph, res, kill);

        return res;
    }

    private void dfs(Map<Integer, Set<Integer>> graph, List<Integer> res, int pid) {
        res.add(pid);
        if (!graph.containsKey(pid)) return;

        for(Integer child: graph.get(pid)) {
            dfs(graph, res, child);
        }
    }
}
