package FIFOQ;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class FIFOQueueTest {
  /**
   * Here's an example of using the FIFO policy. The comments on the right
   * show the state of the cache/queue after each {@code require} operation.
   */
  @Test
  public void extendedExample() {
    ReplacementPolicy<Integer> policy = new FIFOQueue<>(5);
    assertEquals(5, policy.capacity());
    assertEquals(0, policy.size());

    // Requiring items starts to fill the cache.

    policy.require(1);                            // 1 _ _ _ _
    assertEquals(1, policy.size());

    policy.require(2);                            // 1 2 _ _ _
    assertEquals(2, policy.size());

    // But requiring an item that's already in the cache has no effect. (This
    // is different from LRU, where it would rearrange the cache.)

    policy.require(2);                            // 1 2 _ _ _
    assertEquals(2, policy.size());

    policy.require(3);                            // 1 2 3 _ _
    policy.require(4);                            // 1 2 3 4 _
    assertEquals(4, policy.size());

    policy.require(1);                            // 1 2 3 4 _
    assertEquals(4, policy.size());

    policy.require(5);                            // 1 2 3 4 5
    assertEquals(5, policy.size());

    // Once the cache is full, requiring an item that is absent causes the
    // oldest item to be evicted; requiring an item that is present still has
    // no effect.

    assertEquals((Integer) 1, policy.require(6)); // 2 3 4 5 6
    assertEquals(5, policy.size());

    assertNull(policy.require(5));                // 2 3 4 5 6
    assertEquals((Integer) 2, policy.require(1)); // 3 4 5 6 1
    assertNull(policy.require(4));                // 3 4 5 6 1
    assertNull(policy.require(5));                // 3 4 5 6 1
    assertEquals((Integer) 3, policy.require(7)); // 4 5 6 1 7
    assertNull(policy.require(4));                // 4 5 6 1 7
    assertEquals((Integer) 4, policy.require(3)); // 5 6 1 7 3

    assertEquals(5, policy.capacity());
    assertEquals(5, policy.size());
  }
}