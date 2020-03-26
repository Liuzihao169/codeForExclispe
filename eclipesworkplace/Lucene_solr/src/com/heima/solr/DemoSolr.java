package com.heima.solr;


import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

public class DemoSolr {
	  //���
	@Test
	public void testAdd() throws Exception{
		String baseURL = "http://localhost:8088/solr/";
		//������
		SolrServer solrServer=new HttpSolrServer(baseURL);
		SolrInputDocument doc=new SolrInputDocument();
		doc.addField("id", "hh");
		doc.addField("product_name", "������");
		solrServer.add(doc);
		//�ύ����
		solrServer.commit();
		
	}
	//��ѯ ����������ѯ
	//��ѯ����
	
			/* "product_catalog_name": "��Ĭ�ӻ�",
        "product_price": 18.9,
        "product_name": "�Ҹ�һ���˲�ɫ�����ź�� 8���ⶤ�ű��ҹ�2088",
        "id": "2",
        "product_picture": "2014032612461139.png",
        "_version_": 1615019916879986700*/
	@Test 
	public void testSearch() throws Exception{
		String baseURL = "http://localhost:8088/solr/";
		//������,�ؼ��� ̨��  �������� ��Ĭ �۸�  ��ҳ 
		SolrServer solrServer=new HttpSolrServer(baseURL);
	     SolrQuery query=new SolrQuery();
	     query.set("q", "product_name:̨��");
	     query.set("fq", "product_price:[* TO 10]");
	     query.addSort("product_price", ORDER.desc);
	     query.setStart(0);
	     query.setRows(2);
	     //���ø�����ʾ
	     //��һ����������
	     //ѡ���������
	     //���ø�����ʾ��ͷ��β��
	     query.setHighlightRequireFieldMatch(true);
	     query.addHighlightField("product_name");
	     query.setHighlightSimplePre("<p style='color:red'>");
	     query.setHighlightSimplePost("</p>");
		QueryResponse reponse = solrServer.query(query);
		SolrDocumentList results = reponse.getResults();
		Map<String, Map<String, List<String>>> highlighting = reponse.getHighlighting();
		//v k  id map
		//v k  ��  list[0]����ֵ
		long numFound = results.getNumFound();
		System.out.println(numFound);
		for(SolrDocument doc:results){
			System.out.println(doc.get("product_catalog_name"));
			System.out.println(doc.get("product_price"));
			System.out.println(doc.get("id"));
			System.out.println(doc.get("product_picture"));
			System.out.println(highlighting.get(doc.get("id")).get("product_name").get(0));
	
		
		}
	}

}
