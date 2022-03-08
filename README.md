
<h1 align="center">
    <a> 💰 Coin Converter API </a>
</h1>
<p align="center"> Api to convert values from one currency to another </p>

<h4 align="center"> 
	Motivation: To test my knowledge and learn new skills
</h4>

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

- Access Key: To create a transaction you will need an access key generated through your free plan at http://api.exchangeratesapi.io. You also need to generate a random UUID to be your UserId. So, your body will look like this:

```
{
"accessKey": "<YOUR ACCESS>",
"userId": "c250010f-ddc5-4cec-abdd-f69d932b8b75",
"initialCoin": "EUR",
"initialValue": "10",
"finalCoin": "BRL"
}
```


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
$ git clone https://github.com/TathiClau/coin-converter-api

# Open the project in your IDE and wait for it to download the dependencies

# Open your terminal in the project folder and run the command below
$ mvn -U clean install -Dmaven.test.skip=true

# Run docker compose
$ docker-compose up postgres-dev

# Run the the application on the run button 
$ java -Dserver.port=8089 $JAVA_OPTS -jar target/CoinConverter-1.0.1-SNAPSHOT.jar

# The server will start on port:8089 - access <http://localhost:8089>
```

### Collection on postman
https://www.getpostman.com/collections/83a9e7d253b6761f2f19

The API is also available on Heroku, through the link:
https://coin-converter-api.herokuapp.com/coinconverter
