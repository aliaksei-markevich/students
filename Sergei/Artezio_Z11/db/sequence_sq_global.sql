﻿-- Sequence: sq_global

-- DROP SEQUENCE sq_global;

CREATE SEQUENCE sq_global
  INCREMENT 1
  MINVALUE 0
  MAXVALUE 9223372036854775807
  START 20
  CACHE 1;
ALTER TABLE sq_global
  OWNER TO postgres;
