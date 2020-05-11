package bgs;

import bgs.setup.INI.INIParser;
import bgs.setup.recipient.ConfigRecipient;
import bgs.src.AbstractApplication;
import bgs.visual.src.IVisual;

import java.io.IOException;

/**
 * @author Roman
 */
public class Application extends AbstractApplication {

    public Application(IVisual Visual) {
        super(Visual);
    }

    /**
     * @param configFilePathOrNull
     */
    public void run(String configFilePathOrNull) {
        try {
            this.loadSettings(configFilePathOrNull, new String[]{
                    "areaType",
                    "StepOrder",
                    "firstPlayerType", "firstPlayerName",
                    "secondPlayerType", "secondPlayerName",
                    "logFilePath"
            });
            this.runGame();
        } catch (Exception | Error exception) {
            this.Visual.showMessage(exception.getMessage(), false);
            System.exit(-1);
        } finally {
            this.Visual.showMessage("Exiting...", false);
        }
    }

    /**
     * null - player enters config fields
     *
     * @throws IOException
     */
    protected void loadSettings(String configPath, String[] configFields) throws Exception {
        if (configPath != null) {
            this.applySettings(new INIParser(configPath).loadConfig(configFields));
        } else {
            this.applySettings(new ConfigRecipient(this.Visual).findOutPlayersConfig(configFields));
        }
    }
}
