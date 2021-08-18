package cdm.legalagreement.master.meta;

import cdm.legalagreement.master.CreditSupportDocument;
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
@RosettaMeta(model=CreditSupportDocument.class)
public class CreditSupportDocumentMeta implements RosettaMetaData<CreditSupportDocument> {

	@Override
	public List<Validator<? super CreditSupportDocument>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super CreditSupportDocument>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CreditSupportDocument, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CreditSupportDocument> validator() {
		return new cdm.legalagreement.master.validation.CreditSupportDocumentValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CreditSupportDocument, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.master.validation.exists.CreditSupportDocumentOnlyExistsValidator();
	}
}
