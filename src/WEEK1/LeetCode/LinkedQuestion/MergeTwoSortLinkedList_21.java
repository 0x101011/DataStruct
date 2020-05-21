package WEEK1.LeetCode.LinkedQuestion;

import Node.Node;

/**
 * No.21
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4

 */

public class MergeTwoSortLinkedList_21 {

    public Node mergeTwoSortList(Node l1 ,Node l2){
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ///----ready to recur
        if (Integer.parseInt(String.valueOf(l1.data)) < Integer.parseInt(String.valueOf(l2.data)))
            return l1;

        return l1;
    }
}
