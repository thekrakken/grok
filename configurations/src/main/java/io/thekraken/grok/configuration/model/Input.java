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
package io.thekraken.grok.configuration.model;

import org.apache.commons.lang3.StringUtils;

/**
 * Represent output option
 *
 * @author anthonycorbacho
 * @since 0.0.1
 */
public class Input {
  public String type;
  public String location;

  public static Input EMPTY = new Input();

  public Input() {
    type = StringUtils.EMPTY;
    location = StringUtils.EMPTY;
  }

  public Input(String type, String location) {
    this.type = type;
    this.location = location;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

}
