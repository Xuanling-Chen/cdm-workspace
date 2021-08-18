package cdm.product.template.validation.datarule;

import cdm.base.staticdata.party.AncillaryRoleEnum;
import cdm.product.template.CancelableProvision;
import cdm.product.template.ExerciseNotice;
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
@RosettaDataRule("CancelableProvisionCancelableProvisionExerciseNoticeReceiverParty")
public class CancelableProvisionCancelableProvisionExerciseNoticeReceiverParty implements Validator<CancelableProvision> {
	
	private static final String NAME = "CancelableProvisionCancelableProvisionExerciseNoticeReceiverParty";
	private static final String DEFINITION = "if exerciseNotice -> exerciseNoticeReceiver exists then exerciseNotice -> exerciseNoticeReceiver = AncillaryRoleEnum -> ExerciseNoticeReceiverPartyCancelableProvision";
	
	
	@Override
	public ValidationResult<CancelableProvision> validate(RosettaPath path, CancelableProvision cancelableProvision) {
		ComparisonResult result = executeDataRule(cancelableProvision);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "CancelableProvision", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CancelableProvision", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(CancelableProvision cancelableProvision) {
		if (ruleIsApplicable(cancelableProvision).get()) {
			return evaluateThenExpression(cancelableProvision);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(CancelableProvision cancelableProvision) {
		try {
			return exists(MapperS.of(cancelableProvision).<ExerciseNotice>map("getExerciseNotice", _cancelableProvision -> _cancelableProvision.getExerciseNotice()).<AncillaryRoleEnum>map("getExerciseNoticeReceiver", _exerciseNotice -> _exerciseNotice.getExerciseNoticeReceiver()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(CancelableProvision cancelableProvision) {
		try {
			return areEqual(MapperS.of(cancelableProvision).<ExerciseNotice>map("getExerciseNotice", _cancelableProvision -> _cancelableProvision.getExerciseNotice()).<AncillaryRoleEnum>map("getExerciseNoticeReceiver", _exerciseNotice -> _exerciseNotice.getExerciseNoticeReceiver()), MapperS.of(AncillaryRoleEnum.EXERCISE_NOTICE_RECEIVER_PARTY_CANCELABLE_PROVISION), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
