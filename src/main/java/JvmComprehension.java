public class JvmComprehension { // Система загрузки классов сама решает каким =>
                                // загрузчиком загружать класс
                                // Думаю JvmComprehension загружается через ApplicationClassLoader =>
                                // все классы загружаются в Metaspace

    public static void main(String[] args) { //* в stack создаётся фрейм для метода main
        int i = 1;                      // 1 Выделяется место под int i = 1. Вот так => STACK => фрейм main'a => int i = 1;

        Object o = new Object();        // 2 Создаётся new Object() в HEAP (куча) => затем в STACK создаётся Oject о
                                        // и присваивается ссылка из HEAP (куча)

        Integer ii = 2;                 // 3 в HEAP (куча) создаётся обект Integer со значением 2 => затем в STACK создаётся
                                        // Integer ii и присваивается ссылка из HEAP (куча)

        printAll(o, i, ii);             // 4 создаётся фрейм printAll => передаются ссылки на Object o и Integer ii
                                        // + передаётся значение перемонной i


        System.out.println("finished"); // 7 в Stack Memory создается фрейм println =>
                                        // в который передается ссылка на объект String  "finished", созданную в HEAP (куча)
    }

    private static void printAll(Object o, int i, Integer ii) {
        Integer uselessVar = 700;                   // 5 в HEAP (куча) создаётся обект Integer со значением 700 =>
                                                    // во фрейме printAll() присваивается ссылка на uselessVar

        System.out.println(o.toString() + i + ii);  // 6 в Stack Memory создаётся фрейм println =>
                                                    // в который передаются ссылки на  Object o,  int i и Integer ii =>
                                                    // в Stack Memory создаётся фрейм toString
                                                    // выходя из метода printAll данный фрейм удаляется
    }

    // Garbage Collection (сборка мусора) из HEAP (куча)  происходит в непредсказуемый момент времени
    // Хотя в лекции было про Stop The World  (полная остановка потоков программы),
    // но видимо когда это конкретно происходит не ясно(там есть какой-то планировщик) =)
    // там 2 метода (алгоритма) =>
    // 1.работает по принципу остутсвия ссылок
    // 2.обход графа достижимых объектов

    // Там ещё есть оптимизация с достижимыми и недостижимыми объектами => олдов не проверяют =)
    // по причине того, что есть счётчики GC (сборки мусора)
}
