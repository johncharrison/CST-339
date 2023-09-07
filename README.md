# CST-339 Project
---

**Group members**: Bruce Brown, Calvin Clocuh, John Harrison

### Development:

1. Download & Install [Docker Desktop](https://www.docker.com/products/docker-desktop/):

2. Create .env in root of project (where the `docker-compose.yml` file is):
    ```
    MYSQL_USERNAME=root
    MYSQL_ROOT_PASSWORD=root
    MYSQL_PASSWORD=password
    MYSQL_PORT=3306
    MYSQL_HOST=db
    MYSQL_DB=nile
    APP_PORT=8000
    ```

3. Run `build.sh`
    ```bash
    $ ./build.sh
    ```
    *This builds the .jar for the project so it can be used in Docker.*

4. Start Docker and run the following:
    ```bash
    $ docker compose up --build
    ```
    *Builds the docker container images and runs them*
