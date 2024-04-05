-- liquibase formatted sql

-- changeset florian.kolb:1
CREATE TABLE items
(
    id          UUID         NOT NULL,
    created_at  TIMESTAMP WITHOUT TIME ZONE,
    created_by  VARCHAR(20),
    modified_at TIMESTAMP WITHOUT TIME ZONE,
    modified_by VARCHAR(20),
    name        VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    user_id     UUID,
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

INSERT INTO items as i (id, name) VALUES (1, 'Dyson V10'), (2, 'Die göttliche Komödie'), (3, 'Einhell Multitool');
