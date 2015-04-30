package com.std.javassist;

import com.std.javassist.ctmethod.CtMethodStd;
import javassist.CannotCompileException;
import javassist.NotFoundException;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * @ file_name CtMethodStdTest
 * @ author  sence (lovesenceqi@gmail.com)
 * @ date 2015/4/29 15:41
 * @ description
 * @ review by
 */
public class CtMethodStdTest {

    @Test
    public void test() throws NoSuchMethodException, IllegalAccessException, InstantiationException, CannotCompileException, NotFoundException, InvocationTargetException, IOException {
        CtMethodStd ctMethodStd = new CtMethodStd();
        ctMethodStd.testExtendsMethod();
    }

}
