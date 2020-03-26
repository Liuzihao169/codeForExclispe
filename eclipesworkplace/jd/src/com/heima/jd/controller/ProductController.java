package com.heima.jd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.heima.jd.pojo.ProductModel;
import com.heima.jd.service.ProductService;
@Controller
public class ProductController {
	@Autowired
	private ProductService productSevice;
	@RequestMapping(value="/list.action")
	public String findProductListByQuery(String queryString,String catalog_name,String price,String sort,Model molde){
		List<ProductModel> productModels=productSevice.findProductListByQuery(queryString,catalog_name,price,sort);
		molde.addAttribute("productModels", productModels);
		molde.addAttribute("queryString", queryString);
		molde.addAttribute("catalog_name", catalog_name);
		molde.addAttribute("price", price);
		molde.addAttribute("sort", sort);
		return "product_list";
	}
	

}
