package cdm.event.common.validation.datarule;

import cdm.base.math.FinancialUnitEnum;
import cdm.base.math.Quantity;
import cdm.base.math.UnitType;
import cdm.event.common.Transfer;
import cdm.observable.asset.Observable;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("TransferDataRule0")
public class TransferDataRule0 implements Validator<Transfer> {
	
	private static final String NAME = "TransferDataRule0";
	private static final String DEFINITION = "if observable exists then quantity -> unitOfAmount -> financialUnit exists";
	
	
	@Override
	public ValidationResult<Transfer> validate(RosettaPath path, Transfer transfer) {
		ComparisonResult result = executeDataRule(transfer);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "Transfer", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "Transfer", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(Transfer transfer) {
		if (ruleIsApplicable(transfer).get()) {
			return evaluateThenExpression(transfer);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(Transfer transfer) {
		try {
			return exists(MapperS.of(transfer).<Observable>map("getObservable", _transfer -> _transfer.getObservable()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(Transfer transfer) {
		try {
			return exists(MapperS.of(transfer).<Quantity>map("getQuantity", _transfer -> _transfer.getQuantity()).<UnitType>map("getUnitOfAmount", _measureBase -> _measureBase.getUnitOfAmount()).<FinancialUnitEnum>map("getFinancialUnit", _unitType -> _unitType.getFinancialUnit()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
