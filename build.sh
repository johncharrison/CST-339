export $(cat .env | xargs) && cd cst339 && ./mvnw clean package && docker compose up --build
