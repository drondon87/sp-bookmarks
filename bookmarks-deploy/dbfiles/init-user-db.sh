#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL
    CREATE USER bookmarkapp WITH PASSWORD 'qwerty';
    ALTER USER bookmarkapp WITH SUPERUSER;
    CREATE DATABASE bookmarkapp_db;
    GRANT ALL PRIVILEGES ON DATABASE bookmarkapp_db TO bookmarkapp;
EOSQL