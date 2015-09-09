/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package component.text;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JLabel;

/**
 *
 * @author zaf
 */
public class TextBerdiri extends JLabel{
    private String text;
    public TextBerdiri(){
        this.setText("Text Berdiri");
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.rotate(Math.toRadians(270.0));
        g2d.drawString(text, 0, 0);
    }

}
