package io.thekraken.grok.configuration.model;

public class Filter {

  public String file;
  public String pattern;

  public Filter() {}

  public Filter(String file, String pattern) {
    this.file = file;
    this.pattern = pattern;
  }

  public String getFile() {
    return file;
  }

  public void setFile(String file) {
    this.file = file;
  }

  public String getPattern() {
    return pattern;
  }

  public void setPattern(String pattern) {
    this.pattern = pattern;
  }
  
}
