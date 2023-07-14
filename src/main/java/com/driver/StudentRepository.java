package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {
    HashMap<Integer, Student> studentDB = new HashMap<>();
    HashMap<Integer, Teacher> teacherDB = new HashMap<>();

    HashMap<Student, Teacher> studentTeacherDB =new HashMap<>();

    public void addStudentTeacherPair(String student, String teacher) {

        Student student1 = null;
        Teacher teacher1 = null;

        for(int key : studentDB.keySet()){
            if(student.equals(studentDB.get(key).getName())){
                student1 = studentDB.get(key);
            }
        }

        for(int key : teacherDB.keySet()){
            if(teacher.equals(teacherDB.get(key).getName())){
                teacher1 = teacherDB.get(key);
            }
        }

        if(student1==null || teacher1==null){
            throw new RuntimeException("Student or Teacher not added.");
        }

        studentTeacherDB.put(student1, teacher1);

    }

    public Student getStudentByName(String student) {
        for(int key : studentDB.keySet()){
            if(student.equals(studentDB.get(key).getName())){
                return studentDB.get(key);
            }
        }
        return null;
    }

    public List<String> getAllStudent() {
        List<String> ans = new ArrayList<>();

        for(int key : studentDB.keySet()){
           ans.add(studentDB.get(key).getName());
        }
        return ans;
    }

    public Teacher getTeacherByName(String name) {
        for(int key : teacherDB.keySet()){
            if(teacherDB.get(key).getName().equals(name)){
                return teacherDB.get(key);
            }
        }
        return null;
    }

    public List<String> getStudentsByTeacherName(String teacher) {
        List<String> ans =new ArrayList<>();

        for(Student key : studentTeacherDB.keySet()){
            Teacher teacher1 = studentTeacherDB.get(key);

            if(teacher1.getName().equals(teacher)){
                ans.add(key.getName());
            }
        }

        return ans;
    }

    public void deleteTeacherByName(String name) {
        for(int key : teacherDB.keySet()){
            if(teacherDB.get(key).getName().equals(name)){
                teacherDB.remove(key);
            }
        }
    }

    public void deleteAllTeachers() {
        teacherDB.clear();
    }
}
