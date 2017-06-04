/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntornoGrafico;

import Xestion_Movementos.XestorMovementos;
import Xogo.Xogo;
import java.awt.Color;
import javax.swing.JOptionPane;
import xadrez.Xadrez;

/**
 *
 * @author Carlos
 */
public class TaboleiroGrafico extends javax.swing.JFrame {
    private static Boton[][] botons= new Boton[8][8];
    private int ondeSeMoveX,ondeSeMoveY,aMoverX,aMoverY;

    
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
        if(boton.isPosibleMov()==false){
            this.resetearBotonsSeleccionados();
            this.resetearVariables();
        }
        
        
        if(this.comprobarSeContenPeza(boton)){
            boton.mudarEstadoClickado();
            
            if(boton.isClickado() && !boton.isPosibleMov()){      
                boton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0), 3));
                pintarMovementosPosibles(boton.getBotonX(),boton.getBotonY());
                this.aMoverX=boton.getBotonX();
                this.aMoverY=boton.getBotonY();
            }
        }
        
         if(boton.isPosibleMov()){
            this.ondeSeMoveX=boton.getBotonX();
            this.ondeSeMoveY=boton.getBotonY();
            Xogo.efectuarMovemento(aMoverX, aMoverY, ondeSeMoveX, ondeSeMoveY);
            this.resetearBotonsSeleccionados();
            this.resetearVariables();
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
   
    private void resetearVariables(){
        this.ondeSeMoveX=0;
        this.ondeSeMoveY=0;
        this.aMoverX=0;
        this.aMoverY=0;
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
                        botons[x][y].setIcon(null);
                }
            }
        }
    }
    
    public void mensaxeDeVitoria(){
        this.refrescar();
        JOptionPane.showMessageDialog(this,"O Xogador: "+Xadrez.getTurno()+ " Gañou a Partida NORABOA!!!","Aviso",JOptionPane.INFORMATION_MESSAGE );
    }
    
    //GETTERS AND SETTERS
    
    public int getaComerX() {
        return ondeSeMoveX;
    }

    public void setaComerX(int aComerX) {
        this.ondeSeMoveX = aComerX;
    }

    public int getaComerY() {
        return ondeSeMoveY;
    }

    public void setaComerY(int aComerY) {
        this.ondeSeMoveY = aComerY;
    }

    public int getQueComeX() {
        return aMoverX;
    }

    public void setQueComeX(int queComeX) {
        this.aMoverX = queComeX;
    }

    public int getQueComeY() {
        return aMoverY;
    }

    public void setQueComeY(int queComeY) {
        this.aMoverY = queComeY;
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(725, 755));
        setResizable(false);

        javax.swing.GroupLayout PanelTabLayout = new javax.swing.GroupLayout(PanelTab);
        PanelTab.setLayout(PanelTabLayout);
        PanelTabLayout.setHorizontalGroup(
            PanelTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 892, Short.MAX_VALUE)
        );
        PanelTabLayout.setVerticalGroup(
            PanelTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelTab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelTab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    // End of variables declaration//GEN-END:variables
}
