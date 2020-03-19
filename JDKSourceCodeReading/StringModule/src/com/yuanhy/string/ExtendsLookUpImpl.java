package com.yuanhy.string;

import java.util.Map;

public class ExtendsLookUpImpl implements ExtendsLookUp {
    public Map<String, Object> map;


    @Override
    public Map<String, Object> add(String name, Object object) {
        map.put(name, object);
        return map;
    }

    @Override
    public Object remove(String name) {
        Object object = map.remove(name);
        return object;
    }

    @Override
    public Object find(String name) {
        Object object = map.get(name);
        return object;
    }
}
