package com.newstool;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class JdbcProperty {
	private static Properties props = null;
	
	static {
		InputStream is = null;
		is = JdbcProperty.class.getClassLoader().getResourceAsStream("jdbcdao.properties");
		if(is == null) {
			throw new RuntimeException("找不到数据库参数配置文件");
		}
		props = new Properties();
		try {
			props.load(is);
		} catch (IOException e) {
			throw new RuntimeException("数据库配置加载错误");
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static String getProperty(String key) {
		return props.getProperty(key);
	}
}
