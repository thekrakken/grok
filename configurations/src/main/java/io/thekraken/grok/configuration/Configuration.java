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
  public boolean checkLocation(){
    String locationFile = conf.input.location;

    File location = new File(locationFile);
    Preconditions.checkNotNull(location);
    if (!location.exists()) {
      return false;
    }
    if (!location.canRead()) {
      return false;
    }
    if (location.isFile()) {
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
      Preconditions.checkNotNull(yamlConfig);
      Preconditions.checkArgument(yamlConfig.getAbsoluteFile().exists(),
                                  "Configuration %s does not exits",
                                  yamlConfig.getAbsolutePath());
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
