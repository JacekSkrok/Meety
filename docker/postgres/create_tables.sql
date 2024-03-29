CREATE TABLE attendees
(
    attendee_id  SERIAL PRIMARY KEY,
    first_name   varchar(30) NOT NULL,
    last_name    varchar(30) NOT NULL,
    title        varchar(40) NULL,
    company      varchar(50) NULL,
    email        varchar(80) NOT NULL,
    phone_number varchar(20) NULL
);

CREATE TABLE appointments
(
    appointment_id          SERIAL PRIMARY KEY,
    appointment_name        varchar(80)             NOT NULL,
    appointment_date        date                    NOT NULL,
    appointment_start_time  time without time zone  NOT NULL,
    appointment_description varchar(1024)           NOT NULL,
    appointment_length      integer                 NOT NULL
);


CREATE TABLE tags
(
    tag_id      SERIAL PRIMARY KEY,
    description varchar(30) NOT NULL
);

CREATE TABLE appointments_tags
(
    appointment_id integer NOT NULL REFERENCES appointments (appointment_id),
    tag_id     integer NOT NULL REFERENCES tags (tag_id)
);

CREATE TABLE hosts
(
    host_id    SERIAL PRIMARY KEY,
    first_name    varchar(30)   NOT NULL,
    last_name     varchar(30)   NOT NULL,
    title         varchar(40)   NOT NULL,
    company       varchar(50)   NOT NULL,
    host_bio   varchar(2000) NOT NULL,
    host_photo BYTEA   NULL
);

CREATE TABLE appointment_hosts
(
    appointment_id integer NOT NULL REFERENCES appointments (appointment_id),
    host_id integer NOT NULL REFERENCES hosts (host_id)
);
