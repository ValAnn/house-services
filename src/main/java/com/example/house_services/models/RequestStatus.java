package com.example.house_services.models;

public enum RequestStatus {
    /**
     * Заявка только создана, но ещё не принята в работу
     */
    CREATED("Создана"),

    /**
     * Заявка принята в работу (ожидает исполнителя)
     */
    ACCEPTED("Принята"),

    /**
     * Заявка назначена конкретному исполнителю
     */
    ASSIGNED("Назначена"),

    /**
     * Исполнитель приступил к работе по заявке
     */
    IN_PROGRESS("В работе"),

    /**
     * Требуется дополнительная информация от заявителя
     */
    NEED_INFO("Требуются уточнения"),

    /**
     * Заявка приостановлена (например, нет материалов)
     */
    SUSPENDED("Приостановлена"),

    /**
     * Работы по заявке завершены
     */
    COMPLETED("Завершена"),

    /**
     * Заявка отклонена (с указанием причины)
     */
    REJECTED("Отклонена"),

    /**
     * Заявка отменена самим заявителем
     */
    CANCELLED("Отменена");

    private final String displayName;

    RequestStatus(String displayName) {
        this.displayName = displayName;
    }

    /**
     * @return Человеко-читаемое название статуса
     */
    public String getDisplayName() {
        return displayName;
    }
}