drop table if exists candidate;

drop table if exists activity_candidate;

drop table if exists activity_voter;

drop table if exists coupon;

drop table if exists coupon_group;

drop table if exists goods;

drop table if exists vote_activity;

drop table if exists vote_record;

drop table if exists vote_scope;

drop table if exists voter;

drop table if exists voter_session;

/*==============================================================*/
/* Table: candidate                                             */
/*==============================================================*/
create table candidate
(
   candidate_id         varchar(32) not null comment '候选者编号',
   candidate_name       varchar(32) comment '候选者姓名',
   scope_id             varchar(32) comment '区域编号',
   photo_url            varchar(512) comment '照片路径',
   description          varchar(1024) comment '详细描述',
   create_time          datetime comment '创建时间',
   update_time          datetime comment '更新时间',
   primary key (candidate_id)
);

alter table candidate comment '候选人';

/*==============================================================*/
/* Table: activity_candidate                                    */
/*==============================================================*/
create table activity_candidate
(
   activity_candidate_id varchar(32) not null comment '统计编号',
   activity_id          varchar(32) comment '活动编号',
   candidate_id         varchar(32) comment '候选人编号',
   candidate_code       smallint comment '候选人号码',
   votes           smallint comment '投票数',
   create_time          datetime comment '创建时间',
   update_time          datetime comment '更新时间',
   primary key (activity_candidate_id)
);

alter table activity_candidate comment '活动候选人';

/*==============================================================*/
/* Table: activity_voter                                        */
/*==============================================================*/
create table activity_voter
(
   activity_voter_id    varchar(32) not null comment '活动投票人编号',
   activity_id          varchar(32) comment '活动编号',
   voter_id             varchar(32) comment '投票人编号',
   rest_votes           smallint comment '剩余票数',
   coupon_id            varchar(32) comment '优惠券编号',
   create_time          datetime comment '创建时间',
   update_time          datetime comment '更新时间',
   primary key (activity_voter_id)
);

alter table activity_voter comment '活动投票人';

/*==============================================================*/
/* Table: coupon                                                */
/*==============================================================*/
create table coupon
(
   coupon_id            varchar(32) not null comment '优惠券编号',
   voter_id             varchar(32) comment '投票人编号',
   coupon_status        smallint comment '优惠券状态',
   create_time          datetime comment '创建时间',
   update_time          datetime comment '更新时间',
   primary key (coupon_id)
);

alter table coupon comment '优惠券';

/*==============================================================*/
/* Table: coupon_group                                          */
/*==============================================================*/
create table coupon_group
(
   coupon_group_id      varchar(32) not null comment '优惠券组编号',
   coupon_name          varchar(64) comment '优惠券名称',
   coupon_type          smallint comment '优惠券类型（01折扣；02抵扣）',
   discount_rate        int comment '折扣率（100即免费）',
   discount_amout       int comment '抵扣金额（单位：分）',
   goods_id             varchar(32) comment '商品编号',
   scope_id             varchar(32) comment '区域编号',
   scene                smallint comment '领取场景',
   create_time          datetime comment '创建时间',
   update_time          datetime comment '更新时间',
   primary key (coupon_group_id)
);

alter table coupon_group comment '优惠券组';

/*==============================================================*/
/* Table: goods                                                 */
/*==============================================================*/
create table goods
(
   goods_id             varchar(32) not null comment '商品编号',
   goods_name           varchar(64) comment '商品名称',
   phote_url            varchar(512) comment '图片路径',
   goods_price          int comment '商品价格（单位：分）',
   create_time          datetime comment '创建时间',
   update_time          datetime comment '更新时间',
   primary key (goods_id)
);

alter table goods comment '商品';

/*==============================================================*/
/* Table: vote_activity                                         */
/*==============================================================*/
create table vote_activity
(
   activity_id          varchar(32) not null comment '活动编号',
   activity_name        varchar(64) comment '活动名称',
   scope_id             varchar(32) comment '区域编号',
   votes_limit_type    smallint comment '投票数限制类型',
   max_votes            smallint comment '投票人最大投票数（1每天；2整个活动）',
   description          varchar(1024) comment '详细描述',
   start_time           datetime comment '开始时间',
   end_time             datetime comment '结束时间',
   create_time          datetime comment '创建时间',
   update_time          datetime comment '更新时间',
   primary key (activity_id)
);

alter table vote_activity comment '投票活动';

/*==============================================================*/
/* Table: vote_record                                           */
/*==============================================================*/
create table vote_record
(
   record_id            varchar(32) not null comment '记录编号',
   activity_id          varchar(32) comment '活动编号',
   candidate_id         varchar(32) comment '候选人编号',
   voter_id             varchar(32) comment '投票人编号',
   creat_time           datetime comment '创建时间',
   update_time          datetime comment '更新时间',
   primary key (record_id)
);

alter table vote_record comment '投票记录';

/*==============================================================*/
/* Table: vote_scope                                            */
/*==============================================================*/
create table vote_scope
(
   scope_id             varchar(32) not null comment '区域编号',
   scope_name           varchar(64) comment '区域名称',
   scope_parent         varchar(32) comment '父区域',
   scope_level          smallint comment '区域等级',
   description          varchar(1024) comment '详细描述',
   create_time          datetime comment '创建时间',
   update_time          datetime comment '更新时间',
   primary key (scope_id)
);

alter table vote_scope comment '投票区域';

/*==============================================================*/
/* Table: voter                                                 */
/*==============================================================*/
create table voter
(
   voter_id             varchar(32) not null comment '投票人编号',
   wechar_open_id      varchar(128) comment '微信唯一号',
   wechar_nickname      varchar(64) comment '投票人微信昵称',
   voter_mobile         varchar(16) comment '投票人手机号',
   voter_name           varchar(32) comment '投票人姓名',
   voter_gender         smallint comment '性别（1男；2女）',
   create_time          datetime comment '创建时间',
   update_time          datetime comment '更新时间',
   primary key (voter_id)
);

alter table voter comment '投票人';

/*==============================================================*/
/* Table: voter_session                                         */
/*==============================================================*/
create table voter_session
(
   session_content   varchar(128) comment '令牌主体',
   voter_id          varchar(32) comment '投票人编号',
   create_time       datetime comment '创建时间',
   expired_time      datetime comment '失效时间',
   primary key (session_content)
);

alter table voter_session comment '投票人授权令牌';

/*==============================================================*/
/* Table: base_config                                           */
/*==============================================================*/
create table base_config
(
   config_id       varchar(32) comment '配置编号',
   config_name     varchar(64) comment '配置名称',
   config_value    varchar(128) comment '配置值',
   primary key (config_id)
);

alter table base_config comment '基础配置';
