BEGIN;


CREATE TABLE IF NOT EXISTS public.movies
(
    movie_id integer NOT NULL,
    title character varying,
    genres character varying,
    PRIMARY KEY (movie_id)
);

CREATE TABLE IF NOT EXISTS public.ratings
(
    user_id integer,
    movie_id integer,
    rating double precision,
    "timestamp" integer
);

CREATE TABLE IF NOT EXISTS public.tags
(
    user_id integer,
    movie_id integer,
    tag character varying,
    "timestamp" integer
);

ALTER TABLE public.tags
    ADD FOREIGN KEY (movie_id)
    REFERENCES public.movies (movie_id)
    NOT VALID;


ALTER TABLE public.ratings
    ADD FOREIGN KEY (movie_id)
    REFERENCES public.movies (movie_id)
    NOT VALID;

END;