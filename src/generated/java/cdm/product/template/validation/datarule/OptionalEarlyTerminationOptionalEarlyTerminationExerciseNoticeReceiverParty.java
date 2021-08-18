package cdm.product.template.validation.datarule;

import cdm.base.staticdata.party.AncillaryRoleEnum;
import cdm.product.template.ExerciseNotice;
import cdm.product.template.OptionalEarlyTermination;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;
import static com.rosetta.model.lib.expression.ExpressionOperators.contains;

/**
 * @version ${project.version}
 */
@RosettaDataRule("OptionalEarlyTerminationOptionalEarlyTerminationExerciseNoticeReceiverParty")
public class OptionalEarlyTerminationOptionalEarlyTerminationExerciseNoticeReceiverParty implements Validator<OptionalEarlyTermination> {
	
	private static final String NAME = "OptionalEarlyTerminationOptionalEarlyTerminationExerciseNoticeReceiverParty";
	private static final String DEFINITION = "if exerciseNotice -> exerciseNoticeReceiver exists then exerciseNotice -> exerciseNoticeReceiver contains AncillaryRoleEnum -> ExerciseNoticeReceiverPartyOptionalEarlyTermination";
	
	
	@Override
	public ValidationResult<OptionalEarlyTermination> validate(RosettaPath path, OptionalEarlyTermination optionalEarlyTermination) {
		ComparisonResult result = executeDataRule(optionalEarlyTermination);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "OptionalEarlyTermination", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "OptionalEarlyTermination", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(OptionalEarlyTermination optionalEarlyTermination) {
		if (ruleIsApplicable(optionalEarlyTermination).get()) {
			return evaluateThenExpression(optionalEarlyTermination);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(OptionalEarlyTermination optionalEarlyTermination) {
		try {
			return exists(MapperS.of(optionalEarlyTermination).<ExerciseNotice>mapC("getExerciseNotice", _optionalEarlyTermination -> _optionalEarlyTermination.getExerciseNotice()).<AncillaryRoleEnum>map("getExerciseNoticeReceiver", _exerciseNotice -> _exerciseNotice.getExerciseNoticeReceiver()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(OptionalEarlyTermination optionalEarlyTermination) {
		try {
			return contains(MapperS.of(optionalEarlyTermination).<ExerciseNotice>mapC("getExerciseNotice", _optionalEarlyTermination -> _optionalEarlyTermination.getExerciseNotice()).<AncillaryRoleEnum>map("getExerciseNoticeReceiver", _exerciseNotice -> _exerciseNotice.getExerciseNoticeReceiver()), MapperS.of(AncillaryRoleEnum.EXERCISE_NOTICE_RECEIVER_PARTY_OPTIONAL_EARLY_TERMINATION));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
