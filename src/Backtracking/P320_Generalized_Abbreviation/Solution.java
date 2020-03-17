package Backtracking.P320_Generalized_Abbreviation;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<String> generateAbbreviations(String word){
		List<String> res = new ArrayList<>();
		dfs(res, word, 0, "", 0);
		
		return res;
	}
	
	private void dfs(List<String> res, String word, int position, String cur, int count) {
		if (position == word.length()) {
			if (count > 0) cur += count;
			res.add(cur);
		} else {
			dfs(res, word, position + 1, cur, count + 1);
			dfs(res, word, position + 1, cur + (count > 0 ? count : "") + word.charAt(position), 0);
		}
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.generateAbbreviations("word"));
	}
	
	
}
