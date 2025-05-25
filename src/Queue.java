import javax.swing.JOptionPane;

// METODOS DA FILA

public class Queue<T> { //Classe genêrica
    private int maxSize;
    private T[] queueArray; 
    private int front;
    private int rear;
    private int nItems;

    @SuppressWarnings("unchecked") // Tira avisos
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


//INSERINDO VALOR NA FILA

    public void insert(T value) {  
        if (isFull()) {
            JOptionPane.showMessageDialog(null, "A fila está cheia!");
            return;
        }
        rear = (rear + 1) % maxSize;
        queueArray[rear] = value;
        nItems++;
    }

//REMOVENDO VALOR DA FILA

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

//EXIBINDO A FILA

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

//EXIBIR O PRÓXIMO DA FILA

    public T peek() {
        if (isEmpty()) {
            JOptionPane.showMessageDialog(null, "A fila está vazia!");
            return null;
        }
        return queueArray[front];
    }
}

/* Estudar métodos generiocos - Funcionam com qualquer tipo de dados

Java não permite new T[], por isso usamos (T[]) new Object[]

Generics não funcionam com primitivos (int, double). Use as classes wrappers (Integer, Double).

O método display() assume que T tem um toString() implementado (toda classe em Java herda isso).

*/