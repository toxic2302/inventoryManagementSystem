-- liquibase formatted sql

-- changeset florian.kolb:1
CREATE TABLE items
(
    id            UUID         NOT NULL,
    created_at    TIMESTAMP WITHOUT TIME ZONE,
    created_by    VARCHAR(20),
    modified_at   TIMESTAMP WITHOUT TIME ZONE,
    modified_by   VARCHAR(20),
    name          VARCHAR(255) NOT NULL,
    brand         VARCHAR(255) NOT NULL,
    serial_number VARCHAR(255),
    description   VARCHAR(10000),
    user_id       UUID,
    sold          BOOLEAN,
    CONSTRAINT pk_items PRIMARY KEY (id)
);

-- changeset florian.kolb:2
CREATE TABLE users
(
    id          UUID NOT NULL,
    created_at  TIMESTAMP WITHOUT TIME ZONE,
    created_by  VARCHAR(20),
    modified_at TIMESTAMP WITHOUT TIME ZONE,
    modified_by VARCHAR(20),
    oauth_id    VARCHAR(255),
    name        VARCHAR(255),
    email       VARCHAR(255),
    picture_url VARCHAR(255),
    CONSTRAINT pk_users PRIMARY KEY (id)
);

-- changeset florian.kolb:3
ALTER TABLE items ADD CONSTRAINT FK_ITEMS_ON_USER FOREIGN KEY (user_id) REFERENCES users (id);

-- changeset florian.kolb:4
INSERT INTO items as i (id, brand, name, serial_number, description, sold)
VALUES ('018ea910-9ca4-71a6-a2c7-281d24e16b67', 'Dyson', 'V10', 'abc123', 'description', false),
       ('018ea910-ce66-7c3e-81c3-7208fb453359', 'Bosch', 'Bohrhammer', 'abc123', 'description', false),
       ('018ea910-ed49-70ff-b26d-25753a910f46', 'Einhell', 'Multitool', 'abc123', 'description', false);

-- changeset florian.kolb:5
INSERT INTO users as u (id, name, email)
VALUES ('018ea913-629c-7b03-bfce-e85ebbd663e5', 'Florian Kolb', 'toxic2376@googlemail.com');
