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
   ```

3. Run `build.sh`

   **Note**: You have to run this script everytime you update the code.

   ```bash
   $ ./build.sh
   ```

   _This builds the .jar for the project then runs `docker compose up --build`_

### Development w/o Docker:

1. Modify the `application.properties` file to the values specific for your local development. I'll look into profiles so we can easily switch between multiple `.properties` files.

2. Load `database/entrypoint.sql` in your DB.

3. Run as normal.
