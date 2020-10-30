package com.example.jackson;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class Map implements MapView{
    private String id;
    private String name;
    private Point point;
    public Map() {
    }
    public Map(String id, String name, Point point) {
        this.id = id;
        this.name = name;
        this.point = point;
    }
    public String getName() {
        return name;
    }
    @Override 
    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id=id;
    }
    @Override
    @JsonSerialize(as = Point.class)
    public Point getPoint() {
        return point;
    }
    @JsonSerialize(as = Point.class)
    public void setPoint(Point point) {
        this.point=point;
    }
    @Override
    public String toString() {
        return "Map:[ id="+id+", name="+name+","+point+" ]";
    }
}
 