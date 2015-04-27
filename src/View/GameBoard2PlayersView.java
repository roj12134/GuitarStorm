package View;

import Model.NotesModel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javazoom.jl.player.Player;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jamazariegosr
 */
public class GameBoard2PlayersView extends javax.swing.JFrame {

   private int largo = 0;
   private int y = 0;
   private int dificult = 500;
   private NotesModel [] notes ;
   private int i = 0;
   private int duration=1;
   
   boolean  songStarter = false;
   boolean playStart = false;
   
   private boolean a,s,d,f,g;
   FileInputStream music ;
         

   
    
    public GameBoard2PlayersView() {
        initComponents();
        
        setLocationRelativeTo(null);
        
        
        // leo el archivo donde estan las notas 
        readNotes();
        
        try {
            music = new FileInputStream(System.getProperty("user.dir")+"/src/Songs/Back in Black.mp3");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GameBoard2PlayersView.class.getName()).log(Level.SEVERE, null, ex);
        }

        
     
          
    }
    
    public void  readNotes(){
        FileReader fileNotes = null;
        try {
            
            fileNotes = new FileReader (System.getProperty("user.dir")+"/src/NotesOfSongs/BackInBlack.txt");
            Scanner SCAN = new Scanner (fileNotes);
            SCAN.useDelimiter("\\Z"); // delimitador para leer el archivo completo
            String contentFile = SCAN.next();
            
            
            // esl StringTokenizer es para clasificar por proveedor
            StringTokenizer note = new StringTokenizer (contentFile,";");
            // creo mi arreglo de notesModel 
            
            notes = new NotesModel [note.countTokens()];
            int index = 0;
            while (note.hasMoreTokens()){
                
                
                StringTokenizer parametro = new StringTokenizer (note.nextToken(),",");
                notes [index] = new NotesModel(Integer.parseInt(parametro.nextToken()),Integer.parseInt(parametro.nextToken()));
                
                
                
                index++;
                
                
            
            
                }
            
            
            
            // catch de leer archivos 
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GameBoard2PlayersView.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fileNotes.close();
            } catch (IOException ex) {
                Logger.getLogger(GameBoard2PlayersView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    } // fin del metodo notes 
        
        
        
        
   public void Draw (Graphics gio){
        
        
     if (playStart) {
        
        try{
            
  
            // en este punto ya estas en cero. 
            
            
            playTheSong();
            songStarter = true ; //ya empezo la cancion una vez. 
            int ExtraHeight=0;
            for(int x=0;x<20;x++){
                if((i+x)<notes.length){          
                    if(notes[i+x].getTime()>1)
                        ExtraHeight+=(notes[i+x].getTime()-1);
                    notes[i+x].setPosY( ((panelGame.getHeight()/20*(18-x-ExtraHeight))) );
                    int pos = notes[i+x].getPos();
                    int length = notes[i+x].getTime();
                    if (pos == 0){
                        pos = 3;
                        gio.setColor(Color.WHITE);
                    }
                    else if (pos == 1){
                        pos = 18;
                        gio.setColor(new Color(240,233,43));
                    }
                    else if (pos == 2){
                        pos = 14;
                        gio.setColor(new Color(226,4,4));
                    }
                    else if (pos == 4){
                        pos = 10;
                        gio.setColor(new Color(45,123,189));
                    }
                    else if (pos == 8){
                        pos = 6;
                        gio.setColor(new Color(137,206,37));
                    }
                    else if (pos == 16){
                        pos = 2;
                        gio.setColor(new Color(245,104,37));
                    }         

                    if(x==0){
                        if(notes[i].getPos()==16&&a==true){
                            gio.setColor(Color.WHITE);
                            gio.fillRect(pos*20,notes[i+x].getPosY(), 30, 30*length);
                        }
                        if(notes[i].getPos()==8&&s==true){
                            gio.setColor(Color.WHITE);
                            gio.fillRect(pos*20,notes[i+x].getPosY(), 30, 30*length);
                        }
                        if(notes[i].getPos()==4&&d==true){
                            gio.setColor(Color.WHITE);
                            gio.fillRect(pos*20,notes[i+x].getPosY(), 30, 30*length);
                        }
                        if(notes[i].getPos()==2&&f==true){
                            gio.setColor(Color.WHITE);
                            gio.fillRect(pos*20,notes[i+x].getPosY(), 30, 30*length);
                        }
                        if(notes[i].getPos()==1&&g==true){
                            gio.setColor(Color.WHITE);
                            gio.fillRect(pos*20,notes[i+x].getPosY(), 30, 30*length);
                        }
                        
                    }
                    
                    else{
                        gio.fillRect(pos*20,notes[i+x].getPosY(), 30, 30*length);
                    }
                    System.out.println(pos);
                    
                }
            }
            
            if(notes[i].getTime()>1){
                notes[i].setTime(notes[i].getTime()-1);  
                notes[i].setPosY(notes[i].getPosY()-(panelGame.getHeight()/20));
                i--;             
            }
            
            System.out.println("Posicion: "+notes[i].getPos());
            
            
            if (i<notes.length)
                i++;
        }
        catch(Exception e){
            
        }
        
     }
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        panelGame = new JPanel() {

            public void paintComponent (Graphics gio)
            {
                super.paintComponents(gio);

                largo  = panelGame.getHeight();

                gio.setColor(Color.WHITE);
                gio.fillRect(0, 0, panelGame.getHeight(), panelGame.getHeight());

                gio.drawImage(Toolkit.getDefaultToolkit().getImage(System.getProperty("user.dir")+"/src/Images/Fondo1.jpg"), 0, 0, this);

                // color amarillo
                gio.setColor(new Color(240,233,43));
                gio.drawRect(18*20,((panelGame.getHeight()/20)*18), 30, 30);
                // color rojo
                gio.setColor(new Color(226,4,4));
                gio.drawRect(14*20, ((panelGame.getHeight()/20)*18), 30, 30);
                // color azul
                gio.setColor(new Color(45,123,189));
                gio.drawRect(10*20, ((panelGame.getHeight()/20)*18), 30, 30);
                // color verde
                gio.setColor(new Color(137,206,37));
                gio.drawRect(6*20, ((panelGame.getHeight()/20)*18), 30, 30);
                // color anaranjado
                gio.setColor(new Color(245,104,37));
                gio.drawRect(2*20, ((panelGame.getHeight()/20)*18), 30, 30);

                Draw(gio);

                //--------------EVENTO QUE SE ACTIVA CUANDO EL TECLADO ES PRESIONADO
                a=false;
                s=false;
                d=false;
                f=false;
                g=false;

                //-------------------------------

                try {

                    Thread.sleep(dificult);
                    repaint();

                }

                catch(InterruptedException e) {

                }

            }
        }
        ;
        jButton1 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        panelGame1 = new JPanel() {

            public void paintComponent (Graphics gio)
            {
                super.paintComponents(gio);

                largo  = panelGame.getHeight();

                gio.setColor(Color.WHITE);
                gio.fillRect(0, 0, panelGame.getHeight(), panelGame.getHeight());

                gio.drawImage(Toolkit.getDefaultToolkit().getImage(System.getProperty("user.dir")+"/src/Images/Fondo1.jpg"), 0, 0, this);

                // color amarillo
                gio.setColor(new Color(240,233,43));
                gio.drawRect(18*20,((panelGame.getHeight()/20)*18), 30, 30);
                // color rojo
                gio.setColor(new Color(226,4,4));
                gio.drawRect(14*20, ((panelGame.getHeight()/20)*18), 30, 30);
                // color azul
                gio.setColor(new Color(45,123,189));
                gio.drawRect(10*20, ((panelGame.getHeight()/20)*18), 30, 30);
                // color verde
                gio.setColor(new Color(137,206,37));
                gio.drawRect(6*20, ((panelGame.getHeight()/20)*18), 30, 30);
                // color anaranjado
                gio.setColor(new Color(245,104,37));
                gio.drawRect(2*20, ((panelGame.getHeight()/20)*18), 30, 30);

                Draw(gio);

                //--------------EVENTO QUE SE ACTIVA CUANDO EL TECLADO ES PRESIONADO
                a=false;
                s=false;
                d=false;
                f=false;
                g=false;

                //-------------------------------

                try {

                    Thread.sleep(0);
                    repaint();

                }

                catch(InterruptedException e) {

                }

            }
        }
        ;

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/name2.png"))); // NOI18N
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        panelGame.setBackground(new java.awt.Color(255, 255, 255));

        org.jdesktop.layout.GroupLayout panelGameLayout = new org.jdesktop.layout.GroupLayout(panelGame);
        panelGame.setLayout(panelGameLayout);
        panelGameLayout.setHorizontalGroup(
            panelGameLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 0, Short.MAX_VALUE)
        );
        panelGameLayout.setVerticalGroup(
            panelGameLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 481, Short.MAX_VALUE)
        );

        jButton1.setText("Start Game");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField2KeyPressed(evt);
            }
        });

        panelGame1.setBackground(new java.awt.Color(255, 255, 255));

        org.jdesktop.layout.GroupLayout panelGame1Layout = new org.jdesktop.layout.GroupLayout(panelGame1);
        panelGame1.setLayout(panelGame1Layout);
        panelGame1Layout.setHorizontalGroup(
            panelGame1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 0, Short.MAX_VALUE)
        );
        panelGame1Layout.setVerticalGroup(
            panelGame1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 481, Short.MAX_VALUE)
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(358, 358, 358)
                .add(jLabel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(76, 76, 76)
                        .add(jButton1))
                    .add(layout.createSequentialGroup()
                        .add(146, 146, 146)
                        .add(jTextField2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 102, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .add(85, 85, 85))
            .add(layout.createSequentialGroup()
                .add(panelGame, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(50, 50, 50)
                .add(panelGame1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(panelGame, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(panelGame1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(27, 27, 27)
                        .add(jButton1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(jTextField2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(0, 0, Short.MAX_VALUE))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(jLabel2)))
                .addContainerGap())
        );

        layout.linkSize(new java.awt.Component[] {panelGame, panelGame1}, org.jdesktop.layout.GroupLayout.VERTICAL);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        playStart = true;
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyPressed
       
                char i = evt.getKeyChar();
                String str = Character.toString(i);
                if(str.equalsIgnoreCase("a")){
                    a=true;
                }
                else if(str.equalsIgnoreCase("s")){
                    s=true;
                }
                else if(str.equalsIgnoreCase("d")){
                    d=true;
                }
                else if(str.equalsIgnoreCase("f")){
                    f=true;
                }
                else if(str.equalsIgnoreCase("g")){
                    g=true;
                }
            
  
    }//GEN-LAST:event_jTextField2KeyPressed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
       
    }//GEN-LAST:event_jLabel2MouseClicked
public void playTheSong(){
    
    if (!(songStarter)) {
        new PlayTheSong();
    }
}
     

class PlayTheSong implements Runnable {
Thread plays;
    public PlayTheSong(){
        plays = new Thread(this);
        plays.start();
    }
        @Override
        public void run() {
            
         try

                    {
                        
                        Player Mp3=new Player(music);

                        Mp3.play();



                    }

                    catch(Exception e)

                    {

                        System.out.println(e);

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
            java.util.logging.Logger.getLogger(GameBoard2PlayersView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameBoard2PlayersView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameBoard2PlayersView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameBoard2PlayersView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new GameBoard2PlayersView().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JPanel panelGame;
    private javax.swing.JPanel panelGame1;
    // End of variables declaration//GEN-END:variables
}
