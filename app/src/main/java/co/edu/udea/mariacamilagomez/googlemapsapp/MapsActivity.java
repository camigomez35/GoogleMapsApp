package co.edu.udea.mariacamilagomez.googlemapsapp;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private static final int DEFAULT_ZOOM = 15;
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng udea = new LatLng(6.266953, -75.5691111);
        LatLng ruta_n = new LatLng(6.264537, -75.566561);
        LatLng fac_medicina = new LatLng(6.262483, -75.565681);
        LatLng unal = new LatLng(6.261487, -75.577569);
        LatLng atanasio = new LatLng(6.257087, -75.589027);

        Polyline una_ruta = googleMap.addPolyline(new PolylineOptions().add(
                udea, ruta_n
                )
        );


        mMap.addMarker(new MarkerOptions().position(udea).title("Universidad de Antioquia").snippet("Mi linda U"));
        mMap.addMarker(new MarkerOptions().position(ruta_n).title("Ruta N"));
        mMap.addMarker(new MarkerOptions().position(fac_medicina).title("Facultad de medicina UdeA"));
        mMap.addMarker(new MarkerOptions().position(unal).title("Universidad Nacional"));
        mMap.addMarker(new MarkerOptions().position(atanasio).title("Unidad deportiva Atanasio Girardot"));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(udea, DEFAULT_ZOOM));
        //mMap.animateCamera(CameraUpdateFactory.newLatLng(udea));
    }
}
