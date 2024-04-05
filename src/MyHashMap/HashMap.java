package MyHashMap;

public class HashMap<K, V> {
    private Node<K, V> [] table;
    private int size;
    public HashMap(){
        this.table = new Node[4];
    }
    public int size(){
        return size;
    }
    public Node<K, V> [] getTable(){
        return table;
    }
    private void reCapacity(int newCapacity){
        Node<K, V> [] newTable = new Node[newCapacity];
        for (Node<K, V> bucket : table) {
            while (bucket != null){
                int newBucketIndex = bucket.getHash() % newCapacity;
                while (newTable[newBucketIndex] != null){
                    newTable[newBucketIndex] = newTable[newBucketIndex].getNext();
                }
                newTable[newBucketIndex] = bucket;
                bucket = bucket.getNext();
            }
        }
        table = newTable;
    }
    public void put (K key, V val) {
        int hash = key.hashCode();
        int bucketIndex = hash % table.length;
        int count = 0;
        Node<K, V> curNode = table[bucketIndex];
        while (curNode != null) {
            if (curNode.getHash() == hash) {
                if (curNode.getKey().equals(key)) {
                    curNode.setVal(val);
                    return;
                }
            }
            count++;
            curNode = curNode.getNext();
        }
        Node<K,V> newNode = new Node<>(hash, key, val);
        newNode.setNext(table[bucketIndex]);
        table[bucketIndex] = newNode;
        size++;


        if (count >= table.length) {
            reCapacity(table.length * 2);
        }

    }
    public boolean containsKey (K key) {
        int hash = key.hashCode();
        int bucketIndex = hash % table.length;
        Node<K,V> curNode = table[bucketIndex];
        while (curNode != null) {
            if (curNode.getKey().equals(key)) {
                return true;
            }
            curNode = curNode.getNext();
        }
        return false;
    }
    public boolean containsValue (V val) {
        for (Node<K,V> bucket : table) {
            Node<K,V> curNode = bucket;
            while (curNode != null) {
                if (curNode.getVal().equals(val)) {
                    return true;
                }
                curNode = curNode.getNext();
            }
        }
        return false;
    }
    public V remove (K key) {
        int hash = key.hashCode();
        int bucketIndex = hash % table.length;
        Node<K,V> curNode = table[bucketIndex];
        V res;
        if (curNode.getKey().equals(key)) {
            res = curNode.getVal();
            table[bucketIndex] = table[bucketIndex].getNext();
            size--;
            return res;
        }
        while (curNode.getNext() != null) {
            if (curNode.getNext().getKey().equals(key)) {
                res = curNode.getNext().getVal();
                curNode.setNext(curNode.getNext().getNext());
                size--;
                return res;
            }
            curNode = curNode.getNext();
        }
        return null;
    }
    public V get (K key) {
        int hash = key.hashCode();
        int bucketIndex = hash % table.length;
        Node<K,V> curNode = table[bucketIndex];
        while (curNode != null) {
            if (curNode.getKey().equals(key)) {
                return curNode.getVal();
            }
            curNode = curNode.getNext();
        }
        return null;
    }
    public void clear () {
        table = new Node[4];
        size = 0;
    }

}
