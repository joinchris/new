package com.newstool;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Qypropertity {
	private static Properties pro = null;
	
	static{
		InputStream is = null;
		is = Qypropertity.class.getClassLoader().getResourceAsStream("qy.properties");
		if(is == null) {
			throw new RuntimeException("�Ҳ��������ļ�");
		}
		pro = new Properties();	
		try {
			pro.load(is);
		} catch (IOException e) {
			throw new RuntimeException("�����ļ����ش���");
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static String getPropertity(String key) {
		return pro.getProperty(key);
	}
	
}
