/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        // Start typing your Java solution below
        if (root == null) {
            return;
        }
        
        TreeLinkNode runner = root;
        while (runner != null) {
            runner = myConnect(runner);
        }
    }
    
    public TreeLinkNode myConnect(TreeLinkNode root) {
        if (root == null) {
            return null;
        }
                
        TreeLinkNode nextNode = null;
        TreeLinkNode leftmost;
        
        if (root.left != null) {
            leftmost = root.left;
            if (root.right != null) {
                root.left.next = root.right;
                root.right.next = myConnect(root.next);
            } else {
                root.left.next = myConnect(root.next);
            }
        } else {
            if (root.right != null) {
                leftmost = root.right;
                root.right.next = myConnect(root.next);
            } else {
                return myConnect(root.next);
            }
        }
                
        return leftmost;
    }
}