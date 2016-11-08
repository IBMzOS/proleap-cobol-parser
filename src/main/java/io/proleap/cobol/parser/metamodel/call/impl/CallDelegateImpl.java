/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.cobol.parser.metamodel.call.impl;

import org.antlr.v4.runtime.tree.ParseTree;

import io.proleap.cobol.parser.metamodel.CobolScope;
import io.proleap.cobol.parser.metamodel.CopyBook;
import io.proleap.cobol.parser.metamodel.call.Call;
import io.proleap.cobol.parser.metamodel.impl.CobolScopedElementImpl;

public class CallDelegateImpl extends CobolScopedElementImpl implements Call {

	protected final Call delegate;

	public CallDelegateImpl(final Call delegate, final CopyBook copyBook, final CobolScope superScope,
			final ParseTree ctx) {
		super(copyBook, superScope, ctx);

		this.delegate = delegate;
	}

	@Override
	public boolean equals(final Object obj) {
		final boolean result;

		if (super.equals(obj)) {
			result = true;
		} else if (obj instanceof Call) {
			final Call otherCall = (Call) obj;
			result = delegate.getName().toLowerCase().equals(otherCall.getName().toLowerCase());
		} else {
			result = false;
		}

		return result;
	}

	@Override
	public CallType getCallType() {
		return delegate.getCallType();
	}

	@Override
	public String getName() {
		return delegate.getName();
	}

	@Override
	public String toString() {
		return delegate.toString();
	}

	@Override
	public Call unwrap() {
		return delegate.unwrap();
	}

}
