package cdm.base.staticdata.asset.common.validation.datarule;

import cdm.base.staticdata.asset.common.QuasiGovernmentIssuerType;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
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
@RosettaDataRule("QuasiGovernmentIssuerTypeNonSovereignEntityRecourse")
public class QuasiGovernmentIssuerTypeNonSovereignEntityRecourse implements Validator<QuasiGovernmentIssuerType> {
	
	private static final String NAME = "QuasiGovernmentIssuerTypeNonSovereignEntityRecourse";
	private static final String DEFINITION = "if sovereignRecourse exists then sovereignEntity = False";
	
	
	@Override
	public ValidationResult<QuasiGovernmentIssuerType> validate(RosettaPath path, QuasiGovernmentIssuerType quasiGovernmentIssuerType) {
		ComparisonResult result = executeDataRule(quasiGovernmentIssuerType);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "QuasiGovernmentIssuerType", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "QuasiGovernmentIssuerType", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(QuasiGovernmentIssuerType quasiGovernmentIssuerType) {
		if (ruleIsApplicable(quasiGovernmentIssuerType).get()) {
			return evaluateThenExpression(quasiGovernmentIssuerType);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(QuasiGovernmentIssuerType quasiGovernmentIssuerType) {
		try {
			return exists(MapperS.of(quasiGovernmentIssuerType).<Boolean>map("getSovereignRecourse", _quasiGovernmentIssuerType -> _quasiGovernmentIssuerType.getSovereignRecourse()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(QuasiGovernmentIssuerType quasiGovernmentIssuerType) {
		try {
			return areEqual(MapperS.of(quasiGovernmentIssuerType).<Boolean>map("getSovereignEntity", _quasiGovernmentIssuerType -> _quasiGovernmentIssuerType.getSovereignEntity()), MapperS.of(Boolean.valueOf(false)), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
