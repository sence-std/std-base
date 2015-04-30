package com.std.javassist.classloader;

import com.std.javassist.HelloWorld;
import javassist.*;

/**
 * @ file_name JavassistClassLoader
 * @ author  sence (lovesenceqi@gmail.com)
 * @ date 2015/4/29 14:12
 * @ description
 * @ review by
 */
public class JavassistClassLoader {

    /**
     *
     */
    public void runWithClassLoaderCastException() throws NotFoundException, CannotCompileException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Translator translator = new MyTranslator();
        ClassPool pool = ClassPool.getDefault();
        Loader loader = new Loader();
        loader.addTranslator(pool,translator);
        //这里是强行使用loader来加载了HelloWorld类
        Class clazz = loader.loadClass("com.std.javassist.HelloWorld");
        Object obj =  clazz.newInstance();
        //这里的HelloWorld则是使用了默认的AppClassLoader来加载了，会出现ClassCastException
        HelloWorld hw = (HelloWorld)obj;
        hw.sayHello("sence");
    }

    /**
     *
     */
    public void runWithClassLoader() throws NotFoundException, CannotCompileException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Translator translator = new MyTranslator();
        ClassPool pool = ClassPool.getDefault();
        Loader loader = new Loader();
        loader.addTranslator(pool,translator);
        //这里委托双亲来做类加载
        loader.delegateLoadingOf("com.std.javassist.HelloWorld");
        /**
         * 这里如果没有委托双亲[即没有调用delegateLoadingOf()]则，类加载器(ClassLoader,ExtClassLoader,AppClassLoader)之间没有继承关系，
         * 而是通过parent属性进行指定父亲类加载器，进而实现双亲委托
         */
        Class clazz = loader.loadClass("com.std.javassist.HelloWorld");
        Object obj =  clazz.newInstance();
        HelloWorld hw = (HelloWorld)obj;
        hw.sayHello("sence");
    }


}
