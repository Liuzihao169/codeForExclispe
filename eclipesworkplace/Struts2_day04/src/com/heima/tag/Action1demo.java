package com.heima.tag;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Action1demo extends ActionSupport {
          public String action1(){
        	  List<String>list=new ArrayList<String>();
        	  list.add("tom0");
        	  list.add("tom1");
        	  list.add("tom2");
        	  list.add("tom4");
        	  list.add("tom5");
        	  //存储到数据中心
        	  ActionContext.getContext().put("list", list);
        	  return  "view";
          }
}
