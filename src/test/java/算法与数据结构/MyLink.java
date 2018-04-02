package 算法与数据结构;

/**
 * @author: kangkang.lv
 * @date: 18-3-14 下午3:27
 */
public class MyLink {

    private Node head;
    private int size;

    class Node{
        private int data;
        private Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public void addFirst(int obj){
        Node node = new Node(obj);
        if (head == null){
            head = node;
        }else {
            node.next = head;
            head = node;
        }
        size++;
    }

    public void addLast(int obj){
        Node node = new Node(obj);
        if (head == null){
            head = node;
        }else {
            Node tempNode = head;
            while (tempNode.next != null){
                tempNode = tempNode.next;
            }
            tempNode.next = node;
        }
        size++;
    }

    public void deleteNode(int obj){
        if (head != null){
            Node previous = head;
            Node current = head.next;
            while (current != null){
                if (current.data == obj){
                    previous.next = current.next;
                    size--;
                    previous = previous.next;
                    if (previous != null){
                        current = previous.next;
                    }else {
                        return;
                    }
                }else {
                    previous = current;
                    current = current.next;
                }
            }
            //要删除头节点最后单独处理
            if(head.data == obj){
                head = head.next;
                size--;
            }
        }
    }

    /**
     * 单链表翻转
     */
    public void reverse2(){
        if (head!=null){
            Node pre = null;
            Node cur = head;
            while (cur != null){
                head = cur;
                cur = cur.next;
                head.next = pre;
                pre = head;

            }
        }
    }

    public void reverse(){
        if (head!=null && head.next != null){
            Node pre = null;
            Node cur = head;
            Node temp;
            while (cur != null){
                temp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = temp;

            }
            head = pre;
        }
    }

    public void display(){
        if (head!=null){
            Node current = head;
            do {
                System.out.print(current.data + "->");
                current = current.next;
            }while (current!=null);
            System.out.println();
            System.out.println(this.size);
        }
    }

}
