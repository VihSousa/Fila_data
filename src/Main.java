import java.io.IOException;
import results.StatsResult;
import java.util.Random;

// java -cp bin Main
// cd src -> javac -d ../bin *.java

public class Main {
    public static void main(String[] args) {

        String filePath = "data/Student_Data.csv";
        Queue<Student> studentQueue = null;

        // Tempo de inserção
        long startInsert = System.currentTimeMillis();

        try {
            studentQueue = CSVReader.loadStudents(filePath);
        } catch (IOException e) {
            System.err.println("Erro ao carregar o arquivo: " + e.getMessage());
            return;
        }

        long endInsert = System.currentTimeMillis();
        long insertTime = endInsert - startInsert;

        int totalAlunos = studentQueue.size();

        // Calcular estatísticas
        StatsResult estatisticas = calcularEstatisticas(studentQueue);

        long startSearch = System.currentTimeMillis();
        randomSearch(studentQueue, 3);
        long endSearch = System.currentTimeMillis();
        long searchTime = endSearch - startSearch;

        // Tempo de remoção
        long startRemove = System.nanoTime();

        while (!studentQueue.isEmpty()) {
            studentQueue.remove();
        }

        long endRemove = System.nanoTime();
        long removeTime = endRemove - startRemove;

        System.out.println("\n=== Estatísticas dos Alunos ===");
        System.out.printf("Nota média: %.2f\n", estatisticas.mediaNota);
        System.out.printf("Horas médias de estudo por dia: %.2f\n", estatisticas.mediaEstudo);
        System.out.printf("Horas médias de sono por dia: %.2f\n", estatisticas.mediaSono);

        System.out.println("\n=== Resultados do Processamento ===");
        System.out.println("Quantidade de alunos: " + totalAlunos);
        System.out.println("Tempo para inserção na fila: " + insertTime + " ms");
        System.out.println("Tempo para remoção da fila: " + removeTime + " ns");
        System.out.println("Tempo total de busca: " + searchTime + " ms");

    }

    // Estatísticas básicas
    private static StatsResult calcularEstatisticas(Queue<Student> queue) {
        double totalNota = 0, totalEstudo = 0, totalSono = 0;
        int count = 0;

        Queue<Student> temp = new Queue<>(queue.size());

        while (!queue.isEmpty()) {
            Student s = queue.remove();
            temp.insert(s);

            totalNota += s.getExamScore();
            totalEstudo += s.getStudyHoursPerDay();
            totalSono += s.getSleepHours();
            count++;
        }

        // Reinsere os alunos
        while (!temp.isEmpty()) {
            queue.insert(temp.remove());
        }

        if (count > 0) {
            return new StatsResult(
                totalNota / count,
                totalEstudo / count,
                totalSono / count
            );
        } else {
            return new StatsResult(0, 0, 0);
        }
    }

    public static void randomSearch(Queue<Student> queue, int numberOfSearches) {
        Random rand = new Random();
        int queueSize = queue.size();
        Queue<Student> tempQueue = new Queue<>(queueSize);

        System.out.println("\n=== Resultados da Busca Randomizada ===");

        for (int i = 0; i < numberOfSearches; i++) {
            int randomIndex = rand.nextInt(queueSize);
            Student foundStudent = null;

            // "Desenfileira" até chegar no índice aleatório
            for (int j = 0; j <= randomIndex; j++) {
                foundStudent = queue.remove();
                tempQueue.insert(foundStudent);
            }

            // Mostra o estudante encontrado
            if (foundStudent != null) {
                System.out.println("\nEstudante #" + (i + 1) + ":");
                System.out.println("ID: " + foundStudent.getStudentId());
                System.out.println("Nota: " + foundStudent.getExamScore());
                System.out.println("Saúde Mental: " + foundStudent.getMentalHealthRating());
                System.out.println("----------------------------------------");
            }

            // Devolve os estudantes para a fila original
            while (!tempQueue.isEmpty()) {
                queue.insert(tempQueue.remove());
            }
        }
    }
    

}
