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
@Command(name = "--as-deamon", description = "Start grok as deamon")
public class GrokDeamon extends GrokCommand {

  @Arguments(title = "Deamon",
      description = "true / false")
  Boolean deamon = false;

  @Override
  public void run(){
    System.out.println("NOT IMPLEMENTED YET");
    SingletonGrok.getInstance().deamon = deamon;
  }
}
