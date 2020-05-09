package com.example.dynamic.util;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.Map.Entry;

public class CollectionUtils {

    /** 
     * 判断一个集合是否为空
     */
    public static <T> boolean isEmpty(Collection<T> col) {
        if (col == null || col.size() == 0) {
            return true;
        }
        return false;
    }

    /** 
     * 判断一个集合是否不为空
     */
    public static <T> boolean isNotEmpty(Collection<T> col) {
        if (col != null && col.size() >= 1) {
            return true;
        }
        return false;
    }

    /**
     * 检查一个整形数组是否非空
     *
     * @param array 整形数组
     * @return
     */
    public static boolean isNotEmpty(int[] array) {
        return array != null && array.length >= 1;
    }

    /**
     * 检查一个对象数组是否为空
     *
     * @param array 对象数组
     * @return
     */
    public static boolean isEmpty(Object[] array) {
        return array == null || array.length == 0;
    }

    /**
     * 检查一个对象数组是否非空
     *
     * @param array 对象数组
     * @return
     */
    public static boolean isNotEmpty(Object[] array) {
        return array != null && array.length >= 1;
    }

    // 判断Map是否为空
    public static <K, V> boolean isEmpty(Map<K, V> map) {
        if (map == null || map.isEmpty()) {
            return true;
        }

        return false;
    }

    // 判断Map是否不为空为空
    public static <K, V> boolean isNotEmpty(Map<K, V> map) {
        return !isEmpty(map);
    }

    // 去除list中的重复数据
    public static <T> List<T> removeRepeat(List<T> list) {
        if (isEmpty(list)) {
            return list;
        }

        List<T> result = new ArrayList<T>();
        for (T e : list) {
            if (!result.contains(e)) {
                result.add(e);
            }
        }

        return result;
    }

    // 将集合转换为String数组
    public static <T> String[] toArray(List<T> list) {
        if (isEmpty(list)) {
            return null;
        }

        String[] result = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = String.valueOf(list.get(i));
        }

        return result;
    }

    /**
     * 从目标数组中移除某索引
     *
     * @param objs 目标数组
     * @param removeIdx 待移除的索引，下标从0开始
     * @return 移除某索引之后的数组
     */
    public static String[] remove(String[] objs, int removeIdx) {
        if (objs == null || objs.length < removeIdx) {
            return objs;
        }
        String[] afterObjs = new String[objs.length - 1];
        int i = 0;
        int j = 0;
        int length = afterObjs.length;
        for (; i < length; i++, j++) {
            if (i == removeIdx) {
                j = i + 1;
            }
            afterObjs[i] = objs[j];
        }
        return afterObjs;
    }

    /**
     * 从目标数组中移除某索引
     *
     * @param objs 目标数组
     * @param removeIdx 待移除的索引，下标从0开始
     * @return 移除某索引之后的数组
     */
    public static Integer[] remove(Integer[] objs, int removeIdx) {
        if (objs == null || objs.length < removeIdx) {
            return objs;
        }
        Integer[] afterObjs = new Integer[objs.length - 1];
        int i = 0;
        int j = 0;
        int length = afterObjs.length;
        for (; i < length; i++, j++) {
            if (i == removeIdx) {
                j = i + 1;
            }
            afterObjs[i] = objs[j];
        }
        return afterObjs;
    }

    /**
     * 根据value的值大小进行升序
     */
    public static Map<String, Integer> sortAscByValue(Map<String, Integer> map) {
        List<Entry<String, Integer>> lists = new ArrayList<Entry<String, Integer>>(map.entrySet());
        Collections.sort(lists, new Comparator<Entry<String, Integer>>() {
            @Override
            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        Map<String, Integer> result = new LinkedHashMap<String, Integer>();
        for (Entry<String, Integer> set : lists) {
            result.put(set.getKey(), set.getValue());
        }
        return result;
    }


    /**
     * 根据value的值大小进行降序
     */
    public static Map<String, Integer> sortDescByValue(Map<String, Integer> map) {
        List<Entry<String, Integer>> lists = new ArrayList<Entry<String, Integer>>(map.entrySet());
        Collections.sort(lists, new Comparator<Entry<String, Integer>>() {
            @Override
            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
                int q1 = o1.getValue();
                int q2 = o2.getValue();
                int p = q2 - q1;
                if (p > 0) {
                    return 1;
                }
                else if (p == 0) {
                    return 0;
                }
                else {
                    return -1;
                }
            }
        });

        Map<String, Integer> result = new LinkedHashMap<String, Integer>();
        for (Entry<String, Integer> set : lists) {
            result.put(set.getKey(), set.getValue());
        }
        return result;
    }

    /**
     * 根据key的值大小进行升序
     */
    public static Map<String, String> sortAscBykey(Map<String, String> map) {
    	List<Entry<String, String>> lists = new ArrayList<Entry<String, String>>(map.entrySet());
        Collections.sort(lists, new Comparator<Entry<String, String>>() {
            @Override
            public int compare(Entry<String, String> o1, Entry<String, String> o2) {
                return (o1.getKey()).compareTo(o2.getKey());
            }
        });

        Map<String, String> result = new LinkedHashMap<String, String>();
        for (Entry<String, String> set : lists) {
            result.put(set.getKey(), set.getValue());
        }
        return result;
    }
    /**
     * 根据key的值大小进行降序
     */
	public static Map<String, String> sortDescByKey(Map<String, String> map) {
		List<Entry<String, String>> lists = new ArrayList<Entry<String, String>>(map.entrySet());
        Collections.sort(lists, new Comparator<Entry<String, String>>() {
            @Override
            public int compare(Entry<String, String> o1, Entry<String, String> o2) {
                int q1 = Integer.parseInt(o1.getKey());
                int q2 = Integer.parseInt(o2.getKey());
                int p = q2 - q1;
                if (p > 0) {
                    return 1;
                }
                else if (p == 0) {
                    return 0;
                }
                else {
                    return -1;
                }
            }
        });

        Map<String, String> result = new LinkedHashMap<String, String>();
        for (Entry<String, String> set : lists) {
            result.put(set.getKey(), set.getValue());
        }
        return result;
		
	}

    /**
     * 转换JavaBean至TreeMap
     * @param t
     * @param <T>
     * @return
     * @throws IllegalAccessException
     */
	public static <T> TreeMap<String, String> convertBeanToTreeMap(T t) throws IllegalAccessException {
	    if (t == null) {
	        return null;
        }
	    TreeMap<String, String> treeMap = new TreeMap<>();
	    Class clazz = t.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            treeMap.put(field.getName(), (String)field.get(t));
        }
        return treeMap;
    }

	/**
	 * Map转化成JavaBean
	 *
	 * @param map
	 * @param bean
	 * @return
	 */
    public static <T> T mapToBean(Map<String, Object> map, T bean) {
        if (map == null) {
            return null;
        }
        if (bean == null) {
            return null;
        }
        try {
            org.apache.commons.beanutils.BeanUtils.populate(bean, map);
        }
        catch (IllegalAccessException | InvocationTargetException ex) {
            ex.printStackTrace();
        }
        return bean;
    }

}