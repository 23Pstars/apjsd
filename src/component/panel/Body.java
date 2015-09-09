/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package component.panel;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

/**
 *
 * @author zaf
 */
public class Body extends JPanel{
    protected int strokeSize = 1;
    protected Color shadowColor = Color.black;
    protected boolean shady = true;
    protected boolean highQuality = true;
    protected Dimension arcs = new Dimension(20, 20);
    protected int shadowGap = 5;
    protected int shadowOffset = 4;
    protected int shadowAlpha = 150;

    public Body(){
        super();
        this.setOpaque(true);
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        int width = this.getWidth();
        int height = this.getHeight();
        Color shadowColorA = new Color(this.shadowColor.getRed(),
                this.shadowColor.getGreen(), this.shadowColor.getBlue(), this.shadowAlpha);
        Graphics2D graphics = (Graphics2D)g;
         if (highQuality) {
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
			RenderingHints.VALUE_ANTIALIAS_ON);
        }
        if (shady) {
            graphics.setColor(shadowColorA);
            graphics.fillRoundRect(
                    shadowOffset,// X position
                    shadowOffset,// Y position
                    width - strokeSize - shadowOffset, // width
                    height - strokeSize - shadowOffset, // height
                    arcs.width, arcs.height);// arc Dimension
        } else {
            shadowGap = 1;
        }
        //Draws the rounded opaque panel with borders.
        graphics.setColor(new Color(198, 255, 212));
        graphics.fillRoundRect(0, 0, width - shadowGap,
		height - shadowGap, arcs.width, arcs.height);
        graphics.setColor(getForeground());
        graphics.setStroke(new BasicStroke(strokeSize));
        graphics.drawRoundRect(0, 0, width - shadowGap,
		height - shadowGap, arcs.width, arcs.height);

        //Sets strokes to default, is better.
        graphics.setStroke(new BasicStroke());

    }
}
