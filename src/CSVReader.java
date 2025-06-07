import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class CSVReader {
    public static Queue<Student> loadStudents(String filePath) throws IOException { //Fazer o pré processamento aqui
        Queue<Student> queue = new Queue<>(11001); // Tamanho do dataset
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;
        br.readLine(); // Pula o cabeçalho

        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            // Converte cada linha em um objeto de Student
            Student student = new Student(
                data[0],                          // student_id (String)
                Integer.parseInt(data[1]),        // age (int)
                data[2],                          // gender (String)
                Double.parseDouble(data[3]),      // study_hours_per_day (double)
                Double.parseDouble(data[4]),      // social_media_hours (double)
                Double.parseDouble(data[5]),      // netflix_hours (double)
                data[6].equalsIgnoreCase("Yes"),  // part_time_job (boolean)
                Double.parseDouble(data[7]),      // attendance_percentage (double)
                Double.parseDouble(data[8]),      // sleep_hours (double)
                data[9],                          // diet_quality (String: "Poor", "Fair", "Good")
                Integer.parseInt(data[10]),       // exercise_frequency (int)
                data[11],                         // parental_education (String: "High School", "Master", etc.)
                data[12],                         // internet_quality (String: "Poor", "Average", "Good")
                Integer.parseInt(data[13]),       // mental_health_rating (int: 1-10)
                data[14].equalsIgnoreCase("Yes"), // extracurricular_participation (boolean)
                Double.parseDouble(data[15])      // exam_score (double)
            );
            queue.insert(student);
        }
        br.close();
        return queue;
    }
}
