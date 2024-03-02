DROP SCHEMA IF EXISTS category CASCADE;

CREATE SCHEMA category;

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

DROP TABLE IF EXISTS category.categories CASCADE;

CREATE TABLE category.categories
(
    id uuid NOT NULL,
    name character varying COLLATE pg_catalog."default" NOT NULL,
    active boolean NOT NULL,
    CONSTRAINT categories_pkey PRIMARY KEY (id)
);

DROP TYPE IF EXISTS approval_status;

CREATE TYPE approval_status AS ENUM ('APPROVED', 'REJECTED');

DROP TABLE IF EXISTS category.download_approval CASCADE;

CREATE TABLE category.download_approval
(
    id uuid NOT NULL,
    category_id uuid NOT NULL,
    download_id uuid NOT NULL,
    status approval_status NOT NULL,
    CONSTRAINT download_approval_pkey PRIMARY KEY (id)
);

DROP TABLE IF EXISTS category.models CASCADE;

CREATE TABLE category.models
(
    id uuid NOT NULL,
    name character varying COLLATE pg_catalog."default" NOT NULL,
    price numeric(10,2) NOT NULL,
    available boolean NOT NULL,
    CONSTRAINT models_pkey PRIMARY KEY (id)
);

DROP TABLE IF EXISTS category.category_models CASCADE;

CREATE TABLE category.category_models
(
    id uuid NOT NULL,
    category_id uuid NOT NULL,
    model_id uuid NOT NULL,
    CONSTRAINT category_products_pkey PRIMARY KEY (id)
);

ALTER TABLE category.category_models
    ADD CONSTRAINT "FK_CATEGORY_ID" FOREIGN KEY (category_id)
        REFERENCES category.categories (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE RESTRICT
    NOT VALID;

ALTER TABLE category.category_models
    ADD CONSTRAINT "FK_PRODUCT_ID" FOREIGN KEY (category_id)
        REFERENCES category.categories (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE RESTRICT
    NOT VALID;

DROP MATERIALIZED VIEW IF EXISTS category.download_category_m_view;

CREATE MATERIALIZED VIEW category.download_category_m_view
TABLESPACE pg_default
AS
SELECT r.id AS category_id,
       r.name AS category_name,
       r.active AS category_active,
       p.id AS model_id,
       p.name AS model_name,
       p.price AS model_price,
       p.available AS model_available
FROM category.categories r,
     category.models p,
     category.category_models rp
WHERE r.id = rp.category_id AND p.id = rp.model_id
    WITH DATA;

refresh materialized VIEW category.download_category_m_view;

DROP function IF EXISTS category.refresh_download_category_m_view;

CREATE OR replace function category.refresh_download_category_m_view()
              returns trigger
              AS '
BEGIN
    refresh materialized VIEW category.download_category_m_view;
    return null;
END;
'  LANGUAGE plpgsql;

DROP trigger IF EXISTS refresh_download_category_m_view ON category.category_models;

CREATE trigger refresh_download_category_m_view
    after INSERT OR UPDATE OR DELETE OR truncate
    ON category.category_models FOR each statement
EXECUTE PROCEDURE category.refresh_download_category_m_view();