package com.unlate;

import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void startNavigating(View view) {
    	String url = "http://arcgisdev.ecan.govt.nz/arcgis/rest/services/OSM/OSMNetwork/NAServer/Route/solve?stops=172.706%2C-43.536%3B172.68320%2C-43.48179%3B172.65%2C-43.526&barriers=&polylineBarriers=&polygonBarriers=&outSR=4326&ignoreInvalidLocations=true&accumulateAttributeNames=&impedanceAttributeName=Length&restrictionAttributeNames=Oneway&attributeParameterValues=&restrictUTurns=esriNFSBAllowBacktrack&useHierarchy=false&returnDirections=true&returnRoutes=true&returnStops=false&returnBarriers=false&returnPolylineBarriers=false&returnPolygonBarriers=false&directionsLanguage=en&directionsStyleName=&outputLines=esriNAOutputLineTrueShapeWithMeasure&findBestSequence=false&preserveFirstStop=false&preserveLastStop=false&useTimeWindows=false&startTime=0&outputGeometryPrecision=&outputGeometryPrecisionUnits=esriDecimalDegrees&directionsOutputType=esriDOTComplete&directionsTimeAttributeName=&directionsLengthUnits=esriNAUMiles&returnZ=false&f=html";
    	HttpClient httpclient = new DefaultHttpClient();
        HttpGet httpget = new HttpGet(url); 
        String result = "";
        try {
        	HttpResponse response = httpclient.execute(httpget);
            Log.i("Praeda",response.getStatusLine().toString());
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                InputStream instream = entity.getContent();
        		java.util.Scanner s = new java.util.Scanner(instream).useDelimiter("\\A");
        		if (s.hasNext()) 
        			result = s.next();
        	    s.close();
                instream.close();
            }
        } catch (Exception e) {}
    }
}
