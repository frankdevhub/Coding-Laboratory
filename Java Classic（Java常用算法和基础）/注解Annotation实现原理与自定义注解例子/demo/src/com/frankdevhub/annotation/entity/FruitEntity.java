package com.frankdevhub.annotation.entity;

import com.frankdevhub.annotation.custom.FruitColor;
import com.frankdevhub.annotation.custom.FruitName;
import com.frankdevhub.annotation.custom.FruitProvider;

/**
 * @ClassName: FruitEntity
 * @author: frankdevhub@gmail.com
 * @date: 2019年11月17日 下午12:22:50
 * @description: 测试实体类定义
 * @Copyright: 2019 www.frankdevhub.site Inc. All rights reserved.
 */
public class FruitEntity {

	@FruitName(value = "Apple")
	private String fruitName;

	@FruitColor(fruitColor = FruitColor.Color.RED)
	private String fruitColor;

	@FruitProvider(id = "20124860655", name = "RedFuji", address = "Japan")
	private String fruitProvider;

	public FruitEntity() {
	}

	/**
	 * @param fruitName
	 * @param fruitColor
	 * @param fruitProvider
	 */
	public FruitEntity(String fruitName, String fruitColor, String fruitProvider) {
		super();
		this.fruitName = fruitName;
		this.fruitColor = fruitColor;
		this.fruitProvider = fruitProvider;
	}

	/**
	 * @return the fruitName
	 */
	public String getFruitName() {
		return fruitName;
	}

	/**
	 * @param fruitName
	 *            the fruitName to set
	 */
	public void setFruitName(String fruitName) {
		this.fruitName = fruitName;
	}

	/**
	 * @return the fruitColor
	 */
	public String getFruitColor() {
		return fruitColor;
	}

	/**
	 * @param fruitColor
	 *            the fruitColor to set
	 */
	public void setFruitColor(String fruitColor) {
		this.fruitColor = fruitColor;
	}

	/**
	 * @return the fruitProvider
	 */
	public String getFruitProvider() {
		return fruitProvider;
	}

	/**
	 * @param fruitProvider
	 *            the fruitProvider to set
	 */
	public void setFruitProvider(String fruitProvider) {
		this.fruitProvider = fruitProvider;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FruitName=" + this.fruitName + "" + " FruitColor=" + this.fruitColor + "" + " FruitProvider="
				+ this.fruitProvider + "";
	}

}
