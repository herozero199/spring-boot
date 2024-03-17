create table post
( 
	id bigint(20),
	title varchar(255),
	primary key (id)
);

create table post_comment
(
	id bigint(20),
	review varchar(255),
	post_id bigint(20),
	primary key (id)
);