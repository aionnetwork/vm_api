package org.aion.vm.api.interfaces;

import org.aion.vm.api.exceptions.ClosedVirtualMachineException;

/**
 * A {@code VirtualMachine} that is responsible for executing transactional logic on the blockchain.
 *
 * <p>A {@code VirtualMachine} receives an array {@link TransactionContext} objects, each of which
 * contains a specific {@link TransactionInterface} in addition to the context in which that
 * transaction is to be executed, and guarantees that the <u>logical ordering</u> of the
 * transactions is maintained.
 *
 * <p>A {@code VirtualMachine} may or may not be a long-lived machine. For any {@code
 * VirtualMachine} implementations that are long-lived, explicit calls to {@code start()} and {@code
 * shutdown()} must be made before and after (respectively) invoking the {@code run()} method.
 *
 * <p>A {@code VirtualMachine} implementation may not necessarily be thread-safe. It is up to each
 * implementation to precisely define its level of thread safety.
 */
public interface VirtualMachine {

    /**
     * Sets the {@link KernelInterface} that this {@code VirtualMachine} uses to the provided
     * kernel.
     *
     * @param kernel The new {@link KernelInterface}.
     */
    void setKernelInterface(KernelInterface kernel);

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

    /**
     * Executes the transactions contained in the array of contexts in such a way that the logical
     * ordering of the transactions is preserved.
     *
     * <p>This method possibly runs asynchronously and returns its results to the caller via a non-
     * blocking {@link SimpleFuture} array.
     *
     * @param contexts The transaction contexts to execute.
     * @return The results of the execution.
     * @throws ClosedVirtualMachineException if no long-lived instance of this class currently
     *     exists.
     */
    SimpleFuture<TransactionResult>[] run(TransactionContext[] contexts);
}
