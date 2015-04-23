/**
 * @FileName:ClassMakerTest
 * @Package: com.std.javassist
 *
 * @author sence
 * @created 4/23/2015 5:42 PM
 *
 * Copyright 2011-2015 Asura
 */
package com.std.javassist;

import javassist.CannotCompileException;
import javassist.NotFoundException;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

/**
 *
 * <p>单元测试</p>
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
public class ClassMakerTest {

	@Test
	public void test()
			throws IllegalAccessException, InvocationTargetException, InstantiationException, CannotCompileException,
			NotFoundException, NoSuchMethodException {
		ClassMaker maker = new ClassMaker();
		maker.makeClass("com.std.javassist.HelloJavassist");
	}


}
