\echo 'Список роботов'
SELECT *
  FROM jaegers;
	
\echo 'Список не уничтоженных роботов'
SELECT *
  FROM jaegers
 WHERE status <> 'destroyed';
	
\echo 'Список роботов серий "Mark-1" и "Mark-4"'
SELECT *
  FROM jaegers
 WHERE mark IN ('Mark-1', 'Mark-4');
	
\echo 'Список роботов, исключая серии "Mark-1" и "Mark-4"'
SELECT *
  FROM jaegers
 WHERE mark NOT IN ('Mark-1', 'Mark-4');
	
\echo 'Список роботов, отсортированный по убыванию серии'
SELECT *
  FROM jaegers
 ORDER BY mark DESC;
	
\echo 'Самый старый робот'
SELECT *
  FROM jaegers
 ORDER BY launch
 LIMIT 1;

\echo 'Роботы, которые уничтожили больше всех kaiju'
SELECT *
  FROM jaegers
 WHERE kaijukill IN (SELECT MAX(kaijukill) FROM jaegers);

\echo 'Средний вес роботов'
SELECT AVG(weight)
  FROM jaegers;

\echo 'Количество уничтоженных kaiju у роботов, которые'
\echo 'до сих пор не разрушены, увеличено на единицу'
UPDATE jaegers
   SET kaijukill = kaijukill + 1
 WHERE status = 'active';

\echo 'Удаление уничтоженных роботов'
DELETE
  FROM jaegers
 WHERE status = 'destroyed';