package com.licl.designmode.autoInjectStrategyFactoryDesign.strategy;

import org.springframework.stereotype.Service;
import com.licl.designmode.autoInjectStrategyFactoryDesign.enums.PlatformEnum;

@Service
public class TBPlatformStrategy extends AbstractPlatformStrategy {
  @Override
  public void handlePlatform() {
    System.out.println("处理淘宝平台");
  }

  @Override
  public String getPlatform() {
    return PlatformEnum.TB.getPlatform();
  }
}
