package io.thekraken.grok.configuration;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;


import org.junit.Test;

public class ConfigurationTest {

  public static String EMPTY_CONFIG = "src/test/resources/emptyConfig.yaml";
  public static String NULL_CONFIG = "src/test/resources/nullConfig.yaml";
  public static String SAMPLE_CONFIG = "src/test/resources/sampleConfig.yml";

  @Test
  public void testFileDoesntExistConfig() {
    boolean thrown = false;

    try {
      Configuration conf = new Configuration("/you/die");
    } catch (IllegalArgumentException e) {
      thrown = true;
    }
    assertTrue(thrown);

    thrown = false;
    try {
      Configuration conf = new Configuration("");
    } catch (IllegalArgumentException e) {
      thrown = true;
    }
    assertTrue(thrown);

    try {
      Configuration conf = new Configuration(null);
    } catch (IllegalArgumentException e) {
      thrown = true;
    }
    assertTrue(thrown);
  }

  @Test
  public void testEmptyConfig() {

    Configuration conf = new Configuration(EMPTY_CONFIG);

    assertEquals(conf.getInput().location, "");
    assertEquals(conf.getInput().type, "");

    assertEquals(conf.getFilter().file, "");
    assertEquals(conf.getFilter().pattern, "");

    assertEquals(conf.getOutput().location, "");
    assertEquals(conf.getOutput().type, "");
  }

  @Test
  public void testNullConfig() {

    Configuration conf = new Configuration(NULL_CONFIG);

    assertEquals(conf.getInput().location, "");
    assertEquals(conf.getInput().type, "");

    assertEquals(conf.getFilter().file, "");
    assertEquals(conf.getFilter().pattern, "");

    assertEquals(conf.getOutput().location, "");
    assertEquals(conf.getOutput().type, "");
  }

  @Test
  public void testSampleConfig() {

    Configuration conf = new Configuration(SAMPLE_CONFIG);

    assertEquals(conf.getInput().location, "/var/log/httpd.log");
    assertEquals(conf.getInput().type, "FILE");

    assertEquals(conf.getFilter().file, "%{APACHELOG}");
    assertEquals(conf.getFilter().pattern, "/grok/pattern/my_patterns");

    assertEquals(conf.getOutput().location, "./gork/out.txt");
    assertEquals(conf.getOutput().type, "FILE");
  }

}
