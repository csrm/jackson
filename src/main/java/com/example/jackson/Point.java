package com.example.jackson;

public class Point implements PointView{
   private String id;
   private String name;
   public Point() {

   }
   public Point(String name, String id) {
      this.name = name;
      this.id = id;
   }
   @Override
   public String getId() {
        return id;
   } 
   public void setId(String id){
       this.id = id;
   }
   public String getName(){
       return name;
   }
   public void setName(String name){
       this.name = name;
   }
   @Override
   public String toString() {
       return "Point: [ id="+id+", name="+name+" ]";
   }
}
