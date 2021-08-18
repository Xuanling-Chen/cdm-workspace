package cdm.regulation.validation;

import cdm.regulation.Tx;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;

public class TxValidator implements Validator<Tx> {

	@Override
	public ValidationResult<Tx> validate(RosettaPath path, Tx o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("newTx", o.getNewTx()!=null ? 1 : 0, 1, 1),
				checkCardinality("tradDt", o.getTradDt()!=null ? 1 : 0, 1, 1),
				checkCardinality("tradgCpcty", o.getTradgCpcty()!=null ? 1 : 0, 1, 1),
				checkCardinality("qty", o.getQty()!=null ? 1 : 0, 1, 1),
				checkCardinality("pric", o.getPric()!=null ? 1 : 0, 1, 1),
				checkCardinality("tradVn", o.getTradVn()!=null ? 1 : 0, 1, 1),
				checkCardinality("ctryOfBrnch", o.getCtryOfBrnch()!=null ? 1 : 0, 1, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("Tx", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("Tx", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
