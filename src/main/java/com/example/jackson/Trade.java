
package com.example.jackson;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Trade {
  @JsonProperty("symbol")
  public String symbol;
  @JsonProperty("quantity")
  public int quantity;
  @JsonProperty("purchaseDate")
  public String purchaseDate;
  
  public Trade() {
  }
  
  public Trade(String symbol, int quantity, String purchaseDate) {
    this.symbol = symbol;
    this.quantity = quantity;
    this.purchaseDate = purchaseDate;
  }

  @Override
  public String toString() {
    return "Trade [purchaseDate=" + purchaseDate + ", quantity=" + quantity + ", symbol=" + symbol + "]";
  }
}
