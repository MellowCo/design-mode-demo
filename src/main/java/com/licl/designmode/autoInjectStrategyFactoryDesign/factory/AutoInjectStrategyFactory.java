package com.licl.designmode.autoInjectStrategyFactoryDesign.factory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import com.licl.designmode.autoInjectStrategyFactoryDesign.strategy.AbstractPlatformStrategy;

@Component
public class AutoInjectStrategyFactory {

  @Resource
  public List<AbstractPlatformStrategy> platformStrategyList;

  private final Map<String, AbstractPlatformStrategy> strategyMap = new HashMap<>();

  @PostConstruct
  public void registered() {
    platformStrategyList.forEach(strategy -> strategyMap.put(strategy.getPlatform(), strategy));
  }

  public AbstractPlatformStrategy getStrategy(String platform) {
    return strategyMap.get(platform);
  }

}
