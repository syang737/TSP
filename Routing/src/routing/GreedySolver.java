/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package routing;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author simon.yang
 */
public class GreedySolver extends Solver
{
    public House[] solve(House[] allHouses)
    {
        int bartPackages = 0;
        int lisaPackages = 0;
        ArrayList<House> x = new ArrayList<>();
        for( House h : allHouses ) x.add( h );
        int bartTrips = bartPackages / 100;
        int lisaTrips = lisaPackages / 100;
        House start = new House(125, 22, "A");
        House temp = new House(1, 1, "A");
        House[] path = new House[x.size()];

        for (int i = 0; i < path.length; i++) //loop through every house in the cixty
        {
            int bartIndex = 99999;
            int lisaIndex = 99999;
            int bartCounter = 1;
            int lisaCounter = 1;
            int index = 0;
            double bigdist = 99999;
            if (i != 0)
            {
                for (int a = 0; a < x.size(); a++) //loop through every possible path you can take from 1 house to the next
                {
                    if (Util.pythagoreanDistance(path[i - 1], (House) x.get(a)) < bigdist)
                    {
                        bigdist = Util.pythagoreanDistance(path[i - 1], (House) x.get(a));
                        temp = (House) x.get(a);
                        index = a;
                    }
                }
            } else
            {
                for (int a = 0; a < x.size(); a++) //loop through every possible path you can take from 1 house to the next
                {
                    if (Util.pythagoreanDistance(start, (House) x.get(a)) < bigdist)
                    {
                        bigdist = Util.pythagoreanDistance(start, (House) x.get(a));
                        temp = (House) x.get(a);
                        index = a;
                    }
                }

            }
            path[i] = temp;
            if (x.get(index).equals(new House(2, 3, "A")) && bartCounter != bartTrips)
            {
                bartIndex = index;

            }
            if (x.get(index).equals(new House(149, 33, "A")) && lisaCounter != lisaTrips)
            {
                lisaIndex = index;

            }

            x.remove(index);
            if (i == bartIndex + 1)
            {
                x.add(new House(2, 3, "A"));
                bartCounter++;
            }
            if (i == lisaIndex + 1)
            {
                x.add(new House(149, 33, "A"));
                lisaCounter++;
            }

        }
        return path;
    }
}
