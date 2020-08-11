package com.fiberhome.itom.commons.utils;

import java.io.IOException;
import java.net.URL;
import java.util.*;

/**
 * This bundle can scan the specify resource in all jar files; for example, we
 * have 'i18n/message' in business module and common module; this bundle can
 * load these 2 files;
 * 
 * @see java.util.PropertyResourceBundle
 * @author vv
 * @since 2019/5/30
 */
public class ItomResourceBundle extends ResourceBundle {

	private static final Control CONTROL = new AggregateResourceBundleControl();

	private final Properties properties;

	private ItomResourceBundle(Properties properties) {
		this.properties = properties;
	}

	/**
	 * getResourceBundle
	 * 
	 * @param baseName resource name
	 * @param locale language&country
	 * @return ResourceBundle
	 */
	public static final ResourceBundle getResourceBundle(String baseName, Locale locale) {
		return getBundle(baseName, locale, CONTROL);
	}

	@Override
	protected Object handleGetObject(String key) {
		return this.properties.get(key);
	}

	@Override
	public Enumeration<String> getKeys() {
		Set<String> keySet = new HashSet<>();
		keySet.addAll(this.properties.stringPropertyNames());
		if (this.parent != null) {
			keySet.addAll(Collections.list(this.parent.getKeys()));
		}

		return Collections.enumeration(keySet);
	}

	private static class AggregateResourceBundleControl extends Control {
		private AggregateResourceBundleControl() {
		}

		/**
		 * create a bundle;
		 * 
		 * @see Control#newBundle
		 * @param baseName resource name
		 * @param locale language&country
		 * @param format ...
		 * @param loader class loader
		 * @param reload ...
		 * @return ResourceBundle
		 * @throws IllegalAccessException e
		 * @throws InstantiationException e
		 * @throws IOException e
		 */
		public ResourceBundle newBundle(String baseName, Locale locale, String format, ClassLoader loader,
				boolean reload) throws IllegalAccessException, InstantiationException, IOException {
			if (!"java.properties".equals(format)) {
				return super.newBundle(baseName, locale, format, loader, reload);
			} else {
				String resourceName = this.toBundleName(baseName, locale) + ".properties";
				Properties properties = this.load(resourceName, loader);
				return properties.size() == 0 ? null : new ItomResourceBundle(properties);
			}
		}

		private Properties load(String resourceName, ClassLoader loader) throws IOException {
			Properties aggregatedProperties = new Properties();
			// here, we load all files;
			Enumeration urls = loader.getResources(resourceName);
			while (urls.hasMoreElements()) {
				URL url = (URL) urls.nextElement();
				Properties properties = new Properties();
				properties.load(url.openStream());
				aggregatedProperties.putAll(properties);
			}

			return aggregatedProperties;
		}
	}
}
