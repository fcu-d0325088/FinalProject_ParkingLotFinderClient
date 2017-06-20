package edu.fcu.tw.finalproject;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;

import edu.fcu.tw.finalproject.ParkingLot;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.lang.reflect.Array;
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
    private Context context =null;


    public TCPClient(ParkingLotInterface pl_interface, Context mainContext){
        this.context = mainContext;

        this.pl_interface = pl_interface;
    }

    public void run() {
        super.run();
        boolean clientOpen = true;
        String buffer = "";
        pl = new ArrayList<ParkingLot>();
        Log.v("run","running");
        try{
            client = new Socket("10.0.2.10",PORT_NUMBER);
            writer = new PrintStream(client.getOutputStream(),true,"UTF-8");
            mBufferIn  = new BufferedReader(new InputStreamReader(client.getInputStream(),"UTF-8"));

            while(clientOpen){
                Log.v("run","running");
                try {
                    String jsonStr = mBufferIn.readLine();
                    JSONArray jsonArray = new JSONArray(jsonStr);
                    String name,lat,lng,price,distance,address,oph,available;
//                    mw.put("lattitude", pl.get(index).getLattitude()+"");
//                    mw.put("lng", pl.get(index).getLng()+"");
//                    mw.put("address", pl.get(index).getAddress());
//                    mw.put("price", pl.get(index).getPrice()+"");
//                    mw.put("available", pl.get(index).getAvailable()+"");
//                    mw.put("opR", pl.get(index).getOpR()+"");
//                    mw.put("distance", pl.get(index).getDistance()+"");

                    for(int i = 0; i < jsonArray.length();i++){
                        name = jsonArray.getJSONObject(i).getString("name");
                        lat = jsonArray.getJSONObject(i).getString("lattitude");
                        lng = jsonArray.getJSONObject(i).getString("lng");
                        price = jsonArray.getJSONObject(i).getString("price");
                        address = jsonArray.getJSONObject(i).getString("address");
                        distance = jsonArray.getJSONObject(i).getString("distance");
                        oph = jsonArray.getJSONObject(i).getString("opR");
                        available = jsonArray.getJSONObject(i).getString("available");

                        pl.add(new ParkingLot( lat,  lng,  name,  address,  price,  oph,  available, distance));
                    }

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
