package com.sven.util;


import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

/**
 * 增强的BeanUtils类
 * 
 * @author zgh zghlx@163.com
 * @date 2016年4月6日 下午12:41:51
 */
public class BeanUtils extends org.springframework.beans.BeanUtils{
	
	/**
	 * 获取指定对象的空值属性
	* @param source
	* @return
	* @author zgh zghlx@163.com 
	* @date 2016年4月6日 下午12:42:12
	 */
	public static String[] getEmptyValuePropertyNames (Object source) {
	    final BeanWrapper src = new BeanWrapperImpl(source);
	    java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

	    Set<String> emptyNames = new HashSet<String>();
	    for(java.beans.PropertyDescriptor pd : pds) {
	        Object srcValue = src.getPropertyValue(pd.getName());
	        if (srcValue == null || 
	        		(srcValue instanceof String && "".equals(String.valueOf(srcValue))) ||
	        		srcValue instanceof Number && 0== Long.valueOf(String.valueOf(srcValue))
	        		) 
	        	emptyNames.add(pd.getName());
	    }
	    String[] result = new String[emptyNames.size()];
	    return emptyNames.toArray(result);
	}

	/**
	 * 复制对象属性值，忽略空值
	* @param src 源对象
	* @param target 目标对象
	* @author zgh zghlx@163.com 
	* @date 2016年4月6日 下午12:49:57
	 */
	public static void CopyNotEmptyProperties(Object src, Object target) {
		org.springframework.beans.BeanUtils.copyProperties(src, target, getEmptyValuePropertyNames(src));
	}
	
	/**
	 * 将bean的属性名及属性值封装成map
	 * @param bean对象
	 * @return bean的属性名及属性值Map
	 * @author zgh zghlx@163.com 
	 * @date 2016年5月16日 上午9:59:11
	 */
	public static Map<String,Object> tarnsBeanPropertiesToMap(Object obj){
		Map<String,Object> propertyValueMap = new HashMap<String,Object>();
		Field[] fields = obj.getClass().getDeclaredFields();
		for(Field field : fields){
			field.setAccessible(true);
			try {
				if("serialVersionUID".equals(field.getName())){
					continue;
				}
				propertyValueMap.put(field.getName(), field.get(obj));
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return propertyValueMap;
	}
	
	
	/**
	 * 属性名及属性值封map装成bean
	 * @param propertyValueMap
	 * @param clazz
	 * @return
	 * @author zgh zghlx@163.com 
	 * @date 2016年5月21日 下午2:12:10
	 */
	public static <T> T transMapToBeanProperties(Map<String,Object> propertyValueMap, Class<T> clazz){
		T entity = null;
		try {
			entity = clazz.newInstance();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		Field[] fields = clazz.getDeclaredFields();
		for(Field field : fields){
			field.setAccessible(true);
			if(propertyValueMap.containsKey(field.getName())){
				try {
					field.set(entity, propertyValueMap.get(field.getName()));
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
		return entity;
	}
	
	/*public static Map<String,Object> tarnsPropertiesToMap(Class<?> clazz){
		BeanInfo beanInfo = null;
		try {
			beanInfo = Introspector.getBeanInfo(clazz);
		} catch (IntrospectionException e) {
			e.printStackTrace();
		}
		PropertyDescriptor[] propertyDesc = beanInfo.getPropertyDescriptors();
		for (int i = 0; i < propertyDesc.length; i++) {
			if (propertyDesc[i].getName().compareToIgnoreCase("class") == 0){
				continue;
			}
			String column = propertyDesc[i].getName();
			propertyDesc[i].getv
			Object strValue = userMap.get(column);
			
			Method method = propertyDesc[i].getWriteMethod();
			if(method != null){
				
			}

			System.out.println(strValue);


			if (strValue != null) {

				Object[] oParam = new Object[] {};

				Method mr = propertyDesc[i].getWriteMethod();

				if (mr != null) {

					oParam = new Object[] { (strValue) };

					try {

						// 注意这里的参数。

						mr.invoke(bean, oParam);

					} catch (IllegalArgumentException iea) {

						System.out.println("参数错误。");

						iea.printStackTrace();

					}


				}

			}

		}
	}*/
}
