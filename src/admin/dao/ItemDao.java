package admin.dao;
import java.util.Date;
import java.util.List;

import admin.bean.*;

public interface ItemDao {

	public List<Item> findItemByOrganizer(String organizer,int currentPage);//���ճа췽��ѯ�걨�
	public List<Item> findDischeckItem(int currentPage,int pageSize);//��ѯ�����ӵ�û�б���˵Ļ��������еĻ
	public int getAllNotCheckItem();//�������δ����˻����ҳ��
	public boolean verifyItem(int declareItem_Id,String itemResult);//��˻��
	public List<Item> findPassItem();//��ѯͨ����˵Ļ�������ڱ����еĻ
	public List<Item> findEndingItem(Date stopTime,int maxNumber);//��ѯ���������˵Ļ
	public List<Item> findNotPassItem();//��ѯû��ͨ����˵Ļ
//	���ݻ��id��ѯ�û
	public Item queryItemById(int itemId);

	
}
