/*******************************************************************************
 * Copyright (c) 2000, 2003 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.jdt.internal.core.search.matching;

import org.eclipse.jdt.core.compiler.CharOperation;


public class VariablePattern extends SearchPattern {

	protected boolean findDeclarations;
	protected boolean findReferences;
	protected boolean readAccess;
	protected boolean writeAccess;
	
	protected char[] name;
		
	public VariablePattern(
			int kind,
			boolean findDeclarations,
			boolean readAccess,
			boolean writeAccess,
			char[] name, 
			int matchMode, 
			boolean isCaseSensitive) {

		super(kind, matchMode, isCaseSensitive);

		this.findDeclarations = findDeclarations; // set to find declarations & all occurences
		this.readAccess = readAccess; // set to find any reference, read only references & all occurences
		this.writeAccess = writeAccess; // set to find any reference, write only references & all occurences
		this.findReferences = readAccess || writeAccess;
	
		this.name = isCaseSensitive ? name : CharOperation.toLowerCase(name);
	}
	/*
	 * Returns whether a method declaration or message send will need to be resolved to 
	 * find out if this method pattern matches it.
	 */
	protected boolean mustResolve() {
		// would like to change this so that we only do it if generic references are found
		if (this.findReferences) return true; // always resolve (in case of a simple name reference being a potential match)
		return false;
	}	
}
