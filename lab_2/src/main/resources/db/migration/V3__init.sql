-- Создание таблицы product_tab с комментарием
CREATE TABLE eq_shop.product_tab (
                                     id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                     name VARCHAR(200) NOT NULL,
                                     manufacturer_id BIGINT NOT NULL,
                                     category_id BIGINT NOT NULL,
                                     FOREIGN KEY (manufacturer_id) REFERENCES eq_shop.manufacturer_tab(id),
                                     FOREIGN KEY (category_id) REFERENCES eq_shop.category_tab(id)
) COMMENT = 'Таблица для хранения товаров';

-- Вставка данных в таблицу product_tab
INSERT INTO eq_shop.product_tab (name, manufacturer_id, category_id) VALUES
                                                                         ('LG TurboWash', 1, 1),
                                                                         ('Samsung EcoBubble', 2, 1),
                                                                         ('Bosch Serie 4', 3, 1),
                                                                         ('Whirlpool 6th Sense', 4, 1),
                                                                         ('Electrolux EWT 1066', 5, 1),
                                                                         ('Samsung Side-by-Side', 2, 2),
                                                                         ('Bosch KGN39XW20', 3, 2),
                                                                         ('Whirlpool WBE 3411', 4, 2),
                                                                         ('Electrolux ERN 1300', 5, 2),
                                                                         ('Philips HD 9220', 6, 3),
                                                                         ('Panasonic NN-CT56', 7, 3),
                                                                         ('Tefal Cook4Me', 10, 3),
                                                                         ('Dyson V11', 8, 4),
                                                                         ('Xiaomi Mi Robot', 9, 4),
                                                                         ('Bosch Serie 2', 3, 5),
                                                                         ('Electrolux EKC 951', 5, 5),
                                                                         ('Philips HD 4646', 6, 6),
                                                                         ('Tefal Blendforce', 10, 7),
                                                                         ('Miele CM 5300', 8, 8),
                                                                         ('Philips 3200 Series', 6, 8);
