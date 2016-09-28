package FIFOQ;

/**
 * Created by Owner on 10/5/2014.
 */



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FIFOQueue<K> implements ReplacementPolicy<K> {

    private int capacity;

    private Queue<K> queue = new LinkedList<K>();

    public FIFOQueue(int cap) {
        if (cap < 1) {
            throw new IllegalArgumentException("capacity must be at least 1");
        }
        capacity = cap;

    }

    @Override
    public int capacity() {
        return capacity;
    }

    @Override
    public int size() {
        return queue.size();
    }


    @Override
    public K require(K item) {
        K evictedItem = null;

        if(queue.contains(item)){
            return null;

        }
        
        if (queue.isEmpty()) {
                queue.add(item);
                return null;
        }
        
        if (!queue.isEmpty()) {
            if (queue.size() < capacity) {
                queue.add(item);

            } else if (queue.size() == capacity) {
                evictedItem = queue.poll();
                queue.add(item);
                return evictedItem;
            }
        }
        
        return null;
    }
    
    public static void main(String[] args) {
        ReplacementPolicy<Integer> policy = new FIFOQueue<>(5);
       // assertEquals(5, policy.capacity());
        System.out.println(policy.capacity());
       // assertEquals(0, policy.size());
        System.out.println(policy.size());

        // Requiring items starts to fill the cache.

        policy.require(1);                            // 1 _ _ _ _
        //assertEquals(1, policy.size());
        System.out.println(policy.size());
    }
}




/*K delete = null;
for (FIFOQueue<K> k : queue) {
        if (queue.contains(item)) {
        return delete;
        }
        K d = null;
        if (!queue.contains(item)) {
        d = (K) queue.get(0);
        queue.add((FIFOQueue<K>) item);

        }
        return d;
        }
        K m = null;
        if (size == capacity()) {
        queue.remove(0);
        queue.add((FIFOQueue<K>) item);
        m = (K) queue.get(0);
        return m;

        }*/
