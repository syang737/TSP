/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package routing;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author simon.yang
 */
public class Util
{

    public static String shortenString(String s)
    {
        return s.substring(0, s.length() - 1);
    }

    public static double convertToMile(int feet)
    {
        double mile;
        return mile = feet / 5000;
    }

    public static double pythagoreanDistance(House x, House y)
    {
        if (x == null || y == null)
        {
            return 0;
        }
        double pDistance = Math.abs(Math.sqrt(Math.pow((x.getYdistance() - y.getYdistance()), 2) + Math.pow((x.getXdistance() - y.getXdistance()), 2)));
        return pDistance;
    }

    public static double totalPythagoreanDistance(House[] x)
    {
        double totalDistance = 0;
        for (int i = 0; i < x.length - 1; i++)
        {

            totalDistance += pythagoreanDistance(x[i], x[i + 1]);

        }
        return totalDistance;
    }

    public static double swapCut(House a, House b, House c, House d)
    {

        double preSwap = pythagoreanDistance(a, b) + pythagoreanDistance(c, d);
        double postSwap = pythagoreanDistance(a, c) + pythagoreanDistance(b, d);
        double cut = postSwap - preSwap;
        return cut;

    }

    public static int streetsTraveled(House[] path)
    {
        int streetblocks = 0;

        for (int i = 0; i < path.length - 1; i++)
        {
            streetblocks += Math.abs(path[i + 1].getStreet() - path[i].getStreet());

        }
        return streetblocks;
    }

    public static int avenuesTraveled(House[] path)
    {
        int aveblocks = 0;
        for (int i = 0; i < path.length - 1; i++)
        {
            aveblocks += Math.abs(path[i + 1].getAvenue() - path[i].getAvenue());
        }
        return aveblocks;

    }

    public static int getTotalDistanceInFeet(House[] path)
    {

        return (streetsTraveled(path) * 200 + avenuesTraveled(path) * 1000);
    }

    public static double totalDistance(House[] path)
    {

        return (double) getTotalDistanceInFeet(path) / 5000;
    }

    public static double travelTime(House[] path)
    {
        double timeAvenue = avenuesTraveled(path) * 1 / 120; //30 sec. to run through an AVENUE
        double timeStreet = streetsTraveled(path) * 1 / 600; // 6 seconds to travel from STREET TO STREET
        return timeAvenue + timeStreet;
    }

    public static double houseTime(int houses)
    {
        return houses * 1 / 60; // one min. to deliverto each HOUSE

    }

    public static double pathTime(int houses, House[] path)
    {
        return travelTime(path) + houseTime(houses);

    }

    public static double calcFuelCharge(double totalmiles)
    {
        return 5.0 * totalmiles;
    }

    public static double eitherPurchaseOrRent(double totalmiles)
    {
        double dailyPayment;
        double maintanenceFee;

        maintanenceFee = (totalmiles / 100) * 1000;
        if (totalmiles > 500)
        {
            System.out.println("Rented a truck");
            return dailyPayment = 15000;
        }

        dailyPayment = 10000; //purchase
        System.out.println("Purchased a truck");
        return dailyPayment + maintanenceFee;

        //rent
    }

    public static double eachEmployeeCost(double dayTime)
    {
        if (dayTime <= 8)
        {
            return dayTime * 30;
        } else
        {
            return (240 + 45 * (dayTime - 8));
        }
    }

    public static House[] randomAlgorithm(ArrayList x)
    {
        House start = new House(125, 22, "A");
        House temp = new House(1, 1, "A");
        House[] path = new House[x.size()];

        for (int i = 0; i < path.length; i++) //loop through every house in the cixty
        {
            int index = 0;
            double shortdist = 0;
            if (i != 0)
            {
                for (int a = 0; a < x.size(); a++) //loop through every possible path you can take from 1 house to the next
                {
                    if (Util.pythagoreanDistance(path[i - 1], (House) x.get(a)) > shortdist)
                    {
                        shortdist = Util.pythagoreanDistance(path[i - 1], (House) x.get(a));
                        temp = (House) x.get(a);
                        index = a;
                    }
                }
            } else
            {
                for (int a = 0; a < x.size(); a++) //loop through every possible path you can take from 1 house to the next
                {
                    if (Util.pythagoreanDistance(start, (House) x.get(a)) > shortdist)
                    {
                        shortdist = Util.pythagoreanDistance(start, (House) x.get(a));
                        temp = (House) x.get(a);
                        index = a;
                    }
                }

            }
            path[i] = temp;
            x.remove(index);
        }
        return path;
    }
    public static int getPackages(String fileName)
    {
        File f = new File(fileName);
        try
        {
            Scanner sc = new Scanner(f);

            for (int i = 1; sc.hasNext(); i++)
            {
                String line = sc.nextLine();
                String[] address = line.split(",");

                if (i == 2)
                {

                    return Integer.parseInt(line);

                }

            }

        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        return 0;

    }

    public static int getBartPackages(String fileName)
    {

        int bartPackages = 0;
        File f = new File(fileName);
        try
        {
            Scanner sc = new Scanner(f);
            int temp = 99999;
            for (int i = 1; sc.hasNext(); i++)
            {
                String line = sc.nextLine();
                String[] address = line.split(",");

                if (line.equals("Bart Complex"))
                {
                    i = temp;
                }
                if (i == temp + 1)
                {
                    bartPackages = Integer.parseInt(line);
                }

            }

        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        return bartPackages;
    }

    public static int getLisaPackages(String fileName)
    {
        House lisa = new House(2, 3, "A");
        int lisaPackages = 0;
        File f = new File(fileName);
        try
        {
            Scanner sc = new Scanner(f);
            int temp = 99999;
            for (int i = 1; sc.hasNext(); i++)
            {
                String line = sc.nextLine();
                String[] address = line.split(",");

                if (line.equals("Lisa Complex"))
                {
                    i = temp;
                }
                if (i == temp + 1)
                {
                    lisaPackages = Integer.parseInt(line);
                }

            }

        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        return lisaPackages;
    }

    

}
