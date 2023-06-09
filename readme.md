# 设计模式
> 通过设计模式，删除 if else 语句，提高代码的可读性和可维护性

[github 地址](https://github.com/MellowCo/design-mode-demo)

## 无设计模式
```java
public class OrderHandle {
  /**
   * 无设计模式
   */
  public void generateOrder(String orderType) {
    if ("ordinary".equals(orderType)) {
      System.out.println("生成普通订单");
    } else if ("group".equals(orderType)) {
      System.out.println("生成团购订单");
    } else if ("promotion".equals(orderType)) {
      System.out.println("暂不支持促销订单");
    }
  }
}

// 使用
String orderType = "group";
OrderHandle orderHandle = new OrderHandle();
orderHandle.generateOrder(orderType);
```

---

## 静态工厂策略模式

[github](https://github.com/MellowCo/design-mode-demo/tree/master/src/main/java/com/licl/designmode/staticStrategyFactoryDesign)

* factory

```java
public class StaticStrategyFactory {
  static Map<String, AbstractOrderHandle> strategyMap = new HashMap<>();

  public static AbstractOrderHandle getStrategy(String type) {
    return strategyMap.get(type);
  }

  public static void register(String type, AbstractOrderHandle handle) {
    strategyMap.put(type, handle);
  }
}

```

* 策略抽象类
```java
public abstract class AbstractOrderHandle implements InitializingBean {

  public void generateOrder() {
    throw new UnsupportedOperationException("暂不支持生成该类型订单");
  }
}
```

* 订单策略
```java
@Component
public class GroupOrderHandle extends AbstractOrderHandle {

  public void generateOrder() {
    System.out.println("生成团购订单");
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    StaticStrategyFactory.register(OrderEnum.GROUP.getCode(), this);
  }
}
```

* test
```java
@Test
void testOrdinaryOrder() {
  StaticStrategyFactory.getStrategy(OrderEnum.ORDINARY.getCode()).generateOrder();
}
```

---
## 自动装配工厂策略模式

[github](https://github.com/MellowCo/design-mode-demo/tree/master/src/main/java/com/licl/designmode/autoInjectStrategyFactoryDesign)

* factory
```java
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
```

* 策略抽象类
```java
public abstract class AbstractPlatformStrategy implements IPlatform {

  public void handlePlatform() {
    throw new UnsupportedOperationException("暂不支持处理该平台");
  }
}

public interface IPlatform {
  String getPlatform();
}
```

* 策略
```java
@Service
public class JDPlatformStrategy extends AbstractPlatformStrategy {
  @Override
  public void handlePlatform() {
    System.out.println("处理京东平台");
  }

  @Override
  public String getPlatform() {
    return PlatformEnum.JD.getPlatform();
  }
}
```

* test
```java
@Test
void testJDPlatform() {
  autoInjectStrategyFactory.getStrategy(PlatformEnum.JD.getPlatform()).handlePlatform();
}
```

---
## 枚举工厂策略模式

[github](https://github.com/MellowCo/design-mode-demo/tree/master/src/main/java/com/licl/designmode/enumStrategyFactoryDesign)

* factory
```java
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
```

* 策略
```java
@Service
public class ConstructionStrategy implements IWorkOrderStrategy {

  public void generateWorkOrder() {
    System.out.println("生成施工工单");
  }
}
```

* test
```java
@Test
void testConstructionWorkOrder() {
  WorkOrderEnumFactory.getStrategy(WorkOrderEnumFactory.CONSTRUCTION.getCode()).generateWorkOrder();
}
```
