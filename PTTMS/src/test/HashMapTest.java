package test;

import java.util.HashMap;

public class HashMapTest {
    public static void main(String[] args) {
        // 创建 HashMap 对象 Sites
        HashMap<Integer, String> Sites = new HashMap<Integer, String>();
        // 添加键值对
        Sites.put(1, "Google");
        Sites.put(2, "Runoob");
        Sites.put(3, "Taobao");
        Sites.put(4, "Zhihu");
        System.out.println(Sites);

        if (Sites.containsKey(1)) {
          System.out.println("exist 1");
        }
				System.out.println(Integer.parseInt("-1"));
    }
}