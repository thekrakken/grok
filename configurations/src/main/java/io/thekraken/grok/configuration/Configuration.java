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
package io.thekraken.grok.configuration;

import io.thekraken.grok.configuration.model.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import com.google.common.base.Preconditions;

/**
 * Read configuration from file (YAML)
 *
 * @author anthonycorbacho
 * @since 0.0.1
 */
public class Configuration {

  private YamlConfig conf;

  public Configuration(String path){
    conf = YamlConfig.parse(path);
    if (conf==null)
      conf = YamlConfig.EMPTY;
  }

  public Input getInput(){
    return conf.input;
  }

  public Filter getFilter(){
    return conf.filter;
  }

  public Output getOutput(){
    return conf.output;
  }

  /**
   * Check if the Input location is valid
   *
   * @return true if the location is valid
   */
  public static boolean checkLocation(String path){
    File location = new File(path);
    if (!location.exists() || !location.canRead()) {
      return false;
    }
    if (location.isFile()) {
      // Set it
      return true;
    }
    return false;
  }

  public boolean checkGrokFilter(){
    String pattern = conf.filter.pattern;
    String filePattern = conf.filter.file;

    Preconditions.checkNotNull(pattern, "No pattern");
    Preconditions.checkArgument(!pattern.isEmpty(), "Pattern is empty");

    File file = new File(filePattern);
    if (!file.exists() || !file.canRead()) {
      return false;
    }
    if (file.isFile()) {
      // Set it
      return true;
    }
    return false;
  }

  /**
   * YAML reader
   *
   * @author anthonycorbacho
   */
  private static class YamlConfig {
    public static YamlConfig EMPTY = new YamlConfig();

    public Input input;
    public Filter filter;
    public Output output;

    public YamlConfig() {
      input = Input.EMPTY;
      filter = Filter.EMPTY;
      output = Output.EMPTY;
    }

    public static YamlConfig parse(String path) {
      if (path == null ){
        throw new IllegalArgumentException("The path is null");
      }
      File yamlConfig = new File(path);
      Yaml yaml = new Yaml(new Constructor(YamlConfig.class));
      YamlConfig conf = new YamlConfig();
      try {
        conf = (YamlConfig) yaml.load(new FileReader(yamlConfig));
      } catch (FileNotFoundException e) {
        throw new IllegalArgumentException(e.getMessage());
      }
      if (conf == null)
        conf = YamlConfig.EMPTY;
      return conf;
    }

  }

}
