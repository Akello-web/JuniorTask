CREATE TABLE t_category (
                            id BIGSERIAL PRIMARY KEY,
                            category_type VARCHAR(255)
);

CREATE TABLE t_exchange_rates (
                                  id BIGSERIAL PRIMARY KEY,
                                  kzt_value DOUBLE PRECISION NOT NULL,
                                  rub_value DOUBLE PRECISION NOT NULL,
                                  time_last_update_utc VARCHAR(255)
);

CREATE TABLE t_monthly_limit (
                                 id BIGSERIAL PRIMARY KEY,
                                 goods_limitusd INT NOT NULL,
                                 month BYTEA,
                                 services_limitusd INT NOT NULL
);

CREATE TABLE t_transaction (
                               id BIGSERIAL PRIMARY KEY,
                               amount INT NOT NULL,
                               currency VARCHAR(255),
                               goods_limit_exceeded BOOLEAN NOT NULL,
                               init_goods_limit INT NOT NULL,
                               init_service_limit INT NOT NULL,
                               service_limit_exceeded BOOLEAN NOT NULL,
                               transaction_date DATE,
                               category_id BIGINT,
                               FOREIGN KEY (category_id) REFERENCES t_category (id)
);
