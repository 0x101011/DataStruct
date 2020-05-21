package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class TreeCreate {
    public TreeCreate() {

    }

    /**
     * 通过字符#来标识空节点
     ['A','B','D','#','#','E','#','#','F','#','#','#']
     */
    public static void main(String[] args) {
        TreeCreate instance = new TreeCreate();
        List<TreeNode> list = instance.create();
        BinaryTree binaryTree = new BinaryTree();
        int result = binaryTree.countNode2(list.get(0));
        System.out.println("result_" + result);
    }
    public static int index = 0;
    public static final int[] TREE_VALUE = new int[]{1,2,3,0,4,5,0,0,6,0,0,7,0,0,8,0,9,10,0,0,0};

    private TreeNode root = new TreeNode();
    public TreeNode getRoot(){
        return root;
    }
    public void printNode(TreeNode node){
        if ( null == node) {
            System.out.println("_");
        } else {
            System.out.println("node:" + node.val);
        }
    }
    public TreeCreate(String dataResource){
        String[] treeNodes = dataResource.split(",");
       // createBinaryTreeByRecur();
    }
    //先序创建二叉树
    private TreeNode createBinaryTreeByRecur(TreeNode node,List<String> list, int index ) {
        if ( "#".equals(list.get(index))) {
            return null;
        } else {
            node.setVal(list.get(index));
            System.out.println("set值+" + node.val);
        }

        TreeNode left = new TreeNode();
        node.left = createBinaryTreeByRecur(left,list,++index);
        TreeNode right = new TreeNode();
        node.right = createBinaryTreeByRecur(right,list,++index);
        return node;
    }

    public TreeNode createBinaryTree(List<String> list){
        if (null == list || list.isEmpty()) {
            return null;
        }
        return createBinaryTreeConstruct(list);

    }
    //先序创建二叉数
    private TreeNode createBinaryTreeConstruct(List<String> list) {
        int count = 0;
        TreeNode node = null;
        if (count < list.size()) {
            String elem = list.get(count);
            count ++;
            if (elem != null) {
                node = new TreeNode(elem);
                node.left = createBinaryTreeConstruct(list);
                node.right = createBinaryTreeConstruct(list);
            }
        }
        return node;
    }

    private TreeNode createTree(TreeNode node) {
        Scanner input = new Scanner(System.in);
        String string = input.nextLine();

        if (string.equals("#")) {
            node = null;
        } else {
            if (node == null) {
                node = new TreeNode(string);
                node.left  = createTree(node);
                node.right = createTree(node);
                return node;
            }
        }
        return node;
    }

    public void createBinTree() {
        List<TreeNode> nodeList = null;
        nodeList = new LinkedList<TreeNode>();
        // 将一个数组的值依次转换为Node节点
        for (int nodeIndex = 0; nodeIndex < TREE_VALUE.length; nodeIndex++) {
            nodeList.add(new TreeNode(TREE_VALUE[nodeIndex]));
        }
        // 对前lastParentIndex-1个父节点按照父节点与孩子节点的数字关系建立二叉树
        for (int parentIndex = 0; parentIndex < TREE_VALUE.length / 2 - 1; parentIndex++) {
            // 左孩子
            nodeList.get(parentIndex).left = nodeList
                    .get(parentIndex * 2 + 1);
            // 右孩子
            nodeList.get(parentIndex).right = nodeList
                    .get(parentIndex * 2 + 2);
        }
        // 最后一个父节点:因为最后一个父节点可能没有右孩子，所以单独拿出来处理
        int lastParentIndex = TREE_VALUE.length / 2 - 1;
        // 左孩子
        nodeList.get(lastParentIndex).left = nodeList
                .get(lastParentIndex * 2 + 1);
        // 右孩子,如果数组的长度为奇数才建立右孩子
        if (TREE_VALUE.length % 2 == 1) {
            nodeList.get(lastParentIndex).right = nodeList
                    .get(lastParentIndex * 2 + 2);
        }
    }

    public List<TreeNode> create() {

        int[] array ={1,2,3,4,5,6,7,8};
        List<TreeNode> nodeList = new ArrayList();

        for (int nodeIndex = 0; nodeIndex < array.length ; nodeIndex++) {
            nodeList.add(new TreeNode(array[nodeIndex]));

        }
        for (int parentIndex = 0; parentIndex < array.length/2 - 1; parentIndex++) {
            //left
            nodeList.get(parentIndex).left = nodeList.get(parentIndex * 2 + 1);
            //right
            nodeList.get(parentIndex).right = nodeList.get(parentIndex * 2 +2);
        }
        int lastParentIndex = array.length/2 - 1;
        //last left
        nodeList.get(lastParentIndex).left = nodeList.get(lastParentIndex * 2 + 1);
        //right - if length is Odd have right child;
        if (array.length % 2 == 1){
            nodeList.get(lastParentIndex).right = nodeList.get(lastParentIndex * 2 + 2);
        }
        return nodeList;
    }



}
