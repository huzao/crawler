package com.dazhumei.love.utils;

import java.util.UUID;

public class UUIDUtil {
	public static String getUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
	}
	
	public static void main(String[] args) {
		System.out.println("C461AF31C61643E2A8F5697C881B3C6F".length());
	}
}
