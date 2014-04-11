package io.thekraken.grok.parser;

import io.airlift.command.Arguments;
import io.airlift.command.Command;
import io.airlift.command.Option;

@Command(name = "--file", description = "Grok configuration file")
public class File extends GrokCommand {

  @Arguments(description = "location of grok config")
  String filePath;

}
