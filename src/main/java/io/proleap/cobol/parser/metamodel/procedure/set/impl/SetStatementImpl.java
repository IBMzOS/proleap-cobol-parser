/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.cobol.parser.metamodel.procedure.set.impl;

import java.util.ArrayList;
import java.util.List;

import io.proleap.cobol.Cobol85Parser.SetStatementContext;
import io.proleap.cobol.Cobol85Parser.SetToContext;
import io.proleap.cobol.Cobol85Parser.SetToStatementContext;
import io.proleap.cobol.Cobol85Parser.SetToValueContext;
import io.proleap.cobol.Cobol85Parser.SetUpDownByStatementContext;
import io.proleap.cobol.parser.metamodel.ProgramUnit;
import io.proleap.cobol.parser.metamodel.procedure.impl.StatementImpl;
import io.proleap.cobol.parser.metamodel.procedure.set.SetBy;
import io.proleap.cobol.parser.metamodel.procedure.set.SetStatement;
import io.proleap.cobol.parser.metamodel.procedure.set.SetTo;

public class SetStatementImpl extends StatementImpl implements SetStatement {

	protected final SetStatementContext ctx;

	protected SetBy setBy;

	protected List<SetTo> setTos = new ArrayList<SetTo>();

	protected Type type;

	public SetStatementImpl(final ProgramUnit programUnit, final SetStatementContext ctx) {
		super(programUnit, ctx);

		this.ctx = ctx;
	}

	@Override
	public SetBy addSetBy(final SetUpDownByStatementContext ctx) {
		SetBy result = (SetBy) getASGElement(ctx);

		if (result == null) {
			result = new SetByImpl(programUnit, ctx);

			// type
			final SetBy.Type type;

			if (ctx.UP() != null) {
				type = SetBy.Type.Up;
			} else if (ctx.DOWN() != null) {
				type = SetBy.Type.Down;
			} else {
				type = null;
			}

			result.setType(type);

			// to
			for (final SetToContext setToContext : ctx.setTo()) {
				result.addTo(setToContext);
			}

			// by
			result.addBy(ctx.setByValue());

			setBy = result;
			registerASGElement(result);
		}

		return result;
	}

	@Override
	public SetTo addSetTo(final SetToStatementContext ctx) {
		SetTo result = (SetTo) getASGElement(ctx);

		if (result == null) {
			result = new SetToImpl(programUnit, ctx);

			// to
			for (final SetToContext setToContext : ctx.setTo()) {
				result.addTo(setToContext);
			}

			// by
			for (final SetToValueContext setToValueContext : ctx.setToValue()) {
				result.addValue(setToValueContext);
			}

			setTos.add(result);
			registerASGElement(result);
		}

		return result;
	}

	@Override
	public SetBy getSetBy() {
		return setBy;
	}

	@Override
	public List<SetTo> getSetTos() {
		return setTos;
	}

	@Override
	public Type getType() {
		return type;
	}

	@Override
	public void setType(final Type type) {
		this.type = type;
	}

}
