package Segment_Tree.P307_Range_Sum_Query_Mutable;

public class Solution {
    class SegmentTreeNode {
        int start;
        int end;
        int val;
        SegmentTreeNode left;
        SegmentTreeNode right;

        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.val = 0;
        }
    }

    class NumArray {

        private SegmentTreeNode root;

        public NumArray(int[] nums) {
            this.root = buildTree(nums, 0, nums.length - 1);
        }

        private SegmentTreeNode buildTree(int[] nums, int start, int end) {
            if (start > end) return null;
            SegmentTreeNode node = new SegmentTreeNode(start, end);
            if (start == end){
                node.val = nums[start];
            } else {
                int mid = start + (end - start) / 2;
                node.left = buildTree(nums, start, mid);
                node.right = buildTree(nums, mid + 1, end);
                node.val = node.left.val + node.right.val;
            }
            return node;
        }

        public void update(int i, int val) {
            update(this.root, i, val);
        }

        private void update(SegmentTreeNode root, int i, int val) {
            if (root.start == root.end) {
                root.val = val;
                return;
            }

            int mid = root.start + (root.end - root.start) / 2;
            if (i <= mid) {
                update(root.left, i, val);
            } else {
                update(root.right, i, val);
            }
            root.val = root.left.val + root.right.val;
        }

        public int sumRange(int i, int j) {
            return sumRange(this.root, i, j);
        }

        private int sumRange(SegmentTreeNode root, int start, int end) {
            if (root.end == end && root.start == start) return root.val;

            int mid = (root.start) + (root.end - root.start) / 2;
            if (end <= mid) {
                return sumRange(root.left, start, end);
            } else if (start >= mid + 1) {
                return sumRange(root.right, start, end);
            } else {
                return sumRange(root.right, mid + 1, end) + sumRange(root.left, start, mid);
            }
        }
    }
}
