package closestPair;

import java.util.Comparator;



public class Point2D implements Comparable<Point2D> {

    public static final Comparator<Point2D> X_ORDER = new XOrder();

    public static final Comparator<Point2D> Y_ORDER = new YOrder();

    private final double x;    
    private final double y;    

    
    public Point2D(double x, double y) {
        if (Double.isInfinite(x) || Double.isInfinite(y))
            throw new IllegalArgumentException("Coordinates must be finite");
        if (Double.isNaN(x) || Double.isNaN(y))
            throw new IllegalArgumentException("Coordinates cannot be NaN");
        if (x == 0.0){
        	x = 0.0;  
        }
        if (y == 0.0){
        	y = 0.0;  
        }
        this.x = x;
        this.y = y;
    }

    public double x() {
        return x;
    }

    public double y() {
        return y;
    }

    public double distanceTo(Point2D that) {
        double distanceX = this.x - that.x;
        double distanceY = this.y - that.y;
        return Math.sqrt(distanceX*distanceX + distanceY*distanceY);
    }

    public int compareTo(Point2D that) {
    	if (this.y < that.y){
    		return -1;
    	}
        if (this.y > that.y){
        	return +1;
        }
        if (this.x < that.x){
        	return -1;
        }
        if (this.x > that.x){
        	return +1;
        }
        return 0;
    }

    private static class XOrder implements Comparator<Point2D> {
        public int compare(Point2D p, Point2D q) {
            if (p.x < q.x){
            	return -1;
            }
            if (p.x > q.x){
            	return +1;
            }
            return 0;
        }
    }

    private static class YOrder implements Comparator<Point2D> {
        public int compare(Point2D p, Point2D q) {
            if (p.y < q.y){
            	return -1;
            }
            if (p.y > q.y){
            	return +1;
            }
            return 0;
        }
    }

    public boolean equals(Object other) {
        if (other == this){
        	return true;
        }
        if (other == null){
        	return false;
        }
        if (other.getClass() != this.getClass()){
        	return false;
        }
        Point2D that = (Point2D) other;
        return this.x == that.x && this.y == that.y;
    }

    public String toString() {
        return "(" + (int) x + ", " + (int) y + ")";
    }
}
