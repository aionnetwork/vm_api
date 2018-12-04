package main.java.org.aion.vm.api.interfaces;

import main.java.org.aion.vm.api.TransactionContext;
import main.java.org.aion.vm.api.TransactionResult;
import main.java.org.aion.vm.api.exceptions.ClosedVirtualMachineException;

/**
 * A {@code VirtualMachine} that is responsible for executing transactional logic on the blockchain.
 *
 * <p>A {@code VirtualMachine} receives an array {@link TransactionContext} objects, each of which
 * contains a specific {@link TransactionInterface} in addition to the context in which that
 * transaction is to be executed, and guarantees that the <u>logical ordering</u> of the transactions
 * is maintained.
 *
 * <p>A {@code VirtualMachine} may or may not be a long-lived machine. For any {@code VirtualMachine}
 * implementations that are long-lived, explicit calls to {@code start()} and {@code shutdown()} must
 * be made before and after (respectively) invoking the {@code run()} method.
 *
 * <p>A {@code VirtualMachine} implementation may not necessarily be thread-safe. It is up to each
 * implementation to precisely define its level of thread safety.
 */
public interface VirtualMachine {

    /**
     * Starts a long-lived {@code VirtualMachine}.
     *
     * <p>If the particular implementation is not a long-lived {@code VirtualMachine}, then this
     * method does nothing.
     */
    void start();

    /**
     * Shuts down a long-lived {@code VirtualMachine}.
     *
     * <p>If the particular implementation is not a long-lived {@code VirtualMachine}, then this
     * method does nothing.
     */
    void shutdown();

    //TODO: I don't really like the input to this method, TransactionContext, because this object
    //TODO: seems like it is the context around some transaction, but not the transaction as well.
    //TODO: Really we want both of these objects to be included, and if a TransactionContext happens
    //TODO: to hold a transaction (as it does) then either we need a better name here or else we
    //TODO: should explicitly separate these out.

    /**
     * Executes the transactions contained in the array of contexts in such a way that the logical
     * ordering of the transactions is preserved.
     *
     * <p>This method possibly runs asynchronously and returns its results to the caller via a non-
     * blocking {@link SimpleFuture} array.
     *
     * @param contexts The transaction contexts to execute.
     * @return The results of the execution.
     * @throws ClosedVirtualMachineException if no long-lived instance of this class currently exists.
     */
    SimpleFuture<TransactionResult>[] run(TransactionContext[] contexts);

}