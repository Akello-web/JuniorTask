CREATE TABLE t_category (
                            id BIGSERIAL PRIMARY KEY,
                            category_type VARCHAR(255)
);

CREATE TABLE t_exchange_rates (
                                  id BIGSERIAL PRIMARY KEY,
                                  kzt_value DOUBLE PRECISION,
                                  rub_value DOUBLE PRECISION,
                                  time_last_update_utc TIMESTAMP
);

CREATE TABLE t_monthly_limit (
                                 id BIGSERIAL PRIMARY KEY,
                                 goods_limit_usd INT,
                                 services_limit_usd INT,
                                 month DATE NOT NULL
);

CREATE TABLE t_transaction (
                               id serial PRIMARY KEY,
                               amount INT,
                               currency VARCHAR(3),
                               transaction_date DATE,
                               goods_limit_exceeded BOOLEAN,
                               service_limit_exceeded BOOLEAN,
                               init_goods_limit INT,
                               init_service_limit INT,
                               category_id INT,
                               FOREIGN KEY (category_id) REFERENCES t_category(id)
);


