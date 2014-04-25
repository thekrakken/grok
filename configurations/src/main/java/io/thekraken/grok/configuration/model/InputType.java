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

import org.apache.commons.lang3.EnumUtils;

/**
 * Represente a valid input type
 *
 * @author anthonycorbacho
 * @since 0.0.1
 */
public enum InputType {
  FILE;

  public static boolean isValid(String value){
    return EnumUtils.isValidEnum(InputType.class, value.toUpperCase());
  }
}
