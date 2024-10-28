/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package midtermproject_djuan;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
/**
/**
 *
 * @author User
 */
public class Predefined {
    
private ArrayList<Employee> employeeArrayList;
    private LinkedList<Employee> employeeLinkedList;
    private Stack<Employee> employeeStack;
    private Queue<Employee> employeeQueue;

    public Predefined() {
        employeeArrayList = new ArrayList<>();
        employeeLinkedList = new LinkedList<>();
        employeeStack = new Stack<>();
        employeeQueue = new LinkedList<>();
    }

    // This is for ArrayList
    public int sizeArrayList() {
        return employeeArrayList.size();
    }

    public boolean addEmployee(Employee employee) {
        if (searchByIDArrayList(employee.getID()) == null) {
            employeeArrayList.add(employee);
            return true;
        }
        return false;
    }

    public boolean addEmployeeWithIndex(Employee employee, int index) {
        if (searchByIDArrayList(employee.getID()) == null && index >= 0 && index <= employeeArrayList.size()) {
            employeeArrayList.add(index, employee);
            return true;
        }
        return false;
    }

    public boolean removeEmployeeById(int id) {
        Employee employee = searchByIDArrayList(id);
        if (!employeeArrayList.isEmpty()) {
            employeeArrayList.remove(employee);
            return true;
        }
        return false;
    }

    public boolean removeFirstIndex() {
        if (employeeArrayList.size() > 0) {
            employeeArrayList.remove(0);
            return true;
        }
        return false;
    }

    public boolean removeLastIndex() {
        if (employeeArrayList.size() > 0) {
            employeeArrayList.remove(employeeArrayList.size() - 1);
            return true;
        }
        return false;
    }

    public boolean removeEmployeeByIndex(int index) {
        if (index >= 0 && index < employeeArrayList.size()) {
            employeeArrayList.remove(index);
            return true;
        }
        return false;
    }

    public void makeEmptyArrayList() {
        employeeArrayList.clear();
    }

    public Employee searchByIDArrayList(int id) {
        for (Employee employee : employeeArrayList) {
            if (employee.getID() == id) {
                return employee;
            }
        }
        return null;
    }

    public String toStringArrayList() {
        if (employeeArrayList.size() > 0) {
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < employeeArrayList.size(); i++) {
                str.append(employeeArrayList.get(i)).append("\n\n");
            }
            return str.toString();
        }
        return "";
    }

    //This is for LinkedList
    public int sizeLinkedList() {
        return employeeLinkedList.size();
    }

    public boolean insert(Employee employee) {
        if (searchByIDLinkedList(employee.getID()) == null) {
            employeeLinkedList.add(employee);
            return true;
        }
        return false;
    }

    public boolean insertAtIndex(Employee employee, int index) {
        if (searchByIDLinkedList(employee.getID()) == null && index >= 0 && index <= employeeLinkedList.size()) {
            employeeLinkedList.add(index, employee);
            return true;
        }
        return false;
    }

    public Employee getFirstNode() {
        return employeeLinkedList.peekFirst();
    }

    public Employee getLastNode() {
        return employeeLinkedList.peekLast();
    }

    public boolean deleteNodeById(int id) {
        Employee employee = searchByIDLinkedList(id);
        if (!employeeLinkedList.isEmpty()) {
            employeeLinkedList.remove(employee);
            return true;
        }
        return false;
    }

    public void deleteNodeByIndex(int index) {
        employeeLinkedList.remove(index);
    }

    public void deleteFirstNode() {
        if (!employeeLinkedList.isEmpty()) {
            employeeLinkedList.removeFirst();
        }
    }

    public void deleteLastNode() {
        if (!employeeLinkedList.isEmpty()) {
            employeeLinkedList.removeLast();
        }
    }

    public void makeEmptyLinkedList() {
        employeeArrayList.clear();
    }

    public Employee searchByIDLinkedList(int id) {
        for (Employee employee : employeeLinkedList) {
            if (employee.getID() == id) {
                return employee;
            }
        }
        return null;
    }
    public String toStringLinkedList() {
        StringBuilder str = new StringBuilder();
        for (Employee employee : employeeLinkedList) {
            str.append(employee).append("\n");
        }
        return str.toString();
    }
    // this is for stacks
    public void push(Employee e) {
        employeeStack.push(e);
    }

    public Employee pop() {
        if (!employeeStack.isEmpty()) {
            return employeeStack.pop();
        }
        return null;
    }

    public Employee peekStack() {
        if (!employeeStack.isEmpty()) {
            return employeeStack.peek();
        }
        return null;
    }

    public int getStackSize() {
        return employeeStack.size();
    }
    public void makeEmptyStacks(){
        employeeStack.clear();
    }
    public String toStringStacks() {
        if (employeeStack.size() > 0) {
            StringBuilder str = new StringBuilder("Employees in Stack:\n");
            for (Employee e : employeeStack) {
                str.append(e.toString()).append("\n");
            }
            return str.toString();
        }
        return "";
    }

    // this is for queue    
    public void enqueue(Employee e) {
        employeeQueue.offer(e);
    }

    public Employee dequeue() {
        if (!employeeQueue.isEmpty()) {
            return employeeQueue.poll();
        }
        return null;
    }

    public Employee peekQueue() {
        if (!employeeQueue.isEmpty()) {
            return employeeQueue.peek();
        }
        return null;
    }

    public int getQueueSize() {
        return employeeQueue.size();
    }
    public void makeEmptyQueue(){
        employeeQueue.clear();
    }
    public String toStringQueue() {
        if (employeeQueue.size() > 0) {
            StringBuilder str = new StringBuilder();
            for (Employee e : employeeQueue) {
                str.append(e.toString()).append("\n");
            }
            return str.toString();
        }
        return "";
    }

}

