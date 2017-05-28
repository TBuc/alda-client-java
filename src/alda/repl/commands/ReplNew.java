
package alda.repl.commands;

import alda.AldaServer;
import alda.AldaResponse.AldaScore;
import java.util.function.Consumer;
import jline.console.ConsoleReader;

/**
 * Handles the :new command
 * Simply deletes the contents of the stringbuffer passed into it
 */
public class ReplNew implements ReplCommand {

  private ReplCommandManager cmdManager;

  public ReplNew(ReplCommandManager m) {
    cmdManager = m;
  }

  @Override
  public void act(String args, StringBuffer history, AldaServer server,
                  ConsoleReader reader, Consumer<AldaScore> newInstrument) {
    history.delete(0, history.length());
    newInstrument.accept(null);
    // Reset state of all commands
    cmdManager.forEach(ReplCommand::reset);
  }

  @Override
  public String docSummary() {
    return "Creates a new score.";
  }
  @Override
  public String key() {
    return "new";
  }
}
