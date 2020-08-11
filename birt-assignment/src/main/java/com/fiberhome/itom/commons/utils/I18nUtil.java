package com.fiberhome.itom.commons.utils;
/**
 * Copyright  Fiberhome pvt. ltd.
 * Plot no 19 Noida 127 (India)
 * All rights reserved.
 * <p>
 * This software is the confidential and proprietary information of
 * FiberHome, Inc. ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the terms
 * of the license agreement you entered into with FiberHome.
 * <p>
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * I18nUtil
 *
 * @author Rabbani
 * @version 1.0 02-03-2020
 */
@Component
public class I18nUtil {
	private static final String DFLT_FILE = "i18n/message";
	private static Logger logger = LoggerFactory.getLogger(com.fiberhome.itom.commons.utils.I18nUtil.class);

	/**
	 * i18nUtil
	 */
	@Autowired
    com.fiberhome.itom.commons.utils.I18nUtil i18nUtil;

	/**
	 * getLocal : Default language is english.
	 * 
	 * @return Locale Locale
	 */
	public Locale getLocal() {
		logger.info("-------------- I18nUtil : i18nUtil --------------");
		try {
			String languageConstant = "0";
			if (languageConstant.equalsIgnoreCase("0")) {
				logger.info("I18nUtil : i18nUtil : English");
				return Locale.US;
			}
			if (languageConstant.equalsIgnoreCase("1")) {
				return Locale.CHINA;
			}
		} catch (Throwable ex) {
			logger.info("I18nUtil : i18nUtil : Exception Default language will be English"
					+ ex);
			return Locale.US;
		}
		return Locale.US;
	}

	/**
	 * getMessage
	 * 
	 * @param key translation key
	 * @return String value
	 */
	public String getMessage(String key) {
		return getMessage(DFLT_FILE, key);
	}

	/**
	 * get internationalized message words;
	 *
	 * @param fileName internationalize file
	 * @param key key need to be translated
	 * @return translated words; .
	 */
	private String getMessage(String fileName, String key) {
		Locale locale = i18nUtil.getLocal();
		try {
			return ResourceBundle
					.getBundle(fileName, locale,
							ResourceBundle.Control.getNoFallbackControl(ResourceBundle.Control.FORMAT_DEFAULT))
					.getString(key);
		} catch (Exception e) {
			return key;
		}
	}
}
