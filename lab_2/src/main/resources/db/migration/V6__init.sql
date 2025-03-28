
-- Создание таблицы customer_tab с комментарием
CREATE TABLE eq_shop.customer_tab (
                                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                      first_name VARCHAR(100) NOT NULL,
                                      middle_name VARCHAR(100),
                                      last_name VARCHAR(100) NOT NULL
) ;

-- Вставка данных в таблицу customer_tab
INSERT INTO eq_shop.customer_tab (first_name, middle_name, last_name) VALUES
                                                                       ('Алексей', 'Александрович', 'Алексеев'),
                                                                       ('Марина', 'Сергеевна', 'Сергеев'),
                                                                       ('Дмитрий', 'Дмитриевич', 'Дмитриев'),
                                                                       ('Елена', 'Викторовна', 'Викторова'),
                                                                       ('Светлана', 'Петровна', 'Петрова');