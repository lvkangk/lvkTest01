package 算法与数据结构;

import org.junit.Before;
import org.junit.Test;

/**
 * @author: kangkang.lv
 * @date: 17-3-22 上午11:33
 */
public class LinkTest {

    Node n1 = new Node(1,null);
    Node n2 = new Node(2,n1);
    Node n3 = new Node(3,n2);
    Node n4 = new Node(4,n3);
    Node n5= new Node(5,n4);

    @Before
    public void before(){
        Node nl = n5;
        while (nl!=null){
            System.out.println(nl.getValue());
            nl=nl.getNext();
        }
        System.out.println("-------------");
    }

    @Test
    public void test02(){
        n5 = reverse3(n5);
        System.out.println("反转后");
        while (n5!=null){
            System.out.println(n5.getValue());
            n5 = n5.getNext();
        }
    }

    public Node reverse(Node head){
        if (head!=null && head.getNext() != null){
            Node pre = null;
            Node cur = head;
            Node temp;
            while (cur != null){
                temp = cur.getNext();
                cur.setNext(pre);
                pre = cur;
                cur = temp;
            }
            head = pre;
        }
        return head;
    }

    public Node reverse2(Node head){
        Node pre = null;
        if (head!=null){
            pre = reverse2(head.getNext());
            pre.setNext(head);
            head.setNext(pre);
        }
        return pre;
    }

    public Node reverse3(Node head) {
        // head看作是前一结点，head.getNext()是当前结点，reHead是反转后新链表的头结点
        if (head == null || head.getNext() == null) {
            return head;// 若为空链或者当前结点在尾结点，则直接还回
        }
        Node reHead = reverse3(head.getNext());// 先反转后续节点head.getNext()
        head.getNext().setNext(head);// 将当前结点的指针域指向前一结点
        head.setNext(null);// 前一结点的指针域令为null;
        return reHead;// 反转后新链表的头结点
    }



    @Test
    public void test01(){
        MyLink myLink = new MyLink();
        myLink.addFirst(1);
        myLink.addFirst(2);
        myLink.addFirst(4);
        myLink.addFirst(7);
        myLink.addFirst(3);
        myLink.addLast(10);
        myLink.addFirst(1);
        //myLink.addFirst(2);
        myLink.display();
        myLink.deleteNode(1);
        System.out.println("--删除1后--");
        myLink.display();
        System.out.println("--翻转后--");
        myLink.reverse();
        myLink.display();
    }


}
