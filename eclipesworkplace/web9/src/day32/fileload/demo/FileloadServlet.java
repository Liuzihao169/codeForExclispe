package day32.fileload.demo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

public class FileloadServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {

			//1�����������ļ����
			//���ã����û����ļ��Ĵ�С  ������ʱ�ļ��洢��λ��
			String path_temp = this.getServletContext().getRealPath("temp");
			//DiskFileItemFactory factory = new DiskFileItemFactory(1024*1024, new File(path_temp));
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(1024*1024);
			factory.setRepository(new File(path_temp));
			//2�������ļ��ϴ��ĺ�����
			ServletFileUpload upload = new ServletFileUpload(factory);
			//�����ϴ��ļ������Ƶı���
			upload.setHeaderEncoding("UTF-8");

			//ServletFileUpload��API
			boolean multipartContent = upload.isMultipartContent(request);//�жϱ��Ƿ����ļ��ϴ��ı�
			if(multipartContent){
				//���ļ��ϴ��ı�
				//***����request����ļ����
				List<FileItem> parseRequest = upload.parseRequest(request);
				if(parseRequest!=null){
					for(FileItem item : parseRequest){
						//�ж��ǲ���һ����ͨ����
						boolean formField = item.isFormField();
						if(formField){
							//username=zhangsan
							String fieldName = item.getFieldName();
							String fieldValue = item.getString("UTF-8");//����ͨ��������ݽ��б���
							
							System.out.println(fieldName+"----"+fieldValue);
							
							//������enctype="multipart/form-data"ʱ request.getParameter��صķ���
							//String parameter = request.getParameter("username");
							
						}else{
							//�ļ��ϴ���
							//�ļ�����
							String fileName = item.getName();
							//����ϴ��ļ�������
							InputStream in = item.getInputStream();
							String path_store = this.getServletContext().getRealPath("upload");
							OutputStream out = new FileOutputStream(path_store+"/"+fileName);
							IOUtils.copy(in, out);
							in.close();
							out.close();
							//ɾ����ʱ�ļ�
							item.delete();
							
						}
					}
				}

			}else{
				//�����ļ��ϴ���
				//ʹ��ԭʼ�ı����ݵĻ�÷�ʽ request.getParameter();
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}


	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}