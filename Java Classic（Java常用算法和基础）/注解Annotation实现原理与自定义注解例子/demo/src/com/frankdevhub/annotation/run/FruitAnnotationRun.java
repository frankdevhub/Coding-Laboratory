package com.frankdevhub.annotation.run;

import com.frankdevhub.annotation.entity.FruitEntity;

/**
 * @ClassName: FruitAnnotationRun
 * @author: frankdevhub@gmail.com
 * @date: 2019年11月17日 下午1:48:42
 * @description: 测试类
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */
public class FruitAnnotationRun {
	// fruitName=Apple
	// fruitColorStr=RED
	// fruitProviderStr=id=20124860655;name=RedFuji;address=Japan;
	// FruitName=Watermelon FruitColor=Green FruitProvider=Shanghai

	public static void main(String[] args) {
		FruitInfoUtils.getFruitInfo(FruitEntity.class);

		FruitEntity customEntity = new FruitEntity("Watermelon", "Green", "Shanghai");
		System.out.println(customEntity);

	}
}
