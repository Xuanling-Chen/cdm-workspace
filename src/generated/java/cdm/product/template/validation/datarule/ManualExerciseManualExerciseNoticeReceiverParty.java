package cdm.product.template.validation.datarule;

import cdm.base.staticdata.party.AncillaryRoleEnum;
import cdm.product.template.ExerciseNotice;
import cdm.product.template.ManualExercise;
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
@RosettaDataRule("ManualExerciseManualExerciseNoticeReceiverParty")
public class ManualExerciseManualExerciseNoticeReceiverParty implements Validator<ManualExercise> {
	
	private static final String NAME = "ManualExerciseManualExerciseNoticeReceiverParty";
	private static final String DEFINITION = "if exerciseNotice -> exerciseNoticeReceiver exists then exerciseNotice -> exerciseNoticeReceiver = AncillaryRoleEnum -> ExerciseNoticeReceiverPartyManual";
	
	
	@Override
	public ValidationResult<ManualExercise> validate(RosettaPath path, ManualExercise manualExercise) {
		ComparisonResult result = executeDataRule(manualExercise);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "ManualExercise", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ManualExercise", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(ManualExercise manualExercise) {
		if (ruleIsApplicable(manualExercise).get()) {
			return evaluateThenExpression(manualExercise);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(ManualExercise manualExercise) {
		try {
			return exists(MapperS.of(manualExercise).<ExerciseNotice>map("getExerciseNotice", _manualExercise -> _manualExercise.getExerciseNotice()).<AncillaryRoleEnum>map("getExerciseNoticeReceiver", _exerciseNotice -> _exerciseNotice.getExerciseNoticeReceiver()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(ManualExercise manualExercise) {
		try {
			return areEqual(MapperS.of(manualExercise).<ExerciseNotice>map("getExerciseNotice", _manualExercise -> _manualExercise.getExerciseNotice()).<AncillaryRoleEnum>map("getExerciseNoticeReceiver", _exerciseNotice -> _exerciseNotice.getExerciseNoticeReceiver()), MapperS.of(AncillaryRoleEnum.EXERCISE_NOTICE_RECEIVER_PARTY_MANUAL), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
