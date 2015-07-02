
//Jim Gurgone
//CSC-421
//Closest Pair Programming Assignment 1





package closestPair;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws FileNotFoundException{

		int N1 = 10;
		Scanner in1 = new Scanner(new File("10points_test.txt"));
  
		Point2D[] points1 = new Point2D[N1];
		for (int i = 0; i < N1; i++) {
			double x = in1.nextDouble();
			double y = in1.nextDouble();
			points1[i] = new Point2D(x, y);
		}
		
		ClosestPair closest1 = new ClosestPair(points1);
        System.out.println("10 points test file:");
		System.out.println("The Minimum Distance is:");
		System.out.printf("%.9f: ",  closest1.distance());
		System.out.println((closest1.either() + "<--->" + closest1.other()));
		System.out.println();
		in1.close();
		
//------------------------------------------------------------------------------------
		
		int N2 = 100;
		Scanner in2 = new Scanner(new File("100points_test.txt"));
  
		Point2D[] points2 = new Point2D[N2];
		for (int i = 0; i < N2; i++) {
			double x = in2.nextDouble();
			double y = in2.nextDouble();
			points2[i] = new Point2D(x, y);
		}
		
		ClosestPair closest2 = new ClosestPair(points2);
        System.out.println("100 points test file:");
		System.out.println("The Minimum Distance is:");
		System.out.printf("%.10f: ",  closest2.distance());
		System.out.println(closest2.either() + "<--->" + closest2.other());
		System.out.println();
		in2.close();
		
//---------------------------------------------------------------------------------
		
		int N3 = 1000;
		Scanner in3 = new Scanner(new File("1000points_test.txt"));

		Point2D[] points3 = new Point2D[N3];
		for (int i = 0; i < N3; i++) {
			double x = in3.nextDouble();
			double y = in3.nextDouble();
			points3[i] = new Point2D(x, y);
		}
	
		ClosestPair closest3 = new ClosestPair(points3);
        System.out.println("1000 points test file:");
		System.out.println("The Minimum Distance is:");
		System.out.printf("%.9f: ",  closest3.distance());
		System.out.println(closest3.other() + "<--->" + closest3.either());
		System.out.println();
		in3.close();
	}
}
