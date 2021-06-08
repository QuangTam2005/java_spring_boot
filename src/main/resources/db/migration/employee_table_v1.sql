-- CREATE TABLE emphoyee_bank (
--   	id NUMBER(10) NOT NULL,
--   	employee_name  VARCHAR2(50)
-- );
-- 
-- ALTER TABLE emphoyee_bank ADD (
--  	CONSTRAINT emphoyee_bank_pk PRIMARY KEY (id)
-- );
-- 
-- CREATE SEQUENCE emphoyee_seq;
-- 
-- CREATE OR REPLACE TRIGGER emphoyee_trigger
--  	BEFORE INSERT ON emphoyee_bank
--  	FOR EACH ROW
-- BEGIN
--  	SELECT emphoyee_seq.nextval
--  	INTO :new.id
--  	FROM dual;
-- END;

CREATE TABLE emphoyee (
 id int(11) NOT NULL,
 name varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL
) 
ALTER TABLE emphoyee
  ADD PRIMARY KEY (id);
ALTER TABLE emphoyee
  MODIFY id int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;COMMIT;
-- 
INSERT INTO emphoyee (id, name) VALUES
(6, 'Nguy?n v?n B nnnn'),
