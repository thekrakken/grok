package io.thekraken.grok.parser;

import io.airlift.command.Arguments;
import io.airlift.command.Command;
import io.airlift.command.Option;
import io.thekraken.grok.configuration.Configuration;
import io.thekraken.grok.configuration.SingletonGrok;

/**
 * Manage --file option
 *
 * @author anthonycorbacho
 * @since 0.0.1
 */
@Command(name = "--file", description = "Grok configuration file")
public class GrokFile extends GrokCommand {

  @Arguments(title = "FILEPATH",
      description = "location of Grok configuration file",
      required = true)
  String filePath;

  @Override
  public void run() {
    /** dont need to check the filePath here */
    SingletonGrok g = SingletonGrok.getInstance();
    g.config = new Configuration(filePath);
  }

}
