CREATE TABLE IF NOT EXISTS t_users (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(255),
    email VARCHAR(255),
    phone VARCHAR(50)
);
