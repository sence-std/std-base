package com.std.javassist.classloader;

import javassist.*;

/**
 * @ file_name MyTranslator
 * @ author  sence (lovesenceqi@gmail.com)
 * @ date 2015/4/29 14:13
 * @ description
 * @ review by
 */
public class MyTranslator implements Translator {
    @Override
    public void start(ClassPool pool) throws NotFoundException, CannotCompileException {

    }

    @Override
    public void onLoad(ClassPool pool, String classname) throws NotFoundException, CannotCompileException {
        CtClass cc = pool.get(classname);
        System.out.println("此处是一个监视器模式,可以作为一个扩展点进行处理");
        cc.setModifiers(Modifier.PUBLIC);
    }
}
