package com.dayNineteen;

import java.util.HashMap;

public class MonsterMessage {

    public String solver() {
        HashMap<Integer, String> hmap = new HashMap<Integer, String>();
        hmap.put(0, "1");
        hmap.put(1, "3");
        hmap.put(2, "4");
        hmap.put(3, "a");
        hmap.put(4, "b");
        return hmap.get(Integer.parseInt(hmap.get(Integer.parseInt(hmap.get(0)))));
    }

}
