/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package midtermproject_djuan;

/**
 *
 * @author User
 */
public class ProgammerDefineDoublyLinkedList {
    

    Employee Head;
    Employee Tail;
    int size;

    ProgammerDefineDoublyLinkedList() {
        MakeEmpty();
    }

    public void MakeEmpty() {
        Head = new Employee();
        Tail = new Employee();
        Head.setNext(Tail);
        Tail.setPrevious(Head);
        size = 0;
    }

    public boolean insert(Employee E, int location) {
        if (location < 0 || location > size) {
            return false;
        }
        Employee current = Head;
        while (current != null && current != Tail) {
            if (E.getID() == current.getID()) {
                return false;
            }
            current = current.getNext();
        }

        if (location == 0) {
            E.setNext(Head.getNext());
            E.setPrevious(Head);
            Head.getNext().setPrevious(E);
            Head.setNext(E);
            size++;
            return true;
        }

        if (location == size) {
            E.setNext(Tail);
            E.setPrevious(Tail.getPrevious());
            Tail.getPrevious().setNext(E);
            Tail.setPrevious(E);
            size++;
            return true;
        }

        Employee nav = findbyIndex(location);
        if (nav != null) {
            E.setNext(nav);
            E.setPrevious(nav.getPrevious());
            nav.getPrevious().setNext(E);
            nav.setPrevious(E);
            size++;
            return true;
        }

        return false;
    }

    public Employee findbyIndex(int location) {
        if (size > 0 && location < size) {
            int x = 0, y = size - 1;
            Employee nav1 = Head.getNext();
            Employee nav2 = Tail.getPrevious();
            while (x <= y) {
                if (x == location) {
                    return nav1;
                }
                if (y == location) {
                    return nav2;
                }
                nav1 = nav1.getNext();
                nav2 = nav2.getPrevious();
                x++;
                y--;
            }
        }
        return null;
    }

    public Employee getFirstNode() {
        return Head.getNext();
    }

    public boolean insertFirstNode(Employee E) {
        Employee current = Head;
        for (int i = 0; i < size; i++) {
            if (E.getID() == current.getID()) {
                return false;
            }
            current = current.getNext();
        }
        E.setNext(Head.getNext());
        E.setPrevious(Head);
        Head.getNext().setPrevious(E);
        Head.setNext(E);
        size++;
        return true;
    }

    public void deleteFirstNode() {
        if (size > 0) {
            Head = Head.getNext();
            if (Head != null) {
                Head.setPrevious(null);
            }
            size--;
        }
        if (size == 0) {
            MakeEmpty();
        }
    }

    public void deleteLastNode() {
        if (size > 0) {
            Tail = Tail.getPrevious();
            if (Tail != null) {
                Tail.setNext(null);
            }
            size--;
        }
        if (size == 0) {
            MakeEmpty();
        }
    }

    public boolean deleteNodeIndex(int index) {
        if (index < 0 || index >= size) {
            return false;
        }
        if (index == 0) {
            deleteFirstNode();
            return true;
        }
        if (index == size - 1) {
            deleteLastNode();
            return true;
        }
        Employee current = Head;
        for (int i = 0; i <= index; i++) {
            current = current.getNext();
        }
        Employee prevNode = current.getPrevious();
        Employee nextNode = current.getNext();

        prevNode.setNext(nextNode);
        nextNode.setPrevious(prevNode);
        size--;
        return true;
    }

    public Employee findByValue(int id) {
        Employee current = Head;
        for (int i = 0; i < size; i++) {
            if (current.getID() == id) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    public Employee findByIndex(int index) {
        Employee current = Head;
        for (int i = 0; i <= index; i++) {
            current = current.getNext();
        }
        return current != null ? current : null;
    }

    public boolean insertLastNode(Employee E) {
        Employee current = Head;
        for (int i = 0; i < size; i++) {
            if (E.getID() == current.getID()) {
                return false;
            }
            current = current.getNext();
        }
        E.setNext(Tail);
        E.setPrevious(Tail.getPrevious());
        Tail.getPrevious().setNext(E);
        Tail.setPrevious(E);
        size++;
        return true;
    }

    public Employee searchByName(String name) {
        Employee current = Head;
        for (int i = 0; i < size; i++) {
            if (current != null && current.getName().equalsIgnoreCase(name)) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    public Employee searchById(int id) {
        Employee current = Head;
        for (int i = 0; i < size; i++) {
            if (current.getID() == id) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    public Employee getEmployee(int index) {
        Employee current = Head;
        for (int i = 0; i <= index; i++) {
            current = current.getNext();
        }
        return current != null ? current : null;
    }

    public Employee next(Employee E) {
        return E.getNext() != Tail ? E.getNext() : null;
    }

    public Employee previous(Employee E) {
        return E.getPrevious() != Head ? E.getPrevious() : null;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        if (size > 0) {
            Employee nav = Head.getNext();
            while (nav != Tail) {
                str.append(nav.toString()).append("\n\n");
                nav = nav.getNext();
            }
        }
        return str.toString();
    }
}

