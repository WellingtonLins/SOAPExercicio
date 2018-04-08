docker stop app-reserva-soap
docker kill app-reserva-soap
docker rm app-reserva-soap
docker rmi -f reserva-img

docker stop reserva-db-soap
docker kill reserva-db-soap
docker rm reserva-db-soap
docker rmi -f  reserva-db-img

mvn clean package