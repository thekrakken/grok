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
