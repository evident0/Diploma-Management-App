
--
-- Table structure for table `employee`
--


DROP TABLE IF EXISTS thesis;
DROP TABLE IF EXISTS professor;





CREATE TABLE professor (
                            `p_id` int(11) NOT NULL AUTO_INCREMENT,
                            `first_name` varchar(45) DEFAULT NULL,
                            `last_name` varchar(45) DEFAULT NULL,
                            `email` varchar(45) DEFAULT NULL,
                            PRIMARY KEY (`p_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;



CREATE TABLE thesis (
                            `t_id` int(11) NOT NULL AUTO_INCREMENT,
                            `title` varchar(45) DEFAULT NULL,
                            `description` varchar(128) DEFAULT NULL,
                            `p_id` int(11) NOT NULL,
                            PRIMARY KEY (`t_id`),
                            FOREIGN KEY (`p_id`) REFERENCES professor(`p_id`) ON DELETE CASCADE

) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

