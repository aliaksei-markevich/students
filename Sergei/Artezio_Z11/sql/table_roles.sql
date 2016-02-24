-- Table: public.roles

-- DROP TABLE public.roles;

CREATE TABLE public.roles
(
  uid integer NOT NULL DEFAULT nextval('roles_uid_seq'::regclass),
  name text,
  CONSTRAINT roles_pkey PRIMARY KEY (uid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.roles
  OWNER TO postgres;
