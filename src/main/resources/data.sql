INSERT INTO patient (name, gender, birth_date, email, blood_group)
VALUES
    ('Aarav Sharma', 'MALE', '1990-05-10', 'aarav.sharma@example.com', 'O_POSITIVE'),
    ('Diya Patel', 'FEMALE', '1995-08-20', 'diya.patel@example.com', 'A_POSITIVE'),
    ('Dishant Verma', 'MALE', '1988-03-15', 'dishant.verma@example.com', 'A_POSITIVE'),
    ('Neha Iyer', 'FEMALE', '1992-12-01', 'neha.iyer@example.com', 'AB_POSITIVE'),
    ('Kabir Singh', 'MALE', '1993-07-11', 'kabir.singh@example.com', 'O_POSITIVE');

INSERT INTO doctor (name, specialization, email)
VALUES
    ('Dr. Rakesh Mehta', 'Cardiology', 'rakesh.mehta@example.com'),
    ('Dr. Sneha Kapoor', 'Dermatology', 'sneha.kapoor@example.com'),
    ('Dr. Arjun Nair', 'Orthopedics', 'arjun.nair@example.com');

INSERT INTO appointment (appointment_time, reason, doctor_id, patient_id)
VALUES
    ('2025-12-10 10:30:00', 'General Checkup', 1, 2),
    ('2025-12-10 11:50:00', 'Skin Rash', 2, 2),
    ('2025-12-23 09:45:00', 'Brain pain', 3, 3),
    ('2026-01-03 16:30:00', 'Follow-up visit', 1, 1),
    ('2025-12-10 10:30:00', 'Consultation', 1, 4),
    ('2025-12-16 14:30:00', 'Allergy Treatment', 2, 5);
