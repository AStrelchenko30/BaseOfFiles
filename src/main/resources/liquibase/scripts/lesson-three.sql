-- liquibase formatted sql

-- changeset findByName:1
CREATE INDEX IF NOT EXISTS student_Name_Index ON student(name);

--changeset ColorFaculty:2
CREATE INDEX IF NOT EXISTS student_Color_Faculty_Index ON faculty(name,color);
