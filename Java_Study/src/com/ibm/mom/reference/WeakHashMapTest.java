package com.ibm.mom.reference;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.WeakHashMap;

/**
 * WeakHashMap���ص��ǣ������������ж�key�������⣬��keyû������������ô��map���Զ�������ֵ;
 * 
 * ��ʵ����������������������Map����һ����HashMap��һ����WeakHashMap��
 * ͬʱ������map�з���a��b�������󣬵�HashMap  remove��a ���ҽ�a��b��ָ��nullʱ��WeakHashMap�е�a���Զ������յ���
 * �������״����ԭ��:����a������ԣ���HashMap  remove�����ҽ�aָ��null�󣬳���WeakHashMap�л�����a��,
 * �Ѿ�û��ָ��a��ָ���ˣ�����WeakHashMap���Զ�������a;
 * ������b������Ȼָ����null����HashMap�л���ָ��b��ָ�룬����WeakHashMap���ᱣ��.
 */
public class WeakHashMapTest {  
    public static void main(String[] args) throws Exception {  
        String a = new String("a");  
        String b = new String("b");  
        Map<String, String> map = new HashMap<String, String>();  
        Map<String, String> weakmap = new WeakHashMap<String, String>();  
        
        map.put(a, "aaa");  
        map.put(b, "bbb");  
          
        weakmap.put(a, "aaa");  
        weakmap.put(b, "bbb");  

        map.remove(a);  

        a=null;  
        b=null;  

        System.gc();  
        
        Iterator<Entry<String, String>> i = map.entrySet().iterator();  
        while (i.hasNext()) {  
            Map.Entry<String, String> entry = (Map.Entry<String, String>)i.next();  
            System.out.println("map:"+entry.getKey()+":"+entry.getValue());  
        }  

        Iterator<Entry<String, String>> j = weakmap.entrySet().iterator();  
        while (j.hasNext()) {  
            Map.Entry<String, String> entry = (Map.Entry<String, String>)j.next();  
            System.out.println("weakmap:"+entry.getKey()+":"+entry.getValue());  
        }  
    }  
      
}  

