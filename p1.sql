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
    id        NUMBER
        GENERATED ALWAYS AS IDENTITY ( START WITH 1 INCREMENT BY 1 ),
    amount    NUMBER(13,2) DEFAULT 0,
    email     VARCHAR2(40),
    purpose   VARCHAR2(40),
    status    NUMBER DEFAULT 1,    -- 1 is pending, 0 denied, 2 approved
    managerEmail   VARCHAR2(40),
    CONSTRAINT pk_id PRIMARY KEY ( id ),
    CONSTRAINT fk_manager FOREIGN KEY ( managerEmail )
        REFERENCES employee ( email ),
    CONSTRAINT fk_email FOREIGN KEY ( email )
        REFERENCES employee ( email )
);

SELECT
    *
FROM
    request;

INSERT INTO request (
    amount,
    email,
    purpose
) VALUES (
    2.42,
    'jane@gmail.com', 
    'candy'
);

INSERT INTO request (
    amount,
    email,
    purpose
) VALUES (
    6.66,
    'jane@gmail.com',
    'business dinner'
);

INSERT INTO request (
    amount,
    email, 
    purpose
) VALUES (
    100.44,
    'jane@gmail.com',
    'personal trainer'
);

SELECT
    *
FROM
    employee
    NATURAL JOIN request;

COMMIT;
    
    
    
    
