package cdm.legalagreement.csa.validation.datarule;

import cdm.legalagreement.csa.RecalculationOfValueElection;
import com.rosetta.model.lib.annotations.RosettaDataRule;
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
@RosettaDataRule("RecalculationOfValueElectionrecalculationOfValueTerms")
public class RecalculationOfValueElectionrecalculationOfValueTerms implements Validator<RecalculationOfValueElection> {
	
	private static final String NAME = "RecalculationOfValueElectionrecalculationOfValueTerms";
	private static final String DEFINITION = "if RecalculationOfValueElection exists then recalculationOfValueTerms is absent";
	
	
	@Override
	public ValidationResult<RecalculationOfValueElection> validate(RosettaPath path, RecalculationOfValueElection recalculationOfValueElection) {
		ComparisonResult result = executeDataRule(recalculationOfValueElection);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "RecalculationOfValueElection", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "RecalculationOfValueElection", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(RecalculationOfValueElection recalculationOfValueElection) {
		if (ruleIsApplicable(recalculationOfValueElection).get()) {
			return evaluateThenExpression(recalculationOfValueElection);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(RecalculationOfValueElection recalculationOfValueElection) {
		try {
			return exists(MapperS.of(recalculationOfValueElection));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(RecalculationOfValueElection recalculationOfValueElection) {
		try {
			return notExists(MapperS.of(recalculationOfValueElection).<String>map("getRecalculationOfValueTerms", _recalculationOfValueElection -> _recalculationOfValueElection.getRecalculationOfValueTerms()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
