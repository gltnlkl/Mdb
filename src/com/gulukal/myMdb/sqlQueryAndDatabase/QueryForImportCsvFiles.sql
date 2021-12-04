COPY movies(movie_id,title,genres)
FROM './src/com.gulukal.myMdb.main/java/com/myMdb/com.gulukal.myMdb.sqlQueryAndDatabase/csv/movies.csv'
DELIMITER ','
CSV HEADER;

COPY ratings(user_id,movie_id,rating,timestamp)
FROM './src/com.gulukal.myMdb.main/java/com/myMdb/com.gulukal.myMdb.sqlQueryAndDatabase/csv/ratings.csv'
DELIMITER ','
CSV HEADER;


COPY tags(user_id,movie_id,tag,timestamp)
FROM './src/com.gulukal.myMdb.main/java/com/myMdb/com.gulukal.myMdb.sqlQueryAndDatabase/csv/tags.csv'
DELIMITER ','
CSV HEADER;