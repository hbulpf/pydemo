# BitSet

1. Check if the integer is even or odd
```
if ((x & 1) == 0) {
    x is even
} else {
    x is odd
}
```


2. Test if the n-th bit is set
```
if (x & (1 << n)) {
    n-th bit is set
} else {
    n-th bit is not set
}
```


3. Set the n-th bit
```
y = x | (1 << n)
```


4. Unset the n-th bit
```
y = x & ~(1 << n)
```


5. Toggle the n-th bit
```
y = x ^ (1 << n)
```


6. Turn off the rightmost 1-bit，将最右边的1清零
```
y = x & (x - 1)
```


7. Isolate the rightmost 1-bit，留下最右边的1，其余位都置为0
```
y = x & (-x)
```


8. Right propagate the rightmost 1-bit，将最右边的1的右边全部置为1
```
y = x | (x - 1)
```


9. Isolate the rightmost 0-bit，将最右边的0置为1，其余位都置为0
```
y = ~x & (x + 1)
```


10. Turn on the rightmost 0-bit，将最右边的0置为1
```
y = x | (x + 1)
```