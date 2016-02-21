-- Table: clients

-- DROP TABLE clients;

CREATE TABLE clients
(
  client_id integer NOT NULL DEFAULT nextval('sq_global'::regclass),
  lastname text NOT NULL,
  firstname text NOT NULL,
  prone_number integer NOT NULL,
  first_id integer NOT NULL,
  second_id integer,
  main_id integer,
  CONSTRAINT "Клиенты_pkey" PRIMARY KEY (client_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE clients
  OWNER TO postgres;
