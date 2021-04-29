drop table if exists post_tag;
drop table if exists tag;
drop table if exists comment;
drop table if exists post;
drop table if exists user_role;
drop table if exists role;
drop table if exists "user";

CREATE TABLE "user" (
  id bigserial PRIMARY KEY,
  username varchar(25) UNIQUE,
  password varchar(100),
  created_at timestamp without time zone,
  is_active boolean
);

CREATE TABLE role (
  id integer PRIMARY KEY,
  name varchar(25)
);

CREATE TABLE user_role (
  user_id bigint REFERENCES "user"(id),
  role_id integer REFERENCES role(id),
  UNIQUE (user_id, role_id)
);

CREATE TABLE post (
  id bigserial PRIMARY KEY,
  user_id bigint REFERENCES "user"(id),
  title varchar(100),
  content text,
  created_at timestamp without time zone,
  updated_at timestamp without time zone
);

CREATE TABLE comment (
  id bigserial PRIMARY KEY,
  user_id bigint REFERENCES "user"(id),
  post_id bigint REFERENCES post(id) ON DELETE CASCADE,
  content text,
  created_at timestamp without time zone,
  updated_at timestamp without time zone
);

CREATE TABLE tag (
  name varchar(50) PRIMARY KEY
);

CREATE TABLE post_tag (
  post_id bigint REFERENCES post(id) ON DELETE CASCADE,
  tag_name varchar(50) REFERENCES tag(name),
  UNIQUE (post_id, tag_name)
);

-- Inserts

INSERT INTO role VALUES (1, 'ADMIN');
INSERT INTO role VALUES (2, 'USER');

INSERT INTO "user" (username, password, created_at, is_active) VALUES (
    'admin',
    'admin',
    now()::timestamp,
    true
);

INSERT INTO "user" (username, password, created_at, is_active) VALUES (
    'user1',
    'user1',
    now()::timestamp,
    true
);

INSERT INTO user_role VALUES (1, 1);
INSERT INTO user_role VALUES (2, 2);

insert into post (user_id, title, content, created_at, updated_at) values (1, 'Day 1', 'It''s all good!', current_date - interval '2 days', current_timestamp);
insert into post (user_id, title, content, created_at, updated_at) values (2, 'Day 2', 'It''s all ok!', current_date - interval '1 days', current_timestamp);
insert into post (user_id, title, content, created_at, updated_at) values (2, 'Day 3', 'It''s all bad!', current_date, current_timestamp);

insert into comment (user_id, post_id, content, created_at) values (1, 2, 'Nice!', current_timestamp);
insert into comment (user_id, post_id, content, created_at) values (1, 1, 'Awesome!', current_timestamp);
insert into comment (user_id, post_id, content, created_at) values (1, 1, 'Excellent!', current_timestamp);
insert into comment (user_id, post_id, content, created_at) values (2, 1, 'Wonderful!', current_timestamp);
insert into comment (user_id, post_id, content, created_at) values (2, 3, 'Disgusting!', current_timestamp);
insert into comment (user_id, post_id, content, created_at) values (2, 3, 'Atrocious!', current_timestamp);

insert into tag (name) values ('news');
insert into tag (name) values ('life');
insert into tag (name) values ('day');
insert into tag (name) values ('mood');
insert into tag (name) values ('ideas');
insert into tag (name) values ('thoughts');

insert into post_tag(post_id, tag_name) values (1, 'news');
insert into post_tag(post_id, tag_name) values (1, 'life');
insert into post_tag(post_id, tag_name) values (2, 'day');
insert into post_tag(post_id, tag_name) values (2, 'life');
insert into post_tag(post_id, tag_name) values (2, 'news');
insert into post_tag(post_id, tag_name) values (2, 'ideas');
insert into post_tag(post_id, tag_name) values (3, 'day');
insert into post_tag(post_id, tag_name) values (3, 'life');
insert into post_tag(post_id, tag_name) values (3, 'thoughts');