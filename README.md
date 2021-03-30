# Slot Machine Application

Slot machine works as follows

```
1 - Receives a request to perform Spin action (default and currently supported). Request contains mandatory bet amount in EUR.
2 - User can also pass optional cheat params to generate specific outcomes. Format of the request is provided further down.
3 - System generates a random outcome (if no cheat is provoided) and created a visible reel of symbols (right now only 3 reels, 5 columns supported).
4 - System checks any win situations from the pre-defined list of betlines configured (right now hardcoded and pre-configured)
5 - System calculates total win amount and desired outcome and sends back to Client
```

![carrental](https://github.com/aviralshukla/slotmachine/blob/main/slotmachine.png)

## Getting Started

Please follow the instructions below to run this application in your local machine - 

### Prerequisites

```
JDK 11
Maven
Docker (optional)
```

### Installing

Install all dependencies and generate jar file
```
mvn clean package
```

And run the application
```
java -jar target/slot-machine-1.0.0.jar
```

### Alternate - PreBuilt Jar

download slot-machine-1.0.0.jar in local system and run below command

```
java -jar target/slot-machine-1.0.0.jar
```

### Docker - Run application as container

To run application as docker container (provided Docker is already setup in your machine), run below command at root of application - 

```
docker build -t slotmachine:1.0.0 .

docker run -dit --name slot-machine -p 8080:8080  slotmachine:1.0.0
```

### Accessing

You can access the running application using this URL - [Swagger](http://localhost:8080/swagger)

```
1. Click on API and press button "Try it out"
2. Enter request body like this (cheat codes are optional and can be omitted) - {
                                    "betAmount": 1,
                                    "cheatCodes": {
                                      "0": "A",
                                      "3": "A",
                                      "6": "A"
                                    }
                                  }
3. Response should look like this - {
                                      "board": "A,A,A,J,mon,A,10,cat,dog,10,K,mon,Q,9,dog",
                                      "betAmount": 1,
                                      "totalWin": 0.2,
                                      "paylines": [
                                        {
                                          "betline": "BetLine(id=1, betLinePositions=[0, 3, 6, 9, 12])",
                                          "matchedSymbols": 3,
                                          "paylineWin": 0.2
                                        },
                                        {
                                          "betline": "BetLine(id=2, betLinePositions=[1, 4, 7, 10, 13])",
                                          "matchedSymbols": 1,
                                          "paylineWin": 0
                                        },
                                        {
                                          "betline": "BetLine(id=3, betLinePositions=[2, 5, 8, 11, 14])",
                                          "matchedSymbols": 1,
                                          "paylineWin": 0
                                        },
                                        {
                                          "betline": "BetLine(id=4, betLinePositions=[0, 4, 8, 10, 12])",
                                          "matchedSymbols": 1,
                                          "paylineWin": 0
                                        },
                                        {
                                          "betline": "BetLine(id=5, betLinePositions=[2, 4, 6, 10, 14])",
                                          "matchedSymbols": 1,
                                          "paylineWin": 0
                                        }
                                      ]
                                    }
```

## Alternatively to use command prompt

Please run below command after running the server - 

```
curl -X POST "http://localhost:8080/api/v1/slots" -H "accept: */*" -H "Content-Type: application/json" -d "{\"betAmount\":1,\"cheatCodes\":{\"0\":\"A\",\"3\":\"A\",\"6\":\"A\"}}"
```


## Running the tests

Tests are omitted for sake of brevity

```
mvn clean verify
```

## Coding style

We use the google code style for this project with some changes.
