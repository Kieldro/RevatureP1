-- ctrl + enter to run statement

DROP TABLE employee;

CREATE TABLE employee (
    email       VARCHAR2(40) NOT NULL,
    password    VARCHAR2(40) DEFAULT 'asd',
    firstname   VARCHAR2(40) NOT NULL,
    lastname    VARCHAR2(40) NOT NULL,
    manager     INT DEFAULT 0,
    CONSTRAINT pk_email PRIMARY KEY ( email )
);

SELECT 
    *
FROM
    employee;

INSERT INTO employee VALUES (
    'jane@gmail.com',
    'asd',
    'Jane',
    'Doe',
    0
);        -- dummy row used for testing
INSERT INTO employee VALUES (
    'keo@gmail.com',
    'asd',
    'Keo',
    'Tron',
    1
); 
DROP TABLE request;

CREATE TABLE request (
    id       number GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1),
    amount   NUMBER(13,2) DEFAULT 0,
    email    VARCHAR2(40),
--    purpose VARCHAR2(40),
--    status   number default 1,    -- 1 is pending, 0 denied, 2 approved
    CONSTRAINT pk_id PRIMARY KEY ( id ),
    CONSTRAINT fk_email FOREIGN KEY ( email )
        REFERENCES employee ( email )
);

SELECT
    *
FROM
    request;

INSERT INTO request (amount, email)VALUES (
2.42,
'jane@gmail.com'
);

INSERT INTO request (amount, email)VALUES (
6.66,
'jane@gmail.com'
);
INSERT INTO request (amount, email)VALUES (
100.44,
'jane@gmail.com'
);

select * from EMPLOYEE natural join request;
    
    commit;
    
    
    
    
    
    
--PROJECT 0

SELECT
    *
FROM
    user_account;

DROP TABLE user_account;

CREATE TABLE user_account (
--    user_id     int,
    name       VARCHAR2(40),
    password   VARCHAR2(40) DEFAULT 'asd',
    balance    NUMBER(13,2) DEFAULT 0,
    admin      INT DEFAULT 0,
    approved   INT DEFAULT 0,
    CONSTRAINT pk_name PRIMARY KEY ( name )
-- , CONSTRAINT UK_user_id UNIQUE (user_id)
);

--test commands

TRUNCATE TABLE user_account;

INSERT INTO user_account VALUES (
    'Jane',
    'asd',
    6.66,
    0,
    0
);        -- dummy row used for testing

INSERT INTO user_account VALUES (
    'keo',
    'asd',
    0,
    1,
    1
);

COMMIT;

SELECT
    *
FROM
    user_account;

INSERT INTO user_account ( name ) VALUES ( 'Ian' );

DELETE FROM user_account
WHERE
    name = 'Ian';

UPDATE user_account
SET
    balance = 4.0,
    approved = 0
WHERE
    name = 'Ian B';

COMMIT;

--Create a Sequence to generate the value for the user id's

CREATE SEQUENCE user_id_sequence START WITH 1 INCREMENT BY 1 MAXVALUE 900 MINVALUE - 1 NOCACHE;

--Create an INSERT trigger on Pokemon to auto-increment the PK

CREATE OR REPLACE TRIGGER before_insert_pokemon BEFORE
    INSERT ON pokemon
    FOR EACH ROW
BEGIN
    IF
        :new.id IS NULL
    THEN
        SELECT
            pokemon_sequence.NEXTVAL
        INTO :new.id
        FROM
            dual;

    END IF;
END;
/

--Create a Stored Procedure to INSERT a new Pokemon

CREATE OR REPLACE PROCEDURE insert_pokemon (
    pokedexentry   IN INTEGER,
    name           IN VARCHAR2,
    type1          IN VARCHAR2,
    type2          IN VARCHAR2,
    generation     IN INTEGER
)
    AS
BEGIN
    INSERT INTO pokemon VALUES (
        NULL,
        pokedexentry,
        name,
        type1,
        type2,
        generation
    );

    COMMIT;
END;
/
-- Park's tables

CREATE TABLE user_customer (
    customer_id     INTEGER,
    first_name      VARCHAR2(160),
    last_name       VARCHAR2(160),
    user_name       VARCHAR2(160),
    user_password   VARCHAR2(160),
    approval        INTEGER DEFAULT 0,
    CONSTRAINT unique_user UNIQUE ( user_name ),
    CONSTRAINT pk_user_customer PRIMARY KEY ( customer_id )
);

CREATE TABLE user_account (
    account_id      INTEGER,
    account_name    VARCHAR2(160),
    user_name       VARCHAR2(160),
    acct_creation   TIMESTAMP DEFAULT current_timestamp,
    balance         NUMBER DEFAULT 0,
    CONSTRAINT pk_user_account PRIMARY KEY ( account_id ),
    CONSTRAINT fk_customer_user FOREIGN KEY ( user_name )
        REFERENCES user_customer ( user_name )
);
SELECT
    *
FROM
    employee;

-- ctrl + enter to run statement
-- 

CREATE TABLE employee (
    email       VARCHAR2(40),
    password    VARCHAR2(40) DEFAULT 'asd',
    firstname   VARCHAR2(40),
    lastname    VARCHAR2(40),
    manager     INT DEFAULT 0,
    CONSTRAINT pk_email PRIMARY KEY ( email )
);

SELECT
    *
FROM
    employee;

INSERT INTO employee VALUES (
    'jane@gmail.com',
    'asd',
    'Jane',
    'Doe',
    0
);        -- dummy row used for testing

DROP TABLE request;

CREATE TABLE request (
    id       VARCHAR2(40),
    amount   NUMBER(13,2) DEFAULT 0,
    email    VARCHAR2(40),
    CONSTRAINT pk_id PRIMARY KEY ( id ),
    CONSTRAINT fk_email FOREIGN KEY ( email )
        REFERENCES employee ( email )
);

SELECT
    *
FROM
    request;
    
    
    
    
    
    
    
    
    
    
    
--PROJECT 0

SELECT
    *
FROM
    user_account;

DROP TABLE user_account;

CREATE TABLE user_account (
--    user_id     int,
    name       VARCHAR2(40),
    password   VARCHAR2(40) DEFAULT 'asd',
    balance    NUMBER(13,2) DEFAULT 0,
    admin      INT DEFAULT 0,
    approved   INT DEFAULT 0,
    CONSTRAINT pk_name PRIMARY KEY ( name )
-- , CONSTRAINT UK_user_id UNIQUE (user_id)
);

--test commands

TRUNCATE TABLE user_account;

INSERT INTO user_account VALUES (
    'Jane',
    'asd',
    6.66,
    0,
    0
);        -- dummy row used for testing

INSERT INTO user_account VALUES (
    'keo',
    'asd',
    0,
    1,
    1
);

COMMIT;

SELECT
    *
FROM
    user_account;

INSERT INTO user_account ( name ) VALUES ( 'Ian' );

DELETE FROM user_account
WHERE
    name = 'Ian';

UPDATE user_account
SET
    balance = 4.0,
    approved = 0
WHERE
    name = 'Ian B';

COMMIT;

--Create a Sequence to generate the value for the user id's

CREATE SEQUENCE user_id_sequence START WITH 1 INCREMENT BY 1 MAXVALUE 900 MINVALUE - 1 NOCACHE;

--Create an INSERT trigger on Pokemon to auto-increment the PK

CREATE OR REPLACE TRIGGER before_insert_pokemon BEFORE
    INSERT ON pokemon
    FOR EACH ROW
BEGIN
    IF
        :new.id IS NULL
    THEN
        SELECT
            pokemon_sequence.NEXTVAL
        INTO :new.id
        FROM
            dual;

    END IF;
END;
/

--Create a Stored Procedure to INSERT a new Pokemon

CREATE OR REPLACE PROCEDURE insert_pokemon (
    pokedexentry   IN INTEGER,
    name           IN VARCHAR2,
    type1          IN VARCHAR2,
    type2          IN VARCHAR2,
    generation     IN INTEGER
)
    AS
BEGIN
    INSERT INTO pokemon VALUES (
        NULL,
        pokedexentry,
        name,
        type1,
        type2,
        generation
    );

    COMMIT;
END;
/
-- Park's tables

CREATE TABLE user_customer (
    customer_id     INTEGER,
    first_name      VARCHAR2(160),
    last_name       VARCHAR2(160),
    user_name       VARCHAR2(160),
    user_password   VARCHAR2(160),
    approval        INTEGER DEFAULT 0,
    CONSTRAINT unique_user UNIQUE ( user_name ),
    CONSTRAINT pk_user_customer PRIMARY KEY ( customer_id )
);

CREATE TABLE user_account ( account_id INTEGER,account_name VARCHAR2(160),user_name VARCHAR2(160),acct_creation TIMESTAMP DEFAULT current_timestamp,balance
NUMBER DEFAULT 0,constraint pk_user_account PRIMARY KEY(account_id),
constraint fk_customer_user FOREIGN KEY(user_name)
    REFERENCES user_customer(user_name)
);