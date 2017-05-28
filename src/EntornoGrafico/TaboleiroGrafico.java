/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntornoGrafico;

import Xestion_Movementos.XestorMovementos;
import Xogo.Xogo;
import java.awt.Color;

/**
 *
 * @author Carlos
 */
public class TaboleiroGrafico extends javax.swing.JFrame {
    private static Boton[][] botons= new Boton[8][8];
    private int aComerX,aComerY,queComeX,queComeY;

    
    /**
     * Creates new form Taboleiro
     */
    public TaboleiroGrafico() {
        initComponents();
        this.encherBotons();
        this.pintarBotons();
        this.refrescar();
    }
    
    public void encherBotons(){
        for(int x=0; x<botons.length; x++){
            for(int y=0;y<botons.length;y++){
                botons[x][y]= new Boton(x,y,90,90);
                botons[x][y].setName(x, y);
                PanelTab.add(botons[x][y]);
                botons[x][y].setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 50, 50), 2));
                botons[x][y].addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        botonSeleccionar(evt);
                        refrescar();
                    }
                });
            }
        }
    }
    
    private void botonSeleccionar(java.awt.event.ActionEvent evt) {                                         
        Boton boton=(Boton) evt.getSource();
        resetearBotonsSeleccionados();
        if(this.comprobarSeContenPeza(boton)){
            boton.mudarEstadoClickado();
            
            if(boton.isClickado()){      
                boton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0), 3));
                pintarMovementosPosibles(boton.getBotonX(),boton.getBotonY());
            }else if(!boton.isClickado()){
               
            }
        }
    }       
    
    
    private void resetearBotonsSeleccionados(){
        for(int x=0;x<botons.length;x++){
            for(int y=0;y<botons.length;y++){           
                botons[x][y].resetearEstado();
                botons[x][y].setPosibleMov(false);
                botons[x][y].setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 50, 50), 2));
            }
        }
    }
    
    private boolean comprobarSeContenPeza(Boton bot){
        try{
            if(Xogo.tab.get(bot.getBotonX(), bot.getBotonY()).equals(null)){
                System.out.println("non peza");
            }
        }catch(NullPointerException e){
            return false;
        }
        return true;
    }
    
    
    private void pintarBotons(){
        int x,y;
        for(x=0;x<botons.length;x++){
            for(y=0;y<botons.length;y++){
                if(y%2==0 && x%2==0 || y%2!=0 && x%2!=0){
                    botons[x][y].setBackground(Color.GRAY);
                }else{
                    botons[x][y].setBackground(Color.WHITE);
                }
            }
        }
    }
    
    //Metodo en Probas
    private void pintarMovementosPosibles(int botonX,int botonY){
        int x,y;
        int[][] tabMov= new int[8][8];
        XestorMovementos xestor= new XestorMovementos();
        tabMov=xestor.movementosPosibles(Xogo.tab, botonX, botonY);
        
        for(x=0;x<tabMov.length;x++){
            for(y=0;y<tabMov.length;y++){
                if(tabMov[x][y]==1 || tabMov[x][y]==2){
                    botons[x][y].setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0), 3));
                    botons[x][y].setPosibleMov(true);
                }
            }
        }
    }
    
   
    public void refrescar(){
        int x,y;
        for(x=0;x<botons.length;x++){
            for(y=0;y<botons.length;y++){
                try{
                    if(Xogo.tab.get(x, y).getPropiedadeDe()==Xogo.getXog1())
                        botons[x][y].setIcon(Xogo.tab.get(x, y).getIconaxog1());
                    else if(Xogo.tab.get(x, y).getPropiedadeDe()==Xogo.getXog2())
                        botons[x][y].setIcon(Xogo.tab.get(x, y).getIconaxog2());
                }catch(NullPointerException e){
                    
                }
            }
        }
    }
    
    //GETTERS AND SETTERS
    
    public int getaComerX() {
        return aComerX;
    }

    public void setaComerX(int aComerX) {
        this.aComerX = aComerX;
    }

    public int getaComerY() {
        return aComerY;
    }

    public void setaComerY(int aComerY) {
        this.aComerY = aComerY;
    }

    public int getQueComeX() {
        return queComeX;
    }

    public void setQueComeX(int queComeX) {
        this.queComeX = queComeX;
    }

    public int getQueComeY() {
        return queComeY;
    }

    public void setQueComeY(int queComeY) {
        this.queComeY = queComeY;
    }
   
    //Proba

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelTab = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("jButton1");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0), 3));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelTabLayout = new javax.swing.GroupLayout(PanelTab);
        PanelTab.setLayout(PanelTabLayout);
        PanelTabLayout.setHorizontalGroup(
            PanelTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTabLayout.createSequentialGroup()
                .addContainerGap(816, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(23, 23, 23))
        );
        PanelTabLayout.setVerticalGroup(
            PanelTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTabLayout.createSequentialGroup()
                .addContainerGap(729, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelTab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelTab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TaboleiroGrafico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TaboleiroGrafico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TaboleiroGrafico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TaboleiroGrafico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TaboleiroGrafico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelTab;
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
