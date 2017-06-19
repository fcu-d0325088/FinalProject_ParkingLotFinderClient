package edu.fcu.tw.finalproject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by sky_h on 6/16/2017.
 */

public class TCPClient {

    private final int PORT_NUMBER = 60132;

    private String mServerMessage;
    // sends message received notifications
//    private OnMessageReceived mMessageListener = null;
    // while this is true, the server will continue running
    private boolean mRun = false;
    // used to send messages
    private PrintWriter mBufferOut;
    // used to read messages from the server
    private BufferedReader mBufferIn;

    public void connectToServer(){
        boolean clientOpen = true;
        //		Scanner scan = new Scanner(System.in);
        String buffer = "";

        try{
            Socket client = new Socket("192.168.1.2",PORT_NUMBER);
            PrintStream writer = new PrintStream(client.getOutputStream());

            while(clientOpen){
                try {
                    System.out.println("send to Server:");
                    //buffer = input.readLine();
                    System.out.println(buffer);
                    writer.println(buffer);
                } catch (Exception e) {
                    System.out.println(e.toString());
                }
            }
            client.close();
        }catch (Exception e) {
            System.out.println(e.toString());
        }
    }







}
