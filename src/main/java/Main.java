class Main {
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
}
