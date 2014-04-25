package io.thekraken.grok.configuration.model;

import static org.junit.Assert.*;

import org.apache.commons.lang3.EnumUtils;
import org.junit.Test;

public class InputTypeTest {

  @Test
  public void testEnumUtilsEnumExist() {
    assertTrue(EnumUtils.isValidEnum(InputType.class, "FILE"));
    assertFalse(EnumUtils.isValidEnum(InputType.class, "YOLO"));
    assertFalse(EnumUtils.isValidEnum(InputType.class, "file"));
  }

  @Test
  public void testEnumExist(){
    assertTrue(InputType.isValid("FILE"));
    assertFalse(InputType.isValid("YOLO"));
    assertTrue(InputType.isValid("file"));
  }

}
