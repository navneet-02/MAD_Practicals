package gps.location;
//import android.R;
import android.app.Activity; import android.os.Bundle; import android.view.View; import android.widget.Button; import android.widget.Toast;
public class GPSlocationActivity extends Activity {
    /** Called when the activity is first created. */ Button btnShowLocation;
    GPStrace gps; @Override
    public void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState); setContentView(R.layout.main); btnShowLocation=(Button)findViewById(R.id.show_Location); btnShowLocation.setOnClickListener(new View.OnClickListener() { @Override
    public void onClick(View v) {
// TODO Auto-generated method stub
        gps=new GPStrace(GPSlocationActivity.this); if(gps.canGetLocation()){
            double latitude=gps.getLatitude(); double longitude=gps.getLongtiude();
            Toast.makeText(getApplicationContext(),"Your Location is
                    \nLat:"+latitude+"\nLong:"+longitude, Toast.LENGTH_LONG).show();
        }
        else
        {
            gps.showSettingAlert();
        }
    } }); } })
        package gps.location;a
        import android.app.AlertDialog; import android.app.Service; import android.content.Context;
        import android.content.DialogInterface; import android.content.Intent;
        import android.location.Location;
        import android.location.LocationListener; import android.location.LocationManager;

        import android.os.Bundle; import android.os.IBinder;
        import android.provider.Settings;
public class GPStrace extends Service implements LocationListener{
    private final Context context; boolean isGPSEnabled=false; boolean canGetLocation=false; boolean isNetworkEnabled=false; Location location;
    double latitude; double longtitude;
    private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES=10; private static final long MIN_TIME_BW_UPDATES=1000*60*1; protected LocationManager locationManager;
    public GPStrace(Context context)
    {
        this.context=context; getLocation();
    }
    public Location getLocation()
    {
        try{ locationManager=(LocationManager)
                context.getSystemService(LOCATION_SERVICE); isGPSEnabled=locationManager.isProviderEnabled(LocationManager.G PS_PROVIDER);
            isNetworkEnabled=locationManager.isProviderEnabled(LocationManag er.NETWORK_PROVI
                    DER);
            if(!isGPSEnabled && !isNetworkEnabled){
            }else{ this.canGetLocation=true; if(isNetworkEnabled){
                locationManager.requestLocationUpdates( LocationManager.NETWORK_PROVIDER, MIN_TIME_BW_UPDATES, MIN_DISTANCE_CHANGE_FOR_UPDATES,this);
            }
                if(locationManager!=null){ location=locationManager.getLastKnownLocation(LocationManager.NE TWORK_PROVIDER)
                ;
                    if(location !=null){ latitude=location.getLatitude(); longtitude=location.getLongitude();
                    }}}

            if(isGPSEnabled){ if(location==null){
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVI DER,MIN_TIME_B
                        W_UPDATES, MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
                if(locationManager!=null){ location=locationManager.getLastKnownLocation(LocationManager.GP S_PROVIDER);
                    if(location!=null){ latitude=location.getLatitude(); longtitude=location.getLongitude();
                    }}}}}
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return location;
    }
    public void stopUsingGPS(){ if(locationManager!=null){ locationManager.removeUpdates(GPStrace.this);
    }}
    public double getLatitude(){ if(location!=null){ latitude=location.getLatitude();
    }
        return latitude;
    }
    public double getLongtiude(){ if(location!=null){ longtitude=location.getLatitude();
    }
        return longtitude;
    }
    public boolean canGetLocation(){ return this.canGetLocation;
    }
    public void showSettingAlert(){ AlertDialog.Builder alertDialog=new AlertDialog.Builder(context); alertDialog.setTitle("GPS is settings");
        alertDialog.setMessage("GPS is not enabled.Do you want to go to setting menu?");
        alertDialog.setPositiveButton("settings", new DialogInterface.OnClickListener() { @Override
        public void onClick(DialogInterface dialog,int which){

            Intent intent=new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS); context.startActivity(intent);
        }});
        alertDialog.setNegativeButton("cancel", new DialogInterface.OnClickListener() { @Override
        public void onClick(DialogInterface dialog, int which) {
// TODO Auto-generated method stub dialog.cancel();
        }
        });
        alertDialog.show();
    }
    @Override
    public void onLocationChanged(Location location) {
// TODO Auto-generated method stub
    }
    @Override
    public void onProviderDisabled(String provider) {
// TODO Auto-generated method stub
    }
    @Override
    public void onProviderEnabled(String provider) {
// TODO Auto-generated method stub
    }
    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
// TODO Auto-generated method stub
    }
    @Override
    public IBinder onBind(Intent intent) {
// TODO Auto-generated method stub return null;
    }}
10)	Go to manifest.xml file and add the code below
<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION"/>
<uses-permission android:name="android.permission.INTERNET"/>
        •	Now go to main.xml and right click.select run as option and select run configuration
        •	Android output is present in the android emulator as shown in below.
