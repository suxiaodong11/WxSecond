package com.suyaodong.mongo;

import org.bson.Document;
import org.junit.Assert;
import org.junit.Test;

import com.google.gson.Gson;
import com.suyaodong.entity.Book;

import net.sf.json.JSONArray;

public class ControllerTest {
	Controller controller;

	@Test
	public void testUpload() {
		Book book = new Book();
		book.setBookID(123);
		book.setBookName("jksjdk");
		book.setTime(System.currentTimeMillis());
		controller = new Controller();
		int result = controller.upload(book);
		Assert.assertEquals("试图将对象强制转换为不是实例的子类时", 1, result);
	}

	@Test
	public void testDownload() {
		int count = 8;
		controller = new Controller();
		JSONArray JsonArray = controller.download();

		Assert.assertEquals("没有拿到全部数据", count, JsonArray.size());
	}

	@Test
	public void testFind() {
		controller = new Controller();

		Book book = new Book();
		book.setBookID(1238910);
		book.setBookName("Think");
		book.setDescript("xixi");

		Gson gson = new Gson();

		Document document = controller.find();

		Assert.assertEquals("查找的数据不相等", book.getBookID(), document.get("bookID"));
	}

	/*
	 * @org.junit.Test public void getAllCategoryTest() throws Exception {
	 * String responseString = mockMvc.perform(
	 * get("/categories/getAllCategory") //请求的url,请求的方法是get
	 * .contentType(MediaType.APPLICATION_FORM_URLENCODED) //数据的格式
	 * .param("pcode","root") //添加参数 ).andExpect(status().isOk()) //返回的状态是200
	 * .andDo(print()) //打印出请求和相应的内容
	 * .andReturn().getResponse().getContentAsString(); //将相应的数据转换为字符串
	 * System.out.println("--------返回的json = " + responseString); }
	 */

}
