INSERT INTO category.categories(id, name, active)
VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb45', 'category_1', TRUE);
INSERT INTO category.categories(id, name, active)
VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb46', 'category_2', FALSE);

INSERT INTO category.models(id, name, price, available)
VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb47', 'model_1', 25.00, FALSE);
INSERT INTO category.models(id, name, price, available)
VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb48', 'model_2', 50.00, TRUE);
INSERT INTO category.models(id, name, price, available)
VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb49', 'model_3', 20.00, FALSE);
INSERT INTO category.models(id, name, price, available)
VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb50', 'model_4', 40.00, TRUE);

INSERT INTO category.category_models(id, category_id, model_id)
VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb51', 'd215b5f8-0249-4dc5-89a3-51fd148cfb45', 'd215b5f8-0249-4dc5-89a3-51fd148cfb47');
INSERT INTO category.category_models(id, category_id, model_id)
VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb52', 'd215b5f8-0249-4dc5-89a3-51fd148cfb45', 'd215b5f8-0249-4dc5-89a3-51fd148cfb48');
INSERT INTO category.category_models(id, category_id, model_id)
VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb53', 'd215b5f8-0249-4dc5-89a3-51fd148cfb46', 'd215b5f8-0249-4dc5-89a3-51fd148cfb49');
INSERT INTO category.category_models(id, category_id, model_id)
VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb54', 'd215b5f8-0249-4dc5-89a3-51fd148cfb46', 'd215b5f8-0249-4dc5-89a3-51fd148cfb50');