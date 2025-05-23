
// MODELAGEM DOS DADOS

public class Student {
    
    private String studentId;
    private int age;
    private String gender;
    private double studyHoursPerDay;
    private double socialMediaHours;
    private double netflixHours;
    private boolean hasPartTimeJob; 
    private double attendancePercentage;
    private double sleepHours;
    private String dietQuality;      // "Poor", "Fair", "Good"
    private int exerciseFrequency;
    private String parentalEducation; // "High School", "Master", etc.
    private String internetQuality;   // "Poor", "Average", "Good"
    private int mentalHealthRating;  // 1 a 10
    private boolean doesExtracurricular;
    private double examScore;

    //////////// CONSTRUTORES \\\\\\\\\\\\

    public Student(
        String studentId, int age, String gender, double studyHoursPerDay,
        double socialMediaHours, double netflixHours, boolean hasPartTimeJob,
        double attendancePercentage, double sleepHours, String dietQuality,
        int exerciseFrequency, String parentalEducation, String internetQuality,
        int mentalHealthRating, boolean doesExtracurricular, double examScore
    ) {
        this.studentId = studentId;
        this.age = age;
        this.gender = gender;
        this.studyHoursPerDay = studyHoursPerDay;
        this.socialMediaHours = socialMediaHours;
        this.netflixHours = netflixHours;
        this.hasPartTimeJob = hasPartTimeJob;
        this.attendancePercentage = attendancePercentage;
        this.sleepHours = sleepHours;
        this.dietQuality = dietQuality;
        this.exerciseFrequency = exerciseFrequency;
        this.parentalEducation = parentalEducation;
        this.internetQuality = internetQuality;
        this.mentalHealthRating = mentalHealthRating;
        this.doesExtracurricular = doesExtracurricular;
        this.examScore = examScore;
    }

    //////////// Getters & Setters \\\\\\\\\\\\

    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public double getStudyHoursPerDay() { return studyHoursPerDay; }
    public void setStudyHoursPerDay(double studyHoursPerDay) { this.studyHoursPerDay = studyHoursPerDay; }

    public double getSocialMediaHours() { return socialMediaHours; }
    public void setSocialMediaHours(double socialMediaHours) { this.socialMediaHours = socialMediaHours; }

    public double getNetflixHours() { return netflixHours; }
    public void setNetflixHours(double netflixHours) { this.netflixHours = netflixHours; }

    public boolean hasPartTimeJob() { return hasPartTimeJob; }
    public void setPartTimeJob(boolean hasPartTimeJob) { this.hasPartTimeJob = hasPartTimeJob; }

    public double getAttendancePercentage() { return attendancePercentage; }
    public void setAttendancePercentage(double attendancePercentage) { this.attendancePercentage = attendancePercentage; }

    public double getSleepHours() { return sleepHours; }
    public void setSleepHours(double sleepHours) { this.sleepHours = sleepHours; }

    public String getDietQuality() { return dietQuality; }
    public void setDietQuality(String dietQuality) { this.dietQuality = dietQuality; }

    public int getExerciseFrequency() { return exerciseFrequency; }
    public void setExerciseFrequency(int exerciseFrequency) { this.exerciseFrequency = exerciseFrequency; }

    public String getParentalEducation() { return parentalEducation; }
    public void setParentalEducation(String parentalEducation) { this.parentalEducation = parentalEducation; }

    public String getInternetQuality() { return internetQuality; }
    public void setInternetQuality(String internetQuality) { this.internetQuality = internetQuality; }

    public int getMentalHealthRating() { return mentalHealthRating; }
    public void setMentalHealthRating(int mentalHealthRating) { this.mentalHealthRating = mentalHealthRating; }

    public boolean doesExtracurricular() { return doesExtracurricular; }
    public void setExtracurricular(boolean doesExtracurricular) { this.doesExtracurricular = doesExtracurricular; }

    public double getExamScore() { return examScore; }
    public void setExamScore(double examScore) { this.examScore = examScore; }

}

