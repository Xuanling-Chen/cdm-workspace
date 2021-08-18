package cdm.legalagreement.common.functions;

import cdm.base.staticdata.identifier.Identifier;
import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.PartyRole;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.legalagreement.common.AgreementTerms;
import cdm.legalagreement.common.LegalAgreement;
import cdm.legalagreement.common.LegalAgreement.LegalAgreementBuilder;
import cdm.legalagreement.common.LegalAgreementType;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@ImplementedBy(Create_LegalAgreementWithPartyReference.Create_LegalAgreementWithPartyReferenceDefault.class)
public abstract class Create_LegalAgreementWithPartyReference implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param agreementTerms The set of elections specific to the contract
	* @param agreementDate The date on which the legal agreement has been agreed between the parties. This corresponds to the Date of Deed in an English Law document.
	* @param effectiveDate The date on which the agreement is effective, if different from the agreement date. It is expected that it will most often correspond to the agreement date, although there could be situations where the parties will explicitly agree on a distinct effective date.
	* @param identifier The legal agreement identifier. Several identifiers can be specified.
	* @param agreementType The type of legal agreement, identified via a set of distinct attributes: name, publisher, governing law and version, e.g. ISDA 2013 Standard Credit Support Annex English Law.
	* @param contractualParty The two contractual parties to the legal agreement, which reference information is positioned as part of the partyInformation attribute.
	* @param otherParty The role(s) that other party(ies) may have in relation to the legal agreement, further to the contractual parties.
	* @return legalAgreement 
	*/
	public LegalAgreement evaluate(AgreementTerms agreementTerms, Date agreementDate, Date effectiveDate, List<? extends Identifier> identifier, LegalAgreementType agreementType, List<? extends Party> contractualParty, List<? extends PartyRole> otherParty) {
		
		LegalAgreement.LegalAgreementBuilder legalAgreementHolder = doEvaluate(agreementTerms, agreementDate, effectiveDate, identifier, agreementType, contractualParty, otherParty);
		LegalAgreement.LegalAgreementBuilder legalAgreement = assignOutput(legalAgreementHolder, agreementTerms, agreementDate, effectiveDate, identifier, agreementType, contractualParty, otherParty);
		
		if (legalAgreement!=null) objectValidator.validateAndFailOnErorr(LegalAgreement.class, legalAgreement);
		return legalAgreement;
	}
	
	private LegalAgreement.LegalAgreementBuilder assignOutput(LegalAgreement.LegalAgreementBuilder legalAgreement, AgreementTerms agreementTerms, Date agreementDate, Date effectiveDate, List<? extends Identifier> identifier, LegalAgreementType agreementType, List<? extends Party> contractualParty, List<? extends PartyRole> otherParty) {
		legalAgreement
			.setAgreementTerms(MapperS.of(agreementTerms).get())
		;
		legalAgreement
			.setAgreementDate(MapperS.of(agreementDate).get())
		;
		legalAgreement
			.setEffectiveDate(MapperS.of(effectiveDate).get())
		;
		legalAgreement
			.addIdentifier(MapperC.of(identifier).getMulti())
		;
		legalAgreement
			.setAgreementType(MapperS.of(agreementType).get())
		;
		legalAgreement
			.addContractualParty(MapperC.of(contractualParty)
			.getItems().map(
					(item) -> ReferenceWithMetaParty.builder().setGlobalReference(item.getMappedObject().getMeta().getGlobalKey()).build()
				).collect(Collectors.toList())
			)
		;
		legalAgreement
			.addOtherParty(MapperC.of(otherParty).getMulti())
		;
		return legalAgreement;
	}

	protected abstract LegalAgreement.LegalAgreementBuilder doEvaluate(AgreementTerms agreementTerms, Date agreementDate, Date effectiveDate, List<? extends Identifier> identifier, LegalAgreementType agreementType, List<? extends Party> contractualParty, List<? extends PartyRole> otherParty);
	
	public static final class Create_LegalAgreementWithPartyReferenceDefault extends Create_LegalAgreementWithPartyReference {
		@Override
		protected  LegalAgreement.LegalAgreementBuilder doEvaluate(AgreementTerms agreementTerms, Date agreementDate, Date effectiveDate, List<? extends Identifier> identifier, LegalAgreementType agreementType, List<? extends Party> contractualParty, List<? extends PartyRole> otherParty) {
			return LegalAgreement.builder();
		}
	}
}
