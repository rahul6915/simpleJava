import java.util.Scanner;

class Node  {
 protected int data;
 protected Node link;

 public Node() {
    link = null;
    data = 0;
 }
 public Node(int d, Node n) {
    data = d;
    link = n;
 }
 public void setLink(Node n) {
    link =n;
 }
 public void setData(int d) {
    data =d;
 }
 public Node getLink() {
    return link;
 }
 public int getData() {
    return data;
 }
}

class LinkedList {
    protected Node start;
    public LinkedList() {
        start = null;
    }
    public boolean isEmpty() {
        return start==null;
    }
    public void Insert(int val) {
        Node nptr , ptr, save = null;
        nptr = new Node(val, null);
        boolean ins = false;
        if(start == null) {
            start = nptr;
        }
        else if (val <= start.getData()) 
        {
            nptr.setLink(start);
            start = nptr;
        }
        else {
            save = start;
            ptr = start.getLink();
            while (ptr != null) {
                if (val >= save.getData() && val <= ptr.getData()) {
                    save.setLink(nptr);
                    nptr.setLink(ptr);
                    ins = true;
                    break;
                }
                else {
                    save = ptr;
                    ptr = ptr.getLink();
                }
            }
            if(ins == false) {
                save.setLink(nptr);
        }
        }

    }
    public void display() {
        Node ptr = start;
        System.out.println(start.getData() + " --> ");
        ptr = start.getLink();
        while (ptr.getLink() != null) {
            System.out.println((ptr.getData() + " --> "));
            ptr = ptr.getLink();
        }
        System.out.println(ptr.getData() + "!!!!");
        System.out.println();
    }
}

class LinkedListTest {
    protected static LinkedList S;
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        int num;
        S = new LinkedList();
        Scanner input = new Scanner(System.in);
        System.out.println("Input");
        for(int a = 0; a< 5; ++a) {
            System.out.println("Enter a number: ");
            try {
                num = input.nextInt();
                S.Insert(num);
                System.out.println("Inserted :" + num);
            }
            catch(Exception e) {
                System.err.println(e);
            }
        }
        System.out.println("cReated list \n");
        S.display();
        System.out.println("-------");
    }
}