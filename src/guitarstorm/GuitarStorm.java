/*
 * Giovanni Rojas Mazariegos 
 * Alex Bolaños 
 * Domingo 18 de Noviembre 2012
 * 
 */
package guitarstorm;

import View.GameBoardView;
import View.LoadingView;
import View.PlayerOptionView;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;

/**
 *
 * @author Giovani Rojas Mazariegos 
 */
public class GuitarStorm {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // look and feel 
        
         //se le agrega un try-catch por si no está instalada el look and feel
            try {
                //se cambia el look and feel
                 UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
                 
                //en caso de que no halla look and feel
                } catch (Exception ex) {
                    // no hace nada 
                
                } 
      
        
        // el game board controller 
        
    
        
      LoadingView load = new LoadingView ();
      load.setSize(312, 441);
      load.setLocationRelativeTo(null);
      load.setVisible(true);
      
      
        try {
            //Thread.sleep(6000);
            
             Thread.sleep(6500);
        } catch (InterruptedException ex) {
            Logger.getLogger(GuitarStorm.class.getName()).log(Level.SEVERE, null, ex);
        }
      load.dispose();
      
      

      PlayerOptionView va = new PlayerOptionView ();
     // va.setSize(400, 280); tamaño ideal 
      
      va.setSize(400,500);
      va.setLocationRelativeTo(null);
      va.setVisible(true);
              
                 
       

        
        
        
    }
}
