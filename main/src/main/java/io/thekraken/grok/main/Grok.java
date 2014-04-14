package io.thekraken.grok.main;

//import org.apache.log4j.Logger;

import io.airlift.command.Cli;
import io.airlift.command.Cli.CliBuilder;
import io.airlift.command.Help;
import io.airlift.command.ParseArgumentsUnexpectedException;
import io.airlift.command.ParseOptionMissingValueException;
import io.thekraken.grok.configuration.SingletonGrok;
import io.thekraken.grok.parser.*;


/**
 * Grok application
 *
 * @author anthonycorbacho
 * @since 0.0.1
 */
@SuppressWarnings("unchecked")
public class Grok {

  //static Logger LOG = Logger.getLogger(Grok.class);

  /**
   * Grok application entry point :)
   *
   * @param Arguments to pass to grok
   */
  public static void main(String... args) {
    //LOG.debug("Starting grok application");
    CliBuilder<Runnable> builder = Cli.<Runnable>builder("grok")
                                   .withDescription("Grok apllication")
                                   .withDefaultCommand(Help.class)
                                   .withCommands(Help.class, GrokFile.class, GrokDeamon.class);
    Cli<Runnable> deguParser = builder.build();
    try {
      deguParser.parse(args).run();
    } catch (ParseArgumentsUnexpectedException e) {
      //LOG.error(e.getMessage());
      System.out.println("Unknown command");
    } catch (ParseOptionMissingValueException e1) {
      //LOG.error(e1.getMessage());
      System.out.println("Missing value: " + e1.getMessage());
    }

    /** Start the grok app */
    SingletonGrok g = SingletonGrok.getInstance();

    //LOG.debug("quit grok application");
  }



}
