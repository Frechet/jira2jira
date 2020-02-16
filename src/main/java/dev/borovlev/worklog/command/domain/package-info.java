/**
 * Domain - слой, отвечающий за бизнес логику приложения.
 * Не зависит от application и infrastructure слоя.
 * Не зависит от используемых технологий и фреймворков.
 * И как следствие устойчив к изменениям в application и infrastructure слое.
 * Может содержать интерфейсы (порты) к infrastructure слою,
 * но следует стремиться к минимизации использования таких портов (исключение репозитории для доменных сущностей).
 */
package dev.borovlev.worklog.command.domain;
