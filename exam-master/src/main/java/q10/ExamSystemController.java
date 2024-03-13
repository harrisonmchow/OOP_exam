package q10;

import java.time.LocalDateTime;
import java.util.List;

public class ExamSystemController {
    private List<Exam> exams; // Composition - Controller has many exams

    public void createExam(String subjectCode, LocalDateTime when) {

    }

    public void createCentre(String name, String supervisorName) {

    }

    public void createClassroom(String centre, String classroomName, String invigilatorName) {

    }

    public void addStudentToClassroom(String classroomName, String studentID) {

    }

    public void removeStudentFromClassroom(String classroomName, String studentID) {

    }

}