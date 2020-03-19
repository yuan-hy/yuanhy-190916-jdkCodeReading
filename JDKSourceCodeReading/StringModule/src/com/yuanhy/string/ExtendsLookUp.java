package com.yuanhy.string;

import java.util.Map;

public interface ExtendsLookUp extends LookUp {

    Map<String, Object> add(String name,Object object);

    Object remove(String name);
}
