drop SEQUENCE if EXISTS account_seq;

create SEQUENCE account_seq;

CREATE TABLE account
(
  id         BIGINT                 NOT NULL PRIMARY KEY ,
  first_name CHARACTER VARYING(255) NOT NULL,
  last_name  CHARACTER VARYING(255) NOT NULL,
  email      CHARACTER VARYING(255) NOT NULL UNIQUE ,
  phone      CHARACTER VARYING(255) NOT NULL,
  password VARCHAR(100) NOT NULL ,
  role VARCHAR(50) NOT NULL ,
--   creation_date TIMESTAMP NOT NULL ,
  job_title VARCHAR(50) ,
  active BOOLEAN NOT NULL
);

ALTER TABLE account
  OWNER TO "user";
