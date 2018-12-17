

create table t_user(
       t_username varchar2(10) primary key,
       t_password varchar2(10),
        
);
create table t_user_song(
       t_songId number(10),
       t_username varchar2(10),
       primary key(t_songId,t_username)
);

create table t_song(
       t_songId number(10) primary key,
	     t_songName varchar2(20) not null,
	     t_songTime number(3,2)
);

insert into t_user values('tom','123456');

select * from t_user;
commit;