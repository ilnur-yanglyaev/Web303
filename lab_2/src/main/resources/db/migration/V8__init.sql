-- Создание таблицы purchase_items_tab с комментарием
CREATE TABLE eq_shop.purchase_items_tab (
                                            id serial PRIMARY KEY,
                                            purchase_id BIGINT NOT NULL,
                                            product_id BIGINT NOT NULL ,
                                            product_count INT NOT NULL,
                                            product_price DECIMAL(10, 2) NOT NULL,
                                            FOREIGN KEY (purchase_id) REFERENCES eq_shop.purchase_tab(id),
                                            FOREIGN KEY (product_id) REFERENCES eq_shop.product_tab(id)
);

-- COMMENT = 'Таблица для хранения информации о товара, купленных в рамках одной покупки (товар в
-- счете на оплату)';

-- Вставка данных в таблицу purchase_items_tab
INSERT INTO eq_shop.purchase_items_tab (purchase_id, product_id, product_count, product_price) VALUES
                                                                                                   (1, 1, 1, 5000000), -- LG TurboWash
                                                                                                   (1, 2, 1, 6000000), -- Samsung EcoBubble
                                                                                                   (2, 3, 1, 4000000), -- Bosch Serie 4
                                                                                                   (2, 4, 1, 4500000), -- Whirlpool 6th Sense
                                                                                                   (3, 5, 1, 3000000), -- Electrolux EWT 1066
                                                                                                   (4, 6, 1, 800000),  -- Philips HD 9220
                                                                                                   (5, 7, 1, 1200000), -- Panasonic NN-CT56
                                                                                                   (6, 8, 1, 1500000), -- Dyson V11
                                                                                                   (7, 9, 1, 2000000); -- Xiaomi Mi Robot
