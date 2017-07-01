package com.ustbcafe.deepin.systems.pojo;

/**
 * Created by Rudy Steiner on 2017/5/12.
 */
public class LatLonPointWrapper  {
    private LatLonPoint latLonPoint;
    private double  latitude;
    private double  longitude;
    public LatLonPointWrapper(){}
    public LatLonPointWrapper(double latitude,double longitude){
        latLonPoint=new LatLonPoint(latitude,longitude);
    }
    public double getLatitude(){
        return latLonPoint.getLatitude();
    }
    public  double getLongitude(){
        return latLonPoint.getLongitude();
    }
}
