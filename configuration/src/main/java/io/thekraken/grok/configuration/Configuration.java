package io.thekraken.grok.configuration;

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
  }

  /**
   * YAML reader
   * 
   * @author anthonycorbacho
   */
  private static class YamlConfig {
    public static YamlConfig EMPTY = new YamlConfig();

    public YamlConfig() {}
    
    public static YamlConfig parse(String path) {
      File yamlConfig = new File(path);
      Preconditions.checkNotNull(yamlConfig);
      Preconditions.checkArgument(yamlConfig.exists(),
                                  "Configuration %s does not exits",
                                  yamlConfig.getAbsolutePath());
      Yaml yaml = new Yaml(new Constructor(YamlConfig.class));
      YamlConfig conf = new YamlConfig();
      try {
        conf = (YamlConfig) yaml.load(new FileReader(yamlConfig));
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      }

      if (conf == null)
        conf = YamlConfig.EMPTY;
      return conf;
    }

  }

}
