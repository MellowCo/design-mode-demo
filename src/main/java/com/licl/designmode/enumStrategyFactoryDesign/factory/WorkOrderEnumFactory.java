package com.licl.designmode.enumStrategyFactoryDesign.factory;

import java.util.Objects;

import com.licl.designmode.enumStrategyFactoryDesign.strategy.ConstructionStrategy;
import com.licl.designmode.enumStrategyFactoryDesign.strategy.IWorkOrderStrategy;
import com.licl.designmode.enumStrategyFactoryDesign.strategy.MaintenanceStrategy;
import com.licl.designmode.enumStrategyFactoryDesign.utils.SpringContextUtils;

public enum WorkOrderEnumFactory {
  CONSTRUCTION("construction", "施工工单", ConstructionStrategy.class),
  MAINTENANCE("maintenance", "维修工单", MaintenanceStrategy.class);

  private String code;
  private String desc;
  private Class<?> strategyClass;

  WorkOrderEnumFactory(String code, String desc, Class<?> strategyClass) {
    this.code = code;
    this.desc = desc;
    this.strategyClass = strategyClass;
  }

  public String getCode() {
    return code;
  }

  public String getDesc() {
    return desc;
  }

  public Class<?> getStrategyClass() {
    return strategyClass;
  }

  public static IWorkOrderStrategy getStrategy(String code) {
    for (WorkOrderEnumFactory workOrderEnumFactory : WorkOrderEnumFactory.values()) {
      if (Objects.equals(workOrderEnumFactory.getCode(), code)) {
        return (IWorkOrderStrategy) SpringContextUtils.getBean(workOrderEnumFactory.getStrategyClass());
      }
    }
    throw new RuntimeException();
  }
}
