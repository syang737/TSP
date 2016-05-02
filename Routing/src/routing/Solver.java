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
        House[] newPath = new House[path.length + 2];
        path = solve(path);
        System.arraycopy(path, 0, newPath, 1, path.length);
        newPath[newPath.length - 1] =  new House(125, 22, "A");
        newPath[0] = new  House(125, 22, "A");
        return newPath;
    }

    public static House[] addBartTrips(House[] path, int bartPackages)
    {
        House bart = new House(2, 3, "A");
        int bartTrips = (int) Math.ceil((double) bartPackages / 100);
        System.out.println(bartTrips);
        House[] newPath = new House[path.length + (bartTrips - 1)];
        System.arraycopy(path, 0, newPath, 0, path.length);
        //traverse the path to look for bart complex
        if (bartTrips > 1)
        {
            for (int i = 0; i < path.length; i++)
            {

                if (path[i].equals(bart))
                {
                    //after found we add as many times as we need
                    for (int j = 1; j < bartTrips; j++)
                    {
                        System.arraycopy(path, 0, newPath, 0, i + 2);
                        System.arraycopy(path, i + 2, newPath, i + 3, path.length - (i + 2));
                        newPath[i + 2] = bart;
                        i += 2;
                    }
                    break;
                }
            }
        }
        

        return path;

    }

    protected abstract House[] solve(House[] path);
}
