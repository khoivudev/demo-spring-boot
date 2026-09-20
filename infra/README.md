# Infra

docker compose up -d --build --force-recreate
docker compose logs -f

# Access to Database

docker exec -it my-db-container psql -U user -d employee_directory
psql -h localhost -p 5432 -U user -d employee_directory
