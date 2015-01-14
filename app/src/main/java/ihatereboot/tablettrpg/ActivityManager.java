package ihatereboot.tablettrpg;



/**
 * Created by aubert_n on 14/01/2015.
 */
public class ActivityManager {
    public static void ResultCodeActivity(int resultCode)
    {
        switch (resultCode) {
            case MainActivity.RESULT_OK:
                // bluetooth now enable
                System.out.println("bluetooth now enable");
                break;
            case MainActivity.RESULT_CANCELED:
                // user said "no" to bluetooth activation or app crashed
                System.out.println("bluetooth not enabled");
                break;
            case MainActivity.RESULT_FIRST_USER:
                // start of user-defined activities
                System.out.println("first user lol ?");
                break;
        }
    }
}
