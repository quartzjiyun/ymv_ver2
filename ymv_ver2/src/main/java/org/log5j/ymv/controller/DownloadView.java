package org.log5j.ymv.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;
/**
 * ���� ������ �ٿ�ε��Ű�� ���� View�� ���� 
 * (View �� ����� ���ؼ��� spring���� �����ϴ� 
 * AbstractView�� ��ӹ޾� �߻�޼��带 ���� ) 
 * @author KOSTA-00-KANGSA
 *
 */
public class DownloadView extends AbstractView{
	
	@Override
	public String getContentType() {
		// 8bit ������ �Ϸ��� ������
		return "application/octet-stream";
	}

	@Override
	protected void renderMergedOutputModel(Map<String, Object> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path=(String)map.get("path");
		String filename=request.getParameter("filename");
		System.out.println("DownloadView ���� "+path+filename);
		// ���ε� ���� ��ü 
		File file=new File(path+filename);
		// ���� �ٿ�ε� 
	    response.setContentType(this.getContentType());
	    response.setContentLength((int)file.length());//���� ũ�� ���� 
	    // �ٿ�ε� ���Ͽ� ���� ���� 
	    response.setHeader("Content-Disposition", 
	      "attachment; fileName="
	    +new String(file.getName().getBytes("UTF-8"),"8859_1"));
	    //������ ���ڵ��� ���̳ʸ� �������� ���
	    response.setHeader("Content-Transfer-encoding", "binary");
		
	    //response�� ����� OutputStream
	    OutputStream os=response.getOutputStream();
	    //���ε�� ������ �Է¹ޱ� ���� �Է½�Ʈ�� 
	    FileInputStream fis=new FileInputStream(file);
	    FileCopyUtils.copy(fis, os);
	    System.out.println("�ٿ�ε� ok:"+file.getName());
	}
}






