package 树;

import org.junit.Test;

/**
 * @author: kangkang.lv
 * @date: 18-3-29 下午5:46
 */
public class BinarySearchTree {
    public BinaryNode root;

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
        display(b2);
        System.out.println("---");
        remove(3,b2);
        display(b2);
        System.out.println("---");
        insert(3,b2);
        display(b2);
    }

    public BinaryNode insert(int value,BinaryNode n){
        if (n == null) return new BinaryNode(value);
        if (value > n.value){
            n.right = insert(value,n.right);
        }else if (value < n.value){
            n.left = insert(value,n.left);
        }
        return n;
    }

    public BinaryNode remove(int value,BinaryNode n){
        if(n==null) return null;
        if (value > n.value){
            n.right = remove(value,n.right);
        }else if (value < n.value){
            n.left = remove(value,n.left);
        }else if (n.left != null && n.right != null){
            n.value = findMin(n.right).value;
            //removeMin(n.right);
            n.right = remove(n.value,n.right);
        }else{
            n = n.left!=null?n.left:n.right;
        }
        return n;
    }

    public BinaryNode findMin(BinaryNode n){
        if (n == null){
            return null;
        }else if (n.left != null){
            return findMin(n.left);
        }else {
            return n;
        }
    }

    /*public void removeMin(BinaryNode n){
        if (n.left != null){
            removeMin(n.left);
        }else {
            n = null;
        }
    }*/

    public void display(BinaryNode n){
        if (n.left != null){
            display(n.left);
        }
        System.out.println(n.value);
        if (n.right != null){
            display(n.right);
        }
    }
}
