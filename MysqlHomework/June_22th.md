CREATE TABLE `post` (
  `workNum` int(11) DEFAULT NULL,
  `workPost` varchar(30) DEFAULT NULL,
  `salary` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `projcets` (
  `projectID` int(11) DEFAULT NULL,
  `projectName` varchar(30) DEFAULT NULL,
  `projectWorker` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `salary` (
  `worktime` int(11) DEFAULT NULL,
  `sumSalary` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `salaryrate` (
  `salary` int(11) DEFAULT NULL,
  `salaryRate` double(255,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `worker` (
  `workerID` int(11) DEFAULT NULL,
  `workerName` varchar(20) DEFAULT NULL,
  `workerGender` varchar(10) DEFAULT NULL,
  `workNum` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;