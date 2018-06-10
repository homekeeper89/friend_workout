drop table tb_user;
drop table tb_bbs;

create table tb_user(
	u_seq int primary key auto_increment,
	email varchar(10) unique,
	u_name varchar(20) unique,
	pwd varchar(100) not null,
	sex tinyint default 0,
	age tinyint default 29,
	height smallint default 175,
	weight smallint default 65,
	u_status tinyint default 0
)

create table tb_bbs(
	b_seq int primary key auto_increment,
	b_title varchar(20),
	u_name varchar(10) not null,
	constraint fk_b_writer foreign key(u_name) references tb_user(u_name) on delete cascade,
	b_content varchar(500) not null,
	b_regdate DATETIME default CURRENT_TIMESTAMP,
	b_status tinyint default 0
)

create table tb_reply(
	r_seq int primary key auto_increment,
	b_seq int not null,
	constraint fk_b_seq foreign key(b_seq) references tb_bbs(b_seq) on delete restrict,
	u_name varchar(20) not null,
	r_content varchar(200) not null,
	r_regdate DATETIME default CURRENT_TIMESTAMP,
	r_status tinyint default 0
)

create table tb_file(
	f_seq int primary key auto_increment,	
	b_seq int not null,
	f_path varchar(100) not null,
	f_regdate datetime default current_timestamp,
	f_status tinyint default 0
)

alter table tb_reply add constraint fk_r_writer foreign key(u_name) references tb_user(u_name);
alter table tb_file add constraint fk_f_bseq foreign key(b_seq) references tb_bbs(b_seq);

alter table tb_user modify email varchar(50);

select * from tb_user;

select * from tb_user where email = 'wkdgndldi@naver.com' and pwd = '1';