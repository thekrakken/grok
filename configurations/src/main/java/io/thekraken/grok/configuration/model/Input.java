package io.thekraken.grok.configuration.model;

public class Input {
  public String type;
  public String location;

  public static Input EMPTY = new Input();

  public Input() {
    type = "";
    location = "";
  }

  public Input(String type, String location) {
    this.type = type;
    this.location = location;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

}
