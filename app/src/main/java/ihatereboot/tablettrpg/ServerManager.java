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

    private BluetoothServerSocket sSock;
    private BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();;
    UUID MY_UUID = UUID.fromString("test");

    public void initialize() // AcceptThread()
    {
        BluetoothServerSocket tmp = null;
        try
        {
            mBluetoothAdapter.listenUsingRfcommWithServiceRecord("TTRPG", MY_UUID);
        }
        catch (IOException e)
        {
            System.out.println("error on listenUsingRfcommWithServiceRecord == "+e);
            e.printStackTrace();
        }
        sSock = tmp;
    }

    public void run()
    {
        BluetoothSocket csock = null;
        while (true) // listening till exception returned or socket is returned
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
            if (csock != null) // if a connection is accepeted
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
    }

    public void manageNewClient(BluetoothSocket csock)
    {
        System.out.println("SERVER UUID == ["+MY_UUID.toString()+"]");
        System.out.println("OU YEAH !");
    }
}
