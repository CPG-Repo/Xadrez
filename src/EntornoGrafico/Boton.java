/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntornoGrafico;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Carlos
 */
public class Boton extends JButton implements ActionListener{
    
    public Boton(int x,int y, int alto, int ancho){
        this.setBounds(x, y, alto, ancho);
        this.addActionListener(this);
    }
    
    public void setName(int x, int y){
        this.setText((x+1)+"-"+(y+1));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.setBackground(Color.GREEN);
    }
}
