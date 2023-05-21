package myproject;

import lombok.AllArgsConstructor;
import lombok.Data;
import myproject.enums.Facility;
import myproject.enums.Program;

import java.time.LocalDate;

@AllArgsConstructor
@Data
public class VisitData {
    Facility facility;
    boolean hospitalReadmission;
    Program program;
    LocalDate date;
    String comment;
}
