FROM mysql:8.0.30

ARG MYSQL_DATABASE
ARG MYSQL_ROOT_PASSWORD
ARG MYSQL_PORT

ENV MYSQL_DATABASE=$MYSQL_DATABASE
ENV MYSQL_ROOT_PASSWORD=$MYSQL_ROOT_PASSWORD
ENV MYSQL_PORT=$MYSQL_PORT

# Copy any custom SQL scripts to initialize the database
# These scripts will run when the container starts
COPY ./init.sql /docker-entrypoint-initdb.d/

EXPOSE 3306