/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package midtermproject_djuan;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class MidtermProject_DJuan {

    private static ProgrammerDefineArray_Stacks_Queue arrayBase = new ProgrammerDefineArray_Stacks_Queue();
    private static ProgammerDefineDoublyLinkedList doublyLinkedList = new ProgammerDefineDoublyLinkedList();
    private static ProgrammerDefineLinkedlist_QueueStacks stacksQueue = new ProgrammerDefineLinkedlist_QueueStacks();
    private static Predefined predefined = new Predefined();

    public static void main(String[] args) {
        String choice = JOptionPane.showInputDialog("[1] Predefined\n[2] Programmer Defined\n[0] Exit");
        if (choice == null || choice.trim().isEmpty()) {
            System.exit(0);
        }
        int option = Integer.parseInt(choice.trim());
        if (option == 1) {
            predefinedGui();
        } else if (option == 2) {
            programmerDefinedGui();
        } else if (option == 0) {
            JOptionPane.showMessageDialog(null, "Exiting program");
        } else {
            JOptionPane.showMessageDialog(null, "Invalid Input");
        }

    }

    public static void predefinedGui() {
        String choice = JOptionPane.showInputDialog("[1] ArrayList\n[2] linkedList \n[3] Stacks \n[4] Queue\n[5] Main Menu");
        if (choice == null || choice.trim().isEmpty()) {
            System.exit(0);
        }
        switch (choice.trim()) {
            case "1":
                arrayListInterface();
                break;
            case "2":
                linkedListInterface();
                break;
            case "3":
                stacksInterface();
                break;
            case "4":
                queueInterfaces();
                break;
            case "5":
                JOptionPane.showMessageDialog(null, "Returning to Main Menu");
                main(new String[0]);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Invalid Input");
        }
        predefinedGui();
    }

    public static void programmerDefinedGui() {
        String choice = JOptionPane.showInputDialog("[1] Array\n[2] Stacks (Array Base) \n[3] Queue (Array Base) \n[4] Doubly LinkedLIst \n[5] Stacks (LinkedLIst) \n[6]Queue (LinkedList)\n[7] Main Menu");
        if (choice == null || choice.trim().isEmpty()) {
            System.exit(0);
        }
        switch (choice.trim()) {
            case "1":
                arrayInterface();
                break;
            case "2":
                arrayStacksInterface();
                break;
            case "3":
                arrayQueueInterface();
                break;
            case "4":
                doublyLinkedListInterface();
                break;
            case "5":
                linkedListStacksInterface();
                break;
            case "6":
                linkedListQueueInterface();
                break;
            case "7":
                JOptionPane.showMessageDialog(null, "Returning to Main Menu");
                main(new String[0]);
            default:
                JOptionPane.showMessageDialog(null, "Invalid Input");
        }
        programmerDefinedGui();

    }

    public static void arrayInterface() {

        String menu = "Array Operations:\n"
                + "1. Add Employee\n"
                + "2. Add Employee using index\n"
                + "3. Remove Employee by ID\n"
                + "4. Remove Employee by Index\n"
                + "5. Display All Employees\n"
                + "6. Make ArrayList Empty\n"
                + "0. Back to Main Menu";

        String choice = JOptionPane.showInputDialog(menu);
        int id, age, index;
        String name, position;
        Employee employee;

        switch (choice) {
            case "1":
                name = JOptionPane.showInputDialog("Enter Employee Name:");
                position = JOptionPane.showInputDialog("Enter Employee Position:");
                age = Integer.parseInt(JOptionPane.showInputDialog("Enter Employee Age:"));
                id = Integer.parseInt(JOptionPane.showInputDialog("Enter Employee ID:"));
                employee = new Employee(name, position, (byte) age, id);
                if (arrayBase.addEmployee(employee)) {
                    JOptionPane.showMessageDialog(null, "Employee added successfully.");
                } else {
                    JOptionPane.showMessageDialog(null, "Employee with the same ID already exists.");
                }
                break;

            case "2":
                name = JOptionPane.showInputDialog("Enter Employee Name:");
                position = JOptionPane.showInputDialog("Enter Employee Position:");
                age = Integer.parseInt(JOptionPane.showInputDialog("Enter Employee Age:"));
                id = Integer.parseInt(JOptionPane.showInputDialog("Enter Employee ID:"));
                index = Integer.parseInt(JOptionPane.showInputDialog("Enter Index:"));
                employee = new Employee(name, position, (byte) age, id);
                if (arrayBase.addEmployeeWithIndex(employee, index)) {
                    JOptionPane.showMessageDialog(null, "Employee added successfully.");
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Index or Employee with the same ID already exists.");
                }
                break;

            case "3":
                id = Integer.parseInt(JOptionPane.showInputDialog("Enter Employee ID to Remove:"));
                if (arrayBase.removeEmployeeByID(id)) {
                    JOptionPane.showMessageDialog(null, "Employee removed successfully.");
                } else {
                    JOptionPane.showMessageDialog(null, "Employee not found.");
                }
                break;
            case "4":
                index = Integer.parseInt(JOptionPane.showInputDialog("Enter Index to Remove:"));
                if (arrayBase.removeEmployeeByIndex(index)) {
                    JOptionPane.showMessageDialog(null, "Employee removed successfully at index " + index);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid index.");
                }
                break;

            case "5":
                String employees = arrayBase.toStringArray();
                JOptionPane.showMessageDialog(null, employees.isEmpty() ? "No employees to display." : employees);
                break;

            case "6":
                arrayBase.makeEmptyArray();
                JOptionPane.showMessageDialog(null, "ArrayList Cleared.");
                break;

            case "0":
                JOptionPane.showMessageDialog(null, "Returning to Main Menu");
                main(new String[0]);;

            default:
                JOptionPane.showMessageDialog(null, "Invalid choice, try again.");
        }
        arrayInterface();
    }

    public static void arrayStacksInterface() {

        String menu = "Stack Operations:\n"
                + "1. Push Employee to Stack\n"
                + "2. Pop Employee from Stack\n"
                + "3. Peek at Top of Stack\n"
                + "4. Display All Employees in Stack\n"
                + "5. Make Stack Empty\n"
                + "6. Back to Main Menu";

        String choice = JOptionPane.showInputDialog(menu);
        int id, age;
        String name, position;
        Employee employee;

        switch (choice) {
            case "1":
                name = JOptionPane.showInputDialog("Enter Employee Name:");
                position = JOptionPane.showInputDialog("Enter Employee Position:");
                age = Integer.parseInt(JOptionPane.showInputDialog("Enter Employee Age:"));
                id = Integer.parseInt(JOptionPane.showInputDialog("Enter Employee ID:"));
                employee = new Employee(name, position, (byte) age, id);
                if (arrayBase.pushToStack(employee)) {
                    JOptionPane.showMessageDialog(null, "Employee pushed to stack successfully.");
                } else {
                    JOptionPane.showMessageDialog(null, "Stack is full.");
                }
                break;

            case "2":
                employee = arrayBase.popFromStack();
                if (employee != null) {
                    JOptionPane.showMessageDialog(null, "Popped Employee: " + employee.toString());
                } else {
                    JOptionPane.showMessageDialog(null, "Stack is empty.");
                }
                break;

            case "3":
                employee = arrayBase.peekStack();
                if (employee != null) {
                    JOptionPane.showMessageDialog(null, "Top Employee: " + employee.toString());
                } else {
                    JOptionPane.showMessageDialog(null, "Stack is empty.");
                }
                break;

            case "4":
                String employees = arrayBase.toStringStack();
                JOptionPane.showMessageDialog(null, employees.isEmpty() ? "Stack is empty." : employees);
                break;

            case "5":
                arrayBase.makeEmptyStack();
                JOptionPane.showMessageDialog(null, "Stack cleared.");
                break;

            case "6":
                JOptionPane.showMessageDialog(null, "Returning to Main Menu");
                main(new String[0]);

            default:
                JOptionPane.showMessageDialog(null, "Invalid choice, try again.");
        }

        arrayStacksInterface();
    }

    public static void arrayQueueInterface() {
        String menu = "Queue Operations:\n"
                + "1. Enqueue Employee to Queue\n"
                + "2. Dequeue Employee from Queue\n"
                + "3. Peek at Front of Queue\n"
                + "4. Display All Employees in Queue\n"
                + "5. Make Queue Empty\n"
                + "6. Back to Main Menu";

        String choice = JOptionPane.showInputDialog(menu);
        int id, age;
        String name, position;
        Employee employee;

        switch (choice) {
            case "1":
                name = JOptionPane.showInputDialog("Enter Employee Name:");
                position = JOptionPane.showInputDialog("Enter Employee Position:");
                age = Integer.parseInt(JOptionPane.showInputDialog("Enter Employee Age:"));
                id = Integer.parseInt(JOptionPane.showInputDialog("Enter Employee ID:"));
                employee = new Employee(name, position, (byte) age, id);
                if (arrayBase.enqueueToQueue(employee)) {
                    JOptionPane.showMessageDialog(null, "Employee added to queue successfully.");
                } else {
                    JOptionPane.showMessageDialog(null, "Queue is full.");
                }
                break;

            case "2":
                employee = arrayBase.dequeueFromQueue();
                if (employee != null) {
                    JOptionPane.showMessageDialog(null, "Dequeued Employee: " + employee.toString());
                } else {
                    JOptionPane.showMessageDialog(null, "Queue is empty.");
                }
                break;

            case "3":
                employee = arrayBase.peekQueue();
                if (employee != null) {
                    JOptionPane.showMessageDialog(null, "Front Employee: " + employee.toString());
                } else {
                    JOptionPane.showMessageDialog(null, "Queue is empty.");
                }
                break;

            case "4":
                String employees = arrayBase.toStringQueue();
                JOptionPane.showMessageDialog(null, employees.isEmpty() ? "Queue is empty." : employees);
                break;

            case "5":
                arrayBase.makeEmptyQueue();
                JOptionPane.showMessageDialog(null, "Queue cleared.");
                break;

            case "6":
                JOptionPane.showMessageDialog(null, "Returning to Main Menu");
                main(new String[0]);

            default:
                JOptionPane.showMessageDialog(null, "Invalid choice, try again.");
        }

        arrayQueueInterface();
    }

    public static void doublyLinkedListInterface() {
        String menu = "Doubly Linked List Operations:\n"
                + "1. Insert Employee\n"
                + "2. Insert Employee At Index\n"
                + "3. Delete First Employee\n"
                + "4. Delete Last Employee\n"
                + "5. Display All Employees\n"
                + "6. Make List Empty\n"
                + "0. Back to Main Menu";

        String choice = JOptionPane.showInputDialog(menu);
        int id, age, index;
        String name, position;
        Employee employee;
        switch (choice) {
            case "1":
                name = JOptionPane.showInputDialog("Enter Employee Name:");
                position = JOptionPane.showInputDialog("Enter Employee Position:");
                age = Integer.parseInt(JOptionPane.showInputDialog("Enter Employee Age:"));
                id = Integer.parseInt(JOptionPane.showInputDialog("Enter Employee ID:"));
                employee = new Employee(name, position, (byte) age, id);
                if (doublyLinkedList.insertLastNode(employee)) {
                    JOptionPane.showMessageDialog(null, "Employee inserted successfully.");
                } else {
                    JOptionPane.showMessageDialog(null, "Employee ID already exists.");
                }
                break;
            case "2":
                name = JOptionPane.showInputDialog("Enter Employee Name:");
                position = JOptionPane.showInputDialog("Enter Employee Position:");
                age = Integer.parseInt(JOptionPane.showInputDialog("Enter Employee Age:"));
                id = Integer.parseInt(JOptionPane.showInputDialog("Enter Employee ID:"));
                index = Integer.parseInt(JOptionPane.showInputDialog("Enter index:"));
                employee = new Employee(name, position, (byte) age, id);
                if (doublyLinkedList.insert(employee, index)) {
                    JOptionPane.showMessageDialog(null, "Employee inserted successfully.");
                } else {
                    JOptionPane.showMessageDialog(null, "Employee ID already exists.");
                }
                break;
            case "3":
                doublyLinkedList.deleteFirstNode();
                JOptionPane.showMessageDialog(null, "First employee deleted.");
                break;

            case "4":
                doublyLinkedList.deleteLastNode();
                JOptionPane.showMessageDialog(null, "Last employee deleted.");
                break;

            case "5":
                String employees = doublyLinkedList.toString();
                JOptionPane.showMessageDialog(null, employees.isEmpty() ? "List is empty." : employees);
                break;
            case "6":
                doublyLinkedList.MakeEmpty();
                JOptionPane.showMessageDialog(null, "Doubly LinkedList cleared.");
                break;

            case "0":
                JOptionPane.showMessageDialog(null, "Returning to Main Menu");
                main(new String[0]);

            default:
                JOptionPane.showMessageDialog(null, "Invalid choice, please try again.");
        }
        doublyLinkedListInterface();
    }

    public static void linkedListStacksInterface() {

        // Menu for stack operations
        String menu = "Stack Operations:\n"
                + "1. Push Employee to Stack\n"
                + "2. Pop Employee from Stack\n"
                + "3. Peek at Top of Stack\n"
                + "4. Display All Employees in Stack\n"
                + "5. Make Stack Empty\n"
                + "6. Back to Main Menu";

        // Get user choice
        String choice = JOptionPane.showInputDialog(menu);
        int id, age;
        String name, position;
        Employee employee;
        switch (choice) {
            case "1":
                name = JOptionPane.showInputDialog("Enter Employee Name:");
                position = JOptionPane.showInputDialog("Enter Employee Position:");
                age = Integer.parseInt(JOptionPane.showInputDialog("Enter Employee Age:"));
                id = Integer.parseInt(JOptionPane.showInputDialog("Enter Employee ID:"));
                employee = new Employee(name, position, (byte) age, id);
                stacksQueue.push(employee);
                JOptionPane.showMessageDialog(null, "Employee pushed to stack successfully.");
                break;

            case "2":
                employee = stacksQueue.pop();
                if (employee != null) {
                    JOptionPane.showMessageDialog(null, "Popped Employee: " + employee.toString());
                } else {
                    JOptionPane.showMessageDialog(null, "Stack is empty.");
                }
                break;

            case "3":
                employee = stacksQueue.peekStack();
                if (employee != null) {
                    JOptionPane.showMessageDialog(null, "Top Employee: " + employee.toString());
                } else {
                    JOptionPane.showMessageDialog(null, "Stack is empty.");
                }
                break;

            case "4":
                String employees = stacksQueue.toStringStack();
                JOptionPane.showMessageDialog(null, employees.isEmpty() ? "Stack is empty." : employees);
                break;

            case "5":
                stacksQueue.makeEmptyStack();
                JOptionPane.showMessageDialog(null, "Stack cleared.");
                break;

            case "6":
                JOptionPane.showMessageDialog(null, "Returning to Main Menu");
                main(new String[0]);

            default:
                JOptionPane.showMessageDialog(null, "Invalid choice, please try again.");
        }
        linkedListStacksInterface();
    }

    public static void linkedListQueueInterface() {
        String menu = "Queue Operations:\n"
                + "1. Enqueue Employee to Queue\n"
                + "2. Dequeue Employee from Queue\n"
                + "3. Peek at Front of Queue\n"
                + "4. Display All Employees in Queue\n"
                + "5. Make Queue Empty\n"
                + "6. Back to Main Menu";
        String choice = JOptionPane.showInputDialog(menu);
        int id, age;
        String name, position;
        Employee employee;
        switch (choice) {
            case "1":
                name = JOptionPane.showInputDialog("Enter Employee Name:");
                position = JOptionPane.showInputDialog("Enter Employee Position:");
                age = Integer.parseInt(JOptionPane.showInputDialog("Enter Employee Age:"));
                id = Integer.parseInt(JOptionPane.showInputDialog("Enter Employee ID:"));
                employee = new Employee(name, position, (byte) age, id);
                stacksQueue.enqueue(employee);
                JOptionPane.showMessageDialog(null, "Employee added to queue successfully.");
                break;

            case "2":
                employee = stacksQueue.dequeue();
                if (employee != null) {
                    JOptionPane.showMessageDialog(null, "Dequeued Employee: " + employee.toString());
                } else {
                    JOptionPane.showMessageDialog(null, "Queue is empty.");
                }
                break;

            case "3":
                employee = stacksQueue.peekQueue();
                if (employee != null) {
                    JOptionPane.showMessageDialog(null, "Front Employee: " + employee.toString());
                } else {
                    JOptionPane.showMessageDialog(null, "Queue is empty.");
                }
                break;

            case "4":
                String employees = stacksQueue.toStringQueue();
                JOptionPane.showMessageDialog(null, employees.isEmpty() ? "Queue is empty." : employees);
                break;

            case "5":
                stacksQueue.makeEmptyQueue();
                JOptionPane.showMessageDialog(null, "Queue cleared.");
                break;

            case "6":
                JOptionPane.showMessageDialog(null, "Returning to Main Menu");
                main(new String[0]);

            default:
                JOptionPane.showMessageDialog(null, "Invalid choice, please try again.");
        }
        linkedListQueueInterface();
    }

    public static void arrayListInterface() {
        String menu = "ArrayList Operations:\n"
                + "1. Add Employee\n"
                + "2. Add Employee using index\n"
                + "3. Remove Employee by ID\n"
                + "4. Remove First Employee\n"
                + "5. Remove Last Employee\n"
                + "6. Remove Employee by Index\n"
                + "7. Display All Employees\n"
                + "8. Make ArrayList Empty\n"
                + "0. Back to Main Menu";

        String choice = JOptionPane.showInputDialog(menu);
        int id, age, index;
        String name, position;
        Employee employee;

        switch (choice) {
            case "1":
                name = JOptionPane.showInputDialog("Enter Employee Name:");
                position = JOptionPane.showInputDialog("Enter Employee Position:");
                age = Integer.parseInt(JOptionPane.showInputDialog("Enter Employee Age:"));
                id = Integer.parseInt(JOptionPane.showInputDialog("Enter Employee ID:"));
                employee = new Employee(name, position, (byte) age, id);
                if (predefined.addEmployee(employee)) {
                    JOptionPane.showMessageDialog(null, "Employee added successfully.");
                } else {
                    JOptionPane.showMessageDialog(null, "Employee with the same ID already exists.");
                }
                break;

            case "2":
                name = JOptionPane.showInputDialog("Enter Employee Name:");
                position = JOptionPane.showInputDialog("Enter Employee Position:");
                age = Integer.parseInt(JOptionPane.showInputDialog("Enter Employee Age:"));
                id = Integer.parseInt(JOptionPane.showInputDialog("Enter Employee ID:"));
                index = Integer.parseInt(JOptionPane.showInputDialog("Enter Index:"));
                employee = new Employee(name, position, (byte) age, id);
                if (predefined.addEmployeeWithIndex(employee, index)) {
                    JOptionPane.showMessageDialog(null, "Employee added successfully.");
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Index or Employee with the same ID already exists.");
                }
                break;

            case "3":
                id = Integer.parseInt(JOptionPane.showInputDialog("Enter Employee ID to Remove:"));
                if (predefined.removeEmployeeById(id)) {
                    JOptionPane.showMessageDialog(null, "Employee removed successfully.");
                } else {
                    JOptionPane.showMessageDialog(null, "Employee not found.");
                }
                break;

            case "4":
                if (predefined.removeFirstIndex()) {
                    JOptionPane.showMessageDialog(null, "First Employee removed successfully.");
                } else {
                    JOptionPane.showMessageDialog(null, "ArrayList is empty.");
                }
                break;

            case "5":
                if (predefined.removeLastIndex()) {
                    JOptionPane.showMessageDialog(null, "Last Employee removed successfully.");
                } else {
                    JOptionPane.showMessageDialog(null, "ArrayList is empty.");
                }
                break;

            case "6":
                index = Integer.parseInt(JOptionPane.showInputDialog("Enter Index to Remove:"));
                if (predefined.removeEmployeeByIndex(index)) {
                    JOptionPane.showMessageDialog(null, "Employee removed successfully at index " + index);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid index.");
                }
                break;

            case "7":
                String employees = predefined.toStringArrayList();
                JOptionPane.showMessageDialog(null, employees.isEmpty() ? "No employees to display." : employees);
                break;

            case "8":
                predefined.makeEmptyArrayList();
                JOptionPane.showMessageDialog(null, "ArrayList Cleared.");
                break;

            case "0":
                JOptionPane.showMessageDialog(null, "Returning to Main Menu");
                main(new String[0]);

            default:
                JOptionPane.showMessageDialog(null, "Invalid choice, try again.");
        }
        arrayListInterface();
    }

    public static void linkedListInterface() {
        String menu = "LinkedList Operations:\n"
                + "1. Add Employee\n"
                + "2. Add Employee using index\n"
                + "3. Remove Employee by ID\n"
                + "4. Remove First Employee\n"
                + "5. Remove Last Employee\n"
                + "6. Remove Employee by Index\n"
                + "7. Display All Employees\n"
                + "8. Make LinkedList Empty\n"
                + "0. Back to Main Menu";

        String choice = JOptionPane.showInputDialog(menu);
        int id, age, index;
        String name, position;
        Employee employee;

        switch (choice) {
            case "1":
                name = JOptionPane.showInputDialog("Enter Employee Name:");
                position = JOptionPane.showInputDialog("Enter Employee Position:");
                age = Integer.parseInt(JOptionPane.showInputDialog("Enter Employee Age:"));
                id = Integer.parseInt(JOptionPane.showInputDialog("Enter Employee ID:"));
                employee = new Employee(name, position, (byte) age, id);
                if (predefined.insert(employee)) {
                    JOptionPane.showMessageDialog(null, "Employee added successfully.");
                } else {
                    JOptionPane.showMessageDialog(null, "Employee with the same ID already exists.");
                }
                break;

            case "2":
                name = JOptionPane.showInputDialog("Enter Employee Name:");
                position = JOptionPane.showInputDialog("Enter Employee Position:");
                age = Integer.parseInt(JOptionPane.showInputDialog("Enter Employee Age:"));
                id = Integer.parseInt(JOptionPane.showInputDialog("Enter Employee ID:"));
                index = Integer.parseInt(JOptionPane.showInputDialog("Enter Index:"));
                employee = new Employee(name, position, (byte) age, id);
                if (predefined.insertAtIndex(employee, index)) {
                    JOptionPane.showMessageDialog(null, "Employee added successfully at index " + index);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Index or Employee with the same ID already exists.");
                }
                break;

            case "3":
                id = Integer.parseInt(JOptionPane.showInputDialog("Enter Employee ID to Remove:"));
                if (predefined.deleteNodeById(id)) {
                    JOptionPane.showMessageDialog(null, "Employee removed successfully.");
                } else {
                    JOptionPane.showMessageDialog(null, "Employee not found.");
                }
                break;

            case "4":
                predefined.deleteFirstNode();
                JOptionPane.showMessageDialog(null, "First Employee removed successfully.");
                break;

            case "5":
                predefined.deleteLastNode();
                JOptionPane.showMessageDialog(null, "Last Employee removed successfully.");
                break;

            case "6":
                index = Integer.parseInt(JOptionPane.showInputDialog("Enter Index to Remove:"));
                predefined.deleteNodeByIndex(index);
                JOptionPane.showMessageDialog(null, "Employee removed successfully at index " + index);
                break;

            case "7":
                String employees = predefined.toStringLinkedList();
                JOptionPane.showMessageDialog(null, employees.isEmpty() ? "No employees to display." : employees);
                break;

            case "8":
                predefined.makeEmptyLinkedList();
                JOptionPane.showMessageDialog(null, "LinkedList cleared.");
                break;

            case "0":
                JOptionPane.showMessageDialog(null, "Returning to Main Menu");
                main(new String[0]);

            default:
                JOptionPane.showMessageDialog(null, "Invalid choice, try again.");
        }
        linkedListInterface();
    }

    public static void stacksInterface() {
        String menu = "Stack Operations:\n"
                + "1. Push Employee\n"
                + "2. Pop Employee\n"
                + "3. Peek at Top Employee\n"
                + "4. Display All Employees\n"
                + "5. Make Stack Empty\n"
                + "0. Back to Main Menu";
        String choice = JOptionPane.showInputDialog(menu);
        int id, age;
        String name, position;
        Employee employee;

        switch (choice) {
            case "1":  // Push Employee
                name = JOptionPane.showInputDialog("Enter Employee Name:");
                position = JOptionPane.showInputDialog("Enter Employee Position:");
                age = Integer.parseInt(JOptionPane.showInputDialog("Enter Employee Age:"));
                id = Integer.parseInt(JOptionPane.showInputDialog("Enter Employee ID:"));
                employee = new Employee(name, position, (byte) age, id);
                predefined.push(employee);
                JOptionPane.showMessageDialog(null, "Employee pushed to stack.");
                break;

            case "2":
                employee = predefined.pop();
                if (employee != null) {
                    JOptionPane.showMessageDialog(null, "Popped Employee: " + employee.toString());
                } else {
                    JOptionPane.showMessageDialog(null, "Stack is empty, cannot pop.");
                }
                break;

            case "3":
                employee = predefined.peekStack();
                if (employee != null) {
                    JOptionPane.showMessageDialog(null, "Top Employee: " + employee.toString());
                } else {
                    JOptionPane.showMessageDialog(null, "Stack is empty, no top employee.");
                }
                break;

            case "4":
                String employees = predefined.toStringStacks();
                JOptionPane.showMessageDialog(null, employees.isEmpty() ? "No employees in stack." : employees);
                break;

            case "5":
                predefined.makeEmptyStacks();
                JOptionPane.showMessageDialog(null, "Stack has been emptied.");
                break;

            case "0":
                JOptionPane.showMessageDialog(null, "Returning to main menu.");
                main(new String[0]);

            default:
                JOptionPane.showMessageDialog(null, "Invalid choice, try again.");
        }
        stacksInterface();
    }

    public static void queueInterfaces() {
        String menu = "Queue Operations:\n"
                + "1. Enqueue Employee\n"
                + "2. Dequeue Employee\n"
                + "3. Peek at Front Employee\n"
                + "4. Display All Employees\n"
                + "5. Make Queue Empty\n"
                + "0. Back to Main Menu";
        String choice = JOptionPane.showInputDialog(menu);
        int id, age;
        String name, position;
        Employee employee;

        switch (choice) {
            case "1":
                name = JOptionPane.showInputDialog("Enter Employee Name:");
                position = JOptionPane.showInputDialog("Enter Employee Position:");
                age = Integer.parseInt(JOptionPane.showInputDialog("Enter Employee Age:"));
                id = Integer.parseInt(JOptionPane.showInputDialog("Enter Employee ID:"));
                employee = new Employee(name, position, (byte) age, id);
                predefined.enqueue(employee);
                JOptionPane.showMessageDialog(null, "Employee enqueued successfully.");
                break;

            case "2":
                employee = predefined.dequeue();
                if (employee != null) {
                    JOptionPane.showMessageDialog(null, "Dequeued Employee: " + employee.toString());
                } else {
                    JOptionPane.showMessageDialog(null, "Queue is empty, cannot dequeue.");
                }
                break;

            case "3":
                employee = predefined.peekQueue();
                if (employee != null) {
                    JOptionPane.showMessageDialog(null, "Front Employee: " + employee.toString());
                } else {
                    JOptionPane.showMessageDialog(null, "Queue is empty, no front employee.");
                }
                break;

            case "4":
                String employees = predefined.toStringQueue();
                JOptionPane.showMessageDialog(null, employees.isEmpty() ? "No employees in queue." : employees);
                break;

            case "5":
                predefined.makeEmptyQueue();
                JOptionPane.showMessageDialog(null, "Queue has been emptied.");
                break;

            case "0":
                JOptionPane.showMessageDialog(null, "Returning to main menu.");
                main(new String[0]);

            default:
                JOptionPane.showMessageDialog(null, "Invalid choice, try again.");
                queueInterfaces();
        }
        queueInterfaces();
    }
}