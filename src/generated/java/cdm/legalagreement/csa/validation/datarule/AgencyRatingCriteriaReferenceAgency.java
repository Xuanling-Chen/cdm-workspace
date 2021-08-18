package cdm.legalagreement.csa.validation.datarule;

import cdm.legalagreement.csa.AgencyRatingCriteria;
import cdm.observable.asset.CreditNotationMismatchResolutionEnum;
import cdm.observable.asset.CreditRatingAgencyEnum;
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
@RosettaDataRule("AgencyRatingCriteriaReferenceAgency")
public class AgencyRatingCriteriaReferenceAgency implements Validator<AgencyRatingCriteria> {
	
	private static final String NAME = "AgencyRatingCriteriaReferenceAgency";
	private static final String DEFINITION = "if AgencyRatingCriteria -> mismatchResolution = CreditNotationMismatchResolutionEnum -> ReferenceAgency then AgencyRatingCriteria -> referenceAgency exists";
	
	
	@Override
	public ValidationResult<AgencyRatingCriteria> validate(RosettaPath path, AgencyRatingCriteria agencyRatingCriteria) {
		ComparisonResult result = executeDataRule(agencyRatingCriteria);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "AgencyRatingCriteria", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "AgencyRatingCriteria", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(AgencyRatingCriteria agencyRatingCriteria) {
		if (ruleIsApplicable(agencyRatingCriteria).get()) {
			return evaluateThenExpression(agencyRatingCriteria);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(AgencyRatingCriteria agencyRatingCriteria) {
		try {
			return areEqual(MapperS.of(agencyRatingCriteria).<CreditNotationMismatchResolutionEnum>map("getMismatchResolution", _agencyRatingCriteria -> _agencyRatingCriteria.getMismatchResolution()), MapperS.of(CreditNotationMismatchResolutionEnum.REFERENCE_AGENCY), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(AgencyRatingCriteria agencyRatingCriteria) {
		try {
			return exists(MapperS.of(agencyRatingCriteria).<CreditRatingAgencyEnum>map("getReferenceAgency", _agencyRatingCriteria -> _agencyRatingCriteria.getReferenceAgency()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
