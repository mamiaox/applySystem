
package admin.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



import admin.bean.Item;
import admin.dao.ItemDao;
import admin.utils.FactoryDemo;
import admin.utils.JdbcUtils;


public class ItemDaoImp implements ItemDao {
	
	List<Item> itemList=null;
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	private int resultCount;	//�ܼ�¼��
	private int pageCount;		//��ҳ��
	private int size=3;			//ÿҳ������
	
//	��ȡ����δ����˻���ܵ�ҳ������δ����˻��ÿҳsize=3��ҳ��һ���ж���ҳ
	public int getAllNotCheckItem(){
		String sql= "select count(*)  from declareItem where ItemResult is null ";
		conn=JdbcUtils.getConnectin();
		try {
			pstmt=conn.prepareStatement(sql);
			//setDate �Ĳ���ֻ���� sql.date  ���ܾ�ȷ��ʱ���룬��ȡ��ǰʱ��
			pstmt.setTimestamp(1, new Timestamp(System.currentTimeMillis())); 
			rs=pstmt.executeQuery();
			rs.next();
			resultCount=rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{	
			JdbcUtils.free(conn, pstmt, rs);
		}
		pageCount=(resultCount + size - 1)/size;//��װsize��ҳ���ҳ��
		return pageCount;
	}
//	���ճа췽��ѯδ����˻
	public List<Item> findItemByOrganizer(String organizer,int currentPage) {
		// TODO Auto-generated method stub
		//δ����˺Ͳ�ѯ����
		String sql="select declareItem_Id,declareItem_title,declareItemStartTime,student,staff,ItemOrganizer��ItemSysDate from declareItem where ItemOrganizer=? and ItemResult is null order by ItemSysDate desc "+" limit "+(currentPage-1)*size + "," +size; 
		conn=JdbcUtils.getConnectin();
		itemList=new ArrayList<Item>();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,organizer);
			rs= pstmt.executeQuery();
			while(rs.next()){
				Item item=new Item();
				item.setItemID(rs.getInt("declareItem_ID"));
				item.setItemTitle(rs.getString("declareItem_title"));
				item.setItemStartTime(rs.getDate("declareItemStartTime"));
				item.setStudent(rs.getBoolean("student"));
				item.setStaff(rs.getBoolean("staff"));
				item.setItemOrganizer(rs.getString("ItemOrganizer"));
				item.setItemSysDate(rs.getDate("ItemSysDate"));
				itemList.add(item);
			}
			JdbcUtils.free(conn, pstmt, rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return itemList;
	}
//	��ѯ�����ӵ�û�б���˵Ļ��������еĻ
	public List<Item> findDischeckItem(int currentPage,int pageSize) {
		// TODO Auto-generated method stub
		String sql=null;
		sql="select declareItem_Id,declareItem_title,declareItemStartTime,student,staff,ItemOrganizer,ItemSysDate from declareItem where ItemResult is null order by ItemSysDate desc "+" limit " +(currentPage-1)*pageSize + "," +pageSize; 
		conn=JdbcUtils.getConnectin();
		itemList=new ArrayList<Item>();
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Item item=new Item();
				item.setItemID(rs.getInt("declareItem_ID"));
				item.setItemTitle(rs.getString("declareItem_title"));
				item.setItemStartTime(rs.getDate("declareItemStartTime"));
				item.setStudent(rs.getBoolean("student"));
				item.setStaff(rs.getBoolean("staff"));
				item.setItemOrganizer(rs.getString("ItemOrganizer"));
				item.setItemSysDate(rs.getDate("ItemSysDate"));
				itemList.add(item);
			}
			JdbcUtils.free(conn, pstmt, rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return itemList;
	}
//	��˻,ȷ���û�Ƿ�ͨ�����
	public boolean verifyItem(int declareItem_Id,String itemResult) {
		// TODO Auto-generated method stub
//		itemResult������ֵ��"y"��ʾͨ����ˣ�"n"��ʾûͨ�����
		boolean isPass=false;
		String sql="update twoapply set ItemResult=? where declareItem_Id=? ";
		conn=JdbcUtils.getConnectin();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,itemResult);
			pstmt.setInt(2,declareItem_Id);
			int n=pstmt.executeUpdate();
			if(n!=0)
				isPass=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isPass;
	}
	
//	���ݻ��id��ѯ�û
	public Item queryItemById(int itemId){
		String sql="select * from declareitem where declareItem_ID=?";
		conn=JdbcUtils.getConnectin();
		Item item=new Item();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, itemId);
			rs=pstmt.executeQuery();
			if(rs.next()){
				item.setItemID(rs.getInt("declareItem_ID"));
				item.setTeamID(rs.getInt("team_Id"));
				item.setItemTitle(rs.getString("declareItem_title"));
				item.setItemIntro(rs.getString("declareItem_intro"));
				item.setItemStopApplyTime(rs.getDate("itemStopApplyTime"));
				item.setItemStartTime(rs.getDate("declareItemStartTime"));
				item.setItemStopTime(rs.getDate("declareItemStopTime"));
				item.setItemAddress(rs.getString("itemAddress"));
				item.setItemApplyMax(rs.getInt("declareItemApplyMax"));
				item.setStudent(rs.getBoolean("student"));
				item.setStaff(rs.getBoolean("staff"));
				item.setAttentions(rs.getString("Attentions"));
				item.setItemOrganizer(rs.getString("ItemOrganizer"));
				item.setItemResult(rs.getString("ItemResult"));
				item.setItemSysDate(rs.getDate("ItemSysDate"));
			}
			JdbcUtils.free(conn, pstmt, rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return item;
	}
//	��ѯ���������˵Ļ
	public List<Item> findEndingItem(Date stopTime,int maxNumber) {
		// TODO Auto-generated method stub 
		String sql="select * from declareitem where declareItemStopTime=? or declareItemApplyMax=?";
		conn=JdbcUtils.getConnectin();
		itemList=new ArrayList<Item>();
		try {
			pstmt=conn.prepareStatement(sql);
//			pstmt.setDate(1, stopTime);
			pstmt.setInt(2,maxNumber);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Item item=new Item();
				item.setItemID(rs.getInt("declareItem_ID"));
				item.setTeamID(rs.getInt("team_Id"));
				item.setItemTitle(rs.getString("declareItem_title"));
				item.setItemIntro(rs.getString("declareItem_intro"));
				item.setItemStopApplyTime(rs.getDate("itemStopApplyTime"));
				item.setItemStartTime(rs.getDate("declareItemStartTime"));
				item.setItemStopTime(rs.getDate("declareItemStopTime"));
				item.setItemAddress(rs.getString("itemAddress"));
				item.setItemApplyMax(rs.getInt("declareItemApplyMax"));
				item.setStudent(rs.getBoolean("student"));
				item.setStaff(rs.getBoolean("staff"));
				item.setAttentions(rs.getString("Attentions"));
				item.setItemOrganizer(rs.getString("ItemOrganizer"));
				item.setItemResult(rs.getString("ItemResult"));
				item.setItemSysDate(rs.getDate("ItemSysDate"));
				itemList.add(item);
			}
			JdbcUtils.free(conn, pstmt, rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return itemList;
	}
//  ��ѯû��ͨ����˵Ļ
	public List<Item> findNotPassItem() {
		
		String sql="select * from twoapply where ItemResult=?";
		
		conn=JdbcUtils.getConnectin();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,"n");//û��ͨ����˵�ʱ��ItemResult=n
			rs=pstmt.executeQuery();
			itemList=new ArrayList<Item>();
			while(rs.next()){
				Item item=new Item();
				item.setItemID(rs.getInt("declareItem_ID"));
				item.setTeamID(rs.getInt("team_Id"));
				item.setItemTitle(rs.getString("declareItem_title"));
				item.setItemIntro(rs.getString("declareItem_intro"));
				item.setItemStopApplyTime(rs.getDate("itemStopApplyTime"));
				item.setItemStartTime(rs.getDate("declareItemStartTime"));
				item.setItemStopTime(rs.getDate("declareItemStopTime"));
				item.setItemAddress(rs.getString("itemAddress"));
				item.setItemApplyMax(rs.getInt("declareItemApplyMax"));
				item.setStudent(rs.getBoolean("student"));
				item.setStaff(rs.getBoolean("staff"));
				item.setAttentions(rs.getString("Attentions"));
				item.setItemOrganizer(rs.getString("ItemOrganizer"));
				item.setItemResult(rs.getString("ItemResult"));
				item.setItemSysDate(rs.getDate("ItemSysDate"));
				itemList.add(item);
			}
			JdbcUtils.free(conn, pstmt, rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return itemList;
	}
//	��ѯͨ����˵Ļ�������ڱ����еĻ��ͨ������ˣ����ڱ���ʱ���ڣ�����Ҳû�г����޶�������
	public List<Item> findPassItem() {
		// TODO Auto-generated method stub
		String sql="select * from twoapply where ItemResult=?";
		conn=JdbcUtils.getConnectin();
		itemList=new ArrayList<Item>();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,"y");//û��ͨ����˵�ʱ��ItemResult=n
			rs=pstmt.executeQuery();
			while(rs.next()){
				Item item=new Item();
				item.setItemID(rs.getInt("declareItem_ID"));
				item.setTeamID(rs.getInt("team_Id"));
				item.setItemTitle(rs.getString("declareItem_title"));
				item.setItemIntro(rs.getString("declareItem_intro"));
				item.setItemStopApplyTime(rs.getDate("itemStopApplyTime"));
				item.setItemStartTime(rs.getDate("declareItemStartTime"));
				item.setItemStopTime(rs.getDate("declareItemStopTime"));
				item.setItemAddress(rs.getString("itemAddress"));
				item.setItemApplyMax(rs.getInt("declareItemApplyMax"));
				item.setStudent(rs.getBoolean("student"));
				item.setStaff(rs.getBoolean("staff"));
				item.setAttentions(rs.getString("Attentions"));
				item.setItemOrganizer(rs.getString("ItemOrganizer"));
				item.setItemResult(rs.getString("ItemResult"));
				item.setItemSysDate(rs.getDate("ItemSysDate"));
				itemList.add(item);
			}
			JdbcUtils.free(conn, pstmt, rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return itemList;
	}
}