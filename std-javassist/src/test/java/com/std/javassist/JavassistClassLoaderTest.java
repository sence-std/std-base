package com.std.javassist;

import com.std.javassist.classloader.JavassistClassLoader;
import javassist.CannotCompileException;
import javassist.NotFoundException;
import org.junit.Test;

/**
 * @ file_name JavassistClassLoaderTest
 * @ author  sence (lovesenceqi@gmail.com)
 * @ date 2015/4/29 14:26
 * @ description
 * @ review by
 */
public class JavassistClassLoaderTest {


    @Test
    public void test() throws ClassNotFoundException, CannotCompileException, InstantiationException, NotFoundException, IllegalAccessException {
        JavassistClassLoader jcl = new JavassistClassLoader();
        jcl.runWithClassLoader();
    }

}
