package ihatereboot.tablettrpg;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;

import static android.support.v4.app.ActivityCompat.startActivity;
import static android.support.v4.app.ActivityCompat.startActivityForResult;


/**
 * Created by aubert_n on 14/01/2015.
 */
public class BluetoothManager
{
    /*
    * Check if Bluetooth is supported on device
    */
    public static boolean isBluetoothSupported()
    {
        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (mBluetoothAdapter == null)
        {
            System.out.println("device does not support bluetooth");
            return (false);
        }
        System.out.println("bluetooth supported"); // debug
        return (true);
    }

    /*
    * Check if Bluetooth is enabled on device
     */
    public static boolean isBluetoothEnabled()
    {
        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (!mBluetoothAdapter.isEnabled()) {
            System.out.println("bluetooth not enabled");
            return (false);
        }
        System.out.println("bluetooth enabled");
        return (true);
    }

    /*
    * Return -1 on fail
    * Return 1 if bluetooth already ON
    * Return 0 if trying to activate bluetooth
     */
    public static int BluetoothActivate()
    {
        if (!isBluetoothSupported())
            return (-1);
        if (isBluetoothEnabled())
            return (1);
        else
        {
            //bob
            System.out.println("bluetooth not enabled");
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(MainActivity.activity, enableBtIntent, MainActivity.REQUEST_ENABLE_BT, null);
        }

        /*

        // make the device discoverable for 300sec

        Intent discoverableIntent = new
        Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
        discoverableIntent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 300);
        startActivityForResult(MainActivity.activity, discoverableIntent, MainActivity.REQUEST_ENABLE_BT, null);
        return true;
        */
        return (0);
    }
}
