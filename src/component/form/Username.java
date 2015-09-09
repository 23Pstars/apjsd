/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package form;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author zaf
 */
public class Username extends JTextField implements MouseListener{
    public Username(){
        this.setText("Username");
    }
    public void mouseClicked(MouseEvent e){
        this.setText("");
        JOptionPane.showMessageDialog(this, "username clicked");
    }

    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
