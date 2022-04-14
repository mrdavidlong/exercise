package exercise;

public class ClosestPoint {
	public static void main(String[] args) {
		Point c = new Point(1,1);
		Point p1 = new Point(2,2);
		Point p2 = new Point(3,3);
		Point p3 = new Point(4,4);
		Point[] pArray = new Point[] {p1, p2, p3};
		
		Point cloestPoint = getClosestPoint(c, pArray);
	}
	
	public static Point getClosestPoint(Point curPoint, Point[] pArray) {
		double minDistance = Double.MAX_VALUE;
		double distance = 0.0;
		Point minPoint = null;
		for (Point p : pArray) {
			distance = getDistance(curPoint, p);
			if (distance < minDistance) {
				minDistance = distance;
				minPoint = p;
			}
		}
		return minPoint;
	}
	
	public static double getDistance(Point p1, Point p2) {
		double distance = 0.0;
		
		double x = Math.abs(p1.getX() - p2.getX());
		double y = Math.abs(p1.getY() - p2.getY());
		distance = Math.sqrt(x*x + y*y);
		
		return distance;
	}
	
}
