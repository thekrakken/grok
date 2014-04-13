package io.thekraken.grok.configuration;

public class SingletonGrok {

  /**
   * Private constructor
   */
  private SingletonGrok(){
  }
  
  /**
   * Configuration of grok app
   */
  public Configuration config;
  
  /**
   * Singleton
   *
   * @return instance of Match
   */
  public static SingletonGrok getInstance() {
    return GrokHolder.INSTANCE;
  }

  private static class GrokHolder {
    private static final SingletonGrok INSTANCE = new SingletonGrok();
  }
  
}
