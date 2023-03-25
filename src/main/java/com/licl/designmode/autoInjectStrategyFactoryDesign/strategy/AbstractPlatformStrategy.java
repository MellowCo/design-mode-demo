package com.licl.designmode.autoInjectStrategyFactoryDesign.strategy;

public abstract class AbstractPlatformStrategy implements IPlatformService {

  public void handlePlatform() {
    throw new UnsupportedOperationException("暂不支持处理该平台");
  }
}
