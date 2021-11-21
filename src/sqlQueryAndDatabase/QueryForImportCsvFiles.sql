COPY movies(movie_id,title,genres)
FROM './src/main/java/com/myMdb/sqlQueryAndDatabase/csv/movies.csv'
DELIMITER ','
CSV HEADER;

COPY ratings(user_id,movie_id,rating,timestamp)
FROM './src/main/java/com/myMdb/sqlQueryAndDatabase/csv/ratings.csv'
DELIMITER ','
CSV HEADER;


COPY tags(user_id,movie_id,tag,timestamp)
FROM './src/main/java/com/myMdb/sqlQueryAndDatabase/csv/tags.csv'
DELIMITER ','
CSV HEADER;