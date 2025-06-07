import javax.swing.JOptionPane;

public class Queue<T> { //Classe genêrica
    private int maxSize;
    private T[] queueArray; 
    private int front;
    private int rear;
    private int nItems;

    public int size() {
    return nItems;
}

    @SuppressWarnings("unchecked") // Remove avisos
    public Queue(int s) {
        maxSize = s;
        queueArray = (T[]) new Object[maxSize]; 
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public boolean isFull() {
        return nItems == maxSize;
    }

    public boolean isEmpty() {
        return nItems == 0;
    }


//INSERÇÃO

    public void insert(T value) {  
        if (isFull()) {
            JOptionPane.showMessageDialog(null, "A fila está cheia!");
            return;
        }
        rear = (rear + 1) % maxSize;
        queueArray[rear] = value;
        nItems++;
    }

//REMOÇÃO

    public T remove() {  
        if (isEmpty()) {
            JOptionPane.showMessageDialog(null, "A fila está vazia!");
            return null;
        }
        T temp = queueArray[front];
        front = (front + 1) % maxSize;
        nItems--;
        return temp;
    }

//EXIBIÇÃO

    public void display() {
        if (isEmpty()) {
            JOptionPane.showMessageDialog(null, "A fila está vazia!");
            return;
        }
        StringBuilder sb = new StringBuilder("Conteúdo da fila:\n");
        int i = front;
        for (int j = 0; j < nItems; j++) {
            sb.append(queueArray[i++ % maxSize]).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

//EXIBIÇÃO DO PRÓXIMO VALOR

    public T peek() {
        if (isEmpty()) {
            JOptionPane.showMessageDialog(null, "A fila está vazia!");
            return null;
        }
        return queueArray[front];
    }
}