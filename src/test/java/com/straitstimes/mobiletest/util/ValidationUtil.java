package com.straitstimes.mobiletest.util;

import org.openqa.selenium.WebElement;

public class ValidationUtil {
	/**
	 * Method to verify image presence
	 * 
	 * @param imageElement
	 * @return
	 */
	public static boolean checkImageValidity(WebElement imageElement) {
		return imageElement.getSize().height > 0 && imageElement.getSize().width > 0;
	}
}
