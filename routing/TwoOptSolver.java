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
public class TwoOptSolver extends Solver
{

    public House[] solve(House[] houses)
    {
        House[] x = houses;

        double cut;

        do
        {
            cut = 0;
            for (int i = 0; i < x.length - 1; i++)
            {
                double oldDistance = Util.totalPythagoreanDistance(x);
                for (int k = i + 1; k < x.length; k++)
                {
                    House[] newRoute = twoOptSwap(x, i, k);
                    double newDistance = Util.totalPythagoreanDistance(newRoute);
                    if (newDistance < oldDistance)
                    {
                        x = newRoute;
                        
                        cut = newDistance - oldDistance;
                    }
                }

            }
            System.out.println("Optimized the path by " + (-cut) + "feet");

        } while (cut < 0);
        return houses;
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
