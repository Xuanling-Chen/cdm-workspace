package cdm.base.staticdata.party.validation.datarule;

import cdm.base.staticdata.party.AncillaryRoleEnum;
import cdm.base.staticdata.party.PayerReceiver;
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
@RosettaDataRule("PayerReceiverCashflowReceiverAncillaryRole")
public class PayerReceiverCashflowReceiverAncillaryRole implements Validator<PayerReceiver> {
	
	private static final String NAME = "PayerReceiverCashflowReceiverAncillaryRole";
	private static final String DEFINITION = "if receiverAncillaryRole exists then receiverAncillaryRole = AncillaryRoleEnum -> ArrangingBroker or receiverAncillaryRole = AncillaryRoleEnum -> Beneficiary or receiverAncillaryRole = AncillaryRoleEnum -> ClearingFirm or receiverAncillaryRole = AncillaryRoleEnum -> CounterpartyAfflilate or receiverAncillaryRole = AncillaryRoleEnum -> Guarantor or receiverAncillaryRole = AncillaryRoleEnum -> OtherParty or receiverAncillaryRole = AncillaryRoleEnum -> PrimeBroker or receiverAncillaryRole = AncillaryRoleEnum -> SettlementAgent";
	
	
	@Override
	public ValidationResult<PayerReceiver> validate(RosettaPath path, PayerReceiver payerReceiver) {
		ComparisonResult result = executeDataRule(payerReceiver);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "PayerReceiver", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "PayerReceiver", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(PayerReceiver payerReceiver) {
		if (ruleIsApplicable(payerReceiver).get()) {
			return evaluateThenExpression(payerReceiver);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(PayerReceiver payerReceiver) {
		try {
			return exists(MapperS.of(payerReceiver).<AncillaryRoleEnum>map("getReceiverAncillaryRole", _payerReceiver -> _payerReceiver.getReceiverAncillaryRole()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(PayerReceiver payerReceiver) {
		try {
			return areEqual(MapperS.of(payerReceiver).<AncillaryRoleEnum>map("getReceiverAncillaryRole", _payerReceiver -> _payerReceiver.getReceiverAncillaryRole()), MapperS.of(AncillaryRoleEnum.ARRANGING_BROKER), CardinalityOperator.All).or(areEqual(MapperS.of(payerReceiver).<AncillaryRoleEnum>map("getReceiverAncillaryRole", _payerReceiver -> _payerReceiver.getReceiverAncillaryRole()), MapperS.of(AncillaryRoleEnum.BENEFICIARY), CardinalityOperator.All)).or(areEqual(MapperS.of(payerReceiver).<AncillaryRoleEnum>map("getReceiverAncillaryRole", _payerReceiver -> _payerReceiver.getReceiverAncillaryRole()), MapperS.of(AncillaryRoleEnum.CLEARING_FIRM), CardinalityOperator.All)).or(areEqual(MapperS.of(payerReceiver).<AncillaryRoleEnum>map("getReceiverAncillaryRole", _payerReceiver -> _payerReceiver.getReceiverAncillaryRole()), MapperS.of(AncillaryRoleEnum.COUNTERPARTY_AFFLILATE), CardinalityOperator.All)).or(areEqual(MapperS.of(payerReceiver).<AncillaryRoleEnum>map("getReceiverAncillaryRole", _payerReceiver -> _payerReceiver.getReceiverAncillaryRole()), MapperS.of(AncillaryRoleEnum.GUARANTOR), CardinalityOperator.All)).or(areEqual(MapperS.of(payerReceiver).<AncillaryRoleEnum>map("getReceiverAncillaryRole", _payerReceiver -> _payerReceiver.getReceiverAncillaryRole()), MapperS.of(AncillaryRoleEnum.OTHER_PARTY), CardinalityOperator.All)).or(areEqual(MapperS.of(payerReceiver).<AncillaryRoleEnum>map("getReceiverAncillaryRole", _payerReceiver -> _payerReceiver.getReceiverAncillaryRole()), MapperS.of(AncillaryRoleEnum.PRIME_BROKER), CardinalityOperator.All)).or(areEqual(MapperS.of(payerReceiver).<AncillaryRoleEnum>map("getReceiverAncillaryRole", _payerReceiver -> _payerReceiver.getReceiverAncillaryRole()), MapperS.of(AncillaryRoleEnum.SETTLEMENT_AGENT), CardinalityOperator.All));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
