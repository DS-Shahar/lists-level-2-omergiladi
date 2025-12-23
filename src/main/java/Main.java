public static Node<Integer> sortLinkedList(Node<Integer> head1, Node<Integer> head2) {
        Node<Integer> plough = new Node<Integer>(-1,null);
        Node<Integer> rike = plough;
        Node<Integer> p1 = head1;
        Node<Integer> p2 = head2;
        while (p1 != null && p2 != null) {
            if (p1.getValue() > p2.getValue()) {
                plough.setNext(p2);
                p2=p2.getNext();
            } else {
                plough.setNext(p1);
                p1=p1.getNext();
            }
            plough = plough.getNext();
        }
        if (p1 == null) {
            plough.setNext(p2);
        } else if (p2 == null) plough.setNext(p1);
        return rike.getNext();
    }
    
    //Big O of O(n) if n is the combined length of both lists.
    
    public static Node<Integer> selectionSort(Node<Integer> head) {
    
        Node<Integer> current = head;
        while (current != null) {
            Node<Integer> minNode = current;
            Node<Integer> nextNode = current.getNext();
            while (nextNode != null) {
                if (nextNode.getValue() < minNode.getValue()) {
                    minNode = nextNode;
                }
                nextNode = nextNode.getNext();
            }
            
            if (minNode != current) {
                int temp = current.getValue();
                current.setValue(minNode.getValue());
                minNode.setValue(temp);
            }
            current = current.getNext();
        }
        
        return head; 
    }

    
    //Big O of O(n^2).
    
    public static int disFromEdges(Node<Integer> head, int num) {
        boolean hasAppeared = false;
        int startCounter = 0;
        int endCounter = 0;
        while (head != null) {
            if (head.getValue() == num) {
                hasAppeared = true;
                endCounter = 0;
            }
            if (hasAppeared == false && head.getValue() != num) {
                startCounter+=1;
            }
            if (hasAppeared == true && head.getValue() != num) {
                endCounter+=1;
            }
            head = head.getNext();
        }
        if (!hasAppeared) return -1;
        return (startCounter + endCounter);
    }
    
    //Big O of O(n).
    
    public static boolean allUnique(Node<Integer> head) {
    Node<Integer> cur = head;

    while (cur != null) {
        Node<Integer> nxt = cur.getNext();
        while (nxt != null) {
            if (cur.getValue().equals(nxt.getValue())) return false;
            nxt = nxt.getNext();
        }
        cur = cur.getNext();
    }

    return true;
}
    
    public static Node<Integer> newUnique(Node<Integer> head) {
        Node<Integer> dummy = new Node<>(-1, null);
        Node<Integer> first = dummy;
    
        while (head != null) {
            if (!contains(dummy.getNext(), head.getValue())) {
                first.setNext(new Node<>(head.getValue(), null));
                first = first.getNext();
            }
            head = head.getNext();
        }
    
        return dummy.getNext();
    }
