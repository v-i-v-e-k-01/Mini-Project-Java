/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proj;

import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

public class Help extends javax.swing.JFrame {


    public Help(Image img,int x,int y) {
        initComponents();
        setLabelIcon(img);
        this.setLocation(x, y);
    }
    private void setLabelIcon(Image img){
        BufferedImage bi=new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB);
        bi.createGraphics().drawImage(img, 0, 0, null);
        img=bi.getScaledInstance(jLabel1.getWidth(),jLabel1.getHeight(), 1);
        jLabel1.setIcon(new ImageIcon(img));
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setIconImage(new ImageIcon(getClass().getResource("/img/logo.png")).getImage());
        setLocationByPlatform(true);
        setUndecorated(true);

        jLabel1.setPreferredSize(new java.awt.Dimension(240, 200));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {
        this.dispose();
    }



    private javax.swing.JLabel jLabel1;

}
