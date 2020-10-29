
package com.example.jackson;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TradePrivate {

  private String symbol;

  private int quantity;

  private String purchaseDate;

  public TradePrivate() {
  }

  public TradePrivate(String symbol, int quantity, String purchaseDate) {
    this.symbol = symbol;
    this.quantity = quantity;
    this.purchaseDate = purchaseDate;
  }

  public String getSymbol() {
    return symbol;
  }

  public void setSymbol(String symbol) {
    this.symbol = symbol;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public String getPurchaseDate() {
    return purchaseDate;
  }

  public void setPurchaseDate(String purchaseDate) {
    this.purchaseDate = purchaseDate;
  }
  
  @Override
  public String toString() {
    return "TradePrivate [purchaseDate=" + purchaseDate + ", quantity=" + quantity + ", symbol=" + symbol + "]";
  }
}
