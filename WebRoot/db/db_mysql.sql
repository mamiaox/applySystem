/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2013/8/28 20:21:59                           */
/*==============================================================*/


drop table if exists ApplyItem;

drop table if exists ItemHits;

drop table if exists declareItem;

drop table if exists individual;

drop table if exists manager;

drop table if exists team;

/*==============================================================*/
/* Table: ApplyItem                                             */
/*==============================================================*/
create table ApplyItem
(
   ApplyItem_ID         numeric(9,0) not null comment '����������',
   declareItem_ID       numeric(9,0) comment '�걨������',
   individual_ID        numeric(12,0) comment '�����˺�',
   ApplyItemResult      char(1) comment '�������',
   ApplySysDate         date comment '����ϵͳʱ��',
   primary key (ApplyItem_ID)
);

alter table ApplyItem comment '��������';

/*==============================================================*/
/* Table: ItemHits                                              */
/*==============================================================*/
create table ItemHits
(
   declareItem_ID       numeric(9,0) not null comment '�걨������',
   hitNumbers           numeric(5,0) comment '�������',
   primary key (declareItem_ID)
);

alter table ItemHits comment '��������
';

/*==============================================================*/
/* Table: declareItem                                           */
/*==============================================================*/
create table declareItem
(
   declareItem_ID       numeric(9,0) not null comment '�걨������',
   team_ID              numeric(6,0),
   declareItem_title    varchar(60) comment '�걨�������',
   declareItem_intro    varchar(1000) comment '�걨����ļ��',
   ItemShowItem         date comment '�걨����֪ͨ����ʱ��',
   ItemStopApplyTime    date comment '�걨����ֹͣ����ʱ��',
   declareItemStartTime date comment '���ʼ�ٰ�ʱ��',
   declareItemStopTime  date comment '����ٰ����ʱ��',
   declareItemApplyMax  numeric(3,0) comment '�걨���������',
   college              bool comment '������',
   Graduate             bool comment '�о���',
   staff                bool comment '��ְ��',
   Attentions           varchar(400) comment 'ע������',
   ItemOrganizer        varchar(40) comment '����а췽',
   ItemResult           char(1) comment '�����걨���',
   ItemSysDate          date comment '�����걨ϵͳʱ��',
   primary key (declareItem_ID)
);

alter table declareItem comment '�걨������';

/*==============================================================*/
/* Table: individual                                            */
/*==============================================================*/
create table individual
(
   individual_ID        numeric(12,0) not null comment '�����˺�',
   individual_pass      varchar(16),
   individual_name      varchar(8),
   IndDepartment        varchar(30) comment '��������Ժϵ',
   Indclass             varchar(30) comment '��������רҵ�༶',
   individual_Te        numeric(11,0) comment '���˵���ϵ�绰',
   individual_Email     varchar(32) comment '���˵ĵ�������',
   primary key (individual_ID)
);

alter table individual comment '����';

/*==============================================================*/
/* Table: manager                                               */
/*==============================================================*/
create table manager
(
   manager_ID           numeric(6,0) not null comment '�����˺�',
   manager_Pass         varchar(16) comment '��������',
   manager_name         varchar(8) comment '�����û���',
   primary key (manager_ID)
);

alter table manager comment '����';

/*==============================================================*/
/* Table: team                                                  */
/*==============================================================*/
create table team
(
   team_ID              numeric(6,0) not null comment '�Ŷ��˺�',
   team_pass            varchar(16) comment '����',
   team_name            varchar(50) comment '�Ŷ�����',
   team_principal       varchar(8) comment '�ŶӸ�����',
   team_tel             numeric(11,0),
   team_address         varchar(60) comment '��ϵ��ַ',
   team_email           varchar(32),
   primary key (team_ID)
);

alter table ApplyItem add constraint FK_Relationship_2 foreign key (individual_ID)
      references individual (individual_ID) on delete restrict on update restrict;

alter table ApplyItem add constraint FK_Relationship_3 foreign key (declareItem_ID)
      references declareItem (declareItem_ID) on delete restrict on update restrict;

alter table ItemHits add constraint FK_Relationship_4 foreign key (declareItem_ID)
      references declareItem (declareItem_ID) on delete restrict on update restrict;

alter table declareItem add constraint FK_apply foreign key (team_ID)
      references team (team_ID) on delete restrict on update restrict;

