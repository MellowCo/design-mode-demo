package com.licl.designmode.strategicFactoryDesign.handle;

import com.licl.designmode.strategicFactoryDesign.factory.Factory;
import org.springframework.stereotype.Component;
import com.licl.designmode.strategicFactoryDesign.constant.OrderEnum;;

@Component
public class GroupOrderHandle extends BaseHandle {

  public void generateOrder() {
    System.out.println("生成团购订单");
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    Factory.register(OrderEnum.GROUP.getCode(), this);
  }
}
