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
public abstract class Solver
{
    public House[] solve(House[] path, int bartPackages, int lisaPackages)
    {
        return addBartTrips(solve(path), bartPackages);
    }
    public static House[] addBartTrips(House[] path, int bartPackages)
    {
        int bartTrips = bartPackages / 100;
        House[] newPath = new House[path.length + (bartTrips - 1)];
        int index = 9999;
        for (int j = 1; j < bartTrips; j++)
        {
            for (int i = 0; i < path.length; i++)
            {
                if (path[i].equals(new House(2, 3, "A")))
                {
                    index = i;
                    System.arraycopy(path, 0, newPath, 0, i + 2);
                    System.arraycopy(path, i + 2, newPath, i + 3, path.length - (i+2));
                    newPath[i + 2] = new House(2,3,"A");
                    break;
                }
            }
        }
        return newPath;

    }
    protected abstract House[] solve(House[] path);
}
