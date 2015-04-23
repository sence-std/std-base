/**
 * @FileName:Singleton
 * @Package: com.std.offerseries
 *
 * @author sence
 * @created 3/27/2015 9:04 AM
 *
 * Copyright 2011-2015 Asura
 */
package com.std.offerseries;

import java.io.Serializable;

/**
 *
 * <p>单例模式</p>
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
public class Singleton implements Serializable {

	/**
	 * 构造私有化
	 */
	private Singleton(){

	}

	/**
	 * 内部静态类
	 */
	private static class SingletonInner{
		private static final Singleton singleton = new Singleton();
	}

	/**
	 * 获取单例实体
	 * @return
	 */
	public static Singleton getInstance(){
		return SingletonInner.singleton;
	}

	/**
	 * 单例序列化后 回读
	 * @return
	 */
	public Object readResolve(){
		return getInstance();
	}

}
