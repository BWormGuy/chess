package visual.src.Interfaces;

import area.Interfaces.IArea;

public interface IVisual {

    /**
     * Перерисовка области
     */
    void Draw(IArea area);

    /**
     * Метод реализует логику общения с игроком
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
    String configClarification();
}
