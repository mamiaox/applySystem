package admin.bean;

import java.util.Date;

public class Item {
	private int itemID;					//�걨����id���
	private int teamID;					//�걨��id
	private String itemTitle;			//�걨�������
	private String itemIntro;			//�걨����ļ��
	private Date itemStopApplyTime;		//ֹͣ����ʱ��
	private Date itemStartTime;			//���ʼʱ��
	private Date itemStopTime;			//���ֹʱ��
	private String itemAddress;			//��ĵص�
	private int itemApplyMax;			//��౨������
	private boolean student;			//����������Уѧ���Ƿ���Բ���
	private boolean staff;				//���������ְ���Ƿ���Բ���
	private String attentions;			//ע������
	private String itemOrganizer;		//��Ŀ�а췽
	private String itemResult;			//�걨�����ͨ������л�����̭
	private Date itemSysDate;			//�걨��ϵͳʱ��
	
	public int getItemID() {
		return itemID;
	}
	public void setItemID(int itemID) {
		this.itemID = itemID;
	}
	public int getTeamID() {
		return teamID;
	}
	public void setTeamID(int teamID) {
		this.teamID = teamID;
	}
	public String getItemTitle() {
		return itemTitle;
	}
	public void setItemTitle(String itemTitle) {
		this.itemTitle = itemTitle;
	}
	public String getItemIntro() {
		return itemIntro;
	}
	public void setItemIntro(String itemIntro) {
		this.itemIntro = itemIntro;
	}
	public Date getItemStopApplyTime() {
		return itemStopApplyTime;
	}
	public void setItemStopApplyTime(Date itemStopApplyTime) {
		this.itemStopApplyTime = itemStopApplyTime;
	}
	public Date getItemStartTime() {
		return itemStartTime;
	}
	public void setItemStartTime(Date itemStartTime) {
		this.itemStartTime = itemStartTime;
	}
	public Date getItemStopTime() {
		return itemStopTime;
	}
	public void setItemStopTime(Date itemStopTime) {
		this.itemStopTime = itemStopTime;
	}
	public String getItemAddress() {
		return itemAddress;
	}
	public void setItemAddress(String addressItem) {
		this.itemAddress = addressItem;
	}
	public int getItemApplyMax() {
		return itemApplyMax;
	}
	public void setItemApplyMax(int itemApplyMax) {
		this.itemApplyMax = itemApplyMax;
	}
	public boolean isStudent() {
		return student;
	}
	public void setStudent(boolean student) {
		this.student = student;
	}
	public boolean isStaff() {
		return staff;
	}
	public void setStaff(boolean staff) {
		this.staff = staff;
	}
	public String getAttentions() {
		return attentions;
	}
	public void setAttentions(String attentions) {
		this.attentions = attentions;
	}
	public String getItemOrganizer() {
		return itemOrganizer;
	}
	public void setItemOrganizer(String itemOrganizer) {
		this.itemOrganizer = itemOrganizer;
	}
	public String getItemResult() {
		return itemResult;
	}
	public void setItemResult(String itemResult) {
		this.itemResult = itemResult;
	}
	public Date getItemSysDate() {
		return itemSysDate;
	}
	public void setItemSysDate(Date itemSysDate) {
		this.itemSysDate = itemSysDate;
	}
	public Item() {
		// TODO Auto-generated constructor stub
	}

}














