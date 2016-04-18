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
public class TwoOptSecond extends Solver
{

    public House[] solve(House[] houses)
    {
        House[] x = houses;
        
        double cut = 0;
        House a, b, c, d;

        do
        {
            double oldDistance = Util.totalDistance(x);
            for (int i = 0; i < x.length - 1; i++)
            {
                a = ((i == 0) ? null : x[i - 1]);

                for (int k = i + 1; k < x.length; k++)
                {

                    b = x[i];

                    c = x[k];
                    d = ((k == x.length - 1) ? null : x[k + 1]);

                    double tempCut = Util.swapCut(a, b, c, d);

                    if (tempCut < 0)
                    {
                        House[] newRoute = twoOptSwap(x, i, k);
                        x = newRoute;
//                        break;

//                        System.out.println("Swapped houses " + i + x[i] + " and " + k + x[k]);
                    }
                }

            }
            double newDistance = Util.totalDistance(x);
            cut = newDistance - oldDistance;

            System.out.println("Optimized the path by " + (-cut) + "miles");

        } while (cut < 0);
        return x;
    }

    public static House[] twoOptSwap(House[] x, int i, int k)
    {
        House[] newPath = new House[x.length];
        int a = 0;
        for (int j = 0; j < x.length; j++)
        {
            newPath[j] = x[j];
        }
        for (int j = i; j <= k; j++)
        {
            newPath[j] = x[k - a];
            a++;
        }

        return newPath;
    }
}
