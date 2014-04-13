package io.thekraken.grok.configuration;

/**
 * Singleton of grok application
 * Manage the behavior of Grok
 * 
 * @author anthonycorbacho
 * @since 0.0.1
 */
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
   * 
   */
  public Boolean deamon;
  
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
  
  @Override
  public String toString(){
    return "Grok";
  }
}
