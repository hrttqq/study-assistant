create table if not exists study_user (
    id bigint primary key auto_increment,
    username varchar(64) not null unique,
    password varchar(64) not null,
    mobile varchar(11) null,
    nickname varchar(64) null,
    email varchar(128) null,
    member_level varchar(32) not null default 'FREE',
    wx_open_id varchar(128) null unique,
    wx_union_id varchar(128) null,
    avatar_url varchar(512) null,
    created_at datetime not null default current_timestamp,
    updated_at datetime not null default current_timestamp on update current_timestamp
) engine=InnoDB default charset=utf8mb4;
