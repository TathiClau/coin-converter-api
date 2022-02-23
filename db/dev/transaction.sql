CREATE TABLE transaction (
    id UUID PRIMARY KEY,
    user_id UUID UNIQUE NOT NULL,
    initial_coin VARCHAR(20),
    initial_value DECIMAL,
    final_coin VARCHAR(20),
    final_value VARCHAR(20),
    conversion_rate DECIMAL,
    transaction_date date
    );