package com.nikomu_enums;

// Перечисления (enum) для хранения кода цветов для текста в консоле
public enum Color {
    ANSI_RESET("\u001B[0m"),
    ANSI_BLACK("\u001B[30m"),
    ANSI_RED("\u001B[31m"),
    ANSI_GREEN("\u001B[32m"),
    ANSI_YELLOW("\u001B[33m"),
    ANSI_BLUE("\u001B[34m"),
    ANSI_PURPLE("\u001B[35m"),
    ANSI_CYAN("\u001B[36m"),
    ANSI_WHITE("\u001B[37m");

    // Поле для хранения кода цвета
    private String code;

    // Конструктор
    Color(String code) {
        this.code = code;
    }

    // Метод для получения кода цвета
    public String getCode() {
        return code;
    }
}
