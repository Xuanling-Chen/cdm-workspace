package cdm.product.template.validation.datarule;

import cdm.base.staticdata.party.AncillaryRoleEnum;
import cdm.product.template.ExerciseNotice;
import cdm.product.template.ExtendibleProvision;
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
@RosettaDataRule("ExtendibleProvisionExtendibleProvisionExerciseNoticeReceiverParty")
public class ExtendibleProvisionExtendibleProvisionExerciseNoticeReceiverParty implements Validator<ExtendibleProvision> {
	
	private static final String NAME = "ExtendibleProvisionExtendibleProvisionExerciseNoticeReceiverParty";
	private static final String DEFINITION = "if exerciseNotice -> exerciseNoticeReceiver exists then exerciseNotice -> exerciseNoticeReceiver = AncillaryRoleEnum -> ExerciseNoticeReceiverPartyExtendibleProvision";
	
	
	@Override
	public ValidationResult<ExtendibleProvision> validate(RosettaPath path, ExtendibleProvision extendibleProvision) {
		ComparisonResult result = executeDataRule(extendibleProvision);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "ExtendibleProvision", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ExtendibleProvision", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(ExtendibleProvision extendibleProvision) {
		if (ruleIsApplicable(extendibleProvision).get()) {
			return evaluateThenExpression(extendibleProvision);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(ExtendibleProvision extendibleProvision) {
		try {
			return exists(MapperS.of(extendibleProvision).<ExerciseNotice>map("getExerciseNotice", _extendibleProvision -> _extendibleProvision.getExerciseNotice()).<AncillaryRoleEnum>map("getExerciseNoticeReceiver", _exerciseNotice -> _exerciseNotice.getExerciseNoticeReceiver()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(ExtendibleProvision extendibleProvision) {
		try {
			return areEqual(MapperS.of(extendibleProvision).<ExerciseNotice>map("getExerciseNotice", _extendibleProvision -> _extendibleProvision.getExerciseNotice()).<AncillaryRoleEnum>map("getExerciseNoticeReceiver", _exerciseNotice -> _exerciseNotice.getExerciseNoticeReceiver()), MapperS.of(AncillaryRoleEnum.EXERCISE_NOTICE_RECEIVER_PARTY_EXTENDIBLE_PROVISION), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
