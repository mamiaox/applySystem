/*==============================================================*/
/* DBMS name:      ORACLE Version 11g                           */
/* Created on:     2013/8/29 10:21:42                           */
/*==============================================================*/


alter table "ApplyItem"
   drop constraint FK_APPLYITE_RELATIONS_INDIVIDU;

alter table "ApplyItem"
   drop constraint FK_APPLYITE_RELATIONS_DECLAREI;

alter table "ItemHits"
   drop constraint FK_ITEMHITS_RELATIONS_DECLAREI;

alter table "declareItem"
   drop constraint FK_DECLAREI_APPLY_TEAM;

drop table "ApplyItem" cascade constraints;

drop table "ItemHits" cascade constraints;

drop table "declareItem" cascade constraints;

drop table "individual" cascade constraints;

drop table "manager" cascade constraints;

drop table "team" cascade constraints;

/*==============================================================*/
/* Table: "ApplyItem"                                           */
/*==============================================================*/
create table "ApplyItem" 
(
   "ApplyItem_ID"       NUMBER(9,0)          not null,
   "declareItem_ID"     NUMBER(9,0),
   "individual_ID"      NUMBER(12,0),
   "ApplyItemResult"    CHAR(1),
   "ApplySysDate"       DATE,
   constraint PK_APPLYITEM primary key ("ApplyItem_ID")
);

comment on table "ApplyItem" is
'��������';

comment on column "ApplyItem"."ApplyItem_ID" is
'����������';

comment on column "ApplyItem"."declareItem_ID" is
'�걨������';

comment on column "ApplyItem"."individual_ID" is
'�����˺�';

comment on column "ApplyItem"."ApplyItemResult" is
'�������';

comment on column "ApplyItem"."ApplySysDate" is
'����ϵͳʱ��';

/*==============================================================*/
/* Table: "ItemHits"                                            */
/*==============================================================*/
create table "ItemHits" 
(
   "declareItem_ID"     NUMBER(9,0)          not null,
   "hitNumbers"         NUMBER(5,0),
   constraint PK_ITEMHITS primary key ("declareItem_ID")
);

comment on table "ItemHits" is
'��������
';

comment on column "ItemHits"."declareItem_ID" is
'�걨������';

comment on column "ItemHits"."hitNumbers" is
'�������';

/*==============================================================*/
/* Table: "declareItem"                                         */
/*==============================================================*/
create table "declareItem" 
(
   "declareItem_ID"     NUMBER(9,0)          not null,
   "team_ID"            NUMBER(6,0),
   "declareItem_title"  VARCHAR2(60),
   "declareItem_intro"  VARCHAR2(1000),
   "ItemShowItem"       DATE,
   "ItemStopApplyTime"  DATE,
   "declareItemStartTime" DATE,
   "declareItemStopTime" DATE,
   "declareItemApplyMax" NUMBER(3,0),
   "college"            SMALLINT,
   "Graduate"           SMALLINT,
   "staff"              SMALLINT,
   "Attentions"         VARCHAR2(400),
   "ItemOrganizer"      VARCHAR2(40),
   "ItemResult"         CHAR(1),
   "ItemSysDate"        DATE,
   constraint PK_DECLAREITEM primary key ("declareItem_ID")
);

comment on table "declareItem" is
'�걨������';

comment on column "declareItem"."declareItem_ID" is
'�걨������';

comment on column "declareItem"."declareItem_title" is
'�걨�������';

comment on column "declareItem"."declareItem_intro" is
'�걨����ļ��';

comment on column "declareItem"."ItemShowItem" is
'�걨����֪ͨ����ʱ��';

comment on column "declareItem"."ItemStopApplyTime" is
'�걨����ֹͣ����ʱ��';

comment on column "declareItem"."declareItemStartTime" is
'���ʼ�ٰ�ʱ��';

comment on column "declareItem"."declareItemStopTime" is
'����ٰ����ʱ��';

comment on column "declareItem"."declareItemApplyMax" is
'�걨���������';

comment on column "declareItem"."college" is
'������';

comment on column "declareItem"."Graduate" is
'�о���';

comment on column "declareItem"."staff" is
'��ְ��';

comment on column "declareItem"."Attentions" is
'ע������';

comment on column "declareItem"."ItemOrganizer" is
'����а췽';

comment on column "declareItem"."ItemResult" is
'�����걨���';

comment on column "declareItem"."ItemSysDate" is
'�����걨ϵͳʱ��';

/*==============================================================*/
/* Table: "individual"                                          */
/*==============================================================*/
create table "individual" 
(
   "individual_ID"      NUMBER(12,0)         not null,
   "individual_pass"    VARCHAR2(16),
   "individual_name"    VARCHAR2(8),
   "IndDepartment"      VARCHAR2(30),
   "Indclass"           VARCHAR2(30),
   "individual_Te"      NUMBER(11,0),
   "individual_Email"   VARCHAR2(32),
   constraint PK_INDIVIDUAL primary key ("individual_ID")
);

comment on table "individual" is
'����';

comment on column "individual"."individual_ID" is
'�����˺�';

comment on column "individual"."IndDepartment" is
'��������Ժϵ';

comment on column "individual"."Indclass" is
'��������רҵ�༶';

comment on column "individual"."individual_Te" is
'l���˵���ϵ�绰';

comment on column "individual"."individual_Email" is
'���˵ĵ�������';

/*==============================================================*/
/* Table: "manager"                                             */
/*==============================================================*/
create table "manager" 
(
   "manager_ID"         NUMBER(6,0)          not null,
   "manager_Pass"       VARCHAR2(16),
   "manager_name"       VARCHAR2(8),
   constraint PK_MANAGER primary key ("manager_ID")
);

comment on table "manager" is
'����';

comment on column "manager"."manager_ID" is
'�����˺�';

comment on column "manager"."manager_Pass" is
'��������';

comment on column "manager"."manager_name" is
'�����û���';

/*==============================================================*/
/* Table: "team"                                                */
/*==============================================================*/
create table "team" 
(
   "team_ID"            NUMBER(6,0)          not null,
   "team_pass"          VARCHAR2(16),
   "team_name"          VARCHAR2(50),
   "team_principal"     VARCHAR2(8),
   "team_tel"           NUMBER(11,0),
   "team_address"       VARCHAR2(60),
   "team_email"         VARCHAR2(32),
   constraint PK_TEAM primary key ("team_ID")
);

comment on column "team"."team_ID" is
'�Ŷ��˺�';

comment on column "team"."team_pass" is
'����';

comment on column "team"."team_name" is
'�Ŷ�����';

comment on column "team"."team_principal" is
'�ŶӸ�����';

comment on column "team"."team_address" is
'��ϵ��ַ';

alter table "ApplyItem"
   add constraint FK_APPLYITE_RELATIONS_INDIVIDU foreign key ("individual_ID")
      references "individual" ("individual_ID");

alter table "ApplyItem"
   add constraint FK_APPLYITE_RELATIONS_DECLAREI foreign key ("declareItem_ID")
      references "declareItem" ("declareItem_ID");

alter table "ItemHits"
   add constraint FK_ITEMHITS_RELATIONS_DECLAREI foreign key ("declareItem_ID")
      references "declareItem" ("declareItem_ID");

alter table "declareItem"
   add constraint FK_DECLAREI_APPLY_TEAM foreign key ("team_ID")
      references "team" ("team_ID");

