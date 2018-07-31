package com.MEGR.udp;
import java.io.*;
import java.net.*;
public class Cliente {
	
		   public static void main(String argv[]) {
		      if (argv.length == 0) {
		         System.err.println("Java ClienteUDP Servidor");
		         System.exit(1);
		      }
		 
		      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		 
		      DatagramSocket socket;
		      InetAddress address;
		      byte[] mensaje_bytes = new byte[256];
		      byte[] MensajeServidor_bytes = new byte[256];
		      String mensaje="";
		      String mensajeServidor="";
		      //Paquete para enviar al servidor
		      DatagramPacket paquete;
		      //Creamos el objeto paquete2 de tipo DatagramPacket para recibir del servidor
		      DatagramPacket paquete2;
		      mensaje_bytes=mensaje.getBytes();
		 
		      try {
		 
		    	  //Creamos el socket
		    	  socket = new DatagramSocket();
		 
		         // Leemos el primer parametro, donde debe ir la direccion  
		         // IP del servidor 
		         address=InetAddress.getByName(argv[0]);
		 
		         mensaje = "Holaaaaaaa uwu";
		         mensaje_bytes = mensaje.getBytes();
		         //Creamos paquete
		         paquete = new DatagramPacket(mensaje_bytes,mensaje.length(),address,6000);
		         //Mandamos el paquete
		         socket.send(paquete);
		 
		         //El mensaje recibido vendra en bytes
		         MensajeServidor_bytes = new byte[256];
		         //Esperamos a recibir un paquete
		         paquete2 = new DatagramPacket(MensajeServidor_bytes,256);
		         socket.receive(paquete2);
		         //Convertimos el mensaje recibido en un string
		 		 mensajeServidor = new String(MensajeServidor_bytes).trim();
		 		 //Imprimimos el paquete recibido
		 		 System.out.println(mensajeServidor);  
		 
		         do {
		 
		        	//Lee los caracteres introducidos por pantalla 
		            mensaje = in.readLine();
		            mensaje_bytes = mensaje.getBytes();
		 
		            //Creamos paquete
		            paquete = new DatagramPacket(mensaje_bytes,mensaje.length(),address,6000);
		 
		            //Mandamos el paquete
		            socket.send(paquete);
		 
		            //El mensaje recibido vendra en bytes
		            MensajeServidor_bytes = new byte[256];
		 
		            //Esperamos a recibir un paquete
		            paquete2 = new DatagramPacket(MensajeServidor_bytes,256);
		            socket.receive(paquete2);
		 
		            //Convertimos el mensaje recibido en un string
		    		mensajeServidor = new String(MensajeServidor_bytes).trim();
		 
		    		//Imprimimos el paquete recibido
		    		System.out.println(mensajeServidor);  
		 
		         } while (!mensaje.startsWith("Fin"));
		      }
		      catch (Exception e) {
		         System.err.println(e.getMessage());
		         System.exit(1);
		      }
		   }
		}