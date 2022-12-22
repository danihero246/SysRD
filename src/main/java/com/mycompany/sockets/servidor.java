/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author daniel.herrera
 */
public class servidor {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            ServerSocket servidor = null;
            Socket sc = null;
            final int puerto = 5000;
            DataInputStream in;
            DataOutputStream out;

            try {    
            servidor = new ServerSocket(puerto);
            System.out.println("Servidor Iniciado");
            while(true){
                sc = servidor.accept();
                System.out.println("Cliente conectado");
                in = new DataInputStream(sc.getInputStream());
                out = new DataOutputStream(sc.getOutputStream());
                String mensaje = in.readUTF();
                System.out.println(mensaje);
                out.writeUTF("Hola Mundo");
                sc.close();
                System.out.println("Cliente desconectado");
            }
        } catch (IOException ex) {
            Logger.getLogger(servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
