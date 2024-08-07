INSERT INTO Addresses (street, city, state, zipcode) VALUES
                                                       ('123 Main St', 'Springfield', 'IL', '62701'),
                                                       ('456 Elm St', 'Chicago', 'IL', '60614'),
                                                       ('789 Maple Ave', 'Naperville', 'IL', '60540'),
                                                       ('101 Oak St', 'Evanston', 'IL', '60201'),
                                                       ('202 Pine St', 'Aurora', 'IL', '60505');

-- Insert into users table
-- Insert into users table
INSERT INTO users (user_Id, first_Name, last_Name, email, password, address_id, years_Of_Experience,
                   employer_name, employer_info, user_type)
VALUES
    (1, 'applicant', 'John', 'applicant@example.com', '123', 1, 5, NULL, NULL, 'APPLICANT'),
    (2, 'employer', 'Smith', 'employer@example.com', '1234', 2, NULL, 'Tech Corp', 'Leading technology solutions provider', 'EMPLOYER');

-- Insert into roles table
INSERT INTO roles (id, name, description) VALUES
                                              (1, 'ROLE_APPLICANT', 'Applicant role'),
                                              (2, 'ROLE_EMPLOYER', 'Employer role');

-- Insert into users_roles table
INSERT INTO users_roles (user_id, role_id) VALUES
                                               (1, 1), -- Applicant
                                               (2, 2); -- Employer


INSERT INTO jobs (job_Id, job_Title, location, job_Salary, employer_id, years_of_experience) VALUES
                                                                         (1, 'Software Engineer', 'New York', 120000, 1,5),
                                                                         (2, 'Data Scientist', 'San Francisco', 130000, 1, 7),
                                                                         (3, 'Nurse', 'Los Angeles', 80000, 2, 0);
INSERT INTO job_technical_skills (job_id, technical_skill) VALUES
                                                               (1, 'Java'),
                                                               (1, 'Spring'),
                                                               (2, 'Python'),
                                                               (2, 'Machine Learning'),
                                                               (3, 'Patient Care'),
                                                               (3, 'CPR');

INSERT INTO job_soft_skills (job_id, soft_skill) VALUES
                                                     (1, 'Teamwork'),
                                                     (1, 'Communication'),
                                                     (2, 'Problem-solving'),
                                                     (2, 'Analytical Thinking'),
                                                     (3, 'Empathy'),
                                                     (3, 'Attention to Detail');

INSERT INTO job_benefits (job_id, benefit) VALUES
                                               (1, 'Health Insurance'),
                                               (1, '401(k)'),
                                               (2, 'Gym Membership'),
                                               (2, 'Stock Options'),
                                               (3, 'Flexible Hours'),
                                               (3, 'Paid Time Off');

INSERT INTO applicant_technical_skills (applicant_id, technical_skill) VALUES
                                                                           (1, 'Java'),
                                                                           (1, 'Spring'),
                                                                           (1, 'Hibernate'),
                                                                           (2, 'Python'),
                                                                           (2, 'Data Analysis');
INSERT INTO applicant_soft_skills (applicant_id, soft_skill) VALUES
                                                                 (1, 'Teamwork'),
                                                                 (1, 'Problem-solving'),
                                                                 (2, 'Communication'),
                                                                 (2, 'Time Management');
INSERT INTO applicant_jobs (applicant_id, job_id) VALUES
                                                      (1, 1),
                                                      (1, 2),
                                                      (2, 3);
INSERT INTO applications (application_Id, applicant_id, job_id, application_Status, application_Date)
                        VALUES
                            (1, 1, 1, 'IN_REVIEW', '2023-01-01'),
                            (2, 1, 2, 'ACCEPTED', '2023-02-15'),
                            (3, 2, 3, 'REJECTED', '2023-03-10');

