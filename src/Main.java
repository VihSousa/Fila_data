import java.io.IOException;
import results.StatsResult;

public class Main {
    public static void main(String[] args) {

        String filePath = "data/Student_Data.csv";
        Queue<Student> studentQueue = null;

        // Medir tempo de inserção
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

        // Medir tempo de remoção
        long startRemove = System.currentTimeMillis();

        while (!studentQueue.isEmpty()) {
            studentQueue.remove();
        }

        long endRemove = System.currentTimeMillis();
        long removeTime = endRemove - startRemove;

        System.out.println("\n=== Resultados do Processamento ===");
        System.out.println("Quantidade de alunos: " + totalAlunos);
        System.out.println("Tempo para inserção na fila: " + insertTime + " ms");
        System.out.println("Tempo para remoção da fila: " + removeTime + " ms");

        System.out.println("\n--- Estatísticas dos Alunos ---");
        System.out.printf("Nota média: %.2f\n", estatisticas.mediaNota);
        System.out.printf("Horas médias de estudo por dia: %.2f\n", estatisticas.mediaEstudo);
        System.out.printf("Horas médias de sono por dia: %.2f\n", estatisticas.mediaSono);
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

        // Reinsere os alunos na fila original
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
}
