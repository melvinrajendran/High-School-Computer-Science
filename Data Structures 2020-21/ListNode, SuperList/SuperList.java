import java.util.EmptyStackException;

public class SuperList<E> {
    private ListNode<E> root;
    private ListNode<E> end;
    private int size;

    public SuperList() {
        root = null;
        end = null;
        size = 0;
    }

    public SuperList(E value) {
        ListNode<E> newNode = new ListNode<E>(value);

        root = newNode;
        end = root;
        size = 1;
    }

    public void add(E value) {
        ListNode<E> newNode = new ListNode<E>(value);

        if (isEmpty()) {
            root = newNode;
            end = root;
        } else {
            newNode.setPrevious(end);
            end.setNext(newNode);
            end = newNode;
        }
        size++;
    }

    public void add(int index, E value) {
        ListNode<E> newNode = new ListNode<E>(value);

        if ((index < 0 || index > size) || (isEmpty() && index != 0)) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            if (isEmpty()) {
                root = newNode;
                end = root;
                size++;
            } else {
                if (index == 0) {
                    root.setPrevious(newNode);
                    newNode.setNext(root);
                    root = newNode;
                    size++;
                } else if (index == size) {
                    add(value);
                } else {
                    ListNode<E> previousNode = root;
                    for (int i = 0; i < index - 1; i++)
                        previousNode = previousNode.getNext();
                    ListNode<E> nextNode = previousNode.getNext();

                    newNode.setPrevious(previousNode);
                    previousNode.setNext(newNode);
                    nextNode.setPrevious(newNode);
                    newNode.setNext(nextNode);
                    size++;
                }
            }
        }
    }

    public void push(E value) {
        add(value);
    }

    public E pop() {
        E removedValue;

        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            removedValue = end.getValue();

            if (size == 1) {
                root = null;
                end = null;
            } else if (size > 1) {
                end = end.getPrevious();
                end.setNext(null);
            }
            size--;
        }

        return removedValue;
    }

    public E poll() {
        E removedValue;

        if (isEmpty()) {
            return null;
        } else {
            removedValue = root.getValue();

            if (size == 1) {
                root = null;
                end = null;
            } else if (size > 1) {
                root = root.getNext();
                root.setPrevious(null);
            }
            size--;
        }

        return removedValue;
    }

    public E peekStack() {
        if (size == 0)
            throw new EmptyStackException();
        else
            return end.getValue();
    }

    public E peekQueue() {
        if (size == 0)
            return null;
        else
            return root.getValue();
    }

    public E get(int index) {
        if (index < 0 || index > size - 1) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            ListNode<E> currentNode = root;
            for (int i = 0; i < index; i++)
                currentNode = currentNode.getNext();
            return currentNode.getValue();
        }
    }

    public E remove(int index) {
        E removedValue;

        if (index < 0 || index > size - 1 || size == 0) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            removedValue = get(index);

            if (size == 1) {
                root = null;
                end = null;
            } else {
                if (index == 0) {
                    root = root.getNext();
                    root.setPrevious(null);
                } else if (index == size - 1) {
                    end = end.getPrevious();
                    end.setNext(null);
                } else {
                    ListNode<E> previousNode = root;
                    for (int i = 0; i < index - 1; i++)
                        previousNode = previousNode.getNext();
                    ListNode<E> nextNode = previousNode.getNext().getNext();
    
                    previousNode.setNext(nextNode);
                    nextNode.setPrevious(previousNode);
                }
            }
            size--;
        }

        return removedValue;
    }

    public void clear() {
        root = null;
        end = null;
        size = 0;
    }

    public int size() { return size; }

    public boolean isEmpty() {
        if (root == null)
            return true;
        else
            return false;
    }

    public String toString() {
        String str = "[";
        ListNode<E> temp = root;

        for (int x = 0; x < size; x++) {
            str += temp.getValue();
            if (x < size - 1)
                str += ", ";
            temp = temp.getNext();
        }
        
        str += "]";
        return str;
    }

    public boolean contains(E value) {
        for (int i = 0; i < size; i++)
            if (get(i).equals(value))
                return true;

        return false;
    }

    public class ListNode<E> {
        private E value;
        private ListNode<E> previous;
        private ListNode<E> next;

        public ListNode(E value) {
            this.value = value;
            previous = null;
            next = null;
        }

        public E getValue() { return value; }

        public ListNode<E> getPrevious() { return previous; }

        public ListNode<E> getNext() { return next; }

        public void setPrevious(ListNode<E> previous) { this.previous = previous; }

        public void setNext(ListNode<E> next) { this.next = next; }

        public boolean hasPrevious() {
            if (previous != null)
                return true;
            else
                return false;
        }

        public boolean hasNext() {
            if (next != null)
                return true;
            else
                return false;
        }
    }
}
