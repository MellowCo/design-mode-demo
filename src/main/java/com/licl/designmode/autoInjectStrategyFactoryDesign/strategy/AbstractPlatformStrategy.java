package com.licl.designmode.autoInjectStrategyFactoryDesign.strategy;

public abstract class AbstractPlatformStrategy implements IPlatform {

  public void handlePlatform() {
    throw new UnsupportedOperationException("暂不支持处理该平台");
  }
}
