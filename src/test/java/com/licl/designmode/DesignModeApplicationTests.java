package com.licl.designmode;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.licl.designmode.autoInjectStrategyFactoryDesign.enums.PlatformEnum;
import com.licl.designmode.autoInjectStrategyFactoryDesign.factory.AutoInjectStrategyFactory;
import com.licl.designmode.enumStrategyFactoryDesign.factory.WorkOrderEnumFactory;
import com.licl.designmode.noDesign.OrderHandle;
import com.licl.designmode.staticStrategyFactoryDesign.enums.OrderEnum;
import com.licl.designmode.staticStrategyFactoryDesign.factory.StaticStrategyFactory;

@SpringBootTest
class DesignModeApplicationTests {

	@Resource
	AutoInjectStrategyFactory autoInjectStrategyFactory;

	@Test
	void noDesignMode() {
		// 无设计模式
		String orderType = "group";
		OrderHandle orderHandle = new OrderHandle();
		orderHandle.generateOrder(orderType);
	}

	/**
	 * 静态工厂策略模式
	 */
	@Test
	void testOrdinaryOrder() {
		StaticStrategyFactory.getStrategy(OrderEnum.ORDINARY.getCode()).generateOrder();
	}

	@Test
	void testGroupOrder() {
		StaticStrategyFactory.getStrategy(OrderEnum.GROUP.getCode()).generateOrder();
	}

	@Test
	void testPromotionOrder() {
		// 该工单模拟不支持生成方法，抛出 暂不支持促销订单 异常
		StaticStrategyFactory.getStrategy(OrderEnum.PROMOTION.getCode()).generateOrder();
	}

	/**
	 * 自动注入策略工厂模式
	 */
	@Test
	void testJDPlatform() {
		autoInjectStrategyFactory.getStrategy(PlatformEnum.JD.getPlatform()).handlePlatform();
	}

	@Test
	void testTBPlatform() {
		autoInjectStrategyFactory.getStrategy(PlatformEnum.TB.getPlatform()).handlePlatform();
	}

	@Test
	void testWXPlatform() {
		// 该平台模拟不支持处理方法，抛出 暂不支持处理该平台 异常
		autoInjectStrategyFactory.getStrategy(PlatformEnum.WX.getPlatform()).handlePlatform();
	}

	/**
	 * 枚举策略工厂模式
	 */
	@Test
	void testConstructionWorkOrder() {
		WorkOrderEnumFactory.getStrategy(WorkOrderEnumFactory.CONSTRUCTION.getCode()).generateWorkOrder();
	}

	@Test
	void testMaintenanceWorkOrder() {
		WorkOrderEnumFactory.getStrategy(WorkOrderEnumFactory.MAINTENANCE.getCode()).generateWorkOrder();
	}

}
