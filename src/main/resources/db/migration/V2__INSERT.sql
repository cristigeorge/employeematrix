DO $$
DECLARE
  i INTEGER;
BEGIN
  FOR i IN 1..200
  LOOP
    INSERT INTO employee (id, first_name, last_name, email, phone)
    VALUES (nextval('PUBLIC.employee_seq')
      , 'FirstName' || currval('public.employee_seq')
      , 'LastName' || currval('public.employee_seq')
      , 'Email' || currval('public.employee_seq')
      , 'Phone' || currval('public.employee_seq'));
  END LOOP;
END
$$;

DO $$
DECLARE
  i INTEGER;
BEGIN
  FOR i IN 1..200
  LOOP
    INSERT INTO skill (id,name, description,date_modified)
    VALUES (nextval('PUBLIC.skill_seq')
      , 'Name' || currval('public.skill_seq')
    ,'Description' || currval('public.skill_seq'),
    now());
  END LOOP;
END
$$;


DO $$
DECLARE
  i INTEGER;
BEGIN
  FOR i IN 1..200
  LOOP
    INSERT INTO employee_skill (id,employee_id, skill_id)
    VALUES (nextval('PUBLIC.employee_skill_seq'),
    (SELECT id FROM EMPLOYEE ORDER BY RANDOM() LIMIT 1),
            (SELECT id FROM SKILL ORDER BY RANDOM() LIMIT 1 ));
  END LOOP;
END
$$;
