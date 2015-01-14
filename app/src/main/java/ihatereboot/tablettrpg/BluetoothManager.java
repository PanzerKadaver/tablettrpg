package ihatereboot.tablettrpg;

import android.bluetooth.BluetoothAdapter;

/**
 * Created by aubert_n on 14/01/2015.
 */
public class BluetoothManager {

    public static void BluetoothActivate() {
        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (mBluetoothAdapter == null) {
            System.out.println("device does not support bluetooth");
        } else
            System.out.println("bluetooth enabled");
    }

}
