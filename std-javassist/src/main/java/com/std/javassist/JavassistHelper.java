package com.std.javassist;

import javassist.*;
import javassist.util.proxy.MethodFilter;
import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.ProxyFactory;
import javassist.util.proxy.ProxyObject;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ file_name JavassistHelper
 * @ author  sence (lovesenceqi@gmail.com)
 * @ date 2015/4/26 22:06
 * @ description
 * @ review by
 */
public class JavassistHelper {

    /**
     * @param className
     */
    public void modifyMethod(String className) throws NotFoundException, CannotCompileException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        ClassPool classPool = ClassPool.getDefault();
        classPool.insertClassPath(new ClassClassPath(JavassistHelper.class));
        CtClass ctClass = classPool.get(className);
        CtClass[] paramCts = {classPool.get("java.lang.String")};
        CtMethod ctMethod = ctClass.getDeclaredMethod("sayHello", paramCts);
        CtMethod newMethod =  CtNewMethod.copy(ctMethod,ctClass,null);
        String oldName = ctMethod.getName()+"$Impl";
        ctMethod.setName(oldName);
        newMethod.setBody("{System.out.println(\"start invoke\");return "+oldName+"($$);"+"System.out.println(\"end invoke\");}");
        ctClass.addMethod(newMethod);
        Class clazz = ctClass.toClass();
        String name =(String) clazz.getMethod("sayHello", String.class).invoke(clazz.newInstance(),"sence");
        System.out.println(name);
        ctClass.defrost();
    }

    public HelloWorld createProxy() throws IllegalAccessException, InstantiationException {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setSuperclass(HelloWorld.class);
        proxyFactory.setFilter(new MethodFilter() {
            @Override
            public boolean isHandled(Method m) {
                return m.getName().endsWith("Hello");
            }
        });
        Class clazz = proxyFactory.createClass();
        HelloWorld helloWorldProxy = (HelloWorld)clazz.newInstance();
        ((ProxyObject)helloWorldProxy).setHandler(new MethodHandler() {
            @Override
            public Object invoke(Object self, Method thisMethod, Method proceed, Object[] args) throws Throwable {
                //拦截后前置处理，改写name属性的内容
                //实际情况可根据需求修改
                System.out.println(thisMethod.getName() + "被调用");
                try {
                    Object ret = proceed.invoke(self, args);
                    System.out.println("返回值: " + ret);
                    return ret;
                } finally {
                    System.out.println(thisMethod.getName() + "调用完毕");
                }
            }
        });
        return helloWorldProxy;
    }
}
