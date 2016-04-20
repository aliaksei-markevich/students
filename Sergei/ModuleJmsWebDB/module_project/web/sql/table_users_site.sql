-- Table: public.users_site

-- DROP TABLE public.users_site;

CREATE TABLE public.users_site
(
  user_id integer NOT NULL,
  user_name text,
  user_password text,
  role_id integer NOT NULL,
  CONSTRAINT "Users_pkey" PRIMARY KEY (user_id),
  CONSTRAINT users_site_role_id_fkey FOREIGN KEY (role_id)
      REFERENCES public.roles (uid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.users_site
  OWNER TO postgres;
