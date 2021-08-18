package cdm.legalagreement.csa.validation.datarule;

import cdm.legalagreement.csa.CustodianRiskElection;
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
@RosettaDataRule("CustodianRiskElectionSpecified")
public class CustodianRiskElectionSpecified implements Validator<CustodianRiskElection> {
	
	private static final String NAME = "CustodianRiskElectionSpecified";
	private static final String DEFINITION = "if isSpecified = False then qualification is absent";
	
	
	@Override
	public ValidationResult<CustodianRiskElection> validate(RosettaPath path, CustodianRiskElection custodianRiskElection) {
		ComparisonResult result = executeDataRule(custodianRiskElection);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "CustodianRiskElection", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CustodianRiskElection", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(CustodianRiskElection custodianRiskElection) {
		if (ruleIsApplicable(custodianRiskElection).get()) {
			return evaluateThenExpression(custodianRiskElection);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(CustodianRiskElection custodianRiskElection) {
		try {
			return areEqual(MapperS.of(custodianRiskElection).<Boolean>map("getIsSpecified", _custodianRiskElection -> _custodianRiskElection.getIsSpecified()), MapperS.of(Boolean.valueOf(false)), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(CustodianRiskElection custodianRiskElection) {
		try {
			return notExists(MapperS.of(custodianRiskElection).<String>map("getQualification", _custodianRiskElection -> _custodianRiskElection.getQualification()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
