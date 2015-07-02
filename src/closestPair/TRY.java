package closestPair;



class MyBool{
	
private boolean _v;
public MyBool(boolean v) { set(v); }
public void set(boolean v) { _v = v; }
public boolean get() { return _v; }
public boolean equals(Object that) {
return (that instanceof MyBool)
&& (this.get() == ((MyBool) that).get());
}
}
public class TRY {
public static void main(String[] args) {
MyBool x = new MyBool(false);
MyBool y = x;
System.out.println( (x.equals(y)) + "," + (x == y) );
y.set(true);
System.out.println( (x.equals(y)) + "," + (x == y) );
MyBool u = new MyBool(false);
MyBool v = new MyBool(false);
System.out.println( (u.equals(v)) + "," + (u == v) );
v.set(true);
System.out.println( (u.equals(v)) + "," + (u == v) );
}
}