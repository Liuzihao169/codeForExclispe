package com.heima.jd.daoImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.heima.jd.dao.ProductDao;
import com.heima.jd.pojo.ProductModel;
@Repository
public class ProductDaoImpl implements ProductDao {
	
@Autowired
   private SolrServer solrServer;
	@Override
	public List<ProductModel> findProductListByQuery(String queryString, String catalog_name, String price,
			String sort) {
		// TODO Auto-generated method stub
		//判断空 然后设置约束条件
		SolrQuery query = new SolrQuery();
		if(null !=queryString&&!"".equals(queryString)){
			query.set("q", "product_name:"+queryString+"");
		}
		if(null !=catalog_name&&!"".equals(catalog_name)){
			query.set("fq", "product_catalog_name:"+catalog_name+"");
		}
		if(null !=price&&!"".equals(price)){
			String[] split = price.split("-");
			query.set("fq", "product_price:["+split[0]+" TO "+split[1]+"]");
		}
		if(null !=sort&&!"".equals(sort)){
			if(sort.equals("1")){
				query.addSort("product_price", ORDER.desc);
			}
			else{
				query.addSort("product_price", ORDER.asc);
			}
		}
		//设置默认查询的域
		query.set("df", "product_keywords");
		//设置显示的域
		query.set("fl", "id,product_price,product_name,product_picture");
		//设置分页
		query.setStart(0);
		query.setRows(15);
		//开启高亮显示
		query.setHighlight(true);
		//设置要高亮显示的域
		query.addHighlightField("product_name");
		query.setHighlightSimplePre("<span style='color:red'>");
		query.setHighlightSimplePost("</span>");
		
		QueryResponse response=null;
		try {
			response= solrServer.query(query);
			
		} catch (SolrServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//通过约束条件得到document结果集合
		SolrDocumentList results = response.getResults();
		Map<String, Map<String, List<String>>> highlighting = response.getHighlighting();
		List<ProductModel>list=new ArrayList<ProductModel>();
		
		for(SolrDocument doc:results){
			ProductModel productModel=new ProductModel();
			productModel.setPid((String) doc.get("id"));
			productModel.setName((String) highlighting.get(doc.get("id")).get("product_name").get(0));
			productModel.setPicture((String) doc.get("product_picture"));
			productModel.setPrice((Float)doc.get("product_price"));
			
			list.add(productModel);
		}
		
		
		return list;
	}

}
