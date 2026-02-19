CREATE TABLE user_auth (
  id SERIAL PRIMARY KEY,
  email CITEXT NOT NULL UNIQUE,
  phone_number VARCHAR(20) UNIQUE,
  email_verified BOOLEAN DEFAULT FALSE,
  phone_number_verified BOOLEAN DEFAULT FALSE,
  password VARCHAR(255) NOT NULL,
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE sessions (
  id SERIAL PRIMARY KEY,
  auth_id INTEGER NOT NULL,
  device_id VARCHAR(255) NOT NULL,  -- unique device identifier
  session_token VARCHAR(255) NOT NULL,
  refresh_token VARCHAR(255) NOT NULL,
  refresh_token_expires_at TIMESTAMP NOT NULL,
  expires_at TIMESTAMP NOT NULL,
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (auth_id) REFERENCES auth (id)
);

CREATE TABLE otps (
  id SERIAL PRIMARY KEY,
  session_id INTEGER,  -- for 2FA during login
  auth_id INTEGER,  -- for 2FA during registration
  purpose VARCHAR(50) NOT NULL,  -- e.g. phone verification, email verification, password reset, 2fa_login, 2fa_registration
  token VARCHAR(255) NOT NULL,
  expires_at TIMESTAMP NOT NULL,
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (session_id) REFERENCES sessions (id),
  FOREIGN KEY (auth_id) REFERENCES auth (id)
);

CREATE TABLE social_accounts (
  id SERIAL PRIMARY KEY,
  auth_id INTEGER NOT NULL,
  provider VARCHAR(255) NOT NULL,
  provider_id VARCHAR(255) NOT NULL,
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (auth_id) REFERENCES auth (id)
);

CREATE TABLE user_details (
  id SERIAL PRIMARY KEY,
  auth_id INTEGER NOT NULL,
  email CITEXT NOT NULL UNIQUE,
  name VARCHAR(255),
  phone_number VARCHAR(20),
  avatar VARCHAR(255),
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (auth_id) REFERENCES auth (id)
);

CREATE TABLE admin_auth (
  id SERIAL PRIMARY KEY,
  email CITEXT NOT NULL UNIQUE,
  password VARCHAR(255) NOT NULL,
  activation_token VARCHAR(255),
  activated_at TIMESTAMP,
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE admin_details (
  id SERIAL PRIMARY KEY,
  admin_auth_id INTEGER NOT NULL,
  name VARCHAR(255),
  email CITEXT NOT NULL UNIQUE,
  phone_number VARCHAR(20),
  avatar VARCHAR(255),
  role_id INTEGER NOT NULL,
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (admin_auth_id) REFERENCES admin_auth (id)
);

CREATE TABLE roles (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  description TEXT,
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE permissions (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  description TEXT,
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE role_permissions (
  role_id INTEGER NOT NULL,
  permission_id INTEGER NOT NULL,
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (role_id, permission_id),
  FOREIGN KEY (role_id) REFERENCES roles (id),
  FOREIGN KEY (permission_id) REFERENCES permissions (id)
);


CREATE TABLE two_factor_auth (
  id SERIAL PRIMARY KEY,
  auth_id INTEGER NOT NULL,
  method VARCHAR(50) NOT NULL,  -- e.g. google_authenticator, sms, email
  secret_key VARCHAR(255) NOT NULL,  -- secret key for the chosen method
  is_enabled BOOLEAN DEFAULT FALSE,
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (auth_id) REFERENCES auth (id)
);


CREATE TABLE admin_two_factor_auth (
  id SERIAL PRIMARY KEY,
  admin_id INTEGER NOT NULL,
  method VARCHAR(50) NOT NULL,  -- e.g. google_authenticator, sms, email
  secret_key VARCHAR(255) NOT NULL,  -- secret key for the chosen method
  is_enabled BOOLEAN DEFAULT FALSE,
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (admin_id) REFERENCES admins (id)
);



