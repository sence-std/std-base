package com.std.lock;

/**
 * @ file_name Student
 * @ author  sence (lovesenceqi@gmail.com)
 * @ date 2015/3/24 20:13
 * @ description
 * @ review by
 */
public class Student {


    private String studentName;

    private Teacher teacher;

    public void sayHello() throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+teacher);
        synchronized (teacher){

            System.out.println(Thread.currentThread().getName()+"teacher sync");
            //这里使用休眠2秒 可观察到 线程一开始是同步阻塞的，后来 await 释放了锁 另一线程才进来了
            Thread.sleep(2000);
            while(!teacher.isComing()){
                System.out.println(Thread.currentThread().getName()+"teacher not coming");
                //await 会释放当前持有的锁对象
                teacher.wait();
            }
            System.out.println(Thread.currentThread().getName()+"teacher came,student say hello");
            System.out.println(Thread.currentThread().getName()+this.studentName+":Hello");
        }
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
