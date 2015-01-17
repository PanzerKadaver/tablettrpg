package ihatereboot.tablettrpg;

import android.content.Context;
import android.telephony.TelephonyManager;

import java.util.UUID;

/**
 * Created by aubert_n on 17/01/2015.
 */
public class Utils {

    public static UUID getUUID()
    {
       UUID uuid;
       uuid = UUID.randomUUID();
       return (uuid);
    }
}
