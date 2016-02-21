-- Table: users_site

-- DROP TABLE users_site;

CREATE TABLE users_site
(
  user_id integer NOT NULL,
  user_name text,
  user_password text,
  user_role text,
  CONSTRAINT "Users_pkey" PRIMARY KEY (user_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE users_site
  OWNER TO postgres;
