/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package midtermproject_djuan;

/**
 *
 * @author User
 */
public class ProgrammerDefineLinkedlist_QueueStacks {
    private class Node {
        Employee data;
        Node next;
        Node(Employee data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node stackTop, queueFront, queueRear;
    private int stackSize, queueSize;

    public ProgrammerDefineLinkedlist_QueueStacks() {
        stackTop = null;
        stackSize = 0;
        queueFront = null;
        queueRear = null;
        queueSize = 0;
    }

    // This is for stack
    public void push(Employee employee) {
        Node newNode = new Node(employee);
        newNode.next = stackTop;
        stackTop = newNode;
        stackSize++;
    }

    public Employee pop() {
        if (stackSize == 0) {
            return null;
        }
        Employee poppedEmployee = stackTop.data;
        stackTop = stackTop.next;
        stackSize--;
        return poppedEmployee;
    }

    public Employee peekStack() {
        return stackSize == 0 ? null : stackTop.data;
    }

    public int getStackSize() {
        return stackSize;
    }

    public void makeEmptyStack() {
        stackTop = null;
        stackSize = 0;
    }

    public String toStringStack() {
        StringBuilder str = new StringBuilder();
        Node current = stackTop;
        while (current != null) {
            str.append(current.data.toString()).append("\n");
            current = current.next;
        }
        return str.toString();
    }

    // This is for queue
    public void enqueue(Employee employee) {
        Node newNode = new Node(employee);
        if (queueSize == 0) {
            queueFront = newNode;
        } else {
            queueRear.next = newNode;
        }
        queueRear = newNode;
        queueSize++;
    }

    public Employee dequeue() {
        if (queueSize == 0) {
            return null;
        }
        Employee dequeuedEmployee = queueFront.data;
        queueFront = queueFront.next;
        if (queueFront == null) {
            queueRear = null; // Queue is empty
        }
        queueSize--;
        return dequeuedEmployee;
    }

    public Employee peekQueue() {
        return queueSize == 0 ? null : queueFront.data;
    }
    public int getQueueSize() {
        return queueSize;
    }

    public void makeEmptyQueue() {
        queueFront = null;
        queueRear = null;
        queueSize = 0;
    }

    public String toStringQueue() {
        StringBuilder str = new StringBuilder();
        Node current = queueFront;
        while (current != null) {
            str.append(current.data.toString()).append("\n");
            current = current.next;
        }
        return str.toString();
    }
}


