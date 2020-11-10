package ru.job4j.singleton;

import ru.job4j.tracker.Tracker;

/**
 * Ленивая загрузка (Lazy loading) происходит, когда мы явно обращаемся к объекту.
 * Происходит его загрузка.
 * <p>
 * Для того чтобы закрыть возможность создавать экземпляр класса,
 * нам нужно явно создать конструктор по умолчанию и присвоить ему модификатор private.
 */
public class TrackerSingleLazy {
    private static TrackerSingleLazy instance;

    private TrackerSingleLazy() {
    }

    /**
     * Метод проверяет статическое поле instance,
     * если поле не загружено, оно инициализируется новосозданным объектом.
     */
    public static TrackerSingleLazy getInstance() {
        if (instance == null) {
            instance = new TrackerSingleLazy();
        }
        return instance;
    }

    public static void main(String[] args) {
        TrackerSingleLazy tracker = TrackerSingleLazy.getInstance();
        System.out.println(tracker);
    }
}
