package com.ibm.mom.reference;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.WeakHashMap;

/**
 * WeakHashMap的特点是，当除了自身有对key的引用外，此key没有其他引用那么此map会自动丢弃此值;
 * 
 * 见实例：此例子中声明了两个Map对象，一个是HashMap，一个是WeakHashMap，
 * 同时向两个map中放入a、b两个对象，当HashMap  remove掉a 并且将a、b都指向null时，WeakHashMap中的a将自动被回收掉。
 * 出现这个状况的原因:对于a对象而言，当HashMap  remove掉并且将a指向null后，除了WeakHashMap中还保存a外,
 * 已经没有指向a的指针了，所以WeakHashMap会自动舍弃掉a;
 * 而对于b对象，虽然指向了null，但HashMap中还有指向b的指针，所以WeakHashMap将会保留.
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

