package test;

import MyHashMap.HashMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HashMapTest {
    private HashMap<String,Integer> map;
    @BeforeEach
    void setUp () {
        map = new HashMap<>();
        map.put("Роберт", 18);
        map.put("Марат", 80);
        map.put("Михаил", 30);
    }
    @Test
    void put () {
        map.put("Амир", 30);
        Assertions.assertTrue(map.containsKey("Амир"));
    }
    @Test
    void containsKey() {
        map.put("Алексей", 41);
        Assertions.assertTrue(map.containsKey("Алексей"));
    }
    @Test
    void containsValue () {
        Assertions.assertTrue(map.containsValue(30));
    }
    @Test
    void remove () {
        Assertions.assertEquals(80, map.remove("Марат"));
        Assertions.assertFalse(map.containsKey("Марат"));
    }
    @Test
    void get () {
        Assertions.assertEquals(80, map.get("Марат"));
    }
    @Test
    void size () {
        Assertions.assertEquals(3,map.size());
    }

}