-- liquibase formatted sql

-- changeset findByName:1
CREATE INDEX student_Name_Index ON student(name);

--changeset ColorFaculty:2
CREATE INDEX student_Color_Faculty_Index ON faculty(name,color);
