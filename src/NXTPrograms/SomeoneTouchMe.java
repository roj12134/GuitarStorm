/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package NXTPrograms;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import lejos.nxt.*;
import lejos.nxt.comm.BTConnection;
import lejos.nxt.comm.Bluetooth;

/**
 *
 * @author jamazariegosr
 */
public class SomeoneTouchMe {
    
    

    public static void main(String[] args) throws Exception{
        
        // Sensores de Lectura 
        UltrasonicSensor DistanceSensor = new UltrasonicSensor(SensorPort.S4);
        
        ColorSensor Light = new ColorSensor(SensorPort.S3);
        TouchSensor Right = new TouchSensor(SensorPort.S2);
        TouchSensor Left = new TouchSensor(SensorPort.S1);
                
                // fin de sensores de lectura 
        
        
        
        LCD.drawString("Esperando Conexion", 0, 0);
        BTConnection connection = Bluetooth.waitForConnection();
        DataInputStream dataIn = connection.openDataInputStream();
	DataOutputStream dataOut = connection.openDataOutputStream();
        LCD.refresh();
        
        LCD.drawString("Conectado a la Maquina Virtual", 0, 0);
        
        
		while (true) // es un ciclo que nunca voy a salir 
		{
			
                  // esta seccion es para leer de la maquina 
			//int numIn = dataIn.readInt(); // este el numero que recibo 
				
			int numIn = 8;	
                       
                       if (numIn == 0){  // si recibo un cero es por que la maquina virtual me mando a cerrar la connecion 
                          dataIn.close();
                          dataOut.close();
                          connection.close();
                          LCD.clear();
                          LCD.drawString("Hasta Pronto",0,0);
			  LCD.refresh();
                          break;
                       }
                       
                   // enviar datos de la maquina 
                       
                        // mando la distancia 
                       dataOut.write(DistanceSensor.getDistance()-5);
                       // luz 
                       dataOut.flush();
                       dataOut.write(Light.getLightValue());
                       // derecho 
                        dataOut.flush();
                       dataOut.writeBoolean(Right.isPressed());
                       // izquierdo 
                        dataOut.flush();
                       dataOut.writeBoolean(Left.isPressed());

                       dataOut.flush();
                       
                        LCD.drawString("Distancia: "+(DistanceSensor.getDistance()-5)+"\nLuz: "+Light.getLightValue(), 0, 0);
			if(Right.isPressed()==true) System.out.println("Derecho");
			if(Left.isPressed()==true) System.out.println("Izquierdo");
			LCD.refresh();
			Thread.sleep(200);
                     
			LCD.clear();
		}

      
    }
    
    
    
    
}
