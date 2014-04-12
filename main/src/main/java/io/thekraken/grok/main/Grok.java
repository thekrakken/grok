package io.thekraken.grok.main;

import io.airlift.command.Cli;
import io.airlift.command.Cli.CliBuilder;
import io.airlift.command.Help;
import io.airlift.command.ParseArgumentsUnexpectedException;
import io.airlift.command.ParseOptionMissingValueException;
import io.thekraken.grok.parser.File;

import org.apache.log4j.Logger;

/**
 * Grok application
 *
 * @author anthonycorbacho
 *
 */
@SuppressWarnings("unchecked")
public class Grok {

  static Logger LOG = Logger.getLogger(Grok.class);

  /**
   * Grok application entry point :)
   *
   * @param Arguments to pass to grok
   */
  public static void main(String... args) {
    LOG.debug("Starting grok application");
    CliBuilder<Runnable> builder = Cli.<Runnable>builder("grok")
                                   .withDescription("Grok apllication")
                                   .withDefaultCommand(Help.class)
                                   .withCommands(Help.class, File.class);
    Cli<Runnable> deguParser = builder.build();
    try {
      deguParser.parse(args).run();
    } catch (ParseArgumentsUnexpectedException e) {
      LOG.error(e.getMessage());
      System.out.println("Unknown command");
    } catch (ParseOptionMissingValueException e1) {
      LOG.error(e1.getMessage());
      System.out.println("Missing value: " + e1.getMessage());
    }
    LOG.debug("quit grok application");
  }

}
