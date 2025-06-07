import java.util.HashSet;
import java.util.Set;

public class DataClear {
    
    public static Queue<Student> removeDuplicates(Queue<Student> queue) {
        Queue<Student> cleanQueue = new Queue<>(queue.size());
        Set<String> ids = new HashSet<>();

        while (!queue.isEmpty()) {
            Student student = queue.remove();
            if (ids.add(student.getStudentId())) { // Se ID for novo, adiciona na fila
                cleanQueue.insert(student);
            }
        }
        return cleanQueue;
    }

    // Substitui valores numéricos inválidos por 0
    public static void fixInvalidValues(Queue<Student> queue) {
        Queue<Student> tempQueue = new Queue<>(queue.size());

        while (!queue.isEmpty()) {
            Student s = queue.remove();
            // Corrige studyHours (não pode ser negativo)
            if (s.getStudyHoursPerDay() < 0) {
                s.setStudyHoursPerDay(0);
            }
            // Corrige examScore (entre 0 e 100)
            if (s.getExamScore() < 0 || s.getExamScore() > 100) {
                s.setExamScore(0);
            }
            tempQueue.insert(s);
        }

        // Retorna os dados corrigidos para a fila original
        while (!tempQueue.isEmpty()) {
            queue.insert(tempQueue.remove());
        }
    }
}
