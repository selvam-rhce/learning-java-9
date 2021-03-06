package Product3.GenericDataStructures;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TrainingCourse {
    private final String courseName;
    private final Map<Student, Grade> gradeMap = new HashMap<>();

    public TrainingCourse(String courseName) {
        this.courseName = courseName;
    }

    public void addStudent(Student student, Grade grade) {
        gradeMap.put(student, grade);
    }

    public String getCourseName() {
        return this.courseName;
    }

    public List<Student> getListOfStudents() {
        return gradeMap.keySet().stream().collect(Collectors.toList());
    }

    public Integer getMaxGrade() {
        return gradeMap.values().stream() //Stream of grades
            .map(grade -> grade.getScore()) //Stream of scores
            .max(Comparator.comparing(Integer::intValue))
            .get();
    }

    public double getAverageGrade() {
        return gradeMap.values().stream() //Stream of grades
            .map(grade -> grade.getScore()) //Stream of scores
            .mapToDouble(x -> x) //Stream of scores (int) to Stream of scores (double)
            .average() //Average
            .orElse(Double.NaN);
    }
}
