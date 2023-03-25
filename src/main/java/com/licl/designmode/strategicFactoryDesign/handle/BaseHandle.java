package com.licl.designmode.strategicFactoryDesign.handle;

import org.springframework.beans.factory.InitializingBean;

public abstract class BaseHandle implements InitializingBean {

  public void generateOrder() {
    throw new UnsupportedOperationException("暂不支持生成该类型订单");
  }
}
