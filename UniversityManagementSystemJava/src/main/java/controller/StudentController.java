package controller;
import entity.Course;
import entity.Student;
import repository.StudentRepository;
import java.sql.SQLException;
import java.util.ArrayList;


public class StudentController {
    StudentRepository studentRepository = new StudentRepository();

    public String addStudent(Student student) {

        try {
            studentRepository.addStudent(student);
        } catch (SQLException e) {
            e.printStackTrace();
            return "error with adding student";
        }
        return "Student added successfully";
    }

    public ArrayList<Student> getAll() {
        ArrayList<Student> students = new ArrayList<Student>();
        try {
            students = studentRepository.getAll();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return students;
    }


    public Student findStudentByID(Integer id) {
        Student student = null;

        try {
            student = studentRepository.findStudentByID(id);
        } catch (SQLException e) {
            System.out.println(e);
        }

        return student;
    }

    public String delete (Student student) {

        try {
            studentRepository.delete(student);
        } catch (SQLException e) {
            e.printStackTrace();
            return "error with deleting student";
        }
        return "Student with ID "+ student.id + " deleted successfully";
    }


    public ArrayList<Student> findStudentEnrolledInCourse(int courseId) {
        ArrayList<Student> students = new ArrayList<Student>();
        try {
            students = studentRepository.findStudentEnrolledInCourse(courseId);
        }catch (SQLException e){
            System.out.println(e);
        }

        return students;
    }


}