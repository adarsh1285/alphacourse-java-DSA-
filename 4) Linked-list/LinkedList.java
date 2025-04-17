public class LinkedList {
    public static class Node {
        // Node type 
        int data;
        Node next;
        
        // constructor -> initialization of Node 
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
     
    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data){
        // step 1 = create a new node
        Node newNode =  new Node(data);
        size++;
        
        if(head == null){
            head = tail = newNode;
            return;
        }
        
        // step 2 newNode next = head;
        newNode.next = head;
        //step 3 head asing
        head = newNode;
    }

    public void addLast(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void print(){
        if(head == null){
            System.out.println("Link list is empty");
            return;
        }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void addMiddle(int idx, int data){
        if(idx == 0){
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;
        while(i < idx-1){
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public int removeFirst(){
        if(size == 0){
            System.out.println("Linked List is empty");
            return Integer.MIN_VALUE;
        }else if(size == 1){
            int val = head.data;
            size = 0;
            head = tail = null;
            return val;
        }
        int val = head.data;
        size--;
        head = head.next;
        return val;
    }

    public int removeLast(){
        if(size == 0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }else if(size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        Node prev = head;
        for(int i = 0 ; i<size-2; i++){
            prev = prev.next;
        }
        int val = tail.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }
    
    public int itrSearch(int key){
        Node temp = head;
        int i = 0;
        while(temp != null){
            if(temp.data == key){
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }

    public void reverse(){
        Node prev = null;
        Node curr = tail = head;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        } 
        head = prev;
    }

    public void deleteNthend(int n){
        int sz = 0;
        Node temp = head;
        while(temp != null){
            temp = temp.next;
            sz++;
        }
         
        if(n == sz){
            head = head.next;
            return;
        }
        int i = 1;
        int iToFind = sz-n;
        Node prev = head;
        while(i < iToFind){
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;
        
    }

    public Node findMiddle(Node head){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public boolean checkpalindrome(){
        if(head == null || head.next == null){
            return true;
        }
        //step 1 find middle of the LL
        Node midNode = findMiddle(head);
        
        // step 2 reverse second halt of the LL
        Node prev = null;
        Node curr = midNode;
        Node next;
        while(curr != null ){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node right = prev;   //right half head
        Node left = head;    // left half head

        //step 3 check 1st and 2nd halt for same value
        while(right != null){
            if(left.data != right.data){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public static boolean checkCycle(){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    public static void removeCycle(){
        // Detect for cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next;
            if(slow == fast){
                cycle = true;
                break;
            }
        }
        
        if(cycle == false){
            return;
        }

        // find meeting point 
        slow = head;
        Node prev = null;
        while(slow != fast){
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        // remove cycle
        prev.next = null;
    }

    // find middle 
    private Node getMid(Node head){
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public Node merge(Node head1, Node head2){
        Node mergeLL = new Node(-1);
        Node temp = mergeLL;

        while(head1 != null && head2 != null){
            if(head1.data <= head2.data){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }else {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }

        while(head1 != null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        while(head2 != null){
            temp.next = head2;
            head2 = head1.next;
            temp = temp.next;
        }

        return mergeLL.next;
    }

    // merge short on linked list
    public Node mergeSort(Node head){
        if(head == null || head.next == null){
            return head;
        }

        // find mid 
        Node mid = getMid(head);

        // left right call merge sort(break in to left and right )
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead); 

        //merge
        return merge(newLeft, newRight);

    }

    public void zigZag(){
        // find mid
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;

        // reverse and break the Linkde list
        Node curr = mid.next;
        mid.next = null; // checking point
        Node prev = null;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev; // checking point
            prev = curr;
            curr = next;
        }
        Node left = head;
        Node right = prev;
        Node nextL , nextR;        

        // alternate merging
        while(left != null && right != null){
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

            left = nextL;
            right = nextR;

        }

    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        
        // ll.addLast(1);
        // ll.addLast(2);
        
        // ll.addLast(3);
        // ll.addLast(2);
        // ll.addLast(1);

              
        // ll.print();
        // ll.addMiddle(2, 20);
       
        // System.out.println("Size of the Linked list is : "+ ll.size);
        // ll.removeFirst();

        // System.out.println("size of the linked list is : "+ ll.size);
        // ll.removeLast();
        // ll.print();

        // int result = ll.itrSearch(20);
        // System.out.println(result);

        // ll.reverse();
        // ll.print();

        // ll.deleteNthend(2);
        // ll.print();

        // System.out.println(ll.checkpalindrome());

        // head = new Node(1);
        // head.next  = new Node(2);
        // head.next.next = new Node(3);
        // head.next.next.next = head;
        // System.out.println(checkCycle());

        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);
        ll.print();

        ll.zigZag();
        ll.print();

        // ll.head = ll.mergeSort(ll.head);
        // ll.print();

    }
}
