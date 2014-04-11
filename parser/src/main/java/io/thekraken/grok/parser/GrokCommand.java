package io.thekraken.grok.parser;

/**
 *
 * @author anthonycorbacho
 */
public class GrokCommand implements Runnable {

  @Override
  public void run() {
    System.out.println(getClass().getSimpleName());
  }

}
