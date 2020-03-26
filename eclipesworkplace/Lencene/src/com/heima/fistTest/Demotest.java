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
//	 第一步：创建一个java工程，并导入jar包。
//	 第二步：创建一个indexwriter对象。
	 IndexWriterConfig config=new IndexWriterConfig(Version.LATEST, anylyzer);
	 IndexWriter indexWriter=new IndexWriter(directory, config);
	
//	 1）指定索引库的存放位置Directory对象
//	 2）指定一个分析器，对文档内容进行分析。
//	 第二步：创建document对象。
//	 第三步：创建field对象，将field添加到document对象中。
	File file=new File("D:\\searchsource");
	File[] listFiles = file.listFiles();
	//
	for(File files:listFiles){
		Document document=new Document();
		//获得文件名
		String file_name = files.getName();
		//获得文件大小
		long file_length = FileUtils.sizeOf(files);
		//获得文件地址
		String file_path = files.getPath();
		//获得文件内容
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
//	 第四步：使用indexwriter对象将document对象写入索引库，此过程进行索引创建。并将索引和document对象写入索引库。
//	 第五步：关闭IndexWriter对象。
 }
 
 
 		@Test
 		public void searchIndex() throws IOException{
// 			第一步：创建一个Directory对象，也就是索引库存放的位置。
 			 Directory directory=FSDirectory.open(new File("D:\\temp\\index"));
// 			第二步：创建一个indexReader对象，需要指定Directory对象。
 			 IndexReader indexReader=DirectoryReader.open(directory);
// 			第三步：创建一个indexsearcher对象，需要指定IndexReader对象
 			 IndexSearcher indexSearcher=new IndexSearcher(indexReader);
// 			第四步：创建一个TermQuery对象，指定查询的域和查询的关键词。
 			 Query qy=new TermQuery(new Term("file_name", "apache"));
 			TopDocs search_result = indexSearcher.search(qy, 2);
// 			第五步：执行查询。
// 			第六步：返回查询结果。遍历查询结果并输出。
 			//拿到的是文档的id  
 			ScoreDoc[] scoreDocs = search_result.scoreDocs;
 			for(ScoreDoc sd:scoreDocs){
 				//通过获得的ID 查询到对应的document
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
// 			第七步：关闭IndexReader对象
 		}
 		
 		
 		public IndexWriter getIndexWriter() throws Exception{
 			 Directory directory=FSDirectory.open(new File("D:\\temp\\index"));
 			 Analyzer anylyzer=new StandardAnalyzer();
// 			 第一步：创建一个java工程，并导入jar包。
// 			 第二步：创建一个indexwriter对象。cp
 			 IndexWriterConfig config=new IndexWriterConfig(Version.LATEST, anylyzer);
 			 return new IndexWriter(directory, config);
 		}
 		
 		public  IndexSearcher getIndexSearcher() throws Exception{
 			//第一步：创建一个Directory对象，也就是索引库存放的位置。
			 Directory directory=FSDirectory.open(new File("D:\\temp\\index"));
//			第二步：创建一个indexReader对象，需要指定Directory对象。
			 IndexReader indexReader=DirectoryReader.open(directory);
//			第三步：创建一个indexsearcher对象，需要指定IndexReader对象
			 return new IndexSearcher(indexReader);
 		}
 		//删除所有
 		//
 		@Test
 		public void deleteAll() throws Exception{
 			IndexWriter indexWriter = getIndexWriter();
 			indexWriter.deleteAll();
 			indexWriter.close();
 		} 
 		//按照条件删除
 		@Test
 		public void delete() throws Exception{
 			IndexWriter indexWriter = getIndexWriter();
 			 Query qy=new TermQuery(new Term("file_name", "apache"));
		indexWriter.deleteDocuments(qy);
 			indexWriter.close();
 		} 
 		
 		//修改
 		@Test
 		public void update() throws Exception{
 			IndexWriter indexWriter = getIndexWriter();
 			Document doc=new Document();
 			Field fiel=new TextField("File_name", "积极", Store.YES);
 			doc.add(fiel);
 			indexWriter.updateDocument(new Term("file_name", "apache"), doc, new StandardAnalyzer());
 			indexWriter.close();
 		} 
 		
 		
 		//查询所有
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
 				//获得id
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
// 		最大值最小值查询
 		@Test
 		public void searchByNumber() throws Exception{
 			IndexSearcher indexSearcher = getIndexSearcher();
 			Query qy=NumericRangeQuery.newLongRange("file_length", 100L, 200L, true, true) ;
 			print(indexSearcher,qy);
 			indexSearcher.getIndexReader().close();
 		}
 		
 		//多条件查询
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
