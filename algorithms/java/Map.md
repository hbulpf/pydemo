# Java 8之Map新增方法

# getOrDefault

```
map.getOrDefault("one", "s");
```

# forEach

```
map.forEach(new BiConsumer<String, String>() {
    @Override
    public void accept(String key, String value) {
        System.out.println(key + ", " + value);
    }
});
```

# replace(K key, V newValue)

类似

```
if (map.containsKey(key)) {
    return map.put(key, newValue);
} else {
    return null;
}
```


# replace(K key, V oldValue, V newValue);

如果key和oldValue都匹配，则替换成newValue。类似：

```
if (map.containsKey(key) && Objects.equals(map.get(key), oldValue)) {
    map.put(key, newValue);
    return true;
} else {
    return false;
}
```

# replaceAll
替换Map中所有Entry的value值，这个值由旧的key和value计算得出

```
map.replaceAll(new BiFunction<String, String, String>() {
    @Override
    public String apply(String key, String value) {
        if (key.equals("two")) {
            return value + ".old";
        }
        return value;
    }
});
```

类似如下代码：

```
for (Entry entry : map.entrySet()) {
    entry.setValue(function.apply(entry.getKey(), entry.getValue()));
}
```

# putIfAbsent(K key, V value)

如果key不存在，则put，并返回null。如果key存在，则什么也不做，返回key对应的value

```
map.putIfAbsent("four", "charge");
```

# remove(K key, V value)

```
map.remove(key, value);
```

类似：

```
if (map.containsKey(key) && Objects.equals(map.get(key), value)) {
    map.remove(key);
    return true;
} else {
    return false;
}
```

# computeIfAbsent(K key, Function f)

```
String s = map.computeIfAbsent("four", new Function<String, String>() {
    @Override
    public String apply(String key) {
        return key + "@";
    }
});
```

类似

```
if (map.get(key) == null) {
    V newValue = function.apply(key);
    if (newValue != null) {
        map.put(key, newValue);
        return newValue;
    }
} else {
    return map.get(key);
}
```

# computeIfPresent(K key, BiFunction f)

```
map.computeIfPresent("one", new BiFunction<String, String, String>() {
    @Override
    public String apply(String key, String value) {
        return null;
    }
});
```

类似：

```
if (map.get(key) != null) {
    V oldValue = map.get(key);
    V newValue = function.apply(key, oldValue);
    if (newValue != null) {
        map.put(key, newValue);
    } else {
        map.remove(key);
    }
    return newValue;
} else {
    return null;
}
```

# compute(K key, BiFunction f)

```
map.compute(key, new BiFunction<String, String, String>() {
    @Override
    public String apply(String key, String value) {
        return key + "@" + value;
    }
});
```

类似：

```
V oldValue = map.get(key);
V newValue = function.apply(key, value);

if (oldValue != null) {
    if (newValue != null) {
        map.put(key, newValue);
    } else {
        map.remove(key);
    }
} else {
    if (newValue != null) {
        map.put(key, newValue);
    }
}
return newValue;
```

# merge(K key, V value, BiFunction f)

apply中第一个参数是oldValue，第二个参数是merge传入的第二个参数

```
map.merge(key, value, new BiFunction<String, String, String>() {
    @Override
    public String apply(String oldValue, String value) {
        return oldValue + "@" + value;
    }
});
```

类似：

```
if (value == null) {
    throw new NullPointerException();
}

V oldValue = map.get(key);
V newValue = (oldValue == null) ? value : function.apply(oldValue, value);

if (newValue == null) {
    map.remove(key);
} else {
    map.put(key, newValue);
    return newValue;
}
```
