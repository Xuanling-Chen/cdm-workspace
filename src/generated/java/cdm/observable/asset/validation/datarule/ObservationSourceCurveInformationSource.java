package cdm.observable.asset.validation.datarule;

import cdm.observable.asset.Curve;
import cdm.observable.asset.InformationSource;
import cdm.observable.asset.ObservationSource;
import com.rosetta.model.lib.annotations.RosettaDataRule;
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
@RosettaDataRule("ObservationSourceCurveInformationSource")
public class ObservationSourceCurveInformationSource implements Validator<ObservationSource> {
	
	private static final String NAME = "ObservationSourceCurveInformationSource";
	private static final String DEFINITION = "if ObservationSource exists then (curve exists and informationSource exists) or curve exists or informationSource exists";
	
	
	@Override
	public ValidationResult<ObservationSource> validate(RosettaPath path, ObservationSource observationSource) {
		ComparisonResult result = executeDataRule(observationSource);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "ObservationSource", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ObservationSource", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(ObservationSource observationSource) {
		if (ruleIsApplicable(observationSource).get()) {
			return evaluateThenExpression(observationSource);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(ObservationSource observationSource) {
		try {
			return exists(MapperS.of(observationSource));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(ObservationSource observationSource) {
		try {
			return exists(MapperS.of(observationSource).<Curve>map("getCurve", _observationSource -> _observationSource.getCurve())).and(exists(MapperS.of(observationSource).<InformationSource>map("getInformationSource", _observationSource -> _observationSource.getInformationSource()))).or(exists(MapperS.of(observationSource).<Curve>map("getCurve", _observationSource -> _observationSource.getCurve()))).or(exists(MapperS.of(observationSource).<InformationSource>map("getInformationSource", _observationSource -> _observationSource.getInformationSource())));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
