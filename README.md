# CST-339 Project
---

**Group members**: Bruce Brown, Calvin Clocuh, John Harrison

### Development w/docker:

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

    **Note**: You have to run this script everytime you update the code.

    ```bash
    $ ./build.sh
    ```
    *This builds the .jar for the project so it can be used in Docker.*

4. Start Docker and run the following:
    ```bash
    $ docker compose up --build
    ```
    *Builds the docker container images and runs them*

### Development w/o Docker:
1. Modify the `application.properties` file to the values specific for your local development. I'll look into profiles so we can easily switch between multiple `.properties` files.

2. Load `database/entrypoint.sql` in your DB.

3. Run as normal.