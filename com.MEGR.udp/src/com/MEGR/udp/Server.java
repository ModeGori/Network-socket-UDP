package com.MEGR.udp;
import java.io.*;
import java.net.*;
public class Server {
	  public static void main(String argv[]) {
		  
	      DatagramSocket socket;
	      boolean fin = false;
	      //Creamos un objeto de tipo DatagramPacket para recibir un paquete del cliente
	      DatagramPacket paquete;
	      //Creamos paquete de vuelta para el cliente
	      DatagramPacket paquete2;
	      //Declaramos una variable de tipo string que guarda el mensaje recibido por el cliente
	      String mensaje ="";
	      //Declaramos una variable string para la cadena que le mandaremos al cliente
	      String MensajeSalida ="";
	 
	      try {
	 
	    	 //Abrimos un socket en el puerto 6000
	    	  //A traves de este socket enviaremos paquetes de tipo Datagram
	         socket = new DatagramSocket(6000);
	 
	         //Nos preparamos para recibir una mensaje de 256 bytes
	    	 byte[] mensaje_bytes = new byte[256];
	    	 mensaje_bytes = new byte[256];
	         //Creamos un contenedor de datagrama, el buffer sera el array mensaje_bytes
	    	 paquete = new DatagramPacket(mensaje_bytes,256);
	 
	         do {
	 
	            mensaje_bytes = new byte[256];
	 
	            //Creamos un contenedor de datagram, el buffer sera el array mensaje_bytes
	            paquete = new DatagramPacket(mensaje_bytes,256);
	 
	            //Esperamos a recibir un paquete
	            socket.receive(paquete);
	 
	           //Convertimos el mensaje recibido en un string
	        	mensaje = new String(mensaje_bytes).trim();
	 
	           //Imprimimos el paquete recibido
	           System.out.println(mensaje);  
	 
	 
	           //Condiciones encadenadas para mandar la información
	           //dependiendo del dato recibido
	           if (mensaje.startsWith("Holaaaaaaa uwu")) {
	 
	          	   MensajeSalida = "Holaaaaaaa uwu";
	           }
	           else if (mensaje.startsWith("ALL")) {
	 
	        	   MensajeSalida = "ALL :D:250; :V:300; :):540; :(:380; :/:240; :*:210; 3:):0; 0:):0; :P:300";
	           	System.out.println(MensajeSalida);
	 
	           }
	           else if(mensaje.startsWith(":D"))
	           {
	        	   MensajeSalida = ":D 250";
	           	System.out.println(MensajeSalida);
	           }
	           else if (mensaje.startsWith(":V")) {
	        	   MensajeSalida = ":V 300";
	           	System.out.println(MensajeSalida);
	           }
	           else if (mensaje.startsWith(":)")) {
	        	   MensajeSalida= ":) 540";
	           	System.out.println(MensajeSalida);
	           }
	           else if (mensaje.startsWith(":(")) {
	        	   MensajeSalida= ":( 380";
	           	System.out.println(MensajeSalida);
	           }
	           else if (mensaje.startsWith(":/")) {
	        	   MensajeSalida= ":/ 240";
	           	System.out.println(MensajeSalida);
	           }
	           else if (mensaje.startsWith(":*")) {
	        	   MensajeSalida= ":* 210";
	           	System.out.println(MensajeSalida);
	           }
	           else if (mensaje.startsWith("3:)")) {
	        	   MensajeSalida= "3:) 0";
	           	System.out.println(MensajeSalida);
	           }
	           else if (mensaje.startsWith("0:)")) {
	        	   MensajeSalida= "0:) 0";
	           	System.out.println(MensajeSalida);
	           }
	           else if (mensaje.startsWith(":P")) {
	        	   MensajeSalida= ":P 300";
	           	System.out.println(MensajeSalida);
	           }
	           else if (mensaje.startsWith("Fin")) {
	        	   MensajeSalida= "Fin";
	       	    System.out.println(MensajeSalida);
	       	    fin=true;
	           }
	           else{
	        	   MensajeSalida = "ERROR";	
	           	   System.out.println(MensajeSalida);
	           }           
	 
	           //Nº de puerto desde donde se envio  
	           int puerto = paquete.getPort();  
	           //Dirección de Internet desde donde se envio
	           InetAddress address = paquete.getAddress();
	           //Preparamos el formato que le vamos a mandar
	           byte[] mensaje2_bytes = new byte[256];
	           //Guardamos en mensaje2_bytes el mensaje de salida formateado
	           mensaje2_bytes = MensajeSalida.getBytes();
	           //Generamos el paquete de vuelta, usando los datos del remitente del paquete original 
	           paquete2 = new DatagramPacket(mensaje2_bytes,MensajeSalida.length(),address,puerto);
	           // Enviamos  
	           socket.send(paquete2);
	 
	         } while (!fin);
	      }
	      catch (Exception e) {
	         System.err.println(e.getMessage());
	         System.exit(1);
	      }
	   }
	}