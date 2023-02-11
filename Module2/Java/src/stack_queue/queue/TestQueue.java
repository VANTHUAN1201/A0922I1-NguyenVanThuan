package stack_queue.queue;

public class TestQueue {
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        queue.deQueue();
        queue.displayQueue();
        System.out.println("-----------");
        queue.enQueue(5);
        queue.enQueue(6);
        queue.enQueue(7);
        queue.deQueue();
        queue.deQueue();
        queue.deQueue();
        queue.deQueue();
        queue.displayQueue();

    }
}
