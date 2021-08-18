package cdm.legalagreement.csa.validation.datarule;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legalagreement.csa.SimmVersion;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;
import static com.rosetta.model.lib.expression.ExpressionOperators.notExists;

/**
 * @version ${project.version}
 */
@RosettaDataRule("SimmVersionVersionNotSpecified")
public class SimmVersionVersionNotSpecified implements Validator<SimmVersion> {
	
	private static final String NAME = "SimmVersionVersionNotSpecified";
	private static final String DEFINITION = "if isSpecified = False then partyVersion is absent";
	
	
	@Override
	public ValidationResult<SimmVersion> validate(RosettaPath path, SimmVersion simmVersion) {
		ComparisonResult result = executeDataRule(simmVersion);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "SimmVersion", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "SimmVersion", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(SimmVersion simmVersion) {
		if (ruleIsApplicable(simmVersion).get()) {
			return evaluateThenExpression(simmVersion);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(SimmVersion simmVersion) {
		try {
			return areEqual(MapperS.of(simmVersion).<Boolean>map("getIsSpecified", _simmVersion -> _simmVersion.getIsSpecified()), MapperS.of(Boolean.valueOf(false)), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(SimmVersion simmVersion) {
		try {
			return notExists(MapperS.of(simmVersion).<CounterpartyRoleEnum>map("getPartyVersion", _simmVersion -> _simmVersion.getPartyVersion()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
