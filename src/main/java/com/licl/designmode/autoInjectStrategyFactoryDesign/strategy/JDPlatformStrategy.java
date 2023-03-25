package com.licl.designmode.autoInjectStrategyFactoryDesign.strategy;

import org.springframework.stereotype.Service;
import com.licl.designmode.autoInjectStrategyFactoryDesign.enums.PlatformEnum;

@Service
public class JDPlatformStrategy extends AbstractPlatformStrategy {
  @Override
  public void handlePlatform() {
    System.out.println("处理京东平台");
  }

  @Override
  public String getPlatform() {
    return PlatformEnum.JD.getPlatform();
  }
}
