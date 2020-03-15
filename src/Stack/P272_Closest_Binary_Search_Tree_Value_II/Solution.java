package Stack.P272_Closest_Binary_Search_Tree_Value_II;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import _utilities.TreeNode;

public class Solution {
	public List<Integer> closestKValues(TreeNode root, double target, int k) {
	    Deque<TreeNode> bigger = new ArrayDeque<TreeNode>();
	    Deque<TreeNode> smaller = new ArrayDeque<TreeNode>();
	    TreeNode node = root;
	    // log(n)
	    while(node != null)
	    {
	        if(node.val > target)
	        {
	            bigger.push(node);
	            node = node.left;
	        }
	        else
	        {
	            smaller.push(node);
	            node = node.right;
	        }
	    }
	    
	    // k
	    List<Integer> ret = new ArrayList<Integer>();
	    while(ret.size() < k)
	    {
	        if(bigger.isEmpty() ||
	           !smaller.isEmpty() &&
	            ((bigger.peek().val - target) > (target - smaller.peek().val)))
	        {
	            node = smaller.pop();
	            ret.add(node.val);
	            
	            // Get next smaller
	            node = node.left;
	            while(node != null)
	            {
	                smaller.push(node);
	                node = node.right;
	            }
	        }
	        else
	        {
	            node = bigger.pop();
	            ret.add(node.val);
	            
	            // get next bigger
	            node = node.right;
	            while(node != null)
	            {
	                bigger.push(node);
	                node = node.left;
	            }                
	        }
	    }
	    
	    return ret;
	}
}










