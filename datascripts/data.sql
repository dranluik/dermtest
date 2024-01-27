insert into role (name)
values ('Dermatologist'),
       ('Family doctor');

insert into organization (name)
values ('ITK'),
       ('Maarjamõisa');

insert into doctor (first_name, last_name, license_code, role_id, organization_id)
values ('John', 'Smith','L03510', 0, 0),
       ('Joan', 'Tree', 'L02341', 1, 1),
       ('Mary', 'Lamb', 'L08742', 1, 0);
