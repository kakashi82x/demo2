/*
 * All right reserved
 */
package com.demo.util;

import org.apache.log4j.Logger;

// TODO: Auto-generated Javadoc
/**
 * The Class LogWrapper.
 */
public class LogWrapper {
	
	/** The logger. */
	private final Logger logger;

	/**
	 * Instantiates a new log wrapper.
	 *
	 * @param logger the logger
	 */
	public LogWrapper(final Logger logger) {
		this.logger = logger;
	}

	/**
	 * Debugger.
	 *
	 * @param message the message
	 * @param args the args
	 */
	public void debugger(final String message, final Object... args) {
		if (this.logger.isDebugEnabled()) {
			this.logger.debug(String.format(message, args));
		}
	}

	/**
	 * Error.
	 *
	 * @param message the message
	 * @param args the args
	 */
	public void error(final String message, final Object... args) {
		this.logger.error(String.format(message, args));
	}

	/**
	 * Fatal.
	 *
	 * @param message the message
	 * @param args the args
	 */
	public void fatal(final String message, final Object... args) {
		this.logger.fatal(String.format(message, args));
	}

	/**
	 * Trace.
	 *
	 * @param message the message
	 * @param args the args
	 */
	public void trace(final String message, final Object... args) {
		this.logger.trace(String.format(message, args));
	}

	/**
	 * Warn.
	 *
	 * @param message the message
	 * @param args the args
	 */
	public void warn(final String message, final Object... args) {
		this.logger.warn(String.format(message, args));
	}

	/**
	 * Info.
	 *
	 * @param message the message
	 * @param args the args
	 */
	public void info(final String message, final Object... args) {
		this.logger.info(String.format(message, args));
	}
}
