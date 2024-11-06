package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;

public class MioThread extends Thread{
    Socket s;
    ArrayList user;

    public MioThread(Socket s, ArrayList user){
        this.s=s;
        this.user=user;
    }

    public void run(){
        try {
            BufferedReader in= new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream out = new DataOutputStream(s.getOutputStream());

            
            String scelta;
            String username;
            String messaggio;
            String nome;

            
            nome=in.readLine();
            
            if(!user.contains(nome)){
                user.add(nome);
            }

            scelta= in.readLine();

            do{
                scelta=in.readLine();
                if(scelta.equals("S")){
                    messaggio="s";
                    out.writeBytes(messaggio+"\n");

                    username=in.readLine();

                
                }
                else if(scelta.equals("L")){
                    messaggio="l";
                    out.writeBytes(messaggio+"\n");
                }
                else if(scelta.equals("EXIT")){
                    messaggio="ex";
                    out.writeBytes(messaggio+"\n");
                }
                else{
                    messaggio="e";
                    out.writeBytes(messaggio+"\n");
                }







                    
            }while(!scelta.equals("ex"));
            
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
