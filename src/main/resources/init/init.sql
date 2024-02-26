-- Create the database if it does not exist
SELECT 'CREATE DATABASE exp_db'
WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'exp_db')\gexec

-- Connect to the todo database
\c todo

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- Create the task table
CREATE TABLE IF NOT EXISTS task(
       id VARCHAR(48) PRIMARY KEY,
       header VARCHAR(100) NOT NULL,
       description VARCHAR(100) NOT NULL,
       status INT NOT NULL
    );

-- Insert data into the task table
INSERT INTO task (id, header, description, status) VALUES
       (uuid_generate_v4(),'aaa','aaa',1),(uuid_generate_v4(),'bbb','bbb',2),(uuid_generate_v4(),'ccc','ccc',0),
       (uuid_generate_v4(),'ddd','ddd',1),(uuid_generate_v4(),'eee','eee',2),(uuid_generate_v4(),'fff','fff',0),
       (uuid_generate_v4(),'ggg','ggg',1),(uuid_generate_v4(),'hhh','hhh',2),(uuid_generate_v4(),'jjj','jjj',0),
       (uuid_generate_v4(),'kkk','kkk',1),(uuid_generate_v4(),'lll','lll',2),(uuid_generate_v4(),'mmm','mmm',0),
       (uuid_generate_v4(),'nnn','nnn',1),(uuid_generate_v4(),'ooo','ooo',2),(uuid_generate_v4(),'ppp','ppp',0);