/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shape;

import java.awt.BasicStroke;
import java.awt.Graphics2D;

/**
 *
 * @author Dang Hung
 */
public class Eraser extends Shape implements DrawType{
    private float size;

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    @Override
    public void draw(Graphics2D g2d) {
        this.setSize(this.width + 10);
        BasicStroke str = new BasicStroke(this.getSize());
        g2d.setStroke(str);
        g2d.setColor(strokeColor);
        if(startPoint != null && endPoint != null){
            g2d.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
        }
    }
}
