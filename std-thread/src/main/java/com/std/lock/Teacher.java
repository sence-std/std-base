package com.std.lock;

/**
 * @ file_name Teacher
 * @ author  sence (lovesenceqi@gmail.com)
 * @ date 2015/3/24 20:19
 * @ description
 * @ review by
 */
public class Teacher {

    private Integer teacherId;
    private Integer teacherName;
    private boolean coming;

    public synchronized void  sayMorning(){
        this.coming = true;
        this.notifyAll();
        System.out.println("teacher"+teacherName+":morning");
    }

    public boolean isComing() {
        return coming;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setComing(boolean coming) {
        this.coming = coming;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public void setTeacherName(Integer teacherName) {
        this.teacherName = teacherName;
    }

    public Integer getTeacherName() {
        return teacherName;
    }
}
