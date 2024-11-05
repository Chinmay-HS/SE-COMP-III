-- SELECT DISTINCT Series
-- FROM CO2_Emissions

-- SELECT MIN(Year_New), MAX(Year_New)
-- FROM CO2_Emissions

-- SELECT MIN(Value_New), MAX(Value_New)
-- FROM CO2_Emissions
-- WHERE Series = 'Emissions (thousand metric tons of carbon dioxide)'

-- SELECT MIN(Value_New), MAX(Value_New)
-- FROM CO2_Emissions
-- WHERE Series = 'Emissions per capita (metric tons of carbon dioxide)'

-- CREATE TABLE Emissions
-- (Country nvarchar(50),
-- Year int, 
-- Series nvarchar(100), 
-- Value float)

-- INSERT INTO Emissions
-- SELECT * FROM CO2_Emissions
-- WHERE Series = 'Emissions (thousand metric tons of carbon dioxide)'

-- Select * from Emissions;

-- CREATE TABLE perCapital
-- (Country nvarchar(50),
-- Year int, 
-- Series nvarchar(100), 
-- Value float)

-- INSERT INTO perCapital
-- SELECT * FROM CO2_Emissions
-- WHERE Series = 'Emissions per capita (metric tons of carbon dioxide)'

-- SELECT * 
-- FROM perCapital

-- SELECT DISTINCT Country 
-- FROM perCapital
-- WHERE COUNTRY LIKE 'I%'

-- SELECT MIN(Value) as min_value, MAX(VALUE) as max_value
-- FROM perCapital 
-- WHERE Country = 'India' 

SELECT Year 
FROM perCapital
WHERE Country = 'India' 
AND (Value BETWEEN 0.349 AND 0.351 OR Value BETWEEN 1.613 AND 1.615);

-- ;WITH value1975 AS
-- ( SELECT Country, Value as old_value
-- FROM perCapital
-- WHERE Year = 1975),
-- value2017 AS
-- (SELECT Country, Value as new_value
-- FROM perCapital
-- WHERE Year = 2017)

-- SELECT 
--     v1975.Country, 
--     v1975.old_value, 
--     v2017.new_value
-- FROM 
--     (SELECT Country, Value AS old_value FROM perCapital WHERE Year = 1975) v1975
-- JOIN 
--     (SELECT Country, Value AS new_value FROM perCapital WHERE Year = 2017) v2017
-- ON 
--     v1975.Country = v2017.Country;

SELECT Country, SUM(Value) AS sum_value
FROM emissions
GROUP BY Country
ORDER BY sum_value DESC
LIMIT 5;

