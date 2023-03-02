package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    /**
     * Добавление новой заявки.
     */
    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    /**
     * Поиск индекса заявки по её id.
     */
    private int indexOf(int id) {
        int rsl = -1;
        for (int i = 0; i < size; i++) {
            if (items[i].getId() == id) {
                rsl = i;
                break;
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    /**
     * Изменение заявки.
     *
     * @param id   Id заявки, которую необходимо заменить
     * @param item Новая заявка
     * @return true, если заменили, иначе false
     */
    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean result = index != -1;
        if (result) {
            item.setId(id);
            items[index] = item;
        }
        return result;
    }

    /**
     * Удаление заявки.
     *
     * @param id Id заявки, которую необходимо удалить
     * @return true, если удалили, иначе false
     */
    public boolean delete(int id) {
        int index = indexOf(id);
        boolean result = index != -1;
        if (result) {
            System.arraycopy(items, index + 1, items, index, size - index - 1);
            items[size - 1] = null;
            size--;
        }
        return result;
    }

    /**
     * Получение списка всех заявок.
     */
    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    /**
     * Получение списка по имени.
     */
    public Item[] findByName(String key) {
        Item[] rsl = new Item[size];
        int counter = 0;
        for (int i = 0; i < size; i++) {
            Item item = items[i];
            if (item.getName().equals(key)) {
                rsl[counter++] = item;
            }
        }
        return Arrays.copyOf(rsl, counter);
    }
}
