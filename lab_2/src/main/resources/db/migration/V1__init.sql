-- Создание таблицы category_tab
create schema eq_shop;
CREATE TABLE eq_shop.category_tab (
                                      id serial PRIMARY KEY,
                                      name VARCHAR(150) NOT NULL
);
--     COMMENT = 'Таблица для хранения категорий товаров';

-- Вставка данных в таблицу category_tab
INSERT INTO eq_shop.category_tab (name) VALUES
                                            ('Стиральные машины'),
                                            ('Холодильники'),
                                            ('Микроволновые печи'),
                                            ('Пылесосы'),
                                            ('Кухонные плиты'),
                                            ('Электрические чайники'),
                                            ('Блендеры'),
                                            ('Кофеварки');
