DROP SCHEMA IF EXISTS "download" CASCADE;

CREATE SCHEMA "download";

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

DROP TYPE IF EXISTS download_status;
CREATE TYPE download_status AS ENUM ('PENDING', 'PAID', 'APPROVED', 'CANCELLED', 'CANCELLING');

DROP TABLE IF EXISTS "download".downloads CASCADE;

CREATE TABLE "download".downloads
(
    id uuid NOT NULL,
    customer_id uuid NOT NULL,
    category_id uuid NOT NULL,
    tracking_id uuid NOT NULL,
    price numeric(10,2) NOT NULL,
    download_status download_status NOT NULL,
    failure_messages character varying COLLATE pg_catalog."default",
    CONSTRAINT downloads_pkey PRIMARY KEY (id)
);

DROP TABLE IF EXISTS "download".download_items CASCADE;

CREATE TABLE "download".download_items
(
    id bigint NOT NULL,
    download_id uuid NOT NULL,
    model_id uuid NOT NULL,
    price numeric(10,2) NOT NULL,
    CONSTRAINT download_items_pkey PRIMARY KEY (id, download_id)
);

ALTER TABLE "download".download_items
    ADD CONSTRAINT "FK_DOWNLOAD_ID" FOREIGN KEY (download_id)
    REFERENCES "download".downloads (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE CASCADE
    NOT VALID;

DROP TABLE IF EXISTS "download".user_information CASCADE;

CREATE TABLE "download".user_information
(
    id uuid NOT NULL,
    download_id uuid UNIQUE NOT NULL,
    email character varying COLLATE pg_catalog."default" NOT NULL,
    country character varying COLLATE pg_catalog."default" NOT NULL,
    city character varying COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT download_address_pkey PRIMARY KEY (id, download_id)
);

ALTER TABLE "download".user_information
    ADD CONSTRAINT "FK_DOWNLOAD_ID" FOREIGN KEY (download_id)
    REFERENCES "download".downloads (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE CASCADE
    NOT VALID;

