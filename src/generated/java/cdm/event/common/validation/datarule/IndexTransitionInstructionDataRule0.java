package cdm.event.common.validation.datarule;

import cdm.base.math.Quantity;
import cdm.base.math.metafields.FieldWithMetaQuantity;
import cdm.event.common.IndexTransitionInstruction;
import cdm.observable.asset.FloatingRateOption;
import cdm.observable.asset.Observable;
import cdm.observable.asset.Price;
import cdm.observable.asset.PriceQuantity;
import cdm.observable.asset.PriceTypeEnum;
import cdm.observable.asset.metafields.FieldWithMetaFloatingRateOption;
import cdm.observable.asset.metafields.FieldWithMetaPrice;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;
import static com.rosetta.model.lib.expression.ExpressionOperators.contains;
import static com.rosetta.model.lib.expression.ExpressionOperators.notExists;

/**
 * @version ${project.version}
 */
@RosettaDataRule("IndexTransitionInstructionDataRule0")
public class IndexTransitionInstructionDataRule0 implements Validator<IndexTransitionInstruction> {
	
	private static final String NAME = "IndexTransitionInstructionDataRule0";
	private static final String DEFINITION = "priceQuantity -> price -> priceType contains PriceTypeEnum -> Spread and priceQuantity -> observable -> rateOption exists and priceQuantity -> quantity is absent";
	
	
	@Override
	public ValidationResult<IndexTransitionInstruction> validate(RosettaPath path, IndexTransitionInstruction indexTransitionInstruction) {
		ComparisonResult result = executeDataRule(indexTransitionInstruction);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "IndexTransitionInstruction", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "IndexTransitionInstruction", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(IndexTransitionInstruction indexTransitionInstruction) {
		if (ruleIsApplicable(indexTransitionInstruction).get()) {
			return evaluateThenExpression(indexTransitionInstruction);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(IndexTransitionInstruction indexTransitionInstruction) {
		try {
			return ComparisonResult.success();
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(IndexTransitionInstruction indexTransitionInstruction) {
		try {
			return contains(MapperS.of(indexTransitionInstruction).<PriceQuantity>mapC("getPriceQuantity", _indexTransitionInstruction -> _indexTransitionInstruction.getPriceQuantity()).<FieldWithMetaPrice>mapC("getPrice", _priceQuantity -> _priceQuantity.getPrice()).<Price>map("getValue", _f->_f.getValue()).<PriceTypeEnum>map("getPriceType", _price -> _price.getPriceType()), MapperS.of(PriceTypeEnum.SPREAD)).and(exists(MapperS.of(indexTransitionInstruction).<PriceQuantity>mapC("getPriceQuantity", _indexTransitionInstruction -> _indexTransitionInstruction.getPriceQuantity()).<Observable>map("getObservable", _priceQuantity -> _priceQuantity.getObservable()).<FieldWithMetaFloatingRateOption>map("getRateOption", _observable -> _observable.getRateOption()).<FloatingRateOption>map("getValue", _f->_f.getValue()))).and(notExists(MapperS.of(indexTransitionInstruction).<PriceQuantity>mapC("getPriceQuantity", _indexTransitionInstruction -> _indexTransitionInstruction.getPriceQuantity()).<FieldWithMetaQuantity>mapC("getQuantity", _priceQuantity -> _priceQuantity.getQuantity()).<Quantity>map("getValue", _f->_f.getValue())));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
