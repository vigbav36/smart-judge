
DROP SCHEMA public CASCADE;
CREATE SCHEMA public;

GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO public;


create table Question (
    question_id BIGSERIAL PRIMARY KEY ,
    title TEXT,
    description TEXT,
    boiler_plate_code TEXT
)