package io.thekraken.grok.parser;

import io.airlift.command.Arguments;
import io.airlift.command.Command;
import io.thekraken.grok.configuration.SingletonGrok;

/**
 * Manage the option --as-deamon
 * 
 * @author anthonycorbacho
 * @since 0.0.1
 */
@Command(name = "--as-deamon", description = "Grok configuration file")
public class GrokDeamon extends GrokCommand {
  
  @Arguments(title = "",
      description = "true / false")
  Boolean deamon = false;

  @Override
  public void run(){
    System.out.println("NOT IMPLEMENTED YET");
    SingletonGrok.getInstance().deamon = deamon;
  }
}
