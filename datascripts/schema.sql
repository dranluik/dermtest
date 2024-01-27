CREATE TABLE role (
                      id INTEGER IDENTITY PRIMARY KEY,
                      name VARCHAR(255) NOT NULL
);

CREATE TABLE organization (
                              id INTEGER IDENTITY PRIMARY KEY,
                              name VARCHAR(255) NOT NULL
);

CREATE TABLE doctor (
                        id INTEGER IDENTITY PRIMARY KEY,
                        first_name VARCHAR(255) NOT NULL,
                        last_name VARCHAR(255) NOT NULL,
                        license_code VARCHAR(255) NOT NULL,
                        role_id INTEGER NOT NULL,
                        organization_id INTEGER NOT NULL,
                        FOREIGN KEY (role_id) REFERENCES role (id),
                        FOREIGN KEY (organization_id) REFERENCES organization (id)
);
