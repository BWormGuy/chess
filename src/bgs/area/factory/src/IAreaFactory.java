package bgs.area.factory.src;

import bgs.area.IArea;

/**
 * @author Roman
 */
public interface IAreaFactory {

    /**
     * Method creates standard configured area
     *
     * @return IArea
     */
    IArea createStandardArea();

    /**
     * Method creates test area
     *
     * @return IArea
     */
    IArea createTestArea();
}
