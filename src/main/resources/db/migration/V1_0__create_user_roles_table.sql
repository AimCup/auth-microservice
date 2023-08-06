CREATE TABLE "user"
(
    id            UUID PRIMARY KEY,
    username      VARCHAR NOT NULL,
    osu_id        BIGINT  NOT NULL,
    is_restricted BOOLEAN NOT NULL,
    CONSTRAINT user_username_unique UNIQUE (username),
    CONSTRAINT user_osuId_unique UNIQUE (osu_id)
);

CREATE INDEX idx_user_username ON "user" (username);
CREATE INDEX idx_user_osuId ON "user" (osu_id);

CREATE TABLE role
(
    id   UUID PRIMARY KEY,
    name VARCHAR(60) NOT NULL
);

CREATE INDEX idx_role_name ON role (name);

CREATE TABLE user_roles
(
    user_id UUID NOT NULL,
    role_id UUID NOT NULL,
    PRIMARY KEY (user_id, role_id)
);
