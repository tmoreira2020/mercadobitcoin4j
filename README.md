MercadoBitcoin4j
==========
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/br.com.thiagomoreira.mercadobitcoin/mercadobitcoin4j/badge.svg)](https://maven-badges.herokuapp.com/maven-central/br.com.thiagomoreira.mercadobitcoin/mercadobitcoin4j)

MercadoBitcoin4j is a Java/REST client to access the Mercado Bitcoin API available at [Mercado Bitcoin's Developer Documentation](https://www.mercadobitcoin.com.br/api-doc). It was developed based on [Retrofit2](http://square.github.io/retrofit/).

### License

MercadoBitcoin4j is licensed under [Apache 2](http://www.apache.org/licenses/LICENSE-2.0) license.

### Getting Started

It's really simple to use the client, just create a object of `br.com.thiagomoreira.mercadobitcoin.MercadoBitcoin` class and  start to invoke its methods. That's it!


```java
import br.com.thiagomoreira.mercadobitcoin.MercadoBitcoin;
import br.com.thiagomoreira.mercadobitcoin.model.Ticker;

public static void main(String[] args) {
    MercadoBitcoin mercadobitcoin = new MercadoBitcoin();

    Ticker ticker = mercadobitcoin.getTicker();

    System.out.println(ticker.getHigh());
    System.out.println(ticker.getLow());
}
```

### Which methods are implemented?

Yep, it is a small list. Can you help me? Look here: [Contributing](#contributing).
* getTicker()
* getOrderbook()

### Maven/Gradle

MercadoBitcoin4j is available on Maven central, the artifact is as follows:

Maven:

```xml
<dependency>
    <groupId>br.com.thiagomoreira.mercadobitcoin</groupId>
    <artifactId>mercadobitcoin4j</artifactId>
    <version>1.0.0</version>
</dependency>
```
Gradle:

```groovy
dependencies {
    compile(group: "br.com.thiagomoreira.mercadobitcoin", name: "mercadobitcoin4j", version: "1.0.0");
}
```
### Support
MercadoBitcoin4j tracks [bugs and feature requests](https://github.com/tmoreira2020/mercadobitcoin4j/issues) with Github's issue system. Feel free to open your [new ticket](https://github.com/tmoreira2020/mercadobitcoin4j/issues/new)!

### Contributing

MercadoBitcoin4j is a project based on Maven to improve it you just need to fork the repository, clone it and from the command line invoke

```shell
mvn package
```
After complete your work you can send a pull request to incorporate the modifications.

Enjoy!