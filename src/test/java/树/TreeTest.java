package 树;

import org.junit.Test;

import java.util.*;

/**
 * @author: kangkang.lv
 * @date: 18-4-12 下午2:02
 */
public class TreeTest {

    @Test
    public void test01(){
        BinaryNode b1 = new BinaryNode(1);
        BinaryNode b2 = new BinaryNode(2);
        BinaryNode b3 = new BinaryNode(3);
        BinaryNode b4 = new BinaryNode(4);
        BinaryNode b5 = new BinaryNode(5);
        b2.left = b1;
        b2.right = b4;
        b4.left = b3;
        b4.right = b5;
        List<Integer> list =
                test3(b2);
                //preorderIteratively(b2);
                //inorderIteratively(b2);
                //postorderIteratively(b2);
                //levelorder(b2);
        for (int l : list){
            System.out.printf(l+" ");
        }

    }

    //前序递归
    public List<Integer> test1(BinaryNode node){
        List<Integer> list = new ArrayList<>();
        list.add(node.value);
        if (node.left != null){
            list.addAll(test1(node.left));
        }
        if (node.right != null){
            list.addAll(test1(node.right));
        }
        return list;
    }

    //中序递归
    public List<Integer> test2(BinaryNode node){
        List<Integer> list = new ArrayList<>();
        if (node.left != null){
            list.addAll(test2(node.left));
        }
        list.add(node.value);
        if (node.right != null){
            list.addAll(test2(node.right));
        }
        return list;
    }

    //后序递归
    public List<Integer> test3(BinaryNode node){
        List<Integer> list = new ArrayList<>();
        if (node.left != null){
            list.addAll(test3(node.left));
        }
        if (node.right != null){
            list.addAll(test3(node.right));
        }
        list.add(node.value);
        return list;
    }


    /**
     * 前序遍历非递归版
     * @param node
     */
    public List<Integer> preorderIteratively(BinaryNode node){
        Stack<BinaryNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        BinaryNode cur = node;
        while (cur!=null || stack.size()>0){
            if (cur != null){
                list.add(cur.value);
                stack.push(cur);
                cur = cur.left;
            }else {
                cur = stack.pop().right;
            }
        }
        return list;
    }

    /**
     * 中序遍历非递归版
     * @param node
     * @return
     */
    public List<Integer> inorderIteratively(BinaryNode node){
        Stack<BinaryNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        BinaryNode cur = node;
        while (cur != null || !stack.isEmpty()){
            if (cur != null){
                stack.push(cur);
                cur = cur.left;
            }else {
                list.add(stack.peek().value);
                cur = stack.pop().right;
            }
        }
        return list;
    }

    /**
     * 后序遍历非递归版
     * @param node
     * @return
     */
    public List<Integer> postorderIteratively(BinaryNode node){
        Stack<BinaryNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        BinaryNode cur = node;
        BinaryNode p_right = null;
        while (cur != null || !stack.isEmpty()){
            if (cur != null){
                stack.push(cur);
                cur = cur.left;
            }else {
                cur = stack.peek().right;
                if (cur != null && cur!=p_right){
                    stack.push(cur);
                    cur = cur.left;
                }else {
                    p_right = stack.pop();
                    list.add(p_right.value);
                    cur = null;
                }
            }
        }
        return list;
    }

    /**
     * 层序遍历(广度优先)
     * @param node
     * @return
     */
    public static List<Integer> levelorder(BinaryNode node){
        Queue<BinaryNode> queue = new LinkedList<>();   //用到队列
        List<Integer> list = new ArrayList<>();
        BinaryNode temp;
        queue.add(node);
        while (queue.size()>0){
            temp = queue.poll();
            list.add(temp.value);
            if (temp.left != null){
                queue.add(temp.left);
            }
            if (temp.right != null){
                queue.add(temp.right);
            }
        }
        return list;
    }


}
