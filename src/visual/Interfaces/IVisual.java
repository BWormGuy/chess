package visual.Interfaces;

import area.src.Interfaces.IArea;

public interface IVisual {

    /**
     * Перерисовка области
     *
     * @return лог цифра
     */
    int reDraw(IArea area);

    /**
     * Метод реализует логику общания с игроком
     *
     * @param message   Сообщение
     * @param getAnswer Получить ответ?
     * @return String ответа/null
     */
    String sendMessage(String message, boolean getAnswer, boolean afterClear);

    /**
     * Вопрос по поводу конфигов
     *
     * @return boolean
     */
    boolean ConfigClarification();
}
