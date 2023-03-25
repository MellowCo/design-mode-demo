package com.licl.designmode.staticStrategyFactoryDesign.strategy;

import org.springframework.stereotype.Service;

import com.licl.designmode.staticStrategyFactoryDesign.enums.OrderEnum;
import com.licl.designmode.staticStrategyFactoryDesign.factory.StaticStrategyFactory;;

@Service
public class OrdinaryOrderStrategy extends AbstractOrderStrategy {

  public void generateOrder() {
    System.out.println("生成普通订单");
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    StaticStrategyFactory.register(OrderEnum.ORDINARY.getCode(), this);
  }
}
