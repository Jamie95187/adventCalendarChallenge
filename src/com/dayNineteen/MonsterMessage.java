package com.dayNineteen;

import java.util.HashMap;

public class MonsterMessage {

    public String solver() {
        HashMap<Integer, String> hmap = new HashMap<Integer, String>();
        hmap.put(0, "1");
        hmap.put(1, "a");
        return hmap.get(Integer.parseInt(hmap.get(0)));
    }
}
