package net.sf.openrocket.rocketcomponent;

import java.util.List;

import net.sf.openrocket.util.ChangeSource;

/**
 * Represents a value or parameter that can vary based on the
 * flight configuration ID.
 * <p>
 * The parameter value is always defined, and null is not a valid
 * parameter value.
 *
 * @param <E>	the parameter type
 */
public interface FlightConfigurable<E extends ChangeSource> extends FlightConfigurableComponent, Iterable<E> {
	
	/**
	 * Return the default parameter value for this FlightConfiguration.
	 * This is used in case a per-flight configuration override
	 * has not been defined.
	 * 
	 * @return the default parameter value (never null)
	 */
	public E getDefault();
	
	/**
	 * Set the default parameter value for this FlightConfiguration.
	 *This is used in case a per-flight configuration override
	 * has not been defined.
	 *  
	 * @param value		the parameter value (null not allowed)
	 */
	public void setDefault(E value);
	
	/**
	 * Return the parameter value for the provided flight configuration ID.
	 * This returns either the value specified for this flight config ID,
	 * or the default value.
	 * 
	 * @param id	the flight configuration ID
	 * @return		the parameter to use (never null)
	 */
	public E get(FlightConfigurationID id);
	
	/**
	 * Return the parameter value for the provided flight configuration ID.
	 * This returns either the value specified for this flight config ID,
	 * or the default value.
	 * 
	 * @param    value the parameter to find
	 * @return   the flight configuration ID
	 */
	public FlightConfigurationID get(E value);
	
	/**
	 * Set the parameter value for the provided flight configuration ID.
	 * This sets the override for this flight configuration ID.
	 * 
	 * @param id		the flight configuration ID
	 * @param value		the parameter value (null not allowed)
	 */
	public void set(FlightConfigurationID id, E value);
	
	/**
	 * 
	 * @return a sorted list of all the contained FlightConfigurationIDs
	 */
	public List<FlightConfigurationID> getSortedConfigurationIDs();
	
	/**
	 * Return whether a specific flight configuration ID is using the
	 * default value.
	 * 
	 * @param id	the flight configuration ID
	 * @return		whether the default is being used
	 */
	public boolean isDefault(FlightConfigurationID id);
	
	/**
	 * Reset a specific flight configuration ID to use the default parameter value.
	 * 
	 * @param id	the flight configuration ID
	 */
	public void reset(FlightConfigurationID id);
	
	/**
	 * Return the number of specific flight configurations other than the default.
	 * @return
	 */
	public int size();
}