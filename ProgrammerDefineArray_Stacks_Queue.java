/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package midtermproject_djuan;

/**
 *
 * @author User
 */
public class ProgrammerDefineArray_Stacks_Queue {
  
    final int finalSize = 100;
    Employee[] stackEmployeeList, queueEmployeeList, arrayEmployeeList;
    int stackSize, queueSize, arraySize;

    public ProgrammerDefineArray_Stacks_Queue() {
        stackEmployeeList = new Employee[finalSize];
        queueEmployeeList = new Employee[finalSize];
        arrayEmployeeList = new Employee[finalSize];
        this.stackSize = 0;
        this.queueSize = 0;
        this.arraySize = 0;
    }

    // This is for the array
    public boolean addEmployee(Employee employee) {
        for (int i = 0; i < arraySize; i++) {
            if (employee.getID() == arrayEmployeeList[i].getID()) {
                return false;
            }
        }
        arrayEmployeeList[arraySize] = new Employee(employee);
        arraySize++;
        return true;
    }

    public boolean addEmployeeWithIndex(Employee employee, int index) {
        for (int i = 0; i < arraySize; i++) {
            if (employee.getID() == arrayEmployeeList[i].getID()) {
                return false;
            }
        }
        if (this.arraySize == arrayEmployeeList.length) {
            this.arraySize++;
        }
        Employee temp = arrayEmployeeList[index];
        arrayEmployeeList[index] = employee;
        for (int i = index + 1; i <= this.arraySize; i++) {
            Employee nextTemp = arrayEmployeeList[i];
            arrayEmployeeList[i] = temp;
            temp = nextTemp;
        }
        return true;
    }

    public boolean removeEmployeeByID(int id) {
        for (int i = 0; i < arraySize; i++) {
            if (arrayEmployeeList[i] != null && arrayEmployeeList[i].getID() == id) {
                for (int j = i; j < arraySize - 1; j++) {
                    arrayEmployeeList[j] = arrayEmployeeList[j + 1];
                }
                arrayEmployeeList[arraySize - 1] = null;
                arraySize--;
                return true;
            }
        }
        return false;
    }

    public boolean removeEmployeeById(int id) {
        int indexToRemove;
        for (int i = 0; i < this.arraySize; i++) {
            if (arrayEmployeeList[i] != null && arrayEmployeeList[i].getID() == id) {
                for (int x = i; x < this.arraySize - 1; x++) {
                    arrayEmployeeList[x] = arrayEmployeeList[x + 1];
                }
                arrayEmployeeList[this.arraySize - 1] = null;
                this.arraySize--;
                return true;
            }
        }
        return false;
    }

    public boolean removeEmployeeByIndex(int index) {
        arrayEmployeeList[index] = null;
        for (int x = index; x < this.arraySize - 1; x++) {
            arrayEmployeeList[x] = arrayEmployeeList[x + 1];
        }
        this.arraySize--;
        return true;
    }

    public Employee searchByID(int id) {
        for (int i = 0; i < arraySize; i++) {
            if (arrayEmployeeList[i] != null && arrayEmployeeList[i].getID() == id) {
                return arrayEmployeeList[i];
            }
        }
        return null;
    }

    public void makeEmptyArray() {
        arrayEmployeeList = new Employee[finalSize];
        this.arraySize = 0;
    }

    public String toStringArray() {
        if (arraySize == 0) {
            return "";
        }
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < arraySize; i++) {
            str.append(arrayEmployeeList[i].toString()).append("\n");
        }
        return str.toString();
    }

    // This is for the stack
    public boolean pushToStack(Employee employee) {
        if (stackSize >= finalSize) {
            return false;
        }
        stackEmployeeList[stackSize] = new Employee(employee);
        stackSize++;
        return true;
    }

    public Employee popFromStack() {
        if (stackSize > 0) {
            Employee topEmployee = stackEmployeeList[stackSize - 1];
            stackEmployeeList[stackSize - 1] = null;
            stackSize--;
            return topEmployee;
        }
        return null;
    }

    public Employee peekStack() {
        if (stackSize > 0) {
            return stackEmployeeList[stackSize - 1];
        }
        return null;
    }

    public void makeEmptyStack() {
        stackEmployeeList = new Employee[finalSize];
        this.stackSize = 0;
    }

    public String toStringStack() {
        if (stackSize == 0) {
            return "";
        }
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < stackSize; i++) {
            str.append(stackEmployeeList[i].toString()).append("\n");
        }
        return str.toString();
    }
    // This is for the queue
    public boolean enqueueToQueue(Employee employee) {
        if (queueSize >= finalSize) {
            return false;
        }
        queueEmployeeList[queueSize] = new Employee(employee);
        queueSize++;
        return true;
    }

    public Employee dequeueFromQueue() {
        if (queueSize > 0) {
            Employee frontEmployee = queueEmployeeList[0];
            for (int i = 0; i < queueSize - 1; i++) {
                queueEmployeeList[i] = queueEmployeeList[i + 1];
            }
            queueEmployeeList[queueSize - 1] = null;
            queueSize--;
            return frontEmployee;
        }
        return null;
    }

    public Employee peekQueue() {
        if (queueSize > 0) {
            return queueEmployeeList[0];
        }
        return null;
    }

    public void makeEmptyQueue() {
        queueEmployeeList = new Employee[finalSize];
        this.queueSize = 0;
    }

    public String toStringQueue() {
        if (queueSize == 0) {
            return "";
        }
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < queueSize; i++) {
            str.append(queueEmployeeList[i].toString()).append("\n");
        }
        return str.toString();
    }
}
  

