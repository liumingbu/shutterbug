package cn.photo.shutterbug.utils;

import com.alibaba.fastjson.JSONObject;

/**
 * responseBody 的响应对象
 * @author Administrator
 *
 */
public class JSONUtil{
	
	public static JSONObject create () {
		JSONObject jo = new JSONObject();
		jo.put("op", "suc");
		return jo;
	}
}
