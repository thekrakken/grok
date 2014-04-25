/*******************************************************************************
 * Copyright 2014 Anthony Corbacho and contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package io.thekraken.grok.main;

//import org.apache.log4j.Logger;

import com.nflabs.grok.GrokException;

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
public class Grok {

  //static Logger LOG = Logger.getLogger(Grok.class);

  /**
   * Grok application entry point :)
   *
   * @param Arguments to pass to grok
   */
  public static void main(String... args) {
    //LOG.debug("Starting grok application");
    @SuppressWarnings("unchecked")
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
    try {
      g.run();
    } catch (GrokException e) {
      e.printStackTrace();
    }

    //LOG.debug("quit grok application");
  }



}
