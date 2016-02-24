-- Table: treetable

-- DROP TABLE treetable;

CREATE TABLE treetable
(
  id integer NOT NULL DEFAULT nextval('sq_treetable'::regclass),
  title text,
  parent_id integer,
  CONSTRAINT treetable_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE treetable
  OWNER TO postgres;
