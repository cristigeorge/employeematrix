DROP SEQUENCE IF EXISTS public.employee_seq;
DROP SEQUENCE IF EXISTS public.skill_seq;
DROP SEQUENCE IF EXISTS public.employee_skill_seq;
DROP TABLE IF EXISTS public.employee_skill;
DROP TABLE IF EXISTS public.employee;
DROP TABLE IF EXISTS public.skill;
DROP TABLE IF EXISTS public.department;
CREATE SEQUENCE public.employee_seq
INCREMENT 1
MINVALUE 1
MAXVALUE 9223372036854775807
START 1
CACHE 1;
ALTER TABLE public.employee_seq
  OWNER TO "user";

CREATE SEQUENCE public.employee_skill_seq
INCREMENT 1
MINVALUE 1
MAXVALUE 9223372036854775807
START 1
CACHE 1;
ALTER TABLE public.employee_skill_seq
  OWNER TO "user";

CREATE SEQUENCE public.skill_seq
INCREMENT 1
MINVALUE 1
MAXVALUE 9223372036854775807
START 1
CACHE 1;
ALTER TABLE public.skill_seq
  OWNER TO "user";

CREATE TABLE public.employee
(
  id         BIGINT                 NOT NULL,
  first_name CHARACTER VARYING(255) NOT NULL,
  last_name  CHARACTER VARYING(255) NOT NULL,
  email      CHARACTER VARYING(255) NOT NULL,
  phone      CHARACTER VARYING(255) NOT NULL,
  CONSTRAINT employeepkey PRIMARY KEY (id)
)
WITH (
OIDS = FALSE
);
ALTER TABLE public.employee
  OWNER TO "user";

CREATE TABLE public.skill
(
  id            BIGINT       NOT NULL,
  name          VARCHAR(70)  NOT NULL,
  description   VARCHAR(250) NOT NULL,
  date_modified TIMESTAMP    NOT NULL,
  CONSTRAINT skillpk PRIMARY KEY (id)
)
WITH (
OIDS = FALSE
);
ALTER TABLE public.skill
  OWNER TO "user";

CREATE TABLE public.department
(
  id            BIGINT      NOT NULL,
  name          VARCHAR(70) NOT NULL,
  date_modified TIMESTAMP   NOT NULL,
  CONSTRAINT departmentpk PRIMARY KEY (id)
)
WITH (
OIDS = FALSE
);
ALTER TABLE public.department
  OWNER TO "user";

CREATE TABLE employee_skill
(
  id            INTEGER NOT NULL
    CONSTRAINT employee_skill_pkey
    PRIMARY KEY,
  employee_id   INTEGER
    CONSTRAINT fkkd8xx37dlmjryoas0d91hri6c
    REFERENCES employee,
  skill_id      INTEGER
    CONSTRAINT fkam2psf41jwoy33ge3uvxep8tl
    REFERENCES skill
);


