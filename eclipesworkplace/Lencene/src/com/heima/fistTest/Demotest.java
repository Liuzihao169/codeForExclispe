package com.heima.fistTest;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.LongField;
import org.apache.lucene.document.StoredField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.xml.builders.NumericRangeQueryBuilder;
import org.apache.lucene.search.BooleanClause.Occur;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.MatchAllDocsQuery;
import org.apache.lucene.search.NumericRangeQuery;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.junit.Test;

public class Demotest {
 @Test 
 public void bulidIndex() throws IOException{
	 Directory directory=FSDirectory.open(new File("D:\\temp\\index"));
	 Analyzer anylyzer=new StandardAnalyzer();
//	 ��һ��������һ��java���̣�������jar����
//	 �ڶ���������һ��indexwriter����
	 IndexWriterConfig config=new IndexWriterConfig(Version.LATEST, anylyzer);
	 IndexWriter indexWriter=new IndexWriter(directory, config);
	
//	 1��ָ��������Ĵ��λ��Directory����
//	 2��ָ��һ�������������ĵ����ݽ��з�����
//	 �ڶ���������document����
//	 ������������field���󣬽�field��ӵ�document�����С�
	File file=new File("D:\\searchsource");
	File[] listFiles = file.listFiles();
	//
	for(File files:listFiles){
		Document document=new Document();
		//����ļ���
		String file_name = files.getName();
		//����ļ���С
		long file_length = FileUtils.sizeOf(files);
		//����ļ���ַ
		String file_path = files.getPath();
		//����ļ�����
		 String file_text = FileUtils.readFileToString(files);
		 
		 Field filenameField=new TextField("file_name", file_name, Store.YES);
		 Field filetextFiels=new TextField("file_text", file_text, Store.YES);
		 Field filepathFiels=new StoredField("file_path", file_path);
		 Field filelengthFiels=new LongField("file_length", file_length, Store.YES);
		 
		 document.add(filenameField);
		 document.add(filetextFiels);
		 document.add(filepathFiels);
		 document.add(filelengthFiels);
		 indexWriter.addDocument(document);
	}
	indexWriter.close();
//	 ���Ĳ���ʹ��indexwriter����document����д�������⣬�˹��̽�����������������������document����д�������⡣
//	 ���岽���ر�IndexWriter����
 }
 
 
 		@Test
 		public void searchIndex() throws IOException{
// 			��һ��������һ��Directory����Ҳ�����������ŵ�λ�á�
 			 Directory directory=FSDirectory.open(new File("D:\\temp\\index"));
// 			�ڶ���������һ��indexReader������Ҫָ��Directory����
 			 IndexReader indexReader=DirectoryReader.open(directory);
// 			������������һ��indexsearcher������Ҫָ��IndexReader����
 			 IndexSearcher indexSearcher=new IndexSearcher(indexReader);
// 			���Ĳ�������һ��TermQuery����ָ����ѯ����Ͳ�ѯ�Ĺؼ��ʡ�
 			 Query qy=new TermQuery(new Term("file_name", "apache"));
 			TopDocs search_result = indexSearcher.search(qy, 2);
// 			���岽��ִ�в�ѯ��
// 			�����������ز�ѯ�����������ѯ����������
 			//�õ������ĵ���id  
 			ScoreDoc[] scoreDocs = search_result.scoreDocs;
 			for(ScoreDoc sd:scoreDocs){
 				//ͨ����õ�ID ��ѯ����Ӧ��document
 				Document doc = indexSearcher.doc(sd.doc);
 			  String file_name = doc.get("file_name");
 			 String file_text = doc.get("file_text");
 			 String file_path = doc.get("file_path");
 			 String file_length = doc.get("file_length");
 			 System.out.println(file_name);
 			 System.out.println(file_text);
 			 System.out.println(file_path);
 			 System.out.println(file_length);
 			 System.out.println("----------------------");
 			}
// 			���߲����ر�IndexReader����
 		}
 		
 		
 		public IndexWriter getIndexWriter() throws Exception{
 			 Directory directory=FSDirectory.open(new File("D:\\temp\\index"));
 			 Analyzer anylyzer=new StandardAnalyzer();
// 			 ��һ��������һ��java���̣�������jar����
// 			 �ڶ���������һ��indexwriter����cp
 			 IndexWriterConfig config=new IndexWriterConfig(Version.LATEST, anylyzer);
 			 return new IndexWriter(directory, config);
 		}
 		
 		public  IndexSearcher getIndexSearcher() throws Exception{
 			//��һ��������һ��Directory����Ҳ�����������ŵ�λ�á�
			 Directory directory=FSDirectory.open(new File("D:\\temp\\index"));
//			�ڶ���������һ��indexReader������Ҫָ��Directory����
			 IndexReader indexReader=DirectoryReader.open(directory);
//			������������һ��indexsearcher������Ҫָ��IndexReader����
			 return new IndexSearcher(indexReader);
 		}
 		//ɾ������
 		//
 		@Test
 		public void deleteAll() throws Exception{
 			IndexWriter indexWriter = getIndexWriter();
 			indexWriter.deleteAll();
 			indexWriter.close();
 		} 
 		//��������ɾ��
 		@Test
 		public void delete() throws Exception{
 			IndexWriter indexWriter = getIndexWriter();
 			 Query qy=new TermQuery(new Term("file_name", "apache"));
		indexWriter.deleteDocuments(qy);
 			indexWriter.close();
 		} 
 		
 		//�޸�
 		@Test
 		public void update() throws Exception{
 			IndexWriter indexWriter = getIndexWriter();
 			Document doc=new Document();
 			Field fiel=new TextField("File_name", "����", Store.YES);
 			doc.add(fiel);
 			indexWriter.updateDocument(new Term("file_name", "apache"), doc, new StandardAnalyzer());
 			indexWriter.close();
 		} 
 		
 		
 		//��ѯ����
 		@Test 
 		public void serachAll() throws Exception{
 			IndexSearcher indexSearcher = getIndexSearcher();
 			Query qy=new MatchAllDocsQuery();
 			print(indexSearcher,qy);
 			
 		}
 		
 		public void print(IndexSearcher indexSearcher ,Query qy) throws Exception{
 			TopDocs search = indexSearcher.search(qy, 20);
 			ScoreDoc[] scoreDocs = search.scoreDocs;
 			for(ScoreDoc sd:scoreDocs){
 				//���id
 				Document doc = indexSearcher.doc(sd.doc);
 			  String file_name = doc.get("file_name");
 			 String file_text = doc.get("file_text");
 			 String file_path = doc.get("file_path");
 			 String file_length = doc.get("file_length");
 			 System.out.println(file_name);
 			 System.out.println(file_text);
 			 System.out.println(file_path);
 			 System.out.println(file_length);
 			 System.out.println("----------------------");
 			}
 		}
// 		���ֵ��Сֵ��ѯ
 		@Test
 		public void searchByNumber() throws Exception{
 			IndexSearcher indexSearcher = getIndexSearcher();
 			Query qy=NumericRangeQuery.newLongRange("file_length", 100L, 200L, true, true) ;
 			print(indexSearcher,qy);
 			indexSearcher.getIndexReader().close();
 		}
 		
 		//��������ѯ
 		@Test
 		public void Booleanseaarch() throws Exception{
 			IndexSearcher indexSearcher = getIndexSearcher();
 			BooleanQuery booleanQuery=new BooleanQuery();
 			 Query qy=new TermQuery(new Term("file_name", "apache"));
 			 Query qy2=new TermQuery(new Term("file_text", "apache"));
 			booleanQuery.add(qy, Occur.MUST);
 			booleanQuery.add(qy2, Occur.MUST);
 			print(indexSearcher,booleanQuery);
 			indexSearcher.getIndexReader().close();
 		}
}
