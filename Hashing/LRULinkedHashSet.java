package Hashing;
//https://www.geeksforgeeks.org/lru-cache-implementation/
// Java program to implement LRU cache
// using LinkedHashSet
import java.util.*;

class LRULinkedHashSet {

    Set<Integer> cache;
    int capacity;

    public LRULinkedHashSet(int capacity)
    {
        this.cache = new LinkedHashSet<Integer>(capacity);
        this.capacity = capacity;
    }

    // This function returns false if key is not
    // present in cache. Else it moves the key to
    // front by first removing it and then adding
    // it, and returns true.
    public boolean get(int key)
    {
        if (!cache.contains(key))
            return false;
        cache.remove(key);
        cache.add(key);
        return true;
    }

    /* Refers key x with in the LRU cache */
    public void refer(int key)
    {
        if (get(key) == false)
            put(key);
    }

    // displays contents of cache in Reverse Order
    public void display()
    {
        LinkedList<Integer> list = new LinkedList<>(cache);

        // The descendingIterator() method of
        // java.util.LinkedList class is used to return an
        // iterator over the elements in this LinkedList in
        // reverse sequential order
        Iterator<Integer> itr = list.descendingIterator();

        while (itr.hasNext())
            System.out.print(itr.next() + " ");
    }

    public void put(int key)
    {

        if (cache.size() == capacity) {
            int firstKey = cache.iterator().next();
            cache.remove(firstKey);
        }

        cache.add(key);
    }

    // Driver code
    public static void main(String[] args)
    {
        LRULinkedHashSet ca = new LRULinkedHashSet(4);
        ca.refer(1);
        ca.refer(2);
        ca.refer(3);
        ca.refer(1);
        ca.refer(4);
        ca.refer(5);
        ca.display();
    }
}
//Time Complexity: O(1), we use a Linked HashSet data structure to implement the cache. The Linked HashSet provides constant time complexity for both adding elements and retrieving elements.
//Auxiliary Space: O(n), we need to store n elements in the cache, so the space complexity is O(n).Time Complexity: O(1), we use a Linked HashSet data structure to implement the cache. The Linked HashSet provides constant time complexity for both adding elements and retrieving elements.

