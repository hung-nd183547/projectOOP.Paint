/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shape;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;

/**
 *  them list State de replay khi lap trinh toi thi se them sau
 * @author Dang Hung
 */
public class Curve extends Shape implements DrawType{
    private int state = 1;
    private ArrayList<Point> curveLine = new ArrayList<>();
            
    public Curve(){
        //khoi tao 4 gia tri 0 0 de de dang su dung cho viec mousepress va mouserelease 
        //vi diem start va end doan thang o dau va cuoi list nen ta khoi tao truoc de khi co start va end ta set lai o list(0) va list(3)
        for(int i=0;i<4;i++){
            curveLine.add(new Point(0, 0));
        }
    }
    
    public void resetState(){
        this.state = 1;
    }
    public void updateState(){
        this.state +=1;
    }
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public ArrayList<Point> getCurveLine() {
        return curveLine;
    }

    public void setCurveLine(ArrayList<Point> curveLine) {
        this.curveLine = curveLine;
    }
    public void addCurveLine(Point point){
        this.curveLine.add(point);
    }
    
    @Override
    public void draw(Graphics2D g2d) {
        //set vien
        BasicStroke str = new BasicStroke(width, cap, join, miterlimit, dash, dash_phase);
        g2d.setStroke(str);
        g2d.setColor(strokeColor);
        //cai dat trang thai
        //state = 1
        //ta chi co start point va end point => control point chua khoi tao
        //khoi tao control point ve diem cuoi 
        if(state == 1){
            //2 control point co gia tri bang endpoint
            curveLine.get(1).setLocation(curveLine.get(3)); //control point 1
            curveLine.get(2).setLocation(curveLine.get(3)); //control point 2
        }
        //dung general path de ve duong cong bezier
        GeneralPath path = new GeneralPath();
        path.moveTo(curveLine.get(0).x, curveLine.get(0).y); // diem co dinh start
        path.curveTo(curveLine.get(1).x, curveLine.get(1).y, curveLine.get(2).x, curveLine.get(2).y, curveLine.get(3).x, curveLine.get(3).y);
        //curveTo giup ve duong cong
        //get(1) control point thu 1
        //get(2) control point thu 2
        //get(3) endpoint cua duong cong
        g2d.draw(path);
    }
    
}
