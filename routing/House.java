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
                break;
            case "B":
            case "BB":
                ldistance = 100;
                break;
            case "C":
            case "CC":
                ldistance = 200;
                break;
            case "D":
            case "DD":
                ldistance = 300;
                break;
            case "E":
            case "EE":
                ldistance = 400;
                break;
            case "F":
            case "FF":
                ldistance = 500;
                break;
            case "G":
            case "GG":
                ldistance = 600;
                break;
            case "H":
            case "HH":
                ldistance = 700;
                break;
            case "I":
            case "II":
                ldistance = 800;
                break;
            case "J":
            case "JJ":
                ldistance = 900;
                break;
                
        }
        
        ydistance = (avenue - 1) * 1000 + ldistance;
        xdistance = (street - 1) * 200 + 100;
        
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
                break;
            case "B":
            case "BB":
                ldistance = 100;
                break;
            case "C":
            case "CC":
                ldistance = 200;
                break;
            case "D":
            case "DD":
                ldistance = 300;
                break;
            case "E":
            case "EE":
                ldistance = 400;
                break;
            case "F":
            case "FF":
                ldistance = 500;
                break;
            case "G":
            case "GG":
                ldistance = 600;
                break;
            case "H":
            case "HH":
                ldistance = 700;
                break;
            case "I":
            case "II":
                ldistance = 800;
                break;
            case "J":
            case "JJ":
                ldistance = 900;
                break;

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
    public String toString()
    {
        return "" + street + "," + avenue + "," + letter;
    }
}
