package com.licl.designmode.strategicFactoryDesign.factory;

import java.util.HashMap;
import java.util.Map;
import com.licl.designmode.strategicFactoryDesign.handle.BaseHandle;

public class Factory {
  static Map<String, BaseHandle> map = new HashMap<>();

  public static BaseHandle getHandle(String type) {
    return map.get(type);
  }

  public static void register(String type, BaseHandle handle) {
    map.put(type, handle);
  }
}
