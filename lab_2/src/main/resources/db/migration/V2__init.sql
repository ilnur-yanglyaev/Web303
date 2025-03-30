-- Создание таблицы manufacturer_tab с комментарием
CREATE TABLE eq_shop.manufacturer_tab (
                                          id serial PRIMARY KEY,
                                          name VARCHAR(150) NOT NULL
);
-- COMMENT = 'Таблица для хранения информации о производителе';

-- Вставка данных в таблицу manufacturer_tab
INSERT INTO eq_shop.manufacturer_tab (name) VALUES
                                                ('LG'),
                                                ('Samsung'),
                                                ('Bosch'),
                                                ('Whirlpool'),
                                                ('Electrolux'),
                                                ('Philips'),
                                                ('Panasonic'),
                                                ('Miele'),
                                                ('Siemens'),
                                                ('Tefal');
