package com.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Server partito");
        ServerSocket s1= new ServerSocket(3000);
        ArrayList user = new ArrayList<String>();

        do{

            Socket s= s1.accept();
            MioThread t= new MioThread(s, user);
            t.start();
        }while(true);
    }
}