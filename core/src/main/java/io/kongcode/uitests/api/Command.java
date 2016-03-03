package io.kongcode.uitests.api;

/**
 * Test Case Command Interface
 */
@FunctionalInterface public interface Command {

    /**
     * Executes the command.
     */
    void execute();
}
