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
