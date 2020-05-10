package area;

import area.snapshot.SnapShot;
import objects.IObject;

import java.awt.*;
import java.util.Iterator;

/**
 * @author Roman
 */
public interface IArea {

    /**
     * Проверка может ли существовать такая клетка
     *
     * @param SquareNumber Номер клетки
     * @return Возвращает валиден ли номер клетки
     */
    boolean isValidSquareNumber(int SquareNumber);

    /**
     * Метод удаляет объект на заданной клетке
     *
     * @param ObjectSquareNumber Номер клетки на которой нужно "удалить" объект
     */
    void deleteObject(int ObjectSquareNumber);

    /**
     * Помещаем объект на область если клетка пустая
     *
     * @param object Объект
     */
    void putObject(IObject object);

    /**
     * Небезопасное движение объекта по области
     *
     * @param ObjectSquareNumber Номер клетки с объектом
     * @param SquareNumber       Номер клетки куда нужно переместить объект
     * @return Возвращает удачно ли прошло движение
     */
    boolean moveObject(int ObjectSquareNumber, int SquareNumber);

    /**
     * Безопасное движение объекта по области
     * Добавлено дополнительное сравнивание цветов для ограничения управления другими игроками
     *
     * @param ObjectSquareNumber Номер клетки с объектом
     * @param SquareNumber       Номер клетки куда нужно переместить объект
     * @param objectColor        Цвет объекта
     * @return Возвращает удачно ли прошло движение
     */
    boolean moveObjectSafe(int ObjectSquareNumber, int SquareNumber, Color objectColor);

    /**
     * Метод активирует action объекта на заданной клетке
     *
     * @param ObjectSquareNumber Область где стоит объект
     * @param SquareNumber       Номер клетки для action объекта
     * @return Возвращает возможно ли это
     */
    boolean runObjectAction(int ObjectSquareNumber, int SquareNumber);

    /**
     * Метод возвращает уникальный накопленный номер
     *
     * @return getObjectId
     */
    long getObjectId();

    /**
     * @return Возвращает ширину области
     */
    int getAreaWidth();

    /**
     * @return Возвращает высоту области
     */
    int getAreaHeight();

    /**
     * @return Возвращает макс кол-во клеток
     */
    int getMaxSquareNumber();

    /**
     * @param ObjectSquareNumber Номер клетки на которой находится объект
     * @return Возвращает нужный объект или null
     */
    IObject getObjectFromList(int ObjectSquareNumber);

    /**
     * Возвращает координату X
     *
     * @param SquareNumber Номер клетки
     * @return X
     */
    int getXCoordinate(int SquareNumber);

    /**
     * Возвращает координату Y
     *
     * @param SquareNumber Номер клетки
     * @return Y
     */
    int getYCoordinate(int SquareNumber);

    /**
     * Конвертирует координаты в номер клетки
     *
     * @param XCoordinate X
     * @param YCoordinate Y
     * @return Номер клетки
     */
    int getSquareNumber(int XCoordinate, int YCoordinate);

    /**
     * Восстанавливает несколько последних ходов
     */
    void undoStep(int loopTimes);

    /**
     * Получаем последний снимок
     *
     * @return SnapShot
     */
    SnapShot getLastSnapShot();

    /**
     * Метод очищает ArrayLists с клонами объектов
     */
    void clearSnapShotHistory();

    /**
     * Получаем итератор снимков
     *
     * @return Iterator<SnapShot>
     */
    Iterator<SnapShot> getSnapShotIterator();

    /**
     * Метод создает и записывает новый снимок
     *
     * @param snapShot Новый снимок
     */
    void setSnapShot(SnapShot snapShot);

    /**
     * Получаем размер списка снимков
     *
     * @return int
     */
    int getSnapShotHistorySize();

    /**
     * Метод удаляет последний снимок
     */
    void removeLastSnapShot();
}
