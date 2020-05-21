package Tree;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 树的遍历
 *
 * 前序 preOrder
 * 中序 inOrder
 * 后续 postOrder
 *
 * pre：root - left - right
 * in: left - root - right
 * post: left - right - root
 *
 */
public class TreeTraverse {



    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        int[] arr = new int[]{6,5,4,1,2,3};
        for (int i = 0; i < arr.length; i++) {
           tree.add(arr[i]);
        }
        System.out.println("tree finished ");
        TreeTraverse instance = new TreeTraverse();
        instance.inorderTraversal_Stack(tree.root);

    }

    /**
     * 复制一个二叉树
     * 算法
     * @param root
     * @param result
     */


    //前序
    private void pre_recur(TreeNode root , List<String> result){
        if (root != null){
           result.add(root.val.toString());
           if (root.left != null) {
               pre_recur(root.left,result);
           }
           if (root.right != null){
               pre_recur(root.right,result);
           }
        }
    }
    //中序
    private void in_recur(TreeNode root , List<String> result){
        if (root != null){
            if (root.left != null){
                in_recur(root.left,result);
            }
            result.add(root.val.toString());
            if (root.right != null){
                in_recur(root.right,result);
            }
        }
    }
    //后序
    private void post_recur(TreeNode root , List<String> result){
        if (root != null ){
            if (root.left != null){
                post_recur(root.left,result);
            }
            if (root.right != null){
                post_recur(root.right,result);
            }
            result.add(root.val.toString());
        }
    }
    /**
    前序遍历--------------------------------------------
     */
    /*

     */
    public List<Integer> pre_Traverse_recur(TreeNode treeNode){
        return null;
    }
    public List<Integer> pre_Traverse(TreeNode treeNode){
        return null;
    }
    public List<Integer> in_Traverse(TreeNode treeNode){
        return null;
    }
    public List<Integer> post_Traverse(TreeNode treeNode){
        return null;
    }

    /**
     方法2：维护栈，存储当前node
     思路：left - root - right
     node val压入栈，然后按照顺序对比，如果不符则pop
     */
    public List< String > inorderTraversal_Stack(TreeNode root) {
        List<String> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        //stack不为null 且当前节点不为null
        while (current != null || !stack.isEmpty()) {
            //压入栈node
            while (current != null) {
                stack.push(current);
                System.out.println("cur:val"+current.val);
                current = current.left;
            }
            //左边遍历完，开始右边
            System.out.println("--------");
            current = stack.pop();
            result.add(current.val.toString());
            System.out.println("---recur right---");
            System.out.println("cur:val"+current.val);
            current = current.right;
        }
        return result;
    }
}
