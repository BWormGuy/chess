package bgs.setup.alias.generators;

import bgs.brains.src.IPlayer;
import bgs.setup.alias.Interfaces.IAliasList;
import bgs.setup.alias.Interfaces.IGenerator;
import bgs.setup.alias.exceptions.AliasNotFoundException;
import org.jetbrains.annotations.NotNull;

/**
 * @author Roman
 */
public class PlayerGenerator implements IGenerator<IPlayer> {

    @Override
    public IPlayer generate(@NotNull IAliasList aliasList, final String alias) throws ReflectiveOperationException, AliasNotFoundException {

        for (String[] array : aliasList.getAliasList()) {
            if (array[0].equals(alias)) {
                return (IPlayer) Class.forName(array[1]).getDeclaredConstructor().newInstance();
            }
        }
        throw new AliasNotFoundException("Check player's aliases, no such alias!");
    }
}
