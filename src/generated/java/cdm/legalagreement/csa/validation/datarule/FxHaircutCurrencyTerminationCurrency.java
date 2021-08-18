package cdm.legalagreement.csa.validation.datarule;

import cdm.legalagreement.csa.FxHaircutCurrency;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.metafields.FieldWithMetaString;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;
import static com.rosetta.model.lib.expression.ExpressionOperators.notExists;

/**
 * @version ${project.version}
 */
@RosettaDataRule("FxHaircutCurrencyTerminationCurrency")
public class FxHaircutCurrencyTerminationCurrency implements Validator<FxHaircutCurrency> {
	
	private static final String NAME = "FxHaircutCurrencyTerminationCurrency";
	private static final String DEFINITION = "if isTerminationCurrency = True then fxDesignatedCurrency is absent";
	
	
	@Override
	public ValidationResult<FxHaircutCurrency> validate(RosettaPath path, FxHaircutCurrency fxHaircutCurrency) {
		ComparisonResult result = executeDataRule(fxHaircutCurrency);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "FxHaircutCurrency", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FxHaircutCurrency", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(FxHaircutCurrency fxHaircutCurrency) {
		if (ruleIsApplicable(fxHaircutCurrency).get()) {
			return evaluateThenExpression(fxHaircutCurrency);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(FxHaircutCurrency fxHaircutCurrency) {
		try {
			return areEqual(MapperS.of(fxHaircutCurrency).<Boolean>map("getIsTerminationCurrency", _fxHaircutCurrency -> _fxHaircutCurrency.getIsTerminationCurrency()), MapperS.of(Boolean.valueOf(true)), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(FxHaircutCurrency fxHaircutCurrency) {
		try {
			return notExists(MapperS.of(fxHaircutCurrency).<FieldWithMetaString>map("getFxDesignatedCurrency", _fxHaircutCurrency -> _fxHaircutCurrency.getFxDesignatedCurrency()).<String>map("getValue", _f->_f.getValue()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
