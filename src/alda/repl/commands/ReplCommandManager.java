package alda.repl.commands;

import java.util.Map;
import java.util.HashMap;
import java.util.Collection;

import jline.console.ConsoleReader;
import alda.AldaServer;

/**
 * Class to manage and store all ReplCommands.
 * The ReplHelp object uses this to generate it's list of documentation.
 */
public class ReplCommandManager {

  private Map<String, ReplCommand> commands;
  private String oldSaveFile = null;

  public ReplCommandManager() {
    commands = new HashMap<>();

    // To see the actual command implemnetations, see Repl*.java (for each command)

    // Temp array to store commands so we can iterate over them later
    ReplCommand[] cmds = {
      new ReplDebug(),
      new ReplDown(),
      new ReplDownUp(),
      new ReplHelp(this),
      new ReplList(),
      new ReplLoad(this),
      new ReplMap(),
      new ReplNew(this),
      new ReplPlay(),
      new ReplQuit(),
      new ReplSave(this),
      new ReplScore(),
      new ReplStop(),
      new ReplStatus(),
      new ReplUp(),
      new ReplVersion(),
      new ReplInfo()
    };

    for (ReplCommand c : cmds) {
      commands.put(c.key(), c);
    }
  }

  /**
   * Returns the ReplCommand that corresponds to this key
   * @param key the key to key into
   * @return the repl command key corresponds to.
   * null if no command corresponds to key
   */
  public ReplCommand get(String key) {
    return commands.getOrDefault(key, null);
  }

  /**
   * Gets a collection of all ReplCommands Available
   * @return A collection of all the commands we know about
   */
  public Collection<ReplCommand> values() {
    return commands.values();
  }

  /**
   * Gets the last saved filename, as a string
   */
  public String getSaveFile() {
    return oldSaveFile;
  }
  /**
   * Sets the last saved file.
   */
  public void setSaveFile(String s) {
    oldSaveFile = s;
  }
}
