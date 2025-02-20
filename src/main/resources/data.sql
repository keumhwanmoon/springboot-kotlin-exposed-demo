INSERT INTO users (LOGIN_ID, USER_NAME, PICTURE, PHONE_NUMBER, MOBILE_PHONE_NUMBER, EMAIL)
VALUES ('admin', 'Admin User', null, '010-1111-1111', '010-1111-1111', 'admin@example.com'),
       ('user02', 'Jane Smith', null, '010-3333-3333', '010-3333-3333', 'jane.smith@example.com'),
       ('user01', 'John Doe', null, '010-2222-2222', '010-2222-2222', 'john.doe@example.com'),
       ('user03', 'Alice Johnson', null, '010-4444-4444', '010-4444-4444', 'alice.johnson@example.com'),
       ('user04', 'Bob Brown', null, '010-5555-5555', '010-5555-5555', 'bob.brown@example.com'),
       ('user05', 'Charlie Green', null, '010-6666-6666', '010-6666-6666', 'charlie.green@example.com'),
       ('user06', 'Diana Adams', null, '010-7777-7777', '010-7777-7777', 'diana.adams@example.com'),
       ('user07', 'Eve Carter', null, '010-8888-8888', '010-8888-8888', 'eve.carter@example.com'),
       ('user08', 'Frank White', null, '010-9999-9999', '010-9999-9999', 'frank.white@example.com'),
       ('user09', 'Grace Black', null, '010-0000-0000', '010-0000-0000', 'grace.black@example.com'),
       ('user10', 'Henry Blue', null, '010-1010-1010', '010-1010-1010', 'henry.blue@example.com');

INSERT INTO code (CODE_ID, PAR_CODE_ID, CODE_NAME, CODE_VALUE, CODE_EXPLANATION, USE_YN, SORT_NUMBER)
VALUES ('GENDER', NULL, 'Gender', null, null, 'Y', 1),
       ('GENDER_01', 'GENDER', 'Male', 'M', 'Male', 'Y', 1),
       ('GENDER_02', 'GENDER', 'Female', 'F', 'Female', 'Y', 2),
       ('STATUS', NULL, 'Status', null, null, 'Y', 3),
       ('STATUS_01', 'STATUS', 'Active', 'ACTIVE', 'Active status', 'Y', 3),
       ('STATUS_02', 'STATUS', 'Inactive', 'INACTIVE', 'Inactive status', 'Y', 4),
       ('ROLE', NULL, 'Role', null, null, 'Y', 5),
       ('ROLE_01', 'ROLE', 'Administrator', 'ADMIN', 'Administrative role', 'Y', 5),
       ('ROLE_02', 'ROLE', 'User', 'USER', 'Regular user role', 'Y', 6),
       ('PRIORITY', NULL, 'Priority', null, null, 'Y', 7),
       ('PRIORITY_01', 'PRIORITY', 'High', 'HIGH', 'High priority', 'Y', 7),
       ('PRIORITY_02', 'PRIORITY', 'Medium', 'MEDIUM', 'Medium priority', 'Y', 8),
       ('PRIORITY_03', 'PRIORITY', 'Low', 'LOW', 'Low priority', 'Y', 9),
       ('LANGUAGE', NULL, 'Language', null, null, 'Y', 10),
       ('LANGUAGE_01', 'LANGUAGE', 'English', 'EN', 'English', 'Y', 10),
       ('LANGUAGE_02', 'LANGUAGE', 'Korean', 'KO', 'Korean', 'Y', 11);

