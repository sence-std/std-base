package com.std.javassist;

import javassist.*;
import org.junit.Test;

/**
 * @ file_name JavassistStd
 * @ author  sence (lovesenceqi@gmail.com)
 * @ date 2015/4/28 15:34
 * @ description
 * @ review by
 */
public class JavassistClassPoolStd {


    /**
     * avoid out memory 1
     * 避免ctclass过多造成内存泄漏方法1
     */
    @Test
    public void testCtClassDetach() throws NotFoundException, CannotCompileException, IllegalAccessException, InstantiationException, InterruptedException {
        //这里是单例模式的一个classpool，每次取的都是同一个，一直存在在内存中，所以垃圾回收去回收不了
        ClassPool classPool = ClassPool.getDefault();
        classPool.insertClassPath(new ClassClassPath(this.getClass()));
        CtClass cc = classPool.get("com.std.javassist.HelloWorld");
        cc.detach();
        //调用detach后不能再在这个CtClass上面调用任何方法了,虽然可以调通
//        Class clazz =cc.toClass();
//        HelloWorld helloWorld = (HelloWorld) clazz.newInstance();
//        System.out.println(helloWorld.sayHello("sence"));
    }


    /**
     * avoid out memory 2
     * 避免ctclass过多造成内存泄漏方法2
     */
    @Test
    public void testCtClassPool(){
        //这里是单例模式的一个classpool，每次取的都是同一个，一直存在在内存中，所以垃圾回收去回收不了
        //ClassPool classPool = ClassPool.getDefault();
        //这里是实例级别的，可以被垃圾回收器回收  这里可以防止CtClass不断增多导致的内存溢出，但是性能不高
        //constructs a ClassPool object 并且 appends the system search path to it
        ClassPool classPool = new ClassPool(true);
        classPool.insertClassPath(new ClassClassPath(this.getClass()));

    }

    @Test
    public void testClassPoolChangeName()throws NotFoundException, CannotCompileException, IllegalAccessException, InstantiationException, InterruptedException {
        ClassPool classPool = new ClassPool(true);
        classPool.insertClassPath(new ClassClassPath(this.getClass()));
        CtClass cc = classPool.get("com.std.javassist.HelloWorld");
        //System.out.println(cc.getName());
        cc.setName("com.std.Hello");
        CtClass cc1 = classPool.get("com.std.javassist.HelloWorld");
        CtClass cc2 = classPool.get("com.std.javassist.HelloWorld");
        CtClass cc3 = classPool.get("com.std.Hello");
        assert cc1 == cc2;
        assert cc == cc3;
    }

}
