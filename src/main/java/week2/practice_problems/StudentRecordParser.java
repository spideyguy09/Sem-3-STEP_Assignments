package week2.practice_problems;

public class StudentRecordParser {
    public void parseStudentRecord(String csvLine) {
        String[] fields = csvLine.split(",");
        if (fields.length == 3) {
            System.out.println("Name: " + fields[0].trim() + " | Roll No: " + fields[1].trim() + " | Dept: " + fields[2].trim());
        } else {
            System.out.println("Invalid Record");
        }
    }

    public static void main(String[] args) {
        StudentRecordParser parser = new StudentRecordParser();
        parser.parseStudentRecord("Ananya Verma,RA2211003010123,CSE");
        parser.parseStudentRecord("Ananya Verma,CSE");
    }
}
