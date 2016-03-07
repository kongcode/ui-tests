CREATE TABLE IF NOT EXISTS TEST_CASE (
  ID INT NOT NULL GENERATED BY DEFAULT AS IDENTITY(START WITH 1, INCREMENT BY 1),
  NAME VARCHAR(45) NOT NULL,
  PRIMARY KEY (ID))
;

CREATE TABLE IF NOT EXISTS COMMAND (
  ID INT NOT NULL GENERATED BY DEFAULT AS IDENTITY(START WITH 1, INCREMENT BY 1),
  NAME VARCHAR(45) NOT NULL,
  IS_COMPOUND TINYINT NOT NULL,
  PRIMARY KEY (ID))
;

CREATE TABLE IF NOT EXISTS TEST_CASE_COMMAND (
  COMMAND_ID INT NOT NULL,
  TEST_CASE_ID INT NOT NULL,
  ID INT NOT NULL,
  DATA VARCHAR(5000) NOT NULL,
  PRIMARY KEY (COMMAND_ID, TEST_CASE_ID, ID),
  CONSTRAINT FK_TEST_CASE_COMMAND_TEST_CASE
    FOREIGN KEY (TEST_CASE_ID)
    REFERENCES TEST_CASE (ID)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT FK_TEST_CASE_COMMAND_COMMAND1
    FOREIGN KEY (COMMAND_ID)
    REFERENCES COMMAND (ID)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;

CREATE TABLE IF NOT EXISTS CORE_COMMAND (
  COMMAND_ID INT NOT NULL,
  PRIMARY KEY (COMMAND_ID),
  CONSTRAINT FK_CORE_COMMAND_COMMAND1
    FOREIGN KEY (COMMAND_ID)
    REFERENCES COMMAND (ID)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;


CREATE TABLE IF NOT EXISTS COMPOUND_COMMAND (
  COMMAND_ID INT NOT NULL,
  NAME VARCHAR(45) NOT NULL,
  PRIMARY KEY (COMMAND_ID),
  CONSTRAINT FK_COMPOUND_COMMAND_COMMAND1
    FOREIGN KEY (COMMAND_ID)
    REFERENCES COMMAND (ID)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;


CREATE TABLE IF NOT EXISTS COMPOUND_COMMAND_CORE_COMMAND (
  COMPOUND_COMMAND_ID INT NOT NULL,
  CORE_COMMAND_ID INT NOT NULL,
  ID INT NOT NULL,
  PRIMARY KEY (COMPOUND_COMMAND_ID, CORE_COMMAND_ID, ID),
  CONSTRAINT FK_COMPOUND_COMMAND_CORE_COMMAND_CORE_COMMAND1
    FOREIGN KEY (CORE_COMMAND_ID)
    REFERENCES CORE_COMMAND (COMMAND_ID)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT FK_COMPOUND_COMMAND_CORE_COMMAND_COMPOUND_COMMAND1
    FOREIGN KEY (COMPOUND_COMMAND_ID)
    REFERENCES COMPOUND_COMMAND (COMMAND_ID)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;

CREATE UNIQUE INDEX TEST_CASE_NAME_UNIQUE ON TEST_CASE (NAME ASC);
CREATE UNIQUE INDEX COMMAND_NAME_UNIQUE ON COMMAND (NAME ASC);
CREATE INDEX fk_TEST_CASE_COMMAND_COMMAND1_idx ON TEST_CASE_COMMAND (COMMAND_ID ASC);
CREATE INDEX fk_CORE_COMMAND_COMMAND1_idx ON CORE_COMMAND (COMMAND_ID ASC);
CREATE UNIQUE INDEX NAME_UNIQUE ON COMPOUND_COMMAND (NAME ASC);
CREATE INDEX fk_COMPOUND_COMMAND_COMMAND1_idx ON COMPOUND_COMMAND (COMMAND_ID ASC);
CREATE INDEX fk_COMPOUND_COMMAND_CORE_COMMAND_CORE_COMMAND1_idx ON COMPOUND_COMMAND_CORE_COMMAND (CORE_COMMAND_ID ASC);
