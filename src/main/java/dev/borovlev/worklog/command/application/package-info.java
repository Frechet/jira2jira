/**
 * Application - слой, отвечающий за выполнение и обеспечение бизнес-сценариев приложения.
 * Под выполнением бизнес-сценариев понимается восстановление
 * и вызов методов доменных сущностей в определенной последовательности.
 * Под обеспечением бизнес-сценария понимается вызов определенных инфраструктурных интерфейсов (портов),
 * производящих логирование, включающих транзакционность, синхронизирующих конкурентный доступ и д.р.
 * Слой не зависит от infrastructure слоя.
 * Не зависит от используемых технологий и фреймворков.
 * И как следствие устойчив к изменениям в infrastructure слое.
 * На уровне application слоя следует стремиться к минимизации различной логики
 * ветвления при организации пользовательского сценария, чтобы не выносить бизнес-логику из доменного слоя.
 */
package dev.borovlev.worklog.command.application;
