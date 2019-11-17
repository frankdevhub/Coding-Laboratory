package com.frankdevhub.annotation.run;

import java.lang.reflect.Field;

import com.frankdevhub.annotation.custom.FruitColor;
import com.frankdevhub.annotation.custom.FruitName;
import com.frankdevhub.annotation.custom.FruitProvider;

/**
 * @ClassName: FruitInfoUtils
 * @author: frankdevhub@gmail.com
 * @date: 2019年11月17日 下午1:29:56
 * @description: 注解解释器
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */
public class FruitInfoUtils {

	public static void getFruitInfo(Class<?> clazz) {

		String fruitNameStr = "fruitName=";
		String fruitColorStr = "fruitColorStr=";
		String fruitProviderStr = "fruitProviderStr=";

		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			if (field.isAnnotationPresent(FruitName.class)) {

				FruitName fruitName = (FruitName) field.getAnnotation(FruitName.class);
				fruitNameStr = fruitNameStr + fruitName.value();

				System.out.println(fruitNameStr);
			}

			if (field.isAnnotationPresent(FruitColor.class)) {

				FruitColor fruitColor = (FruitColor) field.getAnnotation(FruitColor.class);
				fruitColorStr = fruitColorStr + fruitColor.fruitColor().toString();

				System.out.println(fruitColorStr);
			}

			if (field.isAnnotationPresent(FruitProvider.class)) {

				FruitProvider fruitProvider = (FruitProvider) field.getAnnotation(FruitProvider.class);
				fruitProviderStr += "id=" + fruitProvider.id() + ";";
				fruitProviderStr += "name=" + fruitProvider.name() + ";";
				fruitProviderStr += "address=" + fruitProvider.address() + ";";

				System.out.println(fruitProviderStr);
			}
		}

	}

}
