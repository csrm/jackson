package com.example.jackson;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.lang.model.util.ElementScanner6;

class Main {

  // Optional
  public void parseJsonManually(File file) throws FileNotFoundException, IOException {
    // if(true) {
    //   ObjectMapper objectMapper = new ObjectMapper();
    //   Trade[] trades = objectMapper.readValue(file, Trade[].class);
    //   for (Trade trade : trades) {
    //     System.out.println(trade);
    //   }
    // }
    // else 
      manualParser(file);

  }
  private void manualParser(File file) throws FileNotFoundException, IOException {
    BufferedReader br = new BufferedReader(new FileReader(file));
    String str,symbol="", purchaseDate="";
    int qty=0;
    Trade tr;
    while((str = br.readLine())!=null) {
      if(str.contains("[") || str.contains("{") || str.contains("]"))
        continue;
      else if(str.contains("}")){
        tr = new Trade(symbol, qty, purchaseDate);
        System.out.println(tr);
      }
      else{
        int first = str.indexOf(":");
        int last;
        if(str.charAt(str.length()-1)=='"')
          last = str.length()-1;
        else if(str.charAt(str.length()-1)!='"' && str.charAt(str.length()-1)!=',')
          last = str.length();
        else if (str.charAt(str.length()-2)=='"')
          last = str.length()-2;
        else
          last = str.length()-1;
         if(str.contains("symbol")){
          first+=3;
           symbol = str.substring(first,last);
         }
         else if(str.contains("purchaseDate")){
          first+=3;
           purchaseDate = str.substring(first, last);
         }
         else if(str.contains("quantity")){
          first+=2;
           qty = Integer.parseInt(str.substring(first,last));
         }
         
      }
    }
    br.close();
  }

  public void parseNestedJsonJacksomatically(Container container) throws JsonParseException, JsonMappingException, IOException{
     File outputFile = new File("src/main/java/com/example/jackson/nestedJson.json"); 
     ObjectMapper objectMapper = new ObjectMapper();
    //  objectMapper.writeValue(outputFile, container);
    //  System.out.println("Serialized the Container object... Check the file "+outputFile+", for Json");
     System.out.println("Now, Deserializing the Json from the same file");
     Container c = objectMapper.readValue(outputFile, Container.class);
     System.out.println(c);
     System.out.println("Done Deserializing a nested Json");
 }

  public void parseJsonJacksomatically(File inputFile, File outputFile) throws JsonParseException, JsonMappingException, IOException {
    ObjectMapper objectMapper = new ObjectMapper();

    Trade[] trades = objectMapper.readValue(inputFile, Trade[].class);
    System.out.println("Deserialized(read) successfully");

    for (Trade trade : trades) {
      System.out.println(trade);
    }

    // Uncomment these past Milestone 1 to serialize the JSON read
    // Serialize back the Java Trade objects to a file
    objectMapper.writeValue(outputFile, trades);
    // System.out.println("Serialized(wrote) successfully");
  }

  // Milestone 1
  public void writeImportantPurchasesToFile(int threshold, File inputFile, File outputFile) 
      throws JsonParseException, JsonMappingException, IOException {
    List<Trade> impTrades = new ArrayList<>();
    ObjectMapper objectMapper = new ObjectMapper();

    Trade[] trades = objectMapper.readValue(inputFile, Trade[].class);
    
    for (Trade trade : trades) {
      if (trade.quantity > threshold) {
        impTrades.add(trade);
      }
    }

    // TODO: Add method arguments
    objectMapper.writeValue(outputFile, impTrades);
  }

  // Milestone 4
  public void parseJsonJacksomaticallyPrivate(File inputFile, File outputFile) 
      throws JsonParseException, JsonMappingException, IOException {
    ObjectMapper objectMapper = new ObjectMapper();

    TradePrivate[] trades = objectMapper.readValue(inputFile, TradePrivate[].class);
    System.out.println("Deserialized(read) successfully");
    
    for (TradePrivate trade : trades) {
      System.out.println(trade);
    }

    objectMapper.writeValue(outputFile, trades);
    System.out.println("Serialized(wrote) successfully");
  }

  public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
    Main main = new Main();

    // Input JSON files to be deserialized
    File trades = new File("src/main/java/com/example/jackson/trades.json");
    File tradesFancy = new File("src/main/java/com/example/jackson/tradesFancy.json");
    File tradesFancier = new File("src/main/java/com/example/jackson/tradesFancier.json");

    // Serialized output JSON files
    File impTrades = new File("src/main/java/com/example/jackson/impTrades.json");
    File outputFile = new File("src/main/java/com/example/jackson/readOutput.json");

    // uncomment below line to run your manual json parsing logic
    main.parseJsonManually(trades);

    /* 
    /* uncomment below line to use Jackson
    /* use json input files as said in instructions
    /* Files - trades/tradesFancy/tradesFancier
    */
    main.parseJsonJacksomatically(tradesFancy, outputFile);
    // uncomment this to 
    main.writeImportantPurchasesToFile(50,trades, impTrades);

    // Uncomment in Milestone 4
    main.parseJsonJacksomaticallyPrivate(tradesFancier, outputFile);

    System.out.println("Running completed");

    //Start of nested Serialization
    Container c = new Container(new Map("500L", "PPFAS", new Point("ELS", "518L")));
    main.parseNestedJsonJacksomatically(c);

  }
}