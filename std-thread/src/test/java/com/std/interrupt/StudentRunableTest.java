package com.std.interrupt;

import com.std.lock.Student;
import com.std.lock.StudentRunable;
import com.std.lock.Teacher;
import org.junit.Test;

/**
 * @ file_name StudentRunableTets
 * @ author  sence (lovesenceqi@gmail.com)
 * @ date 2015/3/24 20:28
 * @ description
 * @ review by
 */
public class StudentRunableTest {

    @Test
    public void  test() throws InterruptedException {
        Student student = new Student();
        student.setStudentName("LUCY");
        Teacher teacher = new Teacher();
        teacher.setTeacherName(10);
        student.setTeacher(teacher);
        StudentRunable studentRunable = new StudentRunable();
        studentRunable.setStudent(student);
        Thread thread = new Thread(studentRunable);
        thread.setName("thread-1");
        Thread thread1 = new Thread(studentRunable);
        thread.setName("thread-2");
        thread.start();
        thread1.start();
        Thread.sleep(1000);
        teacher.sayMorning();

    }

}
