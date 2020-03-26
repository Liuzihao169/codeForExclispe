package day14.demo.responsedownload;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.
	     	  String filename=request.getParameter("filename");
	     	  //���߿ͻ�������ʲô���ͷ��ļ� 
		      response.setContentType(this.getServletContext().getMimeType(filename));
		      //���߿ͻ��˲�Ҫ���� ���ļ�����ʽ��
		      response.setHeader("Content-Disposition", "attachment;filename="+filename );
		      String path=this.getServletContext().getRealPath("download/"+filename);
		      InputStream inp=new FileInputStream(path);
		      //�Զ������������д����
		      ServletOutputStream out=response.getOutputStream();
		      int len=0;
 	   	             byte [] buff=new byte[1024];
		      while((len=inp.read(buff))!=-1){
		    	  out.write(buff,0,len);
		      }
		      inp.close();
		      
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}