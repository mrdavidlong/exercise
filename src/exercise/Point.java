package exercise;

import java.util.Objects;

public class Point
{
    private final int x, y;

    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int getX() 
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

//    @Override
//    public boolean equals(Object other)
//    {
//        if (this == other)
//          return true;
//
//        if (!(other instanceof Point))
//          return false;
//
//        Point otherPoint = (Point) other;
//        return otherPoint.x == x && otherPoint.y == y;
//    }
//
//
//    @Override
//    public int hashCode()
//    {
//        //return (Integer.toString(x) + "," + Integer.toString(y)).hashCode();
//        int hash = 7;
//        hash = 71 * hash + this.x;
//        hash = 71 * hash + this.y;
//        return hash;
//    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        final Point other = (Point) o;
        return (this.x == other.x && this.y == other.y);
    }

}