package com.licl.designmode.enumStrategyFactoryDesign.strategy;

import org.springframework.stereotype.Service;

@Service
public class ConstructionStrategy implements IWorkOrderStrategy {

  public void generateWorkOrder() {
    System.out.println("生成施工工单");
  }
}
