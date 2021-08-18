package cdm.regulation.meta;

import cdm.regulation.OrdrTrnsmssn;
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
@RosettaMeta(model=OrdrTrnsmssn.class)
public class OrdrTrnsmssnMeta implements RosettaMetaData<OrdrTrnsmssn> {

	@Override
	public List<Validator<? super OrdrTrnsmssn>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super OrdrTrnsmssn>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super OrdrTrnsmssn, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super OrdrTrnsmssn> validator() {
		return new cdm.regulation.validation.OrdrTrnsmssnValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OrdrTrnsmssn, Set<String>> onlyExistsValidator() {
		return new cdm.regulation.validation.exists.OrdrTrnsmssnOnlyExistsValidator();
	}
}
