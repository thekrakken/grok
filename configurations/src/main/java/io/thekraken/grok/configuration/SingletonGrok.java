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

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import com.nflabs.grok.Grok;
import com.nflabs.grok.GrokException;
import com.nflabs.grok.Match;

/**
 * Singleton of grok application
 * Manage the behavior of Grok
 *
 * @author anthonycorbacho
 * @since 0.0.1
 */
public class SingletonGrok {

  /**
   * Private constructor
   */
  private SingletonGrok(){
  }

  /**
   * Configuration of grok app
   */
  public Configuration config;

  /**
   *
   */
  public Boolean deamon;

  public static final String encoding = "UTF-8";

  /**
   * Singleton
   *
   * @return instance of Match
   */
  public static SingletonGrok getInstance() {
    return GrokHolder.INSTANCE;
  }

  private static class GrokHolder {
    private static final SingletonGrok INSTANCE = new SingletonGrok();
  }

  @Override
  public String toString(){
    return "Grok";
  }

  public void run() throws GrokException{
    /** Read grok configuration */
    if (config == null){
      throw new GrokException("Invalid configuration, Please check your grok configuration file");
    }
    if (!Configuration.checkLocation(config.getInput().location)
        || !Configuration.checkLocation(config.getFilter().file)){
      throw new GrokException("Location is Not Valid or does not exist");
    }
    /** Start grok api */
    Grok api = Grok.create(config.getFilter().file, config.getFilter().pattern);

    /** Collect the data */
    // TODO: improve the read
    BufferedReader reader = null;
    BufferedWriter writer = null;
    try {
      reader = new BufferedReader(new InputStreamReader(new FileInputStream(config.getInput().location), encoding));
      writer = new BufferedWriter(new FileWriter(config.getOutput().location));
      for (String line; (line = reader.readLine()) != null;) {
        Match gm = api.match(line);
        gm.captures();
        writer.write(gm.toJson() + "\n");
      }
      reader.close();
      writer.close();
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    /** We are done exit */
  }
}
