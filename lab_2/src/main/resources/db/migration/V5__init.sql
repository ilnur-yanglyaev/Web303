-- Создание таблицы delivery_tab с комментарием
CREATE TABLE eq_shop.delivery_tab (
                                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                      store_id BIGINT NOT NULL,
                                      /*product_id BIGINT NOT NULL,*/
                                      delivery_date DATETIME NOT NULL,
                                      product_count INT NOT NULL,
                                      FOREIGN KEY (store_id) REFERENCES eq_shop.store_tab(id),
                                      /*FOREIGN KEY (product_id) REFERENCES eq_shop.product_tab(id)*/
) COMMENT = 'Таблица для хранения информации о доставке товара';

-- Вставка данных в таблицу delivery_tab
INSERT INTO eq_shop.delivery_tab (store_id, delivery_date, product_count) VALUES
                                                                              (1, '2023-01-15 10:00:00', 30),
                                                                              (1, '2023-01-20 10:00:00', 20),
                                                                              (2, '2023-01-18 11:00:00', 25),
                                                                              (3, '2023-01-22 12:00:00', 15),
                                                                              (4, '2023-01-25 13:00:00', 40),
                                                                              (5, '2023-01-30 14:00:00', 50)