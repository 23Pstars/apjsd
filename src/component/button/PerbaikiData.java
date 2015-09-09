/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package component.button;

import java.awt.Dimension;
import javax.swing.JButton;

/**
 *
 * @author zaf
 */
public class PerbaikiData extends JButton{
    public PerbaikiData(){
        this.setPreferredSize(new Dimension(180, 50));
        this.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png")));
        this.setText("Perbaiki Data");
    }
}
