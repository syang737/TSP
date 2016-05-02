/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package routing;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.geom.*;
import java.awt.Color;
import java.lang.Object;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.*;
import java.awt.event.*;
import static routing.Routing.printResults;
import static routing.Routing.readData;
import static routing.Routing.testFunction;

/**
 *
 * @author 18irwinq
 */
public class Gui extends JFrame
{

    public static void main(String[] args)
    {
        Gui graph = new Gui();
        graph.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        graph.setSize(1800, 1080);
        graph.setVisible(true);
        graph.setTitle("Map");
        Color backgroundColor = new Color(102, 205, 170);
        graph.setBackground(Color.lightGray);

//        Gui info = new Gui();
        //      info.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //    info.setSize(1800, 1080);
        //  info.setVisible(true);
        // info.setTitle("Statistics");
    }

    public void paint(Graphics l)
    {
        String fileName = "/Users/simon.yang/Desktop/cycle data/cycle1.txt";
        House[] data = readData(fileName);
        House[] houses = new House[data.length + 2];
        System.arraycopy(data, 0, houses, 0, data.length);
        houses[data.length] = new House(2, 3, "A");
        houses[data.length + 1] = new House(149,33,"A");
        House[] path;
        Graphics2D g2 = (Graphics2D) l;
        int packages = Util.getPackages(fileName);
        int bartPackages = Util.getBartPackages(fileName);
        int lisaPackages = Util.getLisaPackages(fileName);
        path = testFunction("OptimizedTwoOpt", houses, new GreedySolver(), 0, 0);
        
        

        int n = 0;

        //draws streets
//        for (int i = 0; i < 251; i++)
//        {
//            l.drawLine(n, 0, n, 1000);
//
//            // draws yellow vertical line for Distribution Center
//            if (i == 124 || i == 125)
//            {
//                l.setColor(Color.yellow);
//                //NEEDS FIX l.drawLine(n, , n, 580);
//                l.setColor(Color.black);
//            }
//            n += 7;
//
//        }
//
//        int a = 0;
//
//        //draws avenues
//        for (int i = 0; i < 51; i++)
//        {
//            l.drawLine(0, a, 1750, a);
//
//            // draws yellow horizontal line for Distribution Center
//            if (i == 28 || i == 29)
//            {
//                l.setColor(Color.yellow);
//                // NEEDS FIX l.drawLine(496, a, 500, a);
//                l.setColor(Color.black);
//            }
//
//            a += 20;
//
//        }

        for (int i = 0; i < path.length; i++)
        {
            double x1 = Math.ceil(path[i].getXdistance()/27.72);
            double x2 = Math.ceil(path[i + 1].getXdistance()/27.72);
            double y1 = Math.ceil(path[i].getYdistance()/47.13);
            double y2 = Math.ceil(path[i + 1].getYdistance()/47.13);
            g2.setColor(Color.red);
            g2.setStroke(new BasicStroke(4));
      // draw points 
            g2.drawLine((int)x1, (int)y1, (int)x1, (int)y1);
            g2.setStroke(new BasicStroke(2));
            g2.setColor(Color.blue);

            g2.drawLine((int)x1, (int)y1, (int)x1, (int)y2);
            g2.drawLine((int)x1, (int)y2, (int)x2, (int)y2);

            {

            }

            // draw DIST CENTER
            g2.setColor(Color.cyan);
        //(starting x coord, starting y coord, width, height)

            g2.draw(new Rectangle2D.Double(861, 560, 7, 20));

            // draw LISA COMPLEX
            g2.setColor(Color.yellow);
            g2.draw(new Rectangle2D.Double(1036, 340, 7, 20));

            // draw BART COMPLEX
            g2.setColor(Color.yellow);
            g2.draw(new Rectangle2D.Double(7, 920, 7, 20));

            int xmin, xmax, y, tmin, tmax;
            xmin = (-100);
            xmax = 100;
            int x_bet, y_bet;
            GeneralPath gp = new GeneralPath();

            y = 300 - (xmin * xmin);
            gp.moveTo((double) xmin + 300, (double) y);
            while (xmin <= xmax)
            {
                y = 300 - (xmin * xmin);
                gp.lineTo((double) xmin + 300, (double) y);

                xmin++;
            }

        }
        
    }
}
