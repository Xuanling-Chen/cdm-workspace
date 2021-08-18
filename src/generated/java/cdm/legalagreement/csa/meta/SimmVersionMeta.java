package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.SimmVersion;
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
@RosettaMeta(model=SimmVersion.class)
public class SimmVersionMeta implements RosettaMetaData<SimmVersion> {

	@Override
	public List<Validator<? super SimmVersion>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.create(cdm.legalagreement.csa.validation.datarule.SimmVersionVersionNotSpecified.class),
			factory.create(cdm.legalagreement.csa.validation.datarule.SimmVersionVersionSpecified.class)
		);
	}

	@Override
	public List<Validator<? super SimmVersion>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SimmVersion, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SimmVersion> validator() {
		return new cdm.legalagreement.csa.validation.SimmVersionValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SimmVersion, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.SimmVersionOnlyExistsValidator();
	}
}
