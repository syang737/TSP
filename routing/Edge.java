/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package routing;

/**
 *
 * @author simon.yang
 */
public class Edge
{
    private double length;
    private House point1;
    private House point2;

    public Edge(House a, House b)
    {
        this.setPoint1(a);
        this.setPoint2(b);
        this.setLength();
    }
    public void setLength()
    {
        this.length = Math.abs(Math.sqrt(Math.pow((point2.getYdistance() - point1.getYdistance()), 2) + Math.pow((point2.getXdistance() - point1.getXdistance()), 2)));
    }

    public void setPoint1(House point1)
    {
        this.point1 = point1;
    }

    public void setPoint2(House point2)
    {
        this.point2 = point2;
    }

    public double getLength()
    {
        return length;
    }

    public House getPoint1()
    {
        return point1;
    }

    public House getPoint2()
    {
        return point2;
    }
    
}
