package com.example.googlemaps;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap nmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);

        supportMapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        /* ------------------ Any type works which are performed on the google are written here ---------------*/
        nmap = googleMap;


        LatLng delLatLng = new LatLng(28.613939,73.0243);
        MarkerOptions markerOptions = new MarkerOptions().position(delLatLng).title("New Delhi");
        nmap.addMarker(markerOptions);
        nmap.moveCamera (CameraUpdateFactory.newLatLng (delLatLng));
        nmap.animateCamera (CameraUpdateFactory.newLatLngZoom(delLatLng,16f));
        nmap.setMapType(GoogleMap.MAP_TYPE_SATELLITE); //changing view to satellite
    }
}