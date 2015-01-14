package ihatereboot.tablettrpg;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;

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

    public static boolean BluetoothActivate()
    {
        if (!isBluetoothSupported())
            return (false);
        if (isBluetoothEnabled())
            return (true);
        else
        {
            //bob
            System.out.println("bluetooth not enabled");
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(MainActivity.activity, enableBtIntent, MainActivity.REQUEST_ENABLE_BT, null);
            return (true);
        }
    }
}
