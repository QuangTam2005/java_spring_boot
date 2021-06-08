CREATE TABLE test_data (
 id int(11) NOT NULL,
 value VARCHAR(25) NOT NULL,
 PRIMARY KEY(id)
);

-- DELIMITER
-- CREATE PROCEDURE AddData()
--  BEGIN
--    # MySQL-style single line comment
--   INSERT INTO test_data values("2","nghia")
--   INSERT INTO test_data values("3","nghia")
--  END
-- DELIMITER;
-- DELIMITER $$
-- CREATE PROCEDURE generate_data()
-- BEGIN
--   DECLARE i INT DEFAULT 0;
--   WHILE i < 100 DO
--     SET i = i + 1;
--   END WHILE;
-- END$$
-- DELIMITER ;
-- 
-- CALL generate_data();

