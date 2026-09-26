class LRUCache {
    class Node{
        int key;
        int value;

        Node prev;
        Node next;

        Node(int key,int value){
            this.key=key;
            this.value=value;
        }
    }

    int capacity;
    Map<Integer,Node>mpp;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        mpp=new HashMap<>();
        this.capacity=capacity;

        head=new Node(-1,-1);
        tail=new Node(-1,-1);

        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        if(!mpp.containsKey(key)){
            return -1;
        }
        Node node=mpp.get(key);
        remove(node);
        add(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(mpp.containsKey(key)){
            Node node=mpp.get(key);
            node.value=value;
            remove(node);
            add(node);
            return;
        }
        Node node=new Node(key,value);
        mpp.put(key,node);
        add(node);
        if(mpp.size()>capacity){
            Node lru=tail.prev;
            remove(lru);
            mpp.remove(lru.key);
        }
         
    }
    public void add(Node node){

        Node next=head.next;

        node.prev=head;
        head.next=node;
        node.next=next;
        next.prev=node;
         
    }
    public void remove(Node node){
      Node prev=node.prev;
      Node next=node.next;

      prev.next=next;
      next.prev=prev;
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */