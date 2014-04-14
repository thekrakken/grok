package io.thekraken.grok.configuration;

import com.nflabs.grok.GrokException;

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

  public void run() throws GrokException{
    /** Read grok configuration */
    if (config == null){
      throw new GrokException("Invalid configuration, Please check your grok configuration file");
    }
    if (!config.checkLocation()){
      throw new GrokException("Location is Not Valid or does not exist");
    }

    System.out.println(config.getInput().location);

    /** Start grok api */

    /** Collect the data */

    /** Save it */


    /** We are done exit*/
  }

}
