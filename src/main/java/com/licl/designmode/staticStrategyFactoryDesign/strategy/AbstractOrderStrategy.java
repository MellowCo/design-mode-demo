package com.licl.designmode.staticStrategyFactoryDesign.strategy;

import org.springframework.beans.factory.InitializingBean;

public abstract class AbstractOrderStrategy implements InitializingBean {

  public void generateOrder() {
    throw new UnsupportedOperationException("暂不支持生成该类型订单");
  }

  public void getPlatform() {
  }
}
