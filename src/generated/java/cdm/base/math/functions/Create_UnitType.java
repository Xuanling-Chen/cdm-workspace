package cdm.base.math.functions;

import cdm.base.math.FinancialUnitEnum;
import cdm.base.math.UnitType;
import cdm.base.math.UnitType.UnitTypeBuilder;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.mapper.MapperTree;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(Create_UnitType.Create_UnitTypeDefault.class)
public abstract class Create_UnitType implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param currency 
	* @param financialUnit 
	* @return unitType 
	*/
	public UnitType evaluate(String currency, FinancialUnitEnum financialUnit) {
		// pre-conditions
		
			assert
				exists(MapperTree.orDifferent(MapperTree.of(MapperS.of(currency)), MapperTree.of(MapperS.of(financialUnit)))).get()
				: "";
		
		UnitType.UnitTypeBuilder unitTypeHolder = doEvaluate(currency, financialUnit);
		UnitType.UnitTypeBuilder unitType = assignOutput(unitTypeHolder, currency, financialUnit);
		
		if (unitType!=null) objectValidator.validateAndFailOnErorr(UnitType.class, unitType);
		return unitType;
	}
	
	private UnitType.UnitTypeBuilder assignOutput(UnitType.UnitTypeBuilder unitType, String currency, FinancialUnitEnum financialUnit) {
		unitType
			.setCurrencyValue(MapperS.of(currency).get())
		;
		unitType
			.setFinancialUnit(MapperS.of(financialUnit).get())
		;
		return unitType;
	}

	protected abstract UnitType.UnitTypeBuilder doEvaluate(String currency, FinancialUnitEnum financialUnit);
	
	public static final class Create_UnitTypeDefault extends Create_UnitType {
		@Override
		protected  UnitType.UnitTypeBuilder doEvaluate(String currency, FinancialUnitEnum financialUnit) {
			return UnitType.builder();
		}
	}
}
