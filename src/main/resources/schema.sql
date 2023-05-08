
--
-- Table structure for table `employee`
--


DROP TABLE IF EXISTS application;

DROP TABLE IF EXISTS thesis;

DROP TABLE IF EXISTS subject;



DROP TABLE IF EXISTS professor;
DROP TABLE IF EXISTS student;

DROP TABLE IF EXISTS users;


CREATE TABLE users (
                         `id` int(11) NOT NULL AUTO_INCREMENT,
                         `user_name` varchar(45) DEFAULT NULL UNIQUE,
                         `password` text DEFAULT NULL,
                         `role` text DEFAULT NULL,
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


CREATE TABLE professor (
                            `p_id` int(11) NOT NULL AUTO_INCREMENT,
                            `first_name` varchar(45) DEFAULT NULL,
                            `last_name` varchar(45) DEFAULT NULL,
                            `email` varchar(45) DEFAULT NULL,
                            `id` int(11) NOT NULL,
                            PRIMARY KEY (`p_id`),
                            FOREIGN KEY (`id`) REFERENCES users(`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE student (
                         `student_id` int(11) NOT NULL AUTO_INCREMENT,
                         `first_name` varchar(45) DEFAULT NULL,
                         `last_name` varchar(45) DEFAULT NULL,
                         `email` varchar(45) DEFAULT NULL,
                         `remaining_courses` int(11) DEFAULT NULL,
                         `average_grade` float(11) DEFAULT NULL,
                         `id` int(11) NOT NULL,
                         PRIMARY KEY (`student_id`),
                         FOREIGN KEY (`id`) REFERENCES users(`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE subject (
                         `subject_id` int(11) NOT NULL AUTO_INCREMENT,
                         `title` varchar(45) DEFAULT NULL,
                         `description` varchar(128) DEFAULT NULL,
                         `p_id` int(11) NOT NULL,
                         PRIMARY KEY (`subject_id`),
                         FOREIGN KEY (`p_id`) REFERENCES professor(`p_id`) ON DELETE CASCADE

) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE thesis (
                            `t_id` int(11) NOT NULL AUTO_INCREMENT,
                            `title` varchar(45) DEFAULT NULL,
                            `description` varchar(128) DEFAULT NULL,
                            `p_id` int(11) NOT NULL,
                            `subject_id` int(11) NOT NULL,
                            `student_id` int(11) NOT NULL,
                            PRIMARY KEY (`t_id`),
                            FOREIGN KEY (`p_id`) REFERENCES professor(`p_id`) ON DELETE CASCADE,
                            FOREIGN KEY (`subject_id`) REFERENCES subject(`subject_id`) ON DELETE CASCADE,
                            FOREIGN KEY (`student_id`) REFERENCES student(`student_id`) ON DELETE CASCADE

) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;



CREATE TABLE application (
                             subject_id int(11) NOT NULL,
                             student_id int(11) NOT NULL,
                             PRIMARY KEY (subject_id, student_id),
                             FOREIGN KEY (subject_id) REFERENCES subject(subject_id) ON DELETE CASCADE,
                             FOREIGN KEY (student_id) REFERENCES student(student_id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;