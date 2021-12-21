package com.nikomu_array_list;

import com.nikomu_enums.Color;

// Для оптимизации работы c NikoMuArrayList я считаю, что оптимальным вариантом работы будет не каждый
// раз при добавлении или встаке элементов пересоздавать массив, а сначала создать массив, например,
// на 10 элементов и по мере его заполнения (переполнения) увеличивать его размер на определенный шаг.
// Для этих целей в классе предусмотрено два конструктора

public class NikoMuArrayList<T> {
    // Массив
    private Object[] array;
    // Поле для хранения индекса заполнения массива
    private int index;
    // Поле для хранения размера массива
    private int size;
    // Константа для хранения шага на который увеличивается массив при его переполнении
    private int stepSize;

    // Конструктор, для создания нового массива размером 10
    public NikoMuArrayList() {
        this.size = 10;
        this.stepSize = 5;
        array = new Object[this.size];
    }

    // Конструктор, для создания нового массива размером size
    public NikoMuArrayList(int size, int step) {
        array = new Object[size];
        this.stepSize = (step > 0) ? step : 5;
    }

    // Метод для добавления элемента в массив-список
    public void add(Object obj) {
        // Пока индекс добавляемого элемента не достигнет размера массива - 1, не выполняем
        // увеличение массива на указанный шаг
        if(index == size - 1) {
            Object[] tempArray = new Object[size()];

            for(int i = 0; i < size(); i++) {
                tempArray[i] = array[i];
            }

            // Создаем массив с увеличенным размером на шаг stepSize
            array = new Object[size + this.stepSize];

            for(int i = 0; i < tempArray.length; i++) {
                array[i] = tempArray[i];
            }
        }

        array[this.index++] = obj;
    }

    // Метод для удаления из массива-списка
    public T delete(int item) {
        try {
            // Если указанный индекс больше размера массива, то генерируем соответствующее исключение
            if(item >= size()) {
                throw new Exception(String.format("%s\nОшибка! Указанный индекс %s не может быть больше размера " +
                        "массива %s%s", Color.ANSI_RED.getCode(), item, size(), Color.ANSI_RESET.getCode()));
            }

            // Если указанный индекс - отрицательное число, то генерируем соответствующее исключение
            if(item < 0) {
                throw new Exception(String.format("%s\nОшибка! Указанный индекс %s не может быть отрицательным%s",
                        Color.ANSI_RED.getCode(), item, Color.ANSI_RESET.getCode()));
            }

            Object[] tempArray = new Object[size()];

            for(int i = 0; i < size(); i++) {
                tempArray[i] = array[i];
            }

            for(int i = 0, j = 0; i < size(); i++) {
                if(i == item) continue;
                array[j++] = tempArray[i];
            }

            this.index--;
            return (T)tempArray[item];
        }
        // В случае возникновения ошибки
        catch(Exception ex) {
            // Выводим сообщение об ошибке
            return (T)ex.getMessage();
        }
    }

    // Метод для получения обьекта по индексу
    public T get(int item) {
        try {
            // Если указанный индекс больше размера массива, то генерируем соответствующее исключение
            if(item >= array.length)
                throw new Exception(String.format("%s\nОшибка! Указанный индекс %s не может быть больше размера " +
                        "массива %s%s", Color.ANSI_RED.getCode(), item, size(), Color.ANSI_RESET.getCode()));

            // Если указанный индекс - отрицательное число, то генерируем соответствующее исключение
            if(item < 0)
                throw new Exception(String.format("%s\nОшибка! Указанный индекс %s не может быть отрицательным%s",
                        Color.ANSI_RED.getCode(), item, Color.ANSI_RESET.getCode()));
        }
        // В случае возникновения ошибки
        catch(Exception ex) {
            // Возвращаем сообщение об ошибке
            return (T)ex.getMessage();
        }

        return (T)array[item];
    }

    // Метод для добавления элемента в список
    public T insert(Object obj, int item) {
        try {
            // Если указанный индекс - отрицательное число, то генерируем соответствующее исключение
            if(item < 0)
                throw new Exception(String.format("%s\nОшибка! Указанный индекс %s не может быть отрицательным%s",
                        Color.ANSI_RED.getCode(), item, Color.ANSI_RESET.getCode()));

            if(this.index == size - 1) {
                Object[] tempArray = new Object[array.length];

                // Можно заменить на System.arraycopy(array, 0, tempArray, 0, array.length),
                // но мы используем обычный for
                for(int i = 0; i < size; i++) {
                    tempArray[i] = array[i];
                }

                // Создаем массив с увеличенным размером на шаг stepSize
                array = new Object[size + this.stepSize];

                // Можно заменить на System.arraycopy(tempArray, 0, array, 0, tempArray.length),
                // но мы используем обычный for
                for(int i = 0; i < tempArray.length; i++) {
                    array[i] = tempArray[i];
                }
            }

            if(item > size() - 1) {
                item = size();
                array[size()] = obj;
            }

            else {
                Object[] tempArray = new Object[size() + 1];

                for(int i = 0; i < size(); i++) {
                    tempArray[i] = array[i];
                }

                for(int i = 0, j = 0; i < tempArray.length; i++) {
                    if(i == item) continue;
                    array[i] = tempArray[j++];
                }

                array[item] = obj;
            }

            this.index++;
            return (T)array[item];
        }
        // В случае возникновения ошибки
        catch(Exception ex) {
            // Выводим сообщение об ошибке
            return (T)ex.getMessage();
        }
    }

    // Метод для получения размера массива
    public int size() {
        return this.index;
    }

    // Метод для получения индекса элемента массива
    public int indexOf(Object obj) {
        for (int i = 0; i < size(); i++) {
            if (get(i).toString().contains(obj.toString())) {
                return i;
            }
        }
        return -1;
    }

    // Переопределенный метод toString() для вывода содержимого нашего списка
    @Override
    public String toString() {
        String tempStr = "";

        for (int i = 0; i < size(); i++) {
            tempStr += array[i];

            if(i != size() - 1) {
                tempStr += ", ";
            }
        }

        return String.format("%s[%s]%s", Color.ANSI_CYAN.getCode(), tempStr, Color.ANSI_RESET.getCode());
    }
}

