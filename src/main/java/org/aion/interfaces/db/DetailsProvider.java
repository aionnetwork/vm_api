package org.aion.interfaces.db;

/**
 * Interface for a details provider, provides instances of contract details
 *
 * @author yao
 */
public interface DetailsProvider {
    ContractDetails getDetails();
}
