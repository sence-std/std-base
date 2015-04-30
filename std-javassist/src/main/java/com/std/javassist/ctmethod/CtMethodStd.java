package com.std.javassist.ctmethod;

import javassist.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ file_name CtMethodStd
 * @ author  sence (lovesenceqi@gmail.com)
 * @ date 2015/4/29 15:33
 * @ description
 * @ review by
 */
public class CtMethodStd {

    public void testExtendsMethod() throws NotFoundException, CannotCompileException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, IOException {
        ClassPool classPool = ClassPool.getDefault();
        CtClass ctClass1 = classPool.get("com.std.javassist.ctmethod.Point");
        CtMethod ctMethod =  ctClass1.getDeclaredMethod("draw", new CtClass[]{});
        ctMethod.setModifiers(Modifier.PRIVATE);
        ctClass1.writeFile(".");
        CtClass ctClass2 = classPool.get("com.std.javassist.ctmethod.ColorPoint");
        Class clazz = ctClass2.toClass();
        Object obj = clazz.newInstance();
        Method method = clazz.getMethod("draw", new Class[]{});
        method.invoke(obj);
    }

}
