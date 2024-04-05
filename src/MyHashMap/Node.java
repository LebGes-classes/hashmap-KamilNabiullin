package MyHashMap;

public class Node<K,V> {
    private int hash;
    private K key;
    private V value;
    private Node<K,V> next;
    Node(int hash, K key, V val) {
        this.hash = hash;
        this.key = key;
        this.value = val;
    }
    public K getKey() {
        return key;
    }
    public Node<K,V> getNext(){
        return next;
    }
    public V getVal() {
        return value;
    }
    public int getHash() {
        return hash;
    }
    public void setNext(Node<K,V> next) {
        this.next = next;
    }
    public void setVal(V val) {
        this.value = val;
    }
}
