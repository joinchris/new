package com.qy;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Qy {
	//�����Լ�
	void qyDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
