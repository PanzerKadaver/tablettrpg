package ihatereboot.tablettrpg;


import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;

import java.io.IOException;
import java.util.UUID;

/**
 * Created by aubert_n on 17/01/2015.
 */
public class ServerManager extends Thread {

    private static BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();;
    private static UUID MY_UUID = UUID.randomUUID();

    public static BluetoothServerSocket initialize() // AcceptThread()
    {
        BluetoothServerSocket sSock;
        BluetoothServerSocket tmp = null;
        try
        {
            tmp = mBluetoothAdapter.listenUsingRfcommWithServiceRecord("TTRPG", MY_UUID);
        }
        catch (IOException e)
        {
            System.out.println("error on listenUsingRfcommWithServiceRecord == "+e);
            e.printStackTrace();
        }
        sSock = tmp;
        return (sSock);
    }

    public static void runServer()
    {
        System.out.println("ServerManager.runServer() started . . ."); // debug
        System.out.println("Initializing ...");
        BluetoothServerSocket sSock = initialize();
        System.out.println("Successfuly initialized !");

        BluetoothSocket csock = null;





        /*
        String mydeviceaddress = mBluetoothAdapter.getAddress();
        String mydevicename = mBluetoothAdapter.getName();
        String status = mydevicename + " : " + mydeviceaddress;
        System.out.println("STATUS == ["+status+"]");
        */

        /*
        Set<BluetoothDevice> pairedDevices = mBluetoothAdapter.getBondedDevices();
        // If there are paired devices
        if (pairedDevices.size() > 0)
        {
            // Loop through paired devices
            for (BluetoothDevice device : pairedDevices)
            {
                // Add the name and address to an array adapter to show in a ListView
                System.out.println("bonded devices : ["+device.getName()+"::"+device.getAddress());
            }
        }
        */

        /*while (true) // listening till exception returned or socket is returned
        {
            try
            {
                csock = sSock.accept();
            }
            catch (IOException e)
            {
                System.out.println("Caught IOEXCEPTION in WHILE -> BREAK == "+e);
                break;
            }
            if (csock != null) // if a connection is accepted
            {
                manageNewClient(csock);
                try
                {
                    sSock.close(); // only one client
                }
                catch (IOException e)
                {
                    System.out.println("close sSock failed == "+e);
                    e.printStackTrace();
                }
                break;
            }
        }
        SystemClock.sleep(2000);*/
    }

    public static void manageNewClient(BluetoothSocket csock)
    {
        System.out.println("OU YEAH !");
    }
}
