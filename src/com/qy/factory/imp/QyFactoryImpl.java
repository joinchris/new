package com.qy.factory.imp;

import com.newstool.Qypropertity;
import com.qy.Qy;
import com.qy.factory.QyFactory;

public class QyFactoryImpl implements QyFactory{

	@Override
	public Qy creatQy(String key) {
		String className = Qypropertity.getPropertity(key);
		Qy qy = null;
		try {
			try {
				qy = (Qy) Class.forName(className).newInstance();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return qy;
	}

}
