package com.fiberhome.itom.commons.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;

//import org.apache.ignite.IgniteCache;

/*import com.fiberhome.itom.commons.bean.SessionUser;
import com.fiberhome.itom.commons.entity.util.ItomIgniteClient;*/

/**
 * I18nUtils
 * 
 * @author vv
 * @since 2019/5/20
 */
public class I18nUtils {

	private static final Logger LOGGER = LoggerFactory.getLogger(I18nUtils.class);

	private static final String DFLT_FILE = "i18n/message";

	/**
	 * get internationalized message words;
	 * 
	 * @param key key to get internationalized message
	 * @return internationalized message
	 */
	public static String getMessage(String key) {
		return getMessage(DFLT_FILE, key);
	}

	/**
	 * get the user select Locale
	 * 
	 * @return Locale
	 */
	public static Locale getLocal() {
		/*String token = (String) ThreadLocalUtil.get("token");
		if (token == null) {
			return Locale.US;
		}
		ItomIgniteClient igniteClient = SpringUtils.getBean(ItomIgniteClient.class);
		try {
			IgniteCache userCache = igniteClient.getCache(Constant.USER);
			SessionUser sessionUser = (SessionUser) userCache.get(token);
			if (sessionUser == null) {
				return Locale.US;
			}
			String language = sessionUser.getLanguage();
			if (language == null || language.length() == 0) {
				return Locale.US;
			}
			String[] lan = language.split("_");
			if (lan.length == 2) {
				return new Locale(lan[0], lan[1]);
			}
		} catch (Throwable e) {
			LOGGER.error("Fail to load user's local language.");
		}*/
		return Locale.US;
	}

	/**
	 * get internationalized message with specify local.
	 * 
	 * @param key key
	 * @param locale locale
	 * @return message
	 */
	public static String getMessage(String key, Locale locale) {
		try {
			return ItomResourceBundle.getResourceBundle(DFLT_FILE, locale).getString(key);
		} catch (Exception e) {
			LOGGER.warn("Fail to load message. " + e.getMessage());
			return key;
		}
	}

	/**
	 * get internationalized message words;
	 * 
	 * @param fileName internationalize file
	 * @param key key need to be translated
	 * @return translated words;
	 * .
	 */
	private static String getMessage(String fileName, String key) {
		Locale locale = getLocal();
		try {
			return ItomResourceBundle.getResourceBundle(fileName, locale).getString(key);
		} catch (Exception e) {
			LOGGER.warn("Fail to load message. " + e.getMessage());
			return key;
		}
	}
}
