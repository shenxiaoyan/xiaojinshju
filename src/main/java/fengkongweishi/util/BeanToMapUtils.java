package fengkongweishi.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @author jianger
 * @Description bean转Map
 * @Date 2018/2/1 上午10:30
 **/
public class BeanToMapUtils {


    /**
     * 将一个bean转换为一个map
     * 其父类的getter和字段无法自动获取到，只能手动补齐，又或者指明字段名，也可以获取到值
     *
     * @return
     */
    public static Map<String, Object> beanToMap(Object bean) {
        Map<String, Object> result = new HashMap<>();
        if (bean == null) {
            return result;
        }
        Class<?> cls = bean.getClass();
        // 取出bean里的所有方法
        Method[] methods = cls.getDeclaredMethods();
        Field[] fields = cls.getDeclaredFields();
        return getValuesFromMethodsWithFields(methods, fields, bean);
    }

    /**
     * 将一个bean转换为一个map,包括父类
     * @param bean
     * @return
     */
    public static Map<String, Object> beanToMapWithSuper(Object bean) {
        Map<String, Object> result = new HashMap<>();
        if (bean == null) {
            return result;
        }
        // 取出bean里的所有方法
        Method[] methods = getAllMethods(bean);
        Field[] fields = getAllFields(bean);
        return getValuesFromMethodsWithFields(methods, fields, bean);
    }

    private static Field[] getAllFields(Object object){
        Class clazz = object.getClass();
        List<Field> fieldList = new ArrayList<>();
        while (clazz != null){
            fieldList.addAll(new ArrayList<>(Arrays.asList(clazz.getDeclaredFields())));
            clazz = clazz.getSuperclass();
        }
        Field[] fields = new Field[fieldList.size()];
        fieldList.toArray(fields);
        return fields;
    }

    private static Method[] getAllMethods(Object object) {
        Class clazz = object.getClass();
        List<Method> methodList = new ArrayList<>();
        while (clazz != null){
            methodList.addAll(new ArrayList<>(Arrays.asList(clazz.getDeclaredMethods())));
            clazz = clazz.getSuperclass();
        }
        Method[] methods = new Method[methodList.size()];
        methodList.toArray(methods);
        return methods;
    }


    private static Map<String, Object> getValuesFromMethodsWithFields(Method[] methods, Field[] fields, Object bean) {
        Map<String, Object> result = new HashMap<>();
        Class<?> cls = bean.getClass();
        for (Field field : fields) {
            try {
                String fieldGetName = parGetName(field.getName());
                if (!checkGetMet(methods, fieldGetName)) {
                    continue;
                }
                Method fieldGetMet = cls.getMethod(fieldGetName, new Class[]{});
                Object fieldVal = fieldGetMet.invoke(bean, new Object[]{});
                result.put(field.getName(), fieldVal);
            } catch (Exception e) {
                result.put(field.getName(), null);
                continue;
            }
        }
        return result;
    }


    private static boolean checkGetMet(Method[] methods, String fieldGetMet) {
        for (Method met : methods) {
            if (fieldGetMet.equals(met.getName())) {
                return true;
            }
        }
        return false;
    }

    private static String parGetName(String fieldName) {
        if (null == fieldName || "".equals(fieldName)) {
            return null;
        }
        return "get" + fieldName.substring(0, 1).toUpperCase()
                + fieldName.substring(1);
    }


}
