package q10;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Exam {
    private List<Centre> centres = new ArrayList<>(); // Composition - 1 exam has many centres
    private String subjectCode;
    private LocalDateTime when;

    public Exam(String subjectCode, LocalDateTime when) {
    }

    public void addCentre(String name, String supervisor) {

    }
}
