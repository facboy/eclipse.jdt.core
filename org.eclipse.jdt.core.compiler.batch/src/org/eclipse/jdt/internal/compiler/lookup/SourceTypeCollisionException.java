/*******************************************************************************
 * Copyright (c) 2000, 2016 IBM Corporation and others.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.jdt.internal.compiler.lookup;

import org.eclipse.jdt.internal.compiler.env.ICompilationUnit;

public class SourceTypeCollisionException extends RuntimeException {
	private static final long serialVersionUID = 4798247636899127380L;
	public boolean isLastRound = false;
	public ICompilationUnit[] newAnnotationProcessorUnits;
	/**
	 * The index within {@link #newAnnotationProcessorUnits} where annotation processing should
	 * resume.
	 */
	public int annotationProcessorStartIndex;
}
