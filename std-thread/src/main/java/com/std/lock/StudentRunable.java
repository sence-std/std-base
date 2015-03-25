package com.std.lock;

/**
 * @ file_name StudentRunabled
 * @ author  sence (lovesenceqi@gmail.com)
 * @ date 2015/3/24 20:16
 * @ description
 * @ review by
 */
public class StudentRunable implements Runnable{

    private Student student;


    public void run(){
        try {
            student.sayHello();
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
