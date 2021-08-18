package cdm.regulation.validation;

import cdm.regulation.New;
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

public class NewValidator implements Validator<New> {

	@Override
	public ValidationResult<New> validate(RosettaPath path, New o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("txId", o.getTxId()!=null ? 1 : 0, 1, 1),
				checkCardinality("exctgPty", o.getExctgPty()!=null ? 1 : 0, 1, 1),
				checkCardinality("invstmtPtyInd", o.getInvstmtPtyInd()!=null ? 1 : 0, 1, 1),
				checkCardinality("submitgPty", o.getSubmitgPty()!=null ? 1 : 0, 1, 1),
				checkCardinality("buyr", o.getBuyr()!=null ? 1 : 0, 1, 1),
				checkCardinality("sellr", o.getSellr()!=null ? 1 : 0, 1, 1),
				checkCardinality("ordrTrnsmssn", o.getOrdrTrnsmssn()!=null ? 1 : 0, 1, 1),
				checkCardinality("tx", o.getTx()!=null ? 1 : 0, 1, 1),
				checkCardinality("finInstrm", o.getFinInstrm()!=null ? 1 : 0, 1, 1),
				checkCardinality("invstmtDcsnPrsn", o.getInvstmtDcsnPrsn()!=null ? 1 : 0, 1, 1),
				checkCardinality("exctgPrsn", o.getExctgPrsn()!=null ? 1 : 0, 1, 1),
				checkCardinality("addtlAttrbts", o.getAddtlAttrbts()!=null ? 1 : 0, 1, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("New", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("New", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
