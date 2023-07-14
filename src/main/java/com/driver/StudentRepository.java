package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {
    HashMap<String, Student> studentDB = new HashMap<>();
    HashMap<String, Teacher> teacherDB = new HashMap<>();

    HashMap<String, List<String>> studentTeacherDB =new HashMap<>();

    public void addStudentTeacherPair(String student, String teacher) {
        if(!studentTeacherDB.containsKey(teacher)){
            studentTeacherDB.put(teacher, new ArrayList<>());
        }
        List<String> curr = studentTeacherDB.get(teacher);
        curr.add(student);
        studentTeacherDB.put(teacher, curr);
    }

    public Student getStudentByName(String student){
        try{
            return studentDB.get(student);
        }catch (Exception e){
            throw new RuntimeException("Student Does Not Exist.");
        }
    }

    public List<String> getAllStudent() {
        List<String> ans = new ArrayList<>();

        for(String key : studentDB.keySet()){
           ans.add(key);
        }
        return ans;
    }

    public Teacher getTeacherByName(String name) {
        try{
            return teacherDB.get(name);
        }catch (Exception e){
            throw new RuntimeException("Teacher Does Not Exist.");
        }
    }

    public List<String> getStudentsByTeacherName(String teacher) {
        try{
            return studentTeacherDB.get(teacher);
        }catch (Exception e){
            throw new RuntimeException("Teacher does not exist.");
        }
    }

    public void deleteTeacherByName(String name) {
        try{
            teacherDB.remove(name);
        }catch (Exception e){
            throw new RuntimeException("Teacher Not Added Before.");
        }
    }

    public void deleteAllTeachers() {
        teacherDB.clear();
    }

    public void addStudent(Student student) {
        studentDB.put(student.getName(), student);
    }

    public void addTeacher(Teacher teacher) {
        teacherDB.put(teacher.getName(), teacher);
    }
}
