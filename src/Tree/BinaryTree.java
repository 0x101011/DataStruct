package Tree;


import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {


    TreeNode root;

    /**
     * The <code>Stack</code> class represents a last-in-first-out
     * (LIFO) stack of objects. It extends class <tt>Vector</tt> with five
     * operations that allow a vector to be treated as a stack. The usual
     * <tt>push</tt> and <tt>pop</tt> operations are provided, as well as a
     * method to <tt>peek</tt> at the top item on the stack, a method to test
     * for whether the stack is <tt>empty</tt>, and a method to <tt>search</tt>
     * the stack for an item and discover how far it is from the top.
     * <p>
     * When a stack is first created, it contains no items.
     *
     * <p>A more complete and consistent set of LIFO stack operations is
     * provided by the {@link } interface and its implementations, which
     * should be used in preference to this class.  For example:
     * <pre>   {@code
     *   Deque<Integer> stack = new ArrayDeque<Integer>();}</pre>
     *
     * @author  Jonathan Payne
     * @since   JDK1.0
     */
    /**
     * Creates an empty Stack.
     */
    /**
     * Pushes an item onto the top of this stack. This has exactly
     * the same effect as:
     * <blockquote><pre>
     * addElement(item)</pre></blockquote>
     *
     * @param   item   the item to be pushed onto this stack.
     * @return  the <code>item</code> argument.
     * @see     java.util.Vector#addElement
     */
    //拷贝一颗树
    public TreeNode copyTree(TreeNode node) {
        TreeNode copy;
        if ( node == null ) {
            copy = null;
            return null;
        } else {
            copy = new TreeNode(node.val);
            copy.left = copyTree(node.left);
            copy.right = copyTree(node.right);
            return copy;
        }

    }

    public boolean isEqualTree(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) {
            return true;
        }
        if (n1 != null && n2 != null) {
            if (n1.val.equals(n2.val)) {
                if (isEqualTree(n1.left,n2.left)) {
                    if (isEqualTree(n1.right,n2.right)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    //计算总节点个数 先序
    public int countNode(TreeNode node) {

        if (node == null) {
            return 0;
        } else {
            int countL = countNode(node.left);
            int countR = countNode(node.right);
            return countL + countR +1;
        }
    }
    //计算总结点个数 先序
    public int countNode2(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int count = 0;
        count++;//根节点+1
        count = count + countNode2(node.left);
        count = count + countNode2(node.right);
        return count;
    }

    public  int countNode3(TreeNode node) {
        if ( node == null) {
            return 0;
        }

        int count = 0;
        Queue q = new LinkedList();
        q.offer(node);

        while (!q.isEmpty()) {
            count ++;
            TreeNode now = (TreeNode) q.poll();
            if (now.left != null) {
                q.offer(now.left);
            }
            if (now.right != null) {
                q.offer(now.right);
            }
        }
        return count;
    }
    //计算二叉树深度1
    private int treeDepth(TreeNode node) {
        if ( node == null) {
            return 0;
        }
        //+1 because of root
        int left = treeDepth(node.left) ;

        int right = treeDepth(node.right) ;

        //if (left > right) return left + 1;
        //else return right + 1;
        return Math.max(left + 1,right + 1);

    }
    //计算二叉树深度2
    private int treeDepth2(TreeNode node) {

        int depth = 1; int tempDepth = 1;
        Stack<TreeNode> q = new Stack<>();
        Stack<Integer> depthQ = new Stack<>();
        TreeNode cur = node;
        //访问左结点，如有右结点则压栈1，
        // 同时把右结点的深度压栈2，
        // 没有左结点时表示该次遍历完成，
        // 记录深度；
        // 从栈1取出结点，
        // 栈2取出该结点的深度，再次遍历。
        while (cur != null || !q.isEmpty()) {
            if (node == null) {
                node = q.pop();
                depth = depth < tempDepth ? tempDepth : depth;
                tempDepth = depthQ.pop();
            }
            if (node.left != null) {
                tempDepth = tempDepth + 1;
            }
            if (node.right != null) {
                depthQ.add(tempDepth + 1);
                q.add(node.right);
            }
            node = node.left;
        }
        return depth;
    }
    //计算二叉树深度3
    private int treeDepth3(TreeNode node) {
        //.depth3，利用层序遍历的思想，
        // 每完成一层的遍历就给一个标记。
        int depth = 0 ; int tempTag = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);

        Queue<Integer> tagQueue = new LinkedList<>();
        //标记
        tagQueue.add(1);
        while (!queue.isEmpty()) {
            node = queue.poll();

            if (node.left != null) {
                queue.offer(node.left);
                tagQueue.add(0);
            }
            if (node.right != null) {
                queue.offer(node.right);
                tagQueue.add(0);
            }
            tempTag = tagQueue.poll();
            if (tempTag == 1) {
            //标记为1
                depth = depth + 1;
                if (!tagQueue.isEmpty()) {
                    tagQueue.remove();
                    tagQueue.add(1);
                }
            }
        }
        return depth;
    }

    //计算二叉树的宽度
    private int treeWidth2(TreeNode node) {
        if (node == null) {
            return  0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        int width = 1;
        TreeNode cur = null;
        while (!queue.isEmpty()) {
            width = Math.max(width,queue.size());
            int len = queue.size();
            while (len > 0) {
                cur = queue.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                len --;
            }
        }
        return width;
    }
    //计算二叉树的宽度
    private int treeWidth1(TreeNode node) {
        if (node == null) {
            return 0;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        int maxWidth = 1;       //最大宽
        queue.add(node);        //入队

        while (true) {
            int len = queue.size(); //当前层的节点数
            if (len == 0) {
                break;
            }
            while (len > 0) {   //当前层还有节点
                TreeNode t = queue.poll();
                len -- ;
                if (t.left != null) {
                    queue.offer(t.left); //下一层节点入队
                }
                if (t.right != null) {
                    queue.offer(t.right);
                }
            }
            maxWidth = Math.max(maxWidth,queue.size());
        }
        return maxWidth;
    }

    private int treeWidth3(TreeNode node) {
        if (node == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        int width = 1;
        int len = 1;
        while (queue.size() > 0) {
            while (len -- > 0) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            len = queue.size();
            //每层结束后记录下一层的节点数
            width = width > queue.size() ? width : queue.size();
        }
        return width;
    }



    private TreeNode addNodeAndGenerate(TreeNode cur , int value){
        if (cur == null) return new TreeNode(String.valueOf(value));

        if (value < Integer.parseInt(cur.val.toString())) {
            cur.left = addNodeAndGenerate(cur.left , value);
            System.out.println("当前："+cur.val+"——左边："+ cur.left.val);
        } else if (value > Integer.parseInt(cur.val.toString())) {
            cur.right = addNodeAndGenerate(cur.right , value);
            System.out.println("当前："+cur.val+"——右边："+ cur.right.val);
        } else {
            return cur ;
        }
        System.out.println("cur val:"+ cur.val);
        return cur;

    }
    public TreeNode add(int val) {
        this.root = addNodeAndGenerate(root ,val);
        return root;
    }


    //查找节点 二叉搜索树
    /**
  　查找某个节点，我们必须从根节点开始遍历。

　　①、查找值比当前节点值大，则搜索右子树；

　　②、查找值等于当前节点值，停止搜索（终止条件）；

　　③、查找值小于当前节点值，则搜索左子树；
     */
    public TreeNode find(int key) {
        TreeNode cur = root;
        while (cur != null) {
            //Integer.parseInt(String.valueOf(obj))
            if (Integer.parseInt(cur.val.toString()) > key) {
                cur = cur.left;
            } else if (Integer.parseInt(cur.val.toString()) < key) {
                cur = cur.right;
            } else {
                return cur;
            }
        }
        return null;
    }

    /**
    插入节点
    要插入节点，必须先找到插入的位置。与查找操作相似，
    由于二叉搜索树的特殊性，待插入的节点也需要从根节点开始进行比较，
    小于根节点则与根节点左子树比较，反之则与右子树比较，
    直到左子树为空或右子树为空，则插入到相应为空的位置，
    在比较的过程中要注意保存父节点的信息 及 待插入的位置是父节点的左子树还是右子树，
    才能插入到正确的位置。
     */
    public boolean insert( int data) {
        TreeNode node = new TreeNode(data);
        if (this.root == null) {
            this.root = node;
            return true;
        } else {
            TreeNode cur = root;
            TreeNode parent = null;
            while (cur != null) {
                parent = cur;
                if (Integer.parseInt(String.valueOf(cur.val)) > data) {
                    cur = cur.left ;
                    //继续进入左孩子，并且左子为空
                    if (cur == null) {
                        parent.left = node;
                        return true;
                    }
                } else {
                    cur = cur.right;
                    if (cur == null) {
                        parent.right = node;
                        return true;
                    }
                }
            }
                return false;
        }

    }
    /**
    查找最大值和最小值
     */
    //find Max,二叉搜索树的 Max
    public TreeNode findMax() {
        TreeNode cur = root;
        TreeNode maxNode = null;
        while (cur != null) {
            maxNode = cur;
            cur = cur.right;
        }
        return maxNode;
    }
    //find min ,二叉搜索树 Min
    public TreeNode findMin() {
        TreeNode cur = root;
        TreeNode minNode = null;
        while (cur != null) {
            minNode = cur;
            cur = cur.left;
        }
        return minNode;
    }


    /**
     * 删除节点
     * 二叉搜索树中最复杂的操作，删除的节点有三种情况，前两种比较简单，但是第三种却很复杂。
     *
     * 　　1、该节点是叶节点（没有子节点）
     *
     * 　　2、该节点有一个子节点
     *
     * 　　3、该节点有两个子节点
     *
     * 　　下面我们分别对这三种情况进行讲解
     */
    public boolean delete(int key) {
        TreeNode current = root;
        TreeNode parent = root;
        boolean isLeftChild = false;
        //查找删除值，找不到直接返回。
        while (Integer.parseInt(String.valueOf(current.val)) != key) {
            parent = current;
            if (Integer.parseInt(String.valueOf(current.val)) > key) {
                isLeftChild = true;
                current = current.left;
            } else {
                isLeftChild = false;
                current = current.right;
            }
            if (current == null) {
                return false;
            }
        }

        //如果当前节点没有子节点
        if (current.left == null && current.right == null) {
            if (current == root) {
                root = null ;
            } else if (isLeftChild){
                parent.left = null;
            } else {
                parent.right = null;
            }
            return true;
            //当前有一个子节点，左节点
        } else  if (current.left != null && current.right == null) {
            if (current == root) {
                root = current.left;
            } else if (isLeftChild) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
            return true;
            //当前有一个子节点，右节点
        } else if (current.right != null && current.left == null) {
            if (current == root) {
                root = current.right;
            } else if (isLeftChild) {
                parent.left = current.right;
            } else {
                parent.right =current.right;
            }
            return true;
        //当前存在两个子节点
        } else {
            TreeNode succor = getSuccor(current);
            if (current == null) {
                root = succor ;
            } else if (isLeftChild) {
                parent.left = succor;
            } else {
                parent.right =succor;
            }
            succor.left = current.left;
        }
        return false;
    }
    public TreeNode getSuccor(TreeNode delNote) {
        TreeNode succorParent = delNote;
        TreeNode succor = delNote;
        TreeNode current =delNote.right;
        while (current != null) {
            succorParent = succor;
            succor = current;
            current = current.left;
        }
        //后继节点不是删除节点的右子节点，将后续节点替换删除节点。
        if (succor != delNote.right) {
            succorParent.left = succor.right;
            succor.right = delNote.right;
        }
        return succor;
    }
    //删除叶子节点


//    public  BinaryTree createBinaryTree() {
//        BinaryTree tree = new BinaryTree();
//        for (int i = 0; i < 10; i++) {
//            tree.add(i+1);
//        }
//        return tree;
//    }
}
