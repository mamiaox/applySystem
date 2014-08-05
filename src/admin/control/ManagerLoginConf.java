package admin.control;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.bean.Manager;
import admin.dao.imp.ManagerDaoImp;
import admin.utils.FactoryDemo;


//�жϹ���Ա����Ƿ�Ϸ����Ϸ��Ļ�����ת������Ա��ҳ
public class ManagerLoginConf extends HttpServlet{
	
	public void doGet(HttpServletRequest req,HttpServletResponse resp )throws IOException,ServletException{
		this.doPost(req, resp);
	}
	public void doPost(HttpServletRequest req,HttpServletResponse resp)throws IOException,ServletException{
		//���ղ����û���������
		String name=req.getParameter("managerName");
		String password=req.getParameter("managerPass");
		
		String path="admin_login.html";//������תҳ��
		//���������Ϣ
		List errors=new ArrayList();
		//��person��ֵ
		Manager manager=new Manager();
		manager.setManagerName(name);
		manager.setManagerPass(password);
		ManagerDaoImp mdi=FactoryDemo.getPersonDaoImpl();
		
		boolean flag=false;
		flag=mdi.managerLogin(manager);//���÷����жϹ���Ա���
		if(flag){
			path="admin_index.jsp?pageChildren=event";
		}
		else{
			errors.add("�û��������������ȷ�Ϻ��ڵ�¼");
		}
		
		req.setAttribute("error",errors);
		req.setAttribute("manager",manager);
		req.getSession().setAttribute("managerName",manager.getManagerName());//�������Ա��Ϣ
		req.getRequestDispatcher(path).forward(req,resp);//��ת��pathָ����ҳ��
		
	}
}
