package cdm.product.template.validation.datarule;

import cdm.product.template.EarlyTerminationProvision;
import cdm.product.template.MandatoryEarlyTermination;
import cdm.product.template.OptionalEarlyTermination;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.mapper.MapperTree;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("EarlyTerminationProvisionMandatoryEarlyTermination")
public class EarlyTerminationProvisionMandatoryEarlyTermination implements Validator<EarlyTerminationProvision> {
	
	private static final String NAME = "EarlyTerminationProvisionMandatoryEarlyTermination";
	private static final String DEFINITION = "if EarlyTerminationProvision exists then (mandatoryEarlyTermination or optionalEarlyTermination) exists or (mandatoryEarlyTermination and optionalEarlyTermination) exists";
	
	
	@Override
	public ValidationResult<EarlyTerminationProvision> validate(RosettaPath path, EarlyTerminationProvision earlyTerminationProvision) {
		ComparisonResult result = executeDataRule(earlyTerminationProvision);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "EarlyTerminationProvision", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "EarlyTerminationProvision", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(EarlyTerminationProvision earlyTerminationProvision) {
		if (ruleIsApplicable(earlyTerminationProvision).get()) {
			return evaluateThenExpression(earlyTerminationProvision);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(EarlyTerminationProvision earlyTerminationProvision) {
		try {
			return exists(MapperS.of(earlyTerminationProvision));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(EarlyTerminationProvision earlyTerminationProvision) {
		try {
			return exists(MapperTree.orDifferent(MapperTree.of(MapperS.of(earlyTerminationProvision).<MandatoryEarlyTermination>map("getMandatoryEarlyTermination", _earlyTerminationProvision -> _earlyTerminationProvision.getMandatoryEarlyTermination())), MapperTree.of(MapperS.of(earlyTerminationProvision).<OptionalEarlyTermination>map("getOptionalEarlyTermination", _earlyTerminationProvision -> _earlyTerminationProvision.getOptionalEarlyTermination())))).or(exists(MapperTree.andDifferent(MapperTree.of(MapperS.of(earlyTerminationProvision).<MandatoryEarlyTermination>map("getMandatoryEarlyTermination", _earlyTerminationProvision -> _earlyTerminationProvision.getMandatoryEarlyTermination())), MapperTree.of(MapperS.of(earlyTerminationProvision).<OptionalEarlyTermination>map("getOptionalEarlyTermination", _earlyTerminationProvision -> _earlyTerminationProvision.getOptionalEarlyTermination())))));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
