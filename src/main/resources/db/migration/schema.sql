CREATE DATABASE "Library"
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1;

-- SCHEMA: CentralLib

-- DROP SCHEMA "CentralLib" ;
CREATE SCHEMA "CentralLib"
    AUTHORIZATION postgres;

CREATE TABLE IF NOT EXISTS "CentralLib".book
(
    id bigint,
    author character(30)[],
    "book_Title" character(30)[],
    CONSTRAINT "bookId_PK" PRIMARY KEY (id)
    );

ALTER TABLE "CentralLib".book
    OWNER to postgres;

CREATE TABLE IF NOT EXISTS "CentralLib".member
(
    member_id bigint,
    member_name "char"[],
    password "char"[],
    PRIMARY KEY (member_id)
    );

ALTER TABLE "CentralLib".member
    OWNER to postgres;

CREATE TABLE IF NOT EXISTS "CentralLib".borrow
(
    borrow_id bigint,
    start_date date,
    returned_date date,
    book_id bigint,
    member_id bigint,
    PRIMARY KEY (borrow_id)
    );

ALTER TABLE "CentralLib".borrow
    OWNER to postgres;