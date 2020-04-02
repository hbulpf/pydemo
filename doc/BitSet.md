#### **1. Check if the integer is even or odd**
```
if ((x & 1) == 0) {
    x is even
} else {
    x is odd
}
```
<br/>

#### **2. Test if the n-th bit is set**
```
if (x & (1 << n)) {
    n-th bit is set
} else {
    n-th bit is not set
}
```
<br/>

#### **3. Set the n-th bit**
```
y = x | (1 << n)
```
<br/>

#### **4. Unset the n-th bit**
```
y = x & ~(1 << n)
```
<br/>

#### **5. Toggle the n-th bit**
```
y = x ^ (1 << n)
```
<br/>

#### **6. Turn off the rightmost 1-bit，将最右边的1清零**
```
y = x & (x - 1)
```
<br/>

#### **7. Isolate the rightmost 1-bit，留下最右边的1，其余位都置为0**
```
y = x & (-x)
```
<br/>

#### **8. Right propagate the rightmost 1-bit，将最右边的1的右边全部置为1**
```
y = x | (x - 1)
```
<br/>

#### **9. Isolate the rightmost 0-bit，将最右边的0置为1，其余位都置为0**
```
y = ~x & (x + 1)
```
<br/>

#### **10. Turn on the rightmost 0-bit，将最右边的0置为1**
```
y = x | (x + 1)
```