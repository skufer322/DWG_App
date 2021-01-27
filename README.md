# DWG App

## Setup MySQL
1. Open GitBash
    1. Create container: ``docker run --rm -d -p 3306:3306 --name dwg-mysql --network=bridge -e MYSQL_ROOT_PASSWORD=root -d mysql:latest``

2. Open MySQL Workbench
    1. Database -> Connect to Database
    2. Set
        1. Hostname = ``127.0.0.1``
        2. Port = ``3306`` 
        3. User = ``root``
    3. Enter Password when prompted: ``root``
    4. Create the database:
        1. ``create database dwg;``
        2. ``create user 'dwgadmin'@'%' identified by 'dwgadmin';``
        3. ``grant all on dwg.* to 'dwgadmin'@'%';``    
        
## Setup MongoDb
1. Open GitBash
    1. Create container: ``docker run --rm -d -p 27017-27019:27017-27019 --name mongodb mongo:latest``
    2. Connect to container: ``winpty docker exec -it mongodb ./bin/bash``
    3. Start MongoDb Server: ``mongod --version``
    4. Connect to MongoDb: ``mongo``
    5. Create admin user:
        1. ``use admin``
        2. ``db.createUser({ user: "dwgadmin" , pwd: "dwgadmin", roles: ["userAdminAnyDatabase", "dbAdminAnyDatabase", "readWriteAnyDatabase"]})``
    6. Create database 'dwg'': ``use dwg``
    7. Insert test value : ``db.test.insert({"testkey":"testvalue"})`` (such that 'dwg' shows when entering ``show dbs``)
    
