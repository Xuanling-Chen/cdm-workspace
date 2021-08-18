package cdm.product.template.validation.datarule;

import cdm.base.staticdata.party.AncillaryParty;
import cdm.base.staticdata.party.AncillaryRoleEnum;
import cdm.product.template.ContractualProduct;
import cdm.product.template.EconomicTerms;
import cdm.product.template.ExerciseNotice;
import cdm.product.template.ExerciseProcedure;
import cdm.product.template.ManualExercise;
import cdm.product.template.OptionExercise;
import cdm.product.template.OptionPayout;
import cdm.product.template.Payout;
import cdm.product.template.Product;
import cdm.product.template.TradableProduct;
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
@RosettaDataRule("TradableProductExerciseNoticeReceiverPartyManual")
public class TradableProductExerciseNoticeReceiverPartyManual implements Validator<TradableProduct> {
	
	private static final String NAME = "TradableProductExerciseNoticeReceiverPartyManual";
	private static final String DEFINITION = "if product -> contractualProduct -> economicTerms -> payout -> optionPayout -> exerciseTerms -> exerciseProcedure -> manualExercise -> exerciseNotice -> exerciseNoticeReceiver exists then ancillaryParty -> role contains AncillaryRoleEnum -> ExerciseNoticeReceiverPartyManual and if ancillaryParty -> role contains AncillaryRoleEnum -> ExerciseNoticeReceiverPartyManual then product -> contractualProduct -> economicTerms -> payout -> optionPayout -> exerciseTerms -> exerciseProcedure -> manualExercise -> exerciseNotice -> exerciseNoticeReceiver exists";
	
	
	@Override
	public ValidationResult<TradableProduct> validate(RosettaPath path, TradableProduct tradableProduct) {
		ComparisonResult result = executeDataRule(tradableProduct);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "TradableProduct", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "TradableProduct", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(TradableProduct tradableProduct) {
		if (ruleIsApplicable(tradableProduct).get()) {
			return evaluateThenExpression(tradableProduct);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(TradableProduct tradableProduct) {
		try {
			return exists(MapperS.of(tradableProduct).<Product>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).<ContractualProduct>map("getContractualProduct", _product -> _product.getContractualProduct()).<EconomicTerms>map("getEconomicTerms", _contractualProduct -> _contractualProduct.getEconomicTerms()).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<OptionPayout>mapC("getOptionPayout", _payout -> _payout.getOptionPayout()).<OptionExercise>map("getExerciseTerms", _optionPayout -> _optionPayout.getExerciseTerms()).<ExerciseProcedure>map("getExerciseProcedure", _optionExercise -> _optionExercise.getExerciseProcedure()).<ManualExercise>map("getManualExercise", _exerciseProcedure -> _exerciseProcedure.getManualExercise()).<ExerciseNotice>map("getExerciseNotice", _manualExercise -> _manualExercise.getExerciseNotice()).<AncillaryRoleEnum>map("getExerciseNoticeReceiver", _exerciseNotice -> _exerciseNotice.getExerciseNoticeReceiver()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(TradableProduct tradableProduct) {
		try {
			return contains(MapperS.of(tradableProduct).<AncillaryParty>mapC("getAncillaryParty", _tradableProduct -> _tradableProduct.getAncillaryParty()).<AncillaryRoleEnum>map("getRole", _ancillaryParty -> _ancillaryParty.getRole()), MapperS.of(AncillaryRoleEnum.EXERCISE_NOTICE_RECEIVER_PARTY_MANUAL)).and(com.rosetta.model.lib.mapper.MapperUtils.toComparisonResult(com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
			if (contains(MapperS.of(tradableProduct).<AncillaryParty>mapC("getAncillaryParty", _tradableProduct -> _tradableProduct.getAncillaryParty()).<AncillaryRoleEnum>map("getRole", _ancillaryParty -> _ancillaryParty.getRole()), MapperS.of(AncillaryRoleEnum.EXERCISE_NOTICE_RECEIVER_PARTY_MANUAL)).get()) {
						return exists(MapperS.of(tradableProduct).<Product>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).<ContractualProduct>map("getContractualProduct", _product -> _product.getContractualProduct()).<EconomicTerms>map("getEconomicTerms", _contractualProduct -> _contractualProduct.getEconomicTerms()).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<OptionPayout>mapC("getOptionPayout", _payout -> _payout.getOptionPayout()).<OptionExercise>map("getExerciseTerms", _optionPayout -> _optionPayout.getExerciseTerms()).<ExerciseProcedure>map("getExerciseProcedure", _optionExercise -> _optionExercise.getExerciseProcedure()).<ManualExercise>map("getManualExercise", _exerciseProcedure -> _exerciseProcedure.getManualExercise()).<ExerciseNotice>map("getExerciseNotice", _manualExercise -> _manualExercise.getExerciseNotice()).<AncillaryRoleEnum>map("getExerciseNoticeReceiver", _exerciseNotice -> _exerciseNotice.getExerciseNoticeReceiver()));
					}
			else {
						return MapperS.ofNull();
					}
			})));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
