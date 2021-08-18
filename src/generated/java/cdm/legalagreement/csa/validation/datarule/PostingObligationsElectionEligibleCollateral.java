package cdm.legalagreement.csa.validation.datarule;

import cdm.legalagreement.csa.EligibleCollateralSchedule;
import cdm.legalagreement.csa.PostingObligationsElection;
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
@RosettaDataRule("PostingObligationsElectionEligibleCollateral")
public class PostingObligationsElectionEligibleCollateral implements Validator<PostingObligationsElection> {
	
	private static final String NAME = "PostingObligationsElectionEligibleCollateral";
	private static final String DEFINITION = "if asPermitted = False then eligibleCollateral exists";
	
	
	@Override
	public ValidationResult<PostingObligationsElection> validate(RosettaPath path, PostingObligationsElection postingObligationsElection) {
		ComparisonResult result = executeDataRule(postingObligationsElection);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "PostingObligationsElection", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "PostingObligationsElection", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(PostingObligationsElection postingObligationsElection) {
		if (ruleIsApplicable(postingObligationsElection).get()) {
			return evaluateThenExpression(postingObligationsElection);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(PostingObligationsElection postingObligationsElection) {
		try {
			return areEqual(MapperS.of(postingObligationsElection).<Boolean>map("getAsPermitted", _postingObligationsElection -> _postingObligationsElection.getAsPermitted()), MapperS.of(Boolean.valueOf(false)), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(PostingObligationsElection postingObligationsElection) {
		try {
			return exists(MapperS.of(postingObligationsElection).<EligibleCollateralSchedule>mapC("getEligibleCollateral", _postingObligationsElection -> _postingObligationsElection.getEligibleCollateral()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
