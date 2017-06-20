package edu.fcu.tw.finalproject;

import android.util.Log;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by sky_h on 6/16/2017.
 */

public class TCPClient extends Thread {

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
    private PrintStream writer = null;
    private Socket client = null;
    private ParkingLotInterface pl_interface;
    private ArrayList<ParkingLot> pl= null;

    public TCPClient(ParkingLotInterface pl_interface){
        this.pl_interface = pl_interface;
    }

    public void run() {
        super.run();
        boolean clientOpen = true;
        String buffer = "";
        Log.v("run","running");
        try{
            client = new Socket("192.168.1.2",PORT_NUMBER);
            writer = new PrintStream(client.getOutputStream(),true,"UTF-8");
            mBufferIn  = new BufferedReader(new InputStreamReader(client.getInputStream(),"UTF-8"));

            while(clientOpen){
                Log.v("run","running");
                try {
//                    byte[] bytesFromSocket = ;
                  //  ObjectInputStream inFromClient = new ObjectInputStream(clientSocket.getInputStream());
                  //  ByteArrayInputStream bis = new ByteArrayInputStream(bytesFromSocket);
                    ObjectInputStream inFromClient = new ObjectInputStream(client.getInputStream());
                    Log.v("Item","Acquired!");
                    pl = (ArrayList<ParkingLot>)inFromClient.readObject();

                    Log.v("text312",pl.get(0).getName());

                    pl_interface.getParkingLotArray(pl);
                } catch (Exception e) {
                    Log.v("Caught exception","Caught!");
                    System.out.println(e.toString());
                }
            }
            client.close();
        }catch (Exception e) {
            System.out.println(e.toString());
        }
    }



    public void sendCoodinatetoServer(double lat, double lon){
        writer.println(lat+"");
        writer.flush();
        writer.println(lon+"");
        writer.flush();
    }

    public void closeConnection(){
        writer.println("CLOSE");
        writer.flush();
        writer.println("CLOSE");
        writer.flush();
        writer.close();
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
