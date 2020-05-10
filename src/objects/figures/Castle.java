package objects.figures;

import area.IArea;
import objects.figures.src.AbstractFigure;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

/**
 * @author Roman
 */
public class Castle extends AbstractFigure {

    public Castle(int squareNumber, Color color) {
        super(squareNumber, color);
    }

    @Override
    public boolean isInRange(int SquareNumber, @NotNull IArea Board) {
        return super.isWayFreePerpendicular(SquareNumber, Board) &&
                super.isInRange(SquareNumber, Board);
    }

}
