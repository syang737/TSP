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
public class House
{

    private int street;
    private int avenue;
    private String letter;
    private int ldistance;
    private int xdistance;
    private int ydistance;
    public House()
    {
        this.setStreet(1);
        this.setAvenue(1);
        this.setLetter("A");
    }
    public House(int s, int a, String l)
    {
        this.setStreet(s);
        this.setAvenue(a);
        this.setLetter(l);
        switch (l)
        {
            case "A":
            case "AA":
                ldistance = 0;
            case "B":
            case "BB":
                ldistance = 100;
            case "C":
            case "CC":
                ldistance = 200;
            case "D":
            case "DD":
                ldistance = 300;
            case "E":
            case "EE":
                ldistance = 400;
            case "F":
            case "FF":
                ldistance = 500;
            case "G":
            case "GG":
                ldistance = 600;
            case "H":
            case "HH":
                ldistance = 700;
            case "I":
            case "II":
                ldistance = 800;
            case "J":
            case "JJ":
                ldistance = 900;
                
        }
        System.out.println(street);
        ydistance = (avenue - 1) * 1000 + ldistance;
        xdistance = (street - 1) * 200 + 100;
        System.out.println(street);
        System.out.println(xdistance);
    }

    public void setStreet(int street)
    {
        this.street = street;
        xdistance = (street - 1) * 200 + 100;
    }

    public void setAvenue(int avenue)
    {
        this.avenue = avenue;
        ydistance = (avenue - 1) * 1000 + ldistance;
    }

    public void setLetter(String letter)
    {
        this.letter = letter;
        switch (letter)
        {
            case "A":
            case "AA":
                ldistance = 0;
            case "B":
            case "BB":
                ldistance = 100;
            case "C":
            case "CC":
                ldistance = 200;
            case "D":
            case "DD":
                ldistance = 300;
            case "E":
            case "EE":
                ldistance = 400;
            case "F":
            case "FF":
                ldistance = 500;
            case "G":
            case "GG":
                ldistance = 600;
            case "H":
            case "HH":
                ldistance = 700;
            case "I":
            case "II":
                ldistance = 800;
            case "J":
            case "JJ":
                ldistance = 900;

        }
    }

    public int getStreet()
    {
        return street;
    }

    public int getAvenue()
    {
        return avenue;
    }

    public String getLetter()
    {
        return letter;
    }

    public int getXdistance()
    {
        return xdistance;
    }

    public int getYdistance()
    {
        return ydistance;
    }

    public void setLdistance(int ldistance)
    {
        this.ldistance = ldistance;
    }

    public void setXdistance(int xdistance)
    {
        this.xdistance = xdistance;
    }

    public void setYdistance(int ydistance)
    {
        this.ydistance = ydistance;
    }

}
