import java.util.*;

public class FebPrac2 {
    public static void main(String[] args) {

        System.out.println(
                "\nWrite programs showcasing the functionalities of Hashset , Priority queue,Deque , Linked Hashset etc. \n");

        System.out.println("* HashSet Example:");
        AllDS.hashSetExample();

        System.out.println("\n* PriorityQueue Example:");
        AllDS.priorityQueueExample();

        System.out.println("\n* Deque Example:");
        AllDS.dequeExample();

        System.out.println("\n* LinkedHashSet Example:");
        AllDS.linkedHashSetExample();
    }
}

class AllDS {
    // HashSet Example
    public static void hashSetExample() {
        HashSet<String> set = new HashSet<>();
        set.add("Apple");
        set.add("Banana");
        set.add("Cherry");
        set.add("Apple"); // Duplicate, will not be added
        set.add("Date");

        System.out.println("HashSet elements: " + set);
        System.out.println("Contains 'Banana': " + set.contains("Banana"));
        set.remove("Date");
        System.out.println("After removing 'Date': " + set);
    }

    // PriorityQueue
    public static void priorityQueueExample() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(10);
        pq.add(5);
        pq.add(20);
        pq.add(15);

        System.out.println("PriorityQueue elements: " + pq);
        System.out.println("Peek (smallest element): " + pq.peek());
        System.out.println("Polling elements:");
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }

    // Deque ex
    public static void dequeExample() {
        Deque<String> deque = new ArrayDeque<>();
        deque.addFirst("First");
        deque.addLast("Last");
        deque.addFirst("New First");

        System.out.println("Deque elements: " + deque);
        System.out.println("Peek First: " + deque.peekFirst());
        System.out.println("Peek Last: " + deque.peekLast());
        System.out.println("Removing First: " + deque.removeFirst());
        System.out.println("Removing Last: " + deque.removeLast());
        System.out.println("Deque after removals: " + deque);
    }

    // LinkedHashSet ex
    public static void linkedHashSetExample() {
        LinkedHashSet<String> linkedSet = new LinkedHashSet<>();
        linkedSet.add("Dog");
        linkedSet.add("Cat");
        linkedSet.add("Elephant");
        linkedSet.add("Dog"); // Duplicate, will not be added

        System.out.println("LinkedHashSet elements (insertion order): " + linkedSet);
        System.out.println("Contains 'Cat': " + linkedSet.contains("Cat"));
        linkedSet.remove("Elephant");
        System.out.println("After removing 'Elephant': " + linkedSet);
    }
}
