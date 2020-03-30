package Array_BFS.P752_Open_the_Lock;
import java.util.*;

public class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> deadSet = new HashSet<>();
        deadSet.addAll(Arrays.asList(deadends));

        Set<String> startSet = new HashSet<>();
        Set<String> tailSet = new HashSet<>();

        if (deadSet.add("0000"))
            startSet.add("0000");
        if (deadSet.add(target))
            tailSet.add(target);

        int step = 0;
        while(!startSet.isEmpty() && !tailSet.isEmpty()) {
            Set<String> temp = new HashSet<>();
            for(String cur_password : startSet) {
                char[] cur_password_chars = cur_password.toCharArray();
                for(int i = 0; i < 4; i++) {
                    char previous = cur_password_chars[i];
                    cur_password_chars[i] = (char)((previous - '0' + 1)%10 + '0');
                    String new_password = new String(cur_password_chars);

                    if (tailSet.contains(new_password))
                        return step + 1;
                    if (deadSet.add(new_password))
                        temp.add(new_password);

                    cur_password_chars[i] = (char)((previous - '0' + 9)%10 + '0');
                    new_password = new String(cur_password_chars);
                    if (tailSet.contains(new_password))
                        return step + 1;
                    if (deadSet.add(new_password))
                        temp.add(new_password);

                    cur_password_chars[i] = previous;
                }
            }
            startSet = tailSet;
            tailSet = temp;
            step++;
        }
        return -1;
    }
}
