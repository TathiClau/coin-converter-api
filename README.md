
<h1 align="center">
    <a> 💰 Coin Converter API </a>
</h1>
<p align="center"> Api to convert values from one currency to another </p>

<h4 align="center"> 
	🚧  Building...  🚧
</h4>

## 🛠 Technologies

The following tools were used in the construction of the project:

- [SpringBoot](https://expo.io/)
- [Kotlin](https://nodejs.org/en/)
- [PostgreeSQL](https://pt-br.reactjs.org/)
- [Docker](https://docs.docker.com/)

## Key Concepts

- What is a transaction?
  Every time a client use de API for convert a coin, this action is saved in the database and we call it transaction.

## Features

- [x] Do a coin converter transaction
- [x] Get a transaction by id
- [x] Get all transactions
- [ ] Edit a transaction
- [ ] Delete a transaction

## SetUp

Before you start, you will need to have the following tools installed on your machine:
- [Git](https://git-scm.com)
- [Java-jdk-11](https://www.oracle.com/br/java/technologies/javase/jdk11-archive-downloads.html)
- [Maven](https://maven.apache.org/)
- [Docker](https://docs.docker.com/) 
- [IntelliJ](https://www.jetbrains.com/pt-br/idea/)  *If you are more familiar with another IDE feel free to use your choice. 

## 🎲 Running the API Locally

```bash
# Clone the repo
$ git clone <https://github.com/TathiClau/coin-converter-api>

# Open the project in your IDE and wait for it to download the dependencies

# Open your terminal in the project folder and run the command below
$ mvn -U clean install -Dmaven.test.skip=true

# Run docker compose
$ docker-compose up postgres-dev

# The server will start on port:8089 - access <http://localhost:8089>
```
