docker build -t reserva-db-img ./postgres
docker run -p 5433:5432 -d --name reserva-db-soap reserva-db-img

mvn clean package
docker build -t reserva-img .
docker run -p 8080:8080 -d --name app-reserva-soap --link reserva-db-soap:banco reserva-img
