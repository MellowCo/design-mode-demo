package com.licl.designmode.autoInjectStrategyFactoryDesign.strategy;

import org.springframework.stereotype.Service;
import com.licl.designmode.autoInjectStrategyFactoryDesign.enums.PlatformEnum;

@Service
public class WXPlatformStrategy extends AbstractPlatformStrategy {
  // 模拟不支持 handlePlatform 方法，所以不需要实现
  // 抛出异常 暂不支持处理该平台

  @Override
  public String getPlatform() {
    return PlatformEnum.WX.getPlatform();
  }
}
