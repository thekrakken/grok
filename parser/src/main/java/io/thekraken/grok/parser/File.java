package io.thekraken.grok.parser;

import io.airlift.command.Arguments;
import io.airlift.command.Command;
import io.airlift.command.Option;

@Command(name = "file", description = "Grok configuration file")
public class File extends GrokCommand {

  @Arguments(title = "FILEPATH",
      description = "location of Grok configuration file",
      required = true)
  String filePath;

  @Override
  public void run() {
    /** dont need to check the filePath */
    /** Pass the file to YAML parser*/
  }

}
