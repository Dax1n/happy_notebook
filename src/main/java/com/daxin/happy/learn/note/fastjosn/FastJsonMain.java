package com.daxin.happy.learn.note.fastjosn;

import com.alibaba.fastjson.JSONObject;

public class FastJsonMain {
	
	public static void main(String[] args) {
		
		JSONObject os = new JSONObject();
		os.put("name", "daxin");
		os.put("age", 18);
		
		System.out.println(os.toJSONString());
		System.out.println(os.getInteger("age"));
		
		
	}

}
