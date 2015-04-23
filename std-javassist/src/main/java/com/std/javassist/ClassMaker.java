/**
 * @FileName:ClassMaker
 * @Package: com.std.javassist
 *
 * @author sence
 * @created 4/23/2015 5:10 PM
 *
 * Copyright 2011-2015 Asura
 */
package com.std.javassist;

import javassist.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 *
 * <p>创建class</p>
 *
 * <PRE>
 * <BR>	修改记录
 * <BR>-----------------------------------------------
 * <BR>	修改日期			修改人			修改内容
 * </PRE>
 *
 * @author sence
 * @since 1.0
 * @version 1.0
 */
public class ClassMaker {

	/**
	 * 创建一个class
	 * @param className
	 */
	public void makeClass(String className)
			throws NotFoundException, CannotCompileException, IllegalAccessException, InstantiationException,
			NoSuchMethodException, InvocationTargetException {
		ClassPool classPool = new ClassPool();
        classPool.insertClassPath(new ClassClassPath(ClassMaker.class));
		CtClass ctClass = classPool.makeClass(className);
        CtField ctField = new CtField(classPool.get("java.lang.String"), "name", ctClass);
		//CtField ctField = new CtField(classPool.get("java.lang.String"), "name", ctClass);
		ctField.setModifiers(Modifier.PRIVATE);
		//添加这个属性，并提供初始化
		ctClass.addField(ctField, CtField.Initializer.constant("default"));
		//set 方法
		ctClass.addMethod(CtNewMethod.setter("setName",ctField));
		//get方法
		ctClass.addMethod(CtNewMethod.getter("getName",ctField));
		//构造
		CtConstructor ctConstructor = new CtConstructor(new CtClass[]{},ctClass);
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("{\nthis.name=\"sence\";\n}");
		ctConstructor.setBody(stringBuffer.toString());
		ctClass.addConstructor(ctConstructor);
		//调用class
		Class<?> clazz = ctClass.toClass();
		Object o = clazz.newInstance();
		Method method = o.getClass().getMethod("getName",new Class[]{});
		Object name = method.invoke(o,new Object[]{});
		System.out.print("invoke getName result:"+name);
	}


}
