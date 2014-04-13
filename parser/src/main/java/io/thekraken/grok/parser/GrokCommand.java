package io.thekraken.grok.parser;

/**
 * Interface for the commands
 * 
 * @author anthonycorbacho
 * @since 0.0.1
 */
public class GrokCommand implements Runnable {

  @Override
  public void run() {
    System.out.println(getClass().getSimpleName());
  }

}
