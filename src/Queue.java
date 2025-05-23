import javax.swing.JOptionPane;

// METODOS DA FILA
//TROCA DE STRING POR STUDENT, PARA ACEITAR DADOS DO DATASET

public class Queue {
    private int maxSize;
    private Student[] queueArray; 
    private int front;
    private int rear;
    private int nItems;

    public Queue(int s) {
        maxSize = s;
        queueArray = new Student[maxSize];  // ARMAZENA DADOS DE STUDENT.java
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

    public void insert(Student value) {  
        if (isFull()) {
            JOptionPane.showMessageDialog(null, "A fila está cheia!");
            return;
        }
        rear = (rear + 1) % maxSize;
        queueArray[rear] = value;
        nItems++;
    }

//REMOVENDO VALOR DA FILA

    public Student remove() {  
        if (isEmpty()) {
            JOptionPane.showMessageDialog(null, "A fila está vazia!");
            return null;
        }
        Student temp = queueArray[front];
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

    public Student peek() {
        if (isEmpty()) {
            JOptionPane.showMessageDialog(null, "A fila está vazia!");
            return null;
        }
        return queueArray[front];
    }
}