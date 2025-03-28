
-- Создание таблицы purchase_tab с комментарием
CREATE TABLE eq_shop.purchase_tab (
                                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                      customer_id BIGINT NOT NULL ,
                                      store_id BIGINT NOT NULL ,
                                      purchase_date DATE NOT NULL ,
                                      FOREIGN KEY (customer_id) REFERENCES eq_shop.customer_tab(id),
                                      FOREIGN KEY (store_id) REFERENCES eq_shop.store_tab(id)
) COMMENT = 'Таблица для хранения счетов на оплату';

-- Вставка данных в таблицу purchase_tab
INSERT INTO eq_shop.purchase_tab (customer_id, store_id, purchase_date) VALUES
                                                                            (1, 1, '2023-02-01'), -- Алексеев
                                                                            (1, 2, '2023-02-10'), -- Алексеев
                                                                            (2, 2, '2023-02-02'), -- Сергеев
                                                                            (3, 3, '2023-02-03'), -- Дмитриев
                                                                            (4, 4, '2023-02-04'), -- Викторова
                                                                            (5, 5, '2023-02-05'), -- Петрова
                                                                            (1, 3, '2023-02-15'); -- Алексеев