package com.licl.designmode.enumStrategyFactoryDesign.strategy;

import org.springframework.stereotype.Service;

@Service
public class MaintenanceStrategy implements IWorkOrderStrategy {

  public void generateWorkOrder() {
    System.out.println("生成维修工单");
  }
}
