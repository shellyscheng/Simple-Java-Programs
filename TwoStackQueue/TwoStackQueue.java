/*
* 3134 Data Structures 
* HW2 Programming 2 Solution
* TwoStackQueue.java
* Implements a Queue using two Stacks
*/

public class TwoStackQueue<T> {
  private MyStack<T> inbox;
  private MyStack<T> outbox;

  public TwoStackQueue() {
    inbox = new MyStack<>();
    outbox = new MyStack<>();
  }

  // O(1)
  public void enqueue(T item) {
    inbox.push(item);
  }

  // O(1) when outbox is not empty
  // O(n) when outbox is empty. n == inbox.size
  public T dequeue() {
    if (outbox.isEmpty()) {
      while (!inbox.isEmpty()) {
        outbox.push(inbox.pop());
      }
    }

    return outbox.pop();
  }
}
