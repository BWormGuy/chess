package brains.bots;

import area.Interfaces.IArea;
import brains.src.Abstract.AbstractPlayer;
import brains.src.Scanners.ChessScanner;
import brains.src.StepLog;
import brains.src.TimeSpan;
import visual.src.Interfaces.IVisual;

import java.awt.*;

/**
 * @author Roman
 */
public class Bot_0 extends AbstractPlayer {

    /**
     * Сканер области
     */
    protected ChessScanner scanner = new ChessScanner(this.Area);

    public Bot_0(IArea area, Color color, IVisual visual, String Name) {
        super(area, color, visual, Name);
    }

    /**
     * @return StepLog
     */
    @Override
    public StepLog step() {
        if (this.scanner.isKingDead(this.Color)) {
            this.Visual.showMessage(this.Name + " проиграл на " + this.stepNumber + " ходе.", false, false);
            return StepLog.DEFEAT;
        }
        int index = 0;
        int squareNumber;
        int targetSquareNumber;
        do {
            if (index == 1000) {
                this.Visual.showMessage(this.Name + " проиграл на " + this.stepNumber + " ходе.", false, false);
                return StepLog.DEFEAT;
            } else index++;
            do {
                squareNumber = (int) (Math.random() * this.Area.getMaxSquareNumber());
                targetSquareNumber = (int) (Math.random() * this.Area.getMaxSquareNumber());

            } while (!this.Area.moveObjectSafe(squareNumber, targetSquareNumber, this.Color));
        } while (this.scanner.isKingUnderAttack(this.Color));
        return this.finalize(squareNumber, targetSquareNumber, TimeSpan.TIME_SPAN);
    }
}
