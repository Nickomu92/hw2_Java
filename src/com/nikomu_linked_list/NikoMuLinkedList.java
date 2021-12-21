package com.nikomu_linked_list;

import com.nikomu_enums.Color;

public class NikoMuLinkedList<T> {
    // Поле (свойство) для хранения размера "Связанного списка"
    private int size;
    // Поле (свойство) для хранения значения "Узла"
    private T value;
    // Поле (свойство) для хранения головного "Узла"
    private Node head;
    // Поле (свойство) для хранения промежуточного "Узла"
    private Node node;
    // Поле (свойство) для хранения хвостового "Узла"
    private Node tail;

    // Конструктор
    public NikoMuLinkedList() {
        this.value = null;
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    // Метод для получения размера "Связанного списка"
    public int size() {
        return this.size;
    }

    // Метод для добавления элемента в "Связанный список"
    public void add(T value) {
        // Если размер "Связанного списка" равен 0
        if (this.size == 0) {
            this.node = new Node(null, value, null);
            this.head = this.node;
            this.tail = this.node;
        }

        // Иначе
        else {
            this.node = this.tail;
            Node<T> newNode = new Node(this.node, value, null);
            this.node.setNext(newNode);
            this.tail = newNode;
        }

        this.size++;
    }

    // Метод для получения элемента из "Связанного списка" по индексу
    public T get(int index) {
        try {
            // Если указанный индекс больше размера массива, то генерируем соответствующее исключение
            if(index >= this.size) {
                String exceptionMsg = String.format("%s\n\t!!! Указанный индекс %s не может быть больше размера " +
                        "массива %s%s", Color.ANSI_RED.getCode(), index, this.size, Color.ANSI_RESET.getCode());
                throw new Exception(exceptionMsg);
            }

            // Если указанный индекс - отрицательное число, то генерируем соответствующее исключение
            if(index < 0) {
                String exceptionMsg = String.format("%s\n\t!!! Указанный индекс %s не может быть отрицательным%s",
                        Color.ANSI_RED.getCode(), index, Color.ANSI_RESET.getCode());
                throw new Exception(exceptionMsg);
            }
        }
        // В случае возникновения ошибки
        catch(Exception ex) {
            // Завершаем работу метода и в качестве результата возвращаем сообщение об ошибке
            return (T)ex.getMessage();
        }

        this.node = this.head;

        for (int i = 0; i < this.size; i++) {
            if(i != index) {
                this.node = this.node.getNext();
                continue;
            }
            break;
        }
        return (T)this.node.getValue();
    }

    // Метод для удаления элемента из "Связанного списка" по индексу
    public T delete(int index) {
        try {
            // Если указанный индекс больше размера массива, то генерируем соответствующее исключение
            if(index >= this.size) {
                String exceptionMsg = String.format("%s\n\t!!! Указанный индекс %s не может быть больше размера " +
                        "массива %s%s", Color.ANSI_RED.getCode(), index, this.size, Color.ANSI_RESET.getCode());
                throw new Exception(exceptionMsg);
            }

            // Если указанный индекс - отрицательное число, то генерируем соответствующее исключение
            if(index < 0) {
                String exceptionMsg = String.format("%s\n\t!!! Указанный индекс %s не может быть отрицательным%s",
                        Color.ANSI_RED.getCode(), index, Color.ANSI_RESET.getCode());
                throw new Exception(exceptionMsg);
            }
        }
        // В случае возникновения ошибки
        catch(Exception ex) {
            // Завершаем работу метода и в качестве результата возвращаем сообщение об ошибке
            return (T)ex.getMessage();
        }

        // Иначе возвращаем удаленный объект
        this.node = this.head;

        for (int i = 0; i < this.size; i++) {
            if(i != index) {
                this.node = this.node.getNext();
                continue;
            }
            break;
        }

        if(index == this.size) {
            this.node.getPrev().setNext(null);
            this.tail = this.node.getPrev();
        }

        else if(index == 0) {
            this.head = this.node.getNext();
            this.head.setPrev(null);
        }

        else {
            Node<T> tempNode = this.node.getNext();
            if(tempNode != null) {
                tempNode.setPrev(this.node.getPrev());
                tempNode = this.node.getPrev();
                tempNode.setNext(this.node.getNext());
            }
        }

        this.size--;
        return (T)this.node.getValue();
    }

    // Метод для вставки элемента в "Связанный список" на указанную позицию
    public T insert(T obj, int index) {
        try {
            // Если указанный индекс - отрицательное число, то генерируем соответствующее исключение
            if(index < 0) {
                String exceptionMsg = String.format("%s\n\t!!! Указанный индекс %s не может быть отрицательным%s",
                        Color.ANSI_RED.getCode(), index, Color.ANSI_RESET.getCode());
                throw new Exception(exceptionMsg);
            }
        }
        // В случае возникновения ошибки
        catch(Exception ex) {
            // Завершаем работу метода и в качестве результата возвращаем сообщение об ошибке
            return (T)ex.getMessage();
        }

        if(index <= this.size) {
            this.node = this.head;

            if(index == 0) {
                Node<T> newNode = new Node<>(null, obj, this.node);
                this.node = newNode;
                this.head = newNode;
                this.tail = newNode;
            }

            else {
                for (int i = 0; i < this.size; i++) {
                    if(i != index) {
                        this.node = this.node.getNext();
                        continue;
                    }
                    break;
                }

                Node<T> tempNode = this.node.getPrev();

                Node<T> newNode = new Node<>(tempNode, obj, this.node);
                tempNode.setNext(newNode);

                this.node = tempNode.getNext();
            }
        }

        else {
                this.node = this.tail;
                Node<T> newNode = new Node(this.node, obj, null);
                this.node.setNext(newNode);
                this.tail = newNode;
        }

        this.size++;

        return (T)this.node.getValue();
    }

    @Override
    public String toString() {
        String tempStr = "";
        this.node = this.head;

        for (int i = 0; i < this.size; i++) {
            tempStr += this.node.getValue();
            node = node.getNext();

            if(i < this.size - 1) {
                tempStr += ", ";
            }
        }
        return String.format("%s[%s]%s", Color.ANSI_CYAN.getCode(), tempStr, Color.ANSI_RESET.getCode());
    }

    // Внутренний класс, представляющий обьект (сущность) "Узел"
    private class Node<T> {
        // Поле (свойство) значение "Узла"
        private T value;
        // Поле (свойство) представляющее предыдущий "Узел"
        private Node<T> next;
        // Поле (свойство) представляющее следюущий "Узел"
        private Node<T> prev;

        // Конструктор
        public Node(Node prev, T value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }

        // Метод для получения значения "Узла"
        public T getValue() {
            return this.value;
        }

        // Метод для устаноки значения "Узла"
        public void setValue(T value) {
            this.value = value;
        }

        // Метод для получения предыдущего "Узла"
        public Node<T> getPrev() {
            return this.prev;
        }

        // Метод для установки предыдущего "Узла"
        public void setPrev(Node<T> prev) {
            this.prev = prev;
        }

        // Метод для получения следующего "Узла"
        public Node<T> getNext() {
            return this.next;
        }

        // Метод для установки следующего "Узла"
        public void setNext(Node<T> next) {
            this.next = next;
        }

        // Переопределенный метод toString()
        @Override
        public String toString() {
            return value.toString();
        }
    }
}
