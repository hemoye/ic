package com.jsu.ic.commons;

import java.util.Comparator;
import java.util.Random;

/**
 * 
 * 通用随机排序列的比较类
 * 
 * @author hadoop
 */
public class SortRandom implements Comparator<Object> {

	private Random random = new Random();

	public SortRandom() {
	}

	@Override
	public int compare(Object o1, Object o2) {
		return random.nextInt();
	}

}
