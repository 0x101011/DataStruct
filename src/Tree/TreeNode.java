package Tree;

public class TreeNode {
     public Object val;
     TreeNode left;
     TreeNode right;

    TreeNode(Object x){
        this.val =  x;
        this.left = null;
        this.right = null;
    }
    TreeNode(){}

    public void setVal(Object val){
        this.val = val;
    }

    @Override
    public String toString() {
        return this.val.toString();
    }
}
