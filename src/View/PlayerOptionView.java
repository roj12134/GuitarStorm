/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import lejos.pc.comm.NXTConnector;

/**
 *
 * @author jamazariegosr
 */
public class PlayerOptionView extends javax.swing.JFrame {

   NXTConnector connectionGuitar1 = new NXTConnector (),connectionGuitar2 = new NXTConnector () ;
   boolean statusc1,statusc2;
   
   DataOutputStream outDataGuitar1,outDataGuitar2;
   DataInputStream inDataGuitar1,inDataGuitar2;
   
   
   
    public PlayerOptionView() {
        initComponents();
        setLocationRelativeTo(null);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        twoPlayerButton = new javax.swing.JButton();
        onePlayerButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jButton1.setText("Connect");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(20, 320, 96, 38);

        textArea.setColumns(20);
        textArea.setRows(5);
        jScrollPane1.setViewportView(textArea);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(120, 290, 244, 84);

        twoPlayerButton.setBackground(new java.awt.Color(255, 255, 255));
        twoPlayerButton.setFont(new java.awt.Font("Nightmare Hero", 0, 48)); // NOI18N
        twoPlayerButton.setForeground(new java.awt.Color(255, 0, 0));
        twoPlayerButton.setText("Two Players");
        twoPlayerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                twoPlayerButtonActionPerformed(evt);
            }
        });
        getContentPane().add(twoPlayerButton);
        twoPlayerButton.setBounds(40, 140, 310, 90);

        onePlayerButton.setBackground(new java.awt.Color(255, 255, 0));
        onePlayerButton.setFont(new java.awt.Font("Nightmare Hero", 0, 48)); // NOI18N
        onePlayerButton.setForeground(new java.awt.Color(255, 0, 0));
        onePlayerButton.setText("One Player");
        onePlayerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onePlayerButtonActionPerformed(evt);
            }
        });
        getContentPane().add(onePlayerButton);
        onePlayerButton.setBounds(40, 20, 310, 90);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
          // boton donde me conecto 

        statusc1 = connectionGuitar1.connectTo("NXT"); // el primero se va a conectar al nxt 
        statusc2 = connectionGuitar2.connectTo("GioNXT");// el segundo se va a conecdtar a GioNXT


        if (!statusc1) {
            System.out.println("Error al conectar Robot : NXT ");
            
        } else {
            // quiere decir que se conecto exitosamente 
           

        }

        if (!statusc2) {
           System.out.println("Error al conectar Robot : GioNXT ");
            
        } else {
            // se conecto exitosamente  
           
        }




        if (statusc1) {
            // si los dos son verdaderas 
            // informacion de la connecion 1 

            outDataGuitar1 = new DataOutputStream(connectionGuitar1.getOutputStream());
            inDataGuitar1 = new DataInputStream(connectionGuitar1.getInputStream());

            new LookAround ();

           
        }

        if (statusc2) {
            // informacion de la connecion 2

            outDataGuitar2 = new DataOutputStream(connectionGuitar2.getOutputStream());
            inDataGuitar2 = new DataInputStream(connectionGuitar2.getInputStream());
            
              new LookAround ();
        }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void onePlayerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onePlayerButtonActionPerformed
       //  Se va a la ventana de un Jugador 
        
      GameBoardView view = new GameBoardView ();
      view.setSize(1000, 675);
      view.setLocationRelativeTo(null);
      view.setVisible(true);
      
      dispose(); // oculto esta ventana
        
        
    }//GEN-LAST:event_onePlayerButtonActionPerformed

    private void twoPlayerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_twoPlayerButtonActionPerformed
        // ventana de dos jugadores 
        
        
           //  Se va a la ventana de un Jugador 
        
      GameBoard2PlayersView view = new GameBoard2PlayersView ();
      //view.setSize(2000, 800);
      view.setExtendedState(6);
      view.setLocationRelativeTo(null);
      view.setVisible(true);
      
      dispose(); // oculto esta ventana
        
      
      
    }//GEN-LAST:event_twoPlayerButtonActionPerformed

      // aqui voy a crear mi hilo 
    
    class LookAround extends Thread {
        public LookAround(){
            
        }
        public void run(){
            while(true){
           
         
          try { 
              textArea.append("Recivido de Guitarra 1  " + inDataGuitar1.read());
              textArea.append("Recivido de Guitarra 2  " + inDataGuitar2.readInt());
          } 
          catch(IOException ioe) { 
              textArea.append("IO Exception reading bytes:"); 
              textArea.append(ioe.getMessage()); 
               }

         
         //break; // salgo del ciclo 
          
          
          
            }
            
        }
    }
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PlayerOptionView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlayerOptionView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlayerOptionView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlayerOptionView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new PlayerOptionView().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton onePlayerButton;
    private javax.swing.JTextArea textArea;
    private javax.swing.JButton twoPlayerButton;
    // End of variables declaration//GEN-END:variables
}
