/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.cobol.parser.metamodel.data.impl;

import java.util.ArrayList;
import java.util.List;

import io.proleap.cobol.Cobol85Parser.DataDescriptionEntryFormat1Context;
import io.proleap.cobol.parser.metamodel.CobolScope;
import io.proleap.cobol.parser.metamodel.CopyBook;
import io.proleap.cobol.parser.metamodel.call.DataDescriptionEntryCall;
import io.proleap.cobol.parser.metamodel.data.DataDescriptionEntry;
import io.proleap.cobol.parser.metamodel.impl.CobolScopedElementImpl;

public class DataDescriptionEntryImpl extends CobolScopedElementImpl implements DataDescriptionEntry {

	protected final List<DataDescriptionEntryCall> dataDescriptionEntryCalls = new ArrayList<DataDescriptionEntryCall>();

	protected final String name;

	public DataDescriptionEntryImpl(final String name, final CopyBook copyBook, final CobolScope superScope,
			final DataDescriptionEntryFormat1Context ctx) {
		super(copyBook, superScope, ctx);

		this.name = name;
	}

	@Override
	public void addDataDescriptionEntryCall(final DataDescriptionEntryCall dataDescriptionEntryCall) {
		dataDescriptionEntryCalls.add(dataDescriptionEntryCall);
	}

	@Override
	public List<DataDescriptionEntryCall> getDataDescriptionEntryCalls() {
		return dataDescriptionEntryCalls;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "name=[" + name + "]";
	}

}
