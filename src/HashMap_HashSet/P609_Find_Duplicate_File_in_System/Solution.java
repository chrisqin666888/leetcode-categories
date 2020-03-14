package HashMap_HashSet.P609_Find_Duplicate_File_in_System;
import java.util.*;

public class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();

        for(String path : paths) {
            String[] parts = path.split(" ");
            String root = parts[0];

            // from second part is the true meet
            for(int i = 1; i < parts.length; i++) {
                String file_content = parts[i];
                String content = "";
                String file_path = "";

                for(int j = 0; j < file_content.length(); j++) {
                    if (file_content.charAt(j) == '(') {
                        content = file_content.substring(j + 1, file_content.length() - 1);
                        file_path = file_content.substring(0, j);
                        break;
                    }
                }

                map.putIfAbsent(content, new ArrayList<>());
                map.get(content).add(root + "/" + file_path);
            }
        }

        List<List<String>> result = new ArrayList<>();
        for(List<String> group : map.values()) {
            if (group.size() != 1) result.add(group);
        }
        return result;
    }
}
