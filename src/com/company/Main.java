package com.company;

import java.awt.geom.Point2D;
import java.io.*;

import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {
        String circlePath = args[0];
        String pointsPath = args[1];
        String center;
        String point;
        double radius;
        double distance;
        Point2D centerOfCircle;
        ArrayList<Point2D> points = new ArrayList<>();

        try(FileReader fr1 = new FileReader(circlePath); FileReader fr2 = new FileReader(pointsPath)) {
            BufferedReader reader = new BufferedReader(fr1);
            center = reader.readLine();
            radius = Double.parseDouble(reader.readLine());
            centerOfCircle = toPoint(center);
            reader = new BufferedReader(fr2);
            point = reader.readLine();
            while (point != null){
                points.add(toPoint(point));
                point = reader.readLine();
            }
            for (Point2D p: points){
                distance = p.distance(centerOfCircle);
                if(distance > radius){
                    System.out.println(2);
                }
                else if (distance == radius) {
                    System.out.println(0);
                }
                else{
                    System.out.println(1);
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    static Point2D toPoint(String string){
        String[] coordinats = string.split(" ");
        double x = Double.parseDouble(coordinats[0]);
        double y = Double.parseDouble(coordinats[1]);
        return new Point2D.Double(x, y);

    }
}
