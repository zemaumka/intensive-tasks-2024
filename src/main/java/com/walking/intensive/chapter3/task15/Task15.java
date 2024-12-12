package com.walking.intensive.chapter3.task15;

//import java.util.Arrays;

import java.util.Arrays;

/**
 * Существует город, состоящий из N x N блоков, где каждый блок содержит одно здание в форме вертикальной
 * квадратной призмы. Линия горизонта города — это внешний контур, образованный всеми зданиями,
 * если смотреть на город издалека. Линия горизонта с каждого из сторон света — севера,
 * востока, юга и запада — может отличаться.
 *
 * <p>Каждое здание имеет определенную высоту, измеряемую в этажах.
 *
 * <p>Разрешено увеличивать высоту любого количества зданий на любую величину этажей
 * (величина может быть разной для каждого здания). Высота здания с нулевой высотой также может быть увеличена.
 * Увеличение высоты здания не должно повлиять на горизонт города ни с какой стороны света.
 *
 * <p>Реализуйте метод getMaxFloors() с учетом условий ниже.
 *
 * <p>Входящий параметр: массив city[][], где city[r][c] представляет высоту здания,
 * расположенного в блоке в строке r и столбце c. Высота здания может быть строго положительной.
 *
 * <p>Возвращаемое значение: максимально возможное количество достроенных этажей,
 * на которое можно увеличить высоту зданий без изменения горизонта города
 * с любого направления по сторонам света.
 *
 * <p>Пример:
 *
 * <p>Входящий массив: city[ ][ ] = [[2,1],[1,3]].
 *
 * <p>Возвращаемое значение: 2.
 *
 * <p>Пояснение: всего 4 здания, 2 из которых имеют по 1 этажу, 1 здание - 2 этажа и 1 здание - 3 этажа.
 * Можно добавить максимум по 1 этажу к каждому одноэтажному дому чтобы ни одна из 4 линий горизонта не поменялась.
 * Итого 2 этажа.
 *
 * <p>При наличии некорректных входных данных верните из метода -1.
 *
 * <p>P.S. Решение не должно использовать сортировки, коллекции, Stream API и иной материал, выходящий за рамки
 * пройденного курса.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task15 {
    public static void main(String[] args) {
//        Для собственных проверок можете делать любые изменения в этом методе
        int[][] city2 = {{2, 1}, {1, 3}};
        System.out.println(Arrays.deepToString(getMaxRowsColumns(city2)));
        System.out.println(getMaxFloors(city2));
    }

    static int getMaxFloors(int[][] city) {
        if (!isCheckInput(city)) {
            return -1;
        }

        int maxFloor = 0;
        int[][] maxRowsColumns = getMaxRowsColumns(city);

        for (int i = 0; i < city.length; i++) {
            for (int j = 0; j < city.length; j++) {
                if (maxRowsColumns[0][j] > maxRowsColumns[1][i]) {
                    maxFloor = maxFloor + (maxRowsColumns[1][i] - city[i][j]);
                } else {
                    maxFloor = maxFloor + (maxRowsColumns[0][j] - city[i][j]);
                }
            }
        }

        return maxFloor;
    }

    static int[][] getMaxRowsColumns(int[][] city) {
        int[][] maxRowsColumns = new int[2][city.length];

        for (int row = 0; row < city.length; row++) {
            int maxRow = 0;
            int maxColumn = 0;
            for (int columns = 0; columns < city.length; columns++) {
                maxRow = Math.max(maxRow, city[row][columns]);
                maxColumn = Math.max(maxColumn, city[columns][row]);
            }
            maxRowsColumns[0][row] = maxRow;
            maxRowsColumns[1][row] = maxColumn;
        }

        return maxRowsColumns;
    }

    static boolean isCheckInput(int[][] city) {
        if (city.length == 0) {
            return false;
        }

        for (int i = 0; i < city.length; i++) {
            if (city[i].length == 0) {
                return false;
            }
            for (int j = 0; j < city[i].length; j++) {
                if (city[i][j] < 0 || city[i].length != city.length) {
                    return false;
                }
            }
        }

        return true;
    }
}
