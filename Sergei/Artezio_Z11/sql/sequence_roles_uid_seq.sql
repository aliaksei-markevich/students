-- Sequence: public.roles_uid_seq

-- DROP SEQUENCE public.roles_uid_seq;

CREATE SEQUENCE public.roles_uid_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE public.roles_uid_seq
  OWNER TO postgres;
