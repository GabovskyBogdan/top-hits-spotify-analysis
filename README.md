# top-hits-spotify-analysis
Application to get and process some statistics on most popular songs in Spotify of the last two deacades (1999-2019).


## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)
## General info

The main task was to creat SpringBoot Application that takes data from songs_normalize.csv (https://www.kaggle.com/datasets/paradisejoy/top-hits-spotify-from-20002019) and makes some statistics analysis, requested by HTTP.

### There is two GET methods:

#### First takes "colname": 
*put your value for "colname" without bracers*
```
curl --location --request GET 'http://localhost:8080/?colname="colname"'
```
*"colname"* can be one of the next:
- duration_ms
- year
- popularity
- danceability
- energy
- key

and returns JSON array of ten deciles (https://en.wikipedia.org/wiki/Decile) for provided "colname".

#### Second takes "colname" and "year" parameters: 
*put your value for "colname" and "year" without bracers*
```
curl --location --request GET 'http://localhost:8080/?colname="colname"$year="year"'
```
and returns same array but for exact year.

## Technologies
Project is created with:
- Java SE11
- SpringBoot
- Gradle
- Spring Web

## Setup
To run application
```
$ cd ../top-hits-spotify-analysis
$ gradle build bootJar
$ cd ../top-hits-spotify-analysis/build/libs
$ java -jar top-hits-spotify-analysis-0.0.1-SNAPSHOT.jar
```

To shutdown
```
curl --location --request POST 'http://localhost:8080/actuator/shutdown' --data-raw ''
```
