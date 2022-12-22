/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author daniel.herrera
 */
public class cliente {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final String host = "127.0.0.1";
        final int puerto = 5000;
        DataInputStream in;
        DataOutputStream out;

        try {
            Socket sc = new Socket(host, puerto);
            in = new DataInputStream(sc.getInputStream());
            out = new DataOutputStream(sc.getOutputStream());
            out.writeUTF("Hola k ac, desde el cliente");
            String mensaje = in.readUTF();
            System.out.println(mensaje);
            sc.close();
        } catch (IOException ex) {
            Logger.getLogger(cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}