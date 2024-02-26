-- Create the database if it does not exist
SELECT 'CREATE DATABASE todo'
WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'todo')\gexec

-- Connect to the todo database
\c todo

-- Create the task table
CREATE TABLE IF NOT EXISTS task (
       id VARCHAR(48) PRIMARY KEY,
       description VARCHAR(100) NOT NULL,
       status INT NOT NULL
    );

-- Insert data into the task table
INSERT INTO task (description, status) VALUES
       ('aaa',1),('bbb',2),('ccc',0),('ddd',1),('eee',2),
       ('fff',0),('ggg',1),('hhh',2),('jjj',0),('kkk',1),
       ('lll',2),('mmm',0),('nnn',1),('ooo',2),('ppp',0);