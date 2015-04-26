package com.std.javassist;

import javassist.CannotCompileException;
import javassist.NotFoundException;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

/**
 * @ file_name JavassistHelperTest
 * @ author  sence (lovesenceqi@gmail.com)
 * @ date 2015/4/26 22:19
 * @ description
 * @ review by
 */
public class JavassistHelperTest {


    @Test
    public void test01() throws CannotCompileException, InstantiationException, NotFoundException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        JavassistHelper javassistHelper = new JavassistHelper();
       javassistHelper.modifyMethod("com.std.javassist.HelloWorld");
//       HelloWorld helloWorld= (HelloWorld)(t.newInstance());
//        String name = helloWorld.sayHello("sence");
//        System.out.println(name);
    }

    @Test
    public void test02() throws InstantiationException, IllegalAccessException {
        JavassistHelper javassistHelper = new JavassistHelper();
        HelloWorld helloWorld =  javassistHelper.createProxy();
        helloWorld.sayHello("ello");
    }
}
