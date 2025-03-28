-- Создание таблицы store_tab с комментарием
CREATE TABLE eq_shop.store_tab (
                                   id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                   name VARCHAR(255) NOT NULL
) COMMENT = 'Таблица для хранения информации о филиалах';


INSERT INTO eq_shop.store_tab (name) VALUES
                                         ('Магазин Бытовой Техники 1'),
                                         ('Магазин Бытовой Техники 2'),
                                         ('Магазин Бытовой Техники 3'),
                                         ('Магазин Бытовой Техники 4'),
                                         ('Магазин Бытовой Техники 5');