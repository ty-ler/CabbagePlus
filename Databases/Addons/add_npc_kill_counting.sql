DROP TABLE IF EXISTS `openrsc_npckills`;
CREATE TABLE IF NOT EXISTS `openrsc_npckills`
(
    `ID`        int(10) NOT NULL AUTO_INCREMENT,
    `npcID`     int(10) DEFAULT NULL,
    `playerID`  int(10) DEFAULT NULL,
    `killCount` int(10) DEFAULT 0,
    PRIMARY KEY (`ID`)
) ENGINE = InnoDB
  DEFAULT CHARSET = latin1;