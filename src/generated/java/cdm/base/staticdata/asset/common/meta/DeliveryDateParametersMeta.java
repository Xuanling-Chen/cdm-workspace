package cdm.base.staticdata.asset.common.meta;

import cdm.base.staticdata.asset.common.DeliveryDateParameters;
import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

/**
 * @version ${project.version}
 */
@RosettaMeta(model=DeliveryDateParameters.class)
public class DeliveryDateParametersMeta implements RosettaMetaData<DeliveryDateParameters> {

	@Override
	public List<Validator<? super DeliveryDateParameters>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super DeliveryDateParameters>> choiceRuleValidators() {
		return Arrays.asList(
			new cdm.base.staticdata.asset.common.validation.choicerule.DeliveryDateParametersDeliveryDateParametersChoice()
		);
	}
	
	@Override
	public List<Function<? super DeliveryDateParameters, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super DeliveryDateParameters> validator() {
		return new cdm.base.staticdata.asset.common.validation.DeliveryDateParametersValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DeliveryDateParameters, Set<String>> onlyExistsValidator() {
		return new cdm.base.staticdata.asset.common.validation.exists.DeliveryDateParametersOnlyExistsValidator();
	}
}
