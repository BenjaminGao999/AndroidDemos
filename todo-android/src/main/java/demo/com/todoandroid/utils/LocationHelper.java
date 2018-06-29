package demo.com.todoandroid.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.provider.Settings;
import android.widget.Toast;

import demo.com.todoandroid.App;

import static android.content.Context.LOCATION_SERVICE;

/**
 * Author: benjamin
 * Time: 2018/6/19:下午2:36
 * email: benjamin.gaozq@gmail.com
 * desc:
 */

public class LocationHelper {
    private static final LocationHelper ourInstance = new LocationHelper();
    private static final int REQUEST_CODE_LOCATION = 1;
    private static LocationManager mLocationManager;

    public static LocationHelper getInstance() {
        return ourInstance;
    }

    private LocationHelper() {

    }


    /**
     * you have to check for Location Permission before use this method
     * add this code <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" /> to your Manifest file.
     * you have also implement LocationListener and passed it to the method.
     *
     * @param context
     * @param
     * @return {@code Location}
     */
    @SuppressLint("MissingPermission")
    public Location getLocation(Context context) {
        Location location = null;
        try {
            mLocationManager = (LocationManager) context.getSystemService(LOCATION_SERVICE);
            if (!isLocationEnabled()) {
                //no Network and GPS providers is enabled
                Toast.makeText(context
                        , "定位需要打开网络或者GPS"
                        , Toast.LENGTH_LONG)
                        .show();

                openGpsSettings();

            } else {
                if (isLocationEnabled()) {

                    if (mLocationManager != null) {
                        location = mLocationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                        if (location != null) {
                            return location;
                        }
                    }
                }
                //when GPS is enabled.
                if (isGpsEnabled()) {
                    if (location == null) {

                        if (mLocationManager != null) {
                            location =
                                    mLocationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                            if (location != null) {
                                return location;
                            }
                        }
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return location;
    }


    /**
     * 判断Gps是否可用
     *
     * @return {@code true}: 是<br>{@code false}: 否
     */
    private boolean isGpsEnabled() {
        LocationManager lm = (LocationManager) App.getContext().getSystemService(LOCATION_SERVICE);
        return lm != null && lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
    }

    /**
     * 判断定位是否可用
     *
     * @return {@code true}: 是<br>{@code false}: 否
     */
    private boolean isLocationEnabled() {
        LocationManager lm = (LocationManager) App.getContext().getSystemService(LOCATION_SERVICE);
        return lm != null
                && (lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
                || lm.isProviderEnabled(LocationManager.GPS_PROVIDER)
        );
    }

    /**
     * 打开Gps设置界面
     */
    private void openGpsSettings() {
        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
        App.getContext().startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
    }

}
