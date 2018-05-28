package com.suyaodong.servlet;

import static org.easymock.EasyMock.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.suyaodong.servlet.HelloServlet;;

public class ResultServletTest {

	private HelloServlet servlet;
	private HttpServletRequest mockRequest;
	private HttpServletResponse mockResponse;

	@Before
	public void setUp() {
		servlet = new HelloServlet();

		mockRequest = createMock(HttpServletRequest.class); // 加载
		mockResponse = createMock(HttpServletResponse.class);
	}

	@After
	public void tearDown() {
		verify(mockRequest); // 最后验证
		verify(mockResponse);
	}

	@Test
	public void testDoPostHttpServletRequestHttpServletResponse() throws ServletException, IOException {

		mockRequest.getParameter("bookID"); // 传入参数
		expectLastCall().andReturn("181914540");

		replay(mockRequest); // 回放
		replay(mockResponse);

		servlet.doPost(mockRequest, mockResponse); // 调用

	}

}