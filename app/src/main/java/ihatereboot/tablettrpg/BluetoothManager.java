package ihatereboot.tablettrpg;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;

import static android.support.v4.app.ActivityCompat.startActivityForResult;


/**
 * Created by aubert_n on 14/01/2015.
 */
public class BluetoothManager
{
    private final static int REQUEST_ENABLE_BT = 747;

    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {

    }

    public static void BluetoothActivate()
    {
        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (mBluetoothAdapter == null)
            System.out.println("device does not support bluetooth");
        else
            System.out.println("bluetooth supported");
        if (mBluetoothAdapter.isEnabled())
            System.out.println("bluetooth enabled");
        else
        {
            //bob
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(MainActivity.activity, enableBtIntent, REQUEST_ENABLE_BT, null);
        }
    }

}
