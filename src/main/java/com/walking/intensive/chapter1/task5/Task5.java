package com.walking.intensive.chapter1.task5;

import java.util.Arrays;

/**
 * Задача поиска площади, величин углов, длин высот, биссектрис, медиан, радиусов вписанной и описанной вокруг
 * треугольника окружностей является центральной в Геометрии.
 *
 * <p>Реализуйте представленные ниже методы в соответствии с заданными условиями.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task5 {
    public static void main(String[] args) {
//        Для собственных проверок можете делать любые изменения в этом методе
        double a = 12;
        double b = 13;
        double c = 5;
        System.out.println(getAreaByHeron(a, b, c));
        System.out.println(Arrays.toString(getHeights(a, b, c)));
        System.out.println(Arrays.toString(getMedians(a, b, c)));
        System.out.println(Arrays.toString(getBisectors(a, b, c)));
        System.out.println(Arrays.toString(getBisectors(a, b, c)));
        System.out.println(Arrays.toString(getAngles(a, b, c)));
        System.out.println((getInscribedCircleRadius(a, b, c)));
        System.out.println((getAreaAdvanced(a, b, c)));
    }

    static boolean isCheckInput(double a, double b, double c) {
        return a + b > c && b + c > a && c + a > b;
    }

    /**
     * Частным случаем Tеоремы Брахмагупты является формула Герона.
     *
     * <p>Реализуйте метод поиска площади треугольника формулой Герона.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - площадь треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getAreaByHeron(double a, double b, double c) {
        double p = (a + b + c) / 2;

        if (isCheckInput(a, b, c)) {
            return Math.sqrt(p * (p - a) * (p - b) * (p - c));
        }

        return -1;
    }

    /**
     * Реализуйте метод, который будет возвращать высоты треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с высотами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getHeights(double a, double b, double c) {


        if (isCheckInput(a, b, c)) {
            double S = getAreaByHeron(a, b, c);
            double[] h = new double[3];
            h[0] = 2 * S / b;
            h[1] = 2 * S / a;
            h[2] = 2 * S / c;
            Arrays.sort(h);
            return h;
        }
        return new double[0];
    }

    /**
     * Реализуйте метод, который будет возвращать медианы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с медианами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getMedians(double a, double b, double c) {
        if (isCheckInput(a, b, c)) {
            double[] m = new double[3];
            m[0] = 0.5 * (Math.sqrt(2 * Math.pow(b, 2) + 2 * Math.pow(c, 2) - Math.pow(a, 2)));
            m[1] = 0.5 * (Math.sqrt(2 * Math.pow(a, 2) + 2 * Math.pow(c, 2) - Math.pow(b, 2)));
            m[2] = 0.5 * (Math.sqrt(2 * Math.pow(a, 2) + 2 * Math.pow(b, 2) - Math.pow(c, 2)));
            Arrays.sort(m);
            return m;
        }

        return new double[0];
    }

    /**
     * Реализуйте метод, который будет возвращать биссектрисы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с биссектрисами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getBisectors(double a, double b, double c) {
        if (isCheckInput(a, b, c)) {
            double p = (a + b + c) / 2;
            double[] bis = new double[3];
            bis[0] = (2 * Math.sqrt(b * c * p * (p - a))) / (b + c);
            bis[1] = (2 * Math.sqrt(a * c * p * (p - b))) / (a + c);
            bis[2] = (2 * Math.sqrt(a * b * p * (p - c))) / (a + b);
            Arrays.sort(bis);
            return bis;
        }

        return new double[0];
    }

    /**
     * Реализуйте метод, который будет возвращать углы треугольника (в градусах) по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с углами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getAngles(double a, double b, double c) {
        if (isCheckInput(a, b, c)) {
            double[] ang = new double[3];
            ang[0] = Math.acos((Math.pow(a, 2) + Math.pow(c, 2) - Math.pow(b, 2)) / (2 * a * c)) * 180
                    / Math.PI;
            ang[1] = Math.acos((Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 2)) / (2 * a * b)) * 180
                    / Math.PI;
            ang[2] = 180 - (ang[0] + ang[1]);
            Arrays.sort(ang);
            return ang;
        }

        return new double[0];
    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса вписанной в треугольник окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getInscribedCircleRadius(double a, double b, double c) {
        if (isCheckInput(a, b, c)) {
            return getAreaByHeron(a, b, c) / ((a + b + c) / 2);
        }

        return -1;
    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса описанной вокруг треугольника окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getCircumradius(double a, double b, double c) {
        if (isCheckInput(a, b, c)) {
            return (a * b * c) / (4 * getAreaByHeron(a, b, c));
        }

        return -1;
    }

    /**
     * Дополнительная задача по желанию.
     *
     * <p>Реализуйте метод, который будет возвращать площадь треугольника.
     *
     * <p>Расчет площади должен быть произведем через поиск косинуса угла через теорему косинусов,
     * далее нахождение синуса через основное тригонометрическое тождество
     * и подстановку синуса в нужную формулу для площади треугольника.
     * (Всего основных способов поиска площади треугольника 6)
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getAreaAdvanced(double a, double b, double c) {
        if (isCheckInput(a, b, c)) {
            double cosine = (Math.pow(c, 2) + Math.pow(b, 2) - Math.pow(a, 2)) / (2 * b * c);
            double sine = Math.sqrt(1 - Math.pow(cosine, 2));
            return (b * c * sine) / 2;
        }

        return -1;
    }
}
