package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;
    static int studentIdx = -1;
    static int teacherIdx = -1;
    public void addStudent(Student student) {
        studentIdx++;
        studentRepository.studentDB.put(studentIdx, student);
    }

    public void addTeacher(Teacher teacher) {
        teacherIdx++;
        studentRepository.teacherDB.put(teacherIdx, teacher);
    }


    public void addStudentTeacherPair(String student, String teacher) {
        studentRepository.addStudentTeacherPair(student, teacher);
    }

    public Student getStudentByName(String name) {
        return studentRepository.getStudentByName(name);
    }

    public List<String> getAllStudent() {
        return studentRepository.getAllStudent();
    }

    public Teacher getTeacherByName(String name) {
        return studentRepository.getTeacherByName(name);
    }

    public List<String> getStudentsByTeacherName(String teacher) {
        return studentRepository.getStudentsByTeacherName(teacher);
    }

    public void deleteTeacherByName(String teacher) {
        studentRepository.deleteTeacherByName(teacher);
    }

    public void deleteAllTeachers() {
        studentRepository.deleteAllTeachers();
    }
}
