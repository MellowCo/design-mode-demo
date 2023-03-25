package com.licl.designmode.staticStrategyFactoryDesign.factory;

import java.util.HashMap;
import java.util.Map;

import com.licl.designmode.staticStrategyFactoryDesign.strategy.AbstractOrderStrategy;

public class StaticStrategyFactory {
  static Map<String, AbstractOrderStrategy> strategyMap = new HashMap<>();

  public static AbstractOrderStrategy getStrategy(String type) {
    return strategyMap.get(type);
  }

  public static void register(String type, AbstractOrderStrategy handle) {
    strategyMap.put(type, handle);
  }
}
