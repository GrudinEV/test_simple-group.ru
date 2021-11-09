DROP TABLE IF EXISTS well_parameter;

DROP TABLE IF EXISTS well;

DROP TABLE IF EXISTS department;

CREATE TABLE department (
	department_id   INT			  NOT NULL AUTO_INCREMENT,
	department_name VARCHAR(30)   NOT NULL,
	coord_x 		DECIMAL(8, 2) NOT NULL,
	coord_y 		DECIMAL(8, 2) NOT NULL,
	radius 		    DECIMAL(8, 2) NOT NULL,
	PRIMARY KEY (department_id)
);

CREATE TABLE well (
    well_id	 	 INT 			AUTO_INCREMENT,
    well_name	 VARCHAR(20)    NOT NULL,
    coord_x		 DECIMAL(8, 2),
    coord_y 	 DECIMAL(8, 2),
    department_id INT,
    PRIMARY KEY (well_id),
    FOREIGN KEY (department_id) REFERENCES department (department_id) ON DELETE SET NULL
);

CREATE TABLE well_parameter (
    well_parameter_id  INT 			AUTO_INCREMENT,
    well_id 		  INT			NOT NULL,
    parameter_name    VARCHAR(50),
    parameter_value   DECIMAL(8, 2),
    PRIMARY KEY (well_parameter_id),
    FOREIGN KEY (well_id) REFERENCES well (well_id) ON DELETE CASCADE
);