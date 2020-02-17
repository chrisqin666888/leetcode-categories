package Tree_DFS.P690_Employee_Importance;

import java.util.*;

// problem link
// https://leetcode.com/problems/employee-importance/

class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
}

public class Solution {
    Map<Integer, Employee> tree = new HashMap<>();
    public int getImportance(List<Employee> employees, int id) {
        for(Employee e : employees) tree.put(e.id, e);
        return dfs(id);
    }

    private int dfs(int id) {
        Employee employee = tree.get(id);
        int ans = employee.importance;
        for(Integer subid: employee.subordinates) ans += dfs(subid);
        return ans;
    }
}
