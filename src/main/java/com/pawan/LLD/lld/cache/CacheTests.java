package com.pawan.LLD.lld.cache;

/**
 * @author Pawan Saini
 * Created on 19/02/25.
 */
public class CacheTests {

    public static void main(String[] args) {
        CacheManager<Integer, String> cacheManager = new CacheManager<>();
        cacheManager.put("Cache1", 1, "Pawan");
        cacheManager.put("Cache1", 2, "Saini");
        cacheManager.put( "Cache1",3, "Hello");
        System.out.println(cacheManager.get("Cache1", 1));
        cacheManager.put("Cache1", 4, "World");
        System.out.println(cacheManager.get("Cache1", 1));
        System.out.println(cacheManager.get("Cache1", 2));
        cacheManager.put("Cache1", 5, "!!");
        System.out.println(cacheManager.get("Cache1", 5));
        System.out.println(cacheManager.get("Cache1", 1));


        cacheManager.put("Cache2", 1, "abc");
        cacheManager.put("Cache2", 2, "def");
        cacheManager.put( "Cache2",3, "ghi");
        System.out.println(cacheManager.get("Cache2", 1));
        cacheManager.put("Cache2", 4, "jkl");
        System.out.println(cacheManager.get("Cache2", 1));
        System.out.println(cacheManager.get("Cache2", 2));
        cacheManager.put("Cache2", 5, "!!");
        System.out.println(cacheManager.get("Cache2", 5));
        System.out.println(cacheManager.get("Cache2", 1));

        System.out.println(cacheManager.get("Cache1", 1));
    }
}
