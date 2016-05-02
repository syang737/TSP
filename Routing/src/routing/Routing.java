/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package routing;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

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
        
        
        String fileName = "/Users/simon.yang/Desktop/cycle data/cycle1.txt";
        int packages = Util.getPackages(fileName);
        int bartPackages = Util.getBartPackages(fileName);
        int lisaPackages = Util.getLisaPackages(fileName);

        System.out.println(bartPackages);
        System.out.println(lisaPackages);
        House[] data = readData(fileName);
        House[] houses = new House[data.length + 2];
        System.arraycopy(data, 0, houses, 0, data.length);
        houses[data.length] = new House(2, 3, "A");
        houses[data.length + 1] = new House(149,33,"A");
        House[] path;
        
        
        
//        path = testFunction("TwoOpt", houses, new TwoOptSolver());
//        printResults("TwoOpt", path, packages, false);
        path = testFunction("Greedy", houses, new GreedySolver(), bartPackages, lisaPackages);
        
        printResults("Greedy", path, packages, false);
//        path = testFunction("OptimizedTwoOpt", houses, new TwoOptSecond(), bartPackages, lisaPackages);
//        printResults("OptimizedTwoOpt", path, packages, false);

    }

    

    public static House[] readData(String fileName)
    {
        House bart = new House(2, 3, "A");
        House lisa = new House(149, 33, "A");
        //reading in the file

        File f = new File(fileName);
        ArrayList streets = new ArrayList();
        ArrayList avenues = new ArrayList();
        ArrayList letters = new ArrayList();

        int lisaPackages = 0;
        try
        {
            Scanner sc = new Scanner(f);
            int temp = 99999;
            for (int i = 1; sc.hasNext(); i++)
            {
                String line = sc.nextLine();
                String[] address = line.split(",");

                if (i == 1)
                {
                    System.out.println("Day: " + line);
                    continue;
                }
                if (i == 2)
                {
                    System.out.println("Packages: " + line);

                    continue;
                }

                for (int a = 0; a < address.length; a++)
                {
                    switch (address[a].charAt(address[a].length() - 1))
                    {
                        case 's':
                            streets.add(Util.shortenString(address[a].trim()));
                            break;
                        case 'a':
                            avenues.add(Util.shortenString(address[a].trim()));
                            break;
                        default:
                            letters.add(address[a].trim());
                            break;

                    }
                }

            }

        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

        ArrayList x = new ArrayList();

        for (int i = 0; i < streets.size(); i++)
        {
            x.add(new House(Integer.parseInt((String) streets.get(i)), Integer.parseInt((String) avenues.get(i)), (String) letters.get(i)));
        }

        x.add(bart);
        x.add(lisa);
        House[] houses = Util.randomAlgorithm(x);
        return houses;
    }

    public static House[] testFunction(String tag, House[] x, Solver solver, int bartPackages, int lisaPackages)
    {
        long start = System.currentTimeMillis();
        House[] path = solver.solve(x, bartPackages, lisaPackages);
        long end = System.currentTimeMillis();
        System.out.println("Test time for " + tag + ": " + (end - start) + " Milliseconds");
        return path;
    }

    public static void printResults(String tag, House[] path, int packages, boolean verbose)
    {
        System.out.println("Route from " + tag + ":");
        int counter = 2;
        int employees = 1;
        int trucks = 1;
        double manHours = Util.pathTime(packages, path);
        double totalDistance = Util.totalDistance(path);
        double dayTime = manHours;
        while (dayTime > 24)
        {
            if (Util.travelTime(path) / (trucks + 1) > Util.houseTime(packages) / (employees + 1))
            {
                trucks++;
            } else
            {
                employees++;
            }
            dayTime = Util.travelTime(path) / trucks + Util.houseTime(packages) / employees;
        }
        if (verbose)
        {
            System.out.println("Truck 1's Path:");
            for (int i = 0; i < path.length; i++)
            {
                if (i == (int)path.length/trucks)
                {
                    System.out.println("Truck " + counter + "'s Path:");
                }
                if(path[i] == null)
                {
                    System.out.println("null");
                    continue;
                }
                

                System.out.println("House " + (i + 1));

                System.out.println("Street: " + path[i].getStreet());
                System.out.println("Avenue: " + path[i].getAvenue());
                System.out.println("Letter: " + path[i].getLetter());
                System.out.println("------");

            }
        }
        
        System.out.println("Trucks: " + trucks);
        System.out.println("Employees: " + employees);
        double totalCost = Util.eitherPurchaseOrRent(totalDistance) * trucks + Util.calcFuelCharge(totalDistance) + Util.eachEmployeeCost(dayTime) * employees;
        
        System.out.println("Total Distance (miles): " + totalDistance);
        System.out.println(manHours + " Man Hours");
        System.out.println("Total cost: " + totalCost);
        System.out.println("-------------------------------------------------------");

    }
}
