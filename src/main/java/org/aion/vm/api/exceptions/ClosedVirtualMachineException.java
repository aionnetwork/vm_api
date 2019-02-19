package org.aion.vm.api.exceptions;

import org.aion.vm.api.interfaces.VirtualMachine;

/**
 * Thrown when an application attempts to invoke the {@code run()} method of a long-lived
 * {@link VirtualMachine} but the {@link VirtualMachine} is shut down. A {@link VirtualMachine} may
 * be shut down because:
 *
 * <ul>
 *     <li><p> The {@code start()} method was not called prior to invoking {@code run()}. </p></li>
 *     <li><p> The {@code shutdown()} method was called prior to invoking {@code run()}. </p></li>
 * </ul>
 *
 * <p>Or more generally, there is no live {@link VirtualMachine} thread at the time {@code run()}
 * is invoked.
 */
public final class ClosedVirtualMachineException extends RuntimeException {
    private static final long serialVersionUID = 1L;

}