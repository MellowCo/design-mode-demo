package com.licl.designmode.strategicFactoryDesign.handle;

import com.licl.designmode.strategicFactoryDesign.factory.Factory;
import org.springframework.stereotype.Component;
import com.licl.designmode.strategicFactoryDesign.constant.OrderEnum;;

@Component
public class OrdinaryOrderHandle extends BaseHandle {

  public void generateOrder() {
    System.out.println("生成普通订单");
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    Factory.register(OrderEnum.ORDINARY.getCode(), this);
  }
}
