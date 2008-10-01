package net.form105.rm.base.helper;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import net.form105.rm.base.mapping.ITarget;

import org.apache.log4j.Logger;

public class ReflectionHelper {

	public static Logger logger = Logger.getLogger(ReflectionHelper.class);

	/**
	 * Gets an instance of a classname. The classname is provided by a @see
	 * String
	 * 
	 * @param className
	 * @return
	 */
	public static Object getObjectByClassName(String className) {
		Object targetObject = null;

		try {
			Class<?> clazz = Class.forName(className);
			targetObject = clazz.newInstance();
			if (!(targetObject instanceof ITarget)) {
				logger.error("The mapping target isn't instance of ITarget");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return targetObject;
	}

	/**
	 * Sets the default values of a class by invoking a method.
	 * 
	 * @param targetObject
	 * @param methodName
	 * @param methodValue
	 */
	public static void setStringValueByMethod(Object targetObject, String methodName, String methodValue) {

		try {

			BeanInfo info = Introspector.getBeanInfo(targetObject.getClass());

			for (PropertyDescriptor pd : info.getPropertyDescriptors()) {
				if (pd.getName().equals(methodName)) {
					pd.getWriteMethod().invoke(targetObject, methodValue);
				}

			}

		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (IntrospectionException e) {
			e.printStackTrace();
		}

	}

}
