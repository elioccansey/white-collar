-- Insert into Addresses table
INSERT INTO Addresses (street, city, state, zipcode) VALUES
                                                         ('123 Main St', 'Springfield', 'IL', '62701'),
                                                         ('456 Elm St', 'Chicago', 'IL', '60614'),
                                                         ('789 Maple Ave', 'Naperville', 'IL', '60540'),
                                                         ('101 Oak St', 'Evanston', 'IL', '60201'),
                                                         ('202 Pine St', 'Aurora', 'IL', '60505');

-- Insert into users table
INSERT INTO users (first_Name, last_Name, email, password, address_id, years_Of_Experience,
                   employer_name, employer_info, user_type)
VALUES
    ('John', 'Doe', 'john.doe@example.com', 'password1', 1, 5, NULL, NULL, 'APPLICANT'),
    ('Jane', 'Smith', 'jane.smith@example.com', 'password2', 2, 7, NULL, NULL, 'APPLICANT'),
    ('Alice', 'Johnson', 'alice.johnson@example.com', 'password3', 3, 3, NULL, NULL, 'APPLICANT'),
    ('Bob', 'Brown', 'bob.brown@example.com', 'password4', 4, 8, NULL, NULL, 'APPLICANT'),
    ('Charles', 'Davis', 'charles.davis@example.com', 'password5', 5, NULL, 'Davis Tech', 'Innovative tech solutions', 'EMPLOYER'),
    ('Emily', 'Wilson', 'emily.wilson@example.com', 'password6', NULL, NULL, 'Wilson Industries', 'Leading industrial solutions provider', 'EMPLOYER'),
    ('Frank', 'Miller', 'frank.miller@example.com', 'password7', NULL, NULL, 'Miller Consulting', 'Expert consulting services', 'EMPLOYER');

-- Insert into roles table
INSERT INTO roles (id, name, description) VALUES
                                              (1, 'ROLE_APPLICANT', 'Applicant role'),
                                              (2, 'ROLE_EMPLOYER', 'Employer role');

-- Insert into users_roles table
INSERT INTO users_roles (user_id, role_id) VALUES
                                               (1, 1), -- Applicant 1
                                               (2, 1), -- Applicant 2
                                               (3, 1), -- Applicant 3
                                               (4, 1), -- Applicant 4
                                               (5, 2), -- Employer 1
                                               (6, 2), -- Employer 2
                                               (7, 2); -- Employer 3

-- Insert into jobs table
INSERT INTO jobs (job_Id, job_Title, location, job_Salary, employer_id, years_of_experience) VALUES
                                                                                                 (1, 'Software Engineer', 'New York', 120000, 5, 5),  -- Employer 1
                                                                                                 (2, 'Data Scientist', 'San Francisco', 130000, 6, 7), -- Employer 2
                                                                                                 (3, 'Nurse', 'Los Angeles', 80000, 7, 0); -- Employer 3

-- Insert into job_technical_skills table
INSERT INTO job_technical_skills (job_id, technical_skill) VALUES
                                                               (1, 'Java'),
                                                               (1, 'Spring'),
                                                               (2, 'Python'),
                                                               (2, 'Machine Learning'),
                                                               (3, 'Patient Care'),
                                                               (3, 'CPR');

-- Insert into job_soft_skills table
INSERT INTO job_soft_skills (job_id, soft_skill) VALUES
                                                     (1, 'Teamwork'),
                                                     (1, 'Communication'),
                                                     (2, 'Problem-solving'),
                                                     (2, 'Analytical Thinking'),
                                                     (3, 'Empathy'),
                                                     (3, 'Attention to Detail');

-- Insert into job_benefits table
INSERT INTO job_benefits (job_id, benefit) VALUES
                                               (1, 'Health Insurance'),
                                               (1, '401(k)'),
                                               (2, 'Gym Membership'),
                                               (2, 'Stock Options'),
                                               (3, 'Flexible Hours'),
                                               (3, 'Paid Time Off');

-- Insert into applicant_technical_skills table
INSERT INTO applicant_technical_skills (applicant_id, technical_skill) VALUES
                                                                           (1, 'Java'),
                                                                           (1, 'Spring'),
                                                                           (1, 'Hibernate'),
                                                                           (2, 'Python'),
                                                                           (2, 'Data Analysis'),
                                                                           (3, 'JavaScript'),
                                                                           (3, 'React'),
                                                                           (4, 'C#'),
                                                                           (4, '.NET');

-- Insert into applicant_soft_skills table
INSERT INTO applicant_soft_skills (applicant_id, soft_skill) VALUES
                                                                 (1, 'Teamwork'),
                                                                 (1, 'Problem-solving'),
                                                                 (2, 'Communication'),
                                                                 (2, 'Time Management'),
                                                                 (3, 'Leadership'),
                                                                 (3, 'Adaptability'),
                                                                 (4, 'Creativity'),
                                                                 (4, 'Attention to Detail');

-- Insert into applications table
INSERT INTO applications (application_Id, applicant_id, job_id, application_Status, application_Date) VALUES
                                                                                                          (1, 1, 1, 'IN_REVIEW', '2023-01-01'),
                                                                                                          (2, 2, 2, 'ACCEPTED', '2023-02-15'),
                                                                                                          (3, 3, 3, 'REJECTED', '2023-03-10'),
                                                                                                          (4, 4, 1, 'IN_REVIEW', '2023-04-01');
