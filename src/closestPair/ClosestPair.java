package closestPair;


import java.util.Arrays;


public class ClosestPair {

	private Point2D closest1, closest2;
    private double bestDistance = Double.POSITIVE_INFINITY;

    public ClosestPair(Point2D[] points) {
        int N = points.length;
        if (N <= 3) return;

        Point2D[] sortByX = new Point2D[N];
        for (int i = 0; i < N; i++){ 
        	sortByX[i] = points[i];
        }
        Arrays.sort(sortByX, Point2D.X_ORDER);

        for (int i = 0; i < N-1; i++) {
            if (sortByX[i].equals(sortByX[i+1])) {
                bestDistance = 0.0;
                closest1 = sortByX[i];
                closest2 = sortByX[i+1];
                return;
            }
        }

        Point2D[] sortByY = new Point2D[N];
        for (int i = 0; i < N; i++){
        	sortByY[i] = sortByX[i];
        }

        Point2D[] auxArray = new Point2D[N];

        closest(sortByX, sortByY, auxArray, 0, N-1);
    }

    private double closest(Point2D[] sortByX, Point2D[] sortByY, Point2D[] auxArray, int lo, int hi) {
        if (hi <= lo){
        	return Double.POSITIVE_INFINITY;
        }

        int mid = lo + (hi - lo) / 2;
        Point2D median = sortByX[mid];

        double delta1 = closest(sortByX, sortByY, auxArray, lo, mid);
        double delta2 = closest(sortByX, sortByY, auxArray, mid+1, hi);
        double delta = Math.min(delta1, delta2);

        merge(sortByY, auxArray, lo, mid, hi);

        int N = 0;
        for (int i = lo; i <= hi; i++) {
            if (Math.abs(sortByY[i].x() - median.x()) < delta)
                auxArray[N++] = sortByY[i];
        }

        for (int i = 0; i < N; i++) {
            for (int j = i+1; (j < N) && (auxArray[j].y() - auxArray[i].y() < delta); j++) {
                double distance = auxArray[i].distanceTo(auxArray[j]);
                if (distance < delta) {
                    delta = distance;
                    if (distance < bestDistance) {
                        bestDistance = delta;
                        closest1 = auxArray[i];
                        closest2 = auxArray[j];
                    }
                }
            }
        }
        return delta;
    }

    public Point2D either() 
    { 
    	return closest1; 
    }
    public Point2D other()  
    { 
    	return closest2; 
    }

    public double distance() {
        return bestDistance;
    }

	private static boolean less(Comparable a, Comparable b) {
        return (a.compareTo(b) < 0);
    }

    private static void merge(Comparable[] a, Comparable[] auxArray, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++) {
            auxArray[k] = a[k];
        }
    
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)              a[k] = auxArray[j++];
            else if (j > hi)               a[k] = auxArray[i++];
            else if (less(auxArray[j], auxArray[i])) a[k] = auxArray[j++];
            else                           a[k] = auxArray[i++];
        }
    }
}

