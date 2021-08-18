package cdm.legalagreement.common.functions;

import cdm.legalagreement.common.LegalAgreement;
import cdm.legalagreement.common.RelatedAgreement;
import cdm.legalagreement.common.RelatedAgreement.RelatedAgreementBuilder;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;
import java.util.List;


@ImplementedBy(Create_RelatedAgreementsWithPartyReference.Create_RelatedAgreementsWithPartyReferenceDefault.class)
public abstract class Create_RelatedAgreementsWithPartyReference implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param legalAgreement 
	* @return legalAgreementWithPartyReference 
	*/
	public List<? extends RelatedAgreement> evaluate(List<? extends LegalAgreement> legalAgreement) {
		
		List<RelatedAgreement.RelatedAgreementBuilder> legalAgreementWithPartyReferenceHolder = doEvaluate(legalAgreement);
		List<RelatedAgreement.RelatedAgreementBuilder> legalAgreementWithPartyReference = assignOutput(legalAgreementWithPartyReferenceHolder, legalAgreement);
		
		if (legalAgreementWithPartyReference!=null) objectValidator.validateAndFailOnErorr(RelatedAgreement.class, legalAgreementWithPartyReference);
		return legalAgreementWithPartyReference;
	}
	
	private List<RelatedAgreement.RelatedAgreementBuilder> assignOutput(List<RelatedAgreement.RelatedAgreementBuilder> legalAgreementWithPartyReference, List<? extends LegalAgreement> legalAgreement) {
		return legalAgreementWithPartyReference;
	}

	protected abstract List<RelatedAgreement.RelatedAgreementBuilder> doEvaluate(List<? extends LegalAgreement> legalAgreement);
	
	public static final class Create_RelatedAgreementsWithPartyReferenceDefault extends Create_RelatedAgreementsWithPartyReference {
		@Override
		protected  List<RelatedAgreement.RelatedAgreementBuilder> doEvaluate(List<? extends LegalAgreement> legalAgreement) {
			return Arrays.asList();
		}
	}
}
