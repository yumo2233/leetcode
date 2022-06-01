/**
 * @author Pzr
 * @create 2022/6/1 - 20:56
 */

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        if(root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList(); //队列是抽象的，不能初始化
        queue.add(root);

        while(queue.size() > 0){
            List<Integer> list = new ArrayList();
            int size = queue.size();
            for(int i = 0;i < size;i++){
                //为什么要又定义一个size？因为下面添加到队列的时候队列长度会变化
                // System.out.println(queue.size());
                TreeNode temp = queue.poll();
                // System.out.println(temp.val + i);
                list.add(temp.val);
                if(temp.left != null){
                    queue.add(temp.left);
                }
                if(temp.right != null){
                    queue.add(temp.right);
                }
            }
            result.add(list);
            //   System.out.println(list);
        }
        return result;



    }
}
