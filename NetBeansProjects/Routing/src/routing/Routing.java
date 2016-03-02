/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package routing;

import java.io.*;

/**
 *
 * @author simon.yang
 */
public class Routing
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        int n = 0;

        House[] path = new House[20];
        House start = new House(10, 5, "JJ");
        House[] x = new House[20];
        House temp = new House(1, 1, "A");
        House c = new House(2,1,"C");
        House d = new House(2,1,"D");
        House e = new House(2,1,"E");
        House f = new House(2,1,"F");
        House g = new House(2,1,"G");
        House h = new House(2,1,"H");
        House ii = new House(2,1,"I");
        House j = new House(2,1,"J");
        House[] test = new House[8];
        test[0] = c;
        test[1] = d;
        test[2] = e;
        test[3] = f;
        test[4] = g;
        test[5] = h;
        test[6] = ii;
        test[7] = j;
        
        
        
//        for (int i = 0; i < 20; i++)
//        {
//            x[i] = new House();
//        }
//        for (int i = 0; i < 20; i++)
//        {
//            x[i].setAvenue((int) (Math.random() * 5 + 1));
//            x[i].setStreet((int) (Math.random() * 10 + 1));
//            System.out.println((int) (Math.random() * 10 + 1));
//            x[i].setLdistance((int) (Math.random() * 10) * 100);
//        }
        
//        for (int i = 0; i < 20; i++)
//        {
//            if (pythagoreanOrigin(x[i]) < pythagoreanOrigin(start))
//            {
//                start = x[i];
//            }
//        }
        for (int i = 0; i < 8; i++)
        {
            for (int a = 1; a < 7; a++)
            {
                if (pythagoreanDistance(test[i], test[a]) < pythagoreanDistance(test[i], test[a + 1]))
                {
                    temp = test[a];
                }
            }
            path[i] = temp;
            for (int b = 0; b < 7; b++)
            {
                if (temp.equals(test[b]))
                {
                    i = b;
                }
            }
        }

        System.out.println("Route:");
        for (int i = 0; i < 8; i++)
        {

            System.out.println("House " + i);

            System.out.println(path[i].getAvenue());
            System.out.println(path[i].getStreet());
            System.out.println(path[i].getLetter());
            System.out.println(pythagoreanDistance(path[i], path[i + 1]));
        }

    }

    public static double pythagoreanOrigin(House x)
    {
        double pDistance = Math.sqrt(Math.pow(x.getYdistance(), 2) + Math.pow(x.getXdistance(), 2));
        return pDistance;
    }

    public static double pythagoreanDistance(House x, House y)
    {
        double pDistance = Math.abs(Math.sqrt(Math.pow((x.getYdistance() - y.getYdistance()), 2) + Math.pow((x.getXdistance() - y.getXdistance()), 2)));
        return pDistance;
    }

}
