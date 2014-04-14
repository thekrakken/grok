package io.thekraken.grok.configuration.model;

/**
 * Representation of the propertie output in grok configuration file
 *
 * @author anthonycorbacho
 * @since 0.0.1
 */
public class Output {

  public String location;
  public String type;

  public static Output EMPTY = new Output();

  public Output() {
    type = "";
    location = "";
  }

  public Output(String type, String location) {
    this.location = location;
    this.type = type;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }


}
