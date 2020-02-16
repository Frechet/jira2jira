# jira2jira project

Из-за маразма работы IT подрядчиков, есть необходимость логировать рабочие часы в jira клиента и в jira подрядчика.
С целью избавиться от обезьяньего труда, создана эта простая программа, позволяющая перенести залогированные часы из
одной jira в другую с созданием в конечной jira иерархии задач исходной.
Тем самым счастливый разработчик может работать только в одной системе.

А также заодно опробованы следующие инструменты:

1. Quarkus, Supersonic Subatomic Java Framework
1. Domain Driven Design

## Supersonic Subatomic Java Framework

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```
./mvnw quarkus:dev
```

## Packaging and running the application

The application is packageable using `./mvnw package`.
It produces the executable `jira2jira-1.0.0-SNAPSHOT-runner.jar` file in `/target` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/lib` directory.

The application is now runnable using `java -jar target/jira2jira-1.0.0-SNAPSHOT-runner.jar`.

## Creating a native executable

You can create a native executable using: `./mvnw package -Pnative`.

Or you can use Docker to build the native executable using: `./mvnw package -Pnative -Dquarkus.native.container-build=true`.

You can then execute your binary: `./target/jira2jira-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/building-native-image-guide .
