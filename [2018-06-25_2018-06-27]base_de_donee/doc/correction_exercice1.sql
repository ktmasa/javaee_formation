SELECT * FROM `intervention`


SELECT `codeMateriel`,`datePlanification` FROM `intervention`


/* la clause WHERE peut porter sur des colonnes n étant pas renvoyées au final*/
SELECT `codeMateriel`,`datePlanification` FROM `intervention` WHERE `dateRealisation` IS NULL



SELECT * FROM `intervention` WHERE `nomIntervenant` = 'vincent' ORDER BY `datePlanification`
SELECT * FROM `intervention` WHERE `nomIntervenant` IN ('dracos', 'vincent') ORDER BY `datePlanification`
SELECT * FROM `intervention`
	WHERE `nomIntervenant` = 'vincent'
	OR	`nomIntervenant` = 'dracos'
	ORDER BY `datePlanification`

	
SELECT * FROM `intervention`
	WHERE `datePlanification` > '2018-05-15 00:00:00'
	ORDER BY `codeMateriel`, `datePlanification`

	
SELECT * FROM `intervention`
	WHERE `datePlanification` > '2018-05-15 00:00:00'
    AND `duree` >= 60
	ORDER BY `codeMateriel`, `datePlanification`


SELECT * FROM `intervention`
	WHERE `description` like '%changement%'	